package com.xiaohu.zhixuan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaohu.zhixuan.VO.LoginVO;
import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.dao.LoginDao;
import com.xiaohu.zhixuan.dao.UserDao;
import com.xiaohu.zhixuan.entity.Login;
import com.xiaohu.zhixuan.entity.User;
import com.xiaohu.zhixuan.service.LoginService;
import com.xiaohu.zhixuan.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginDao loginDao;
    @Autowired
    UserDao userDao;

    /**
     * 登陆验证接口
     * @param account  账号
     * @param password 密码
     * @return
     */
    @Override
    public ResultVO login(String account, String password){
        ResultVO resultVO = new ResultVO();
        Login login;
        if (account == null){
            //账号错误
            resultVO.setCode(Code.HAVE_NO_USER);
            resultVO.setError(Code.getError(Code.HAVE_NO_USER));
            return resultVO;
        }else if (password == null){
            //密码错误
            resultVO.setCode(Code.PASSWORD_ERROR);
            resultVO.setError(Code.getError(Code.PASSWORD_ERROR));
            return resultVO;
        }

        //根据账号查询账号信息
        login = loginDao.findByAccount(account);

        if (login == null){
            //用户不存在
            resultVO.setCode(Code.HAVE_NO_USER);
            resultVO.setError(Code.getError(Code.HAVE_NO_USER));
            return resultVO;
        }

        if (!login.getPassword().equals(password)){
            //密码错误
            resultVO.setCode(Code.PASSWORD_ERROR);
            resultVO.setError(Code.getError(Code.PASSWORD_ERROR));
            return resultVO;
        }
        //密码正确
        LoginVO loginVO = new LoginVO();
        loginVO.setLoginId(login.getLoginId());
        loginVO.setAccount(login.getAccount());
        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(loginVO));
        return resultVO;
    }

    /**
     * 注册接口
     * @param account  账号
     * @param password  密码
     * @return
     */
    @Override
    public ResultVO register(String account, String password, String userName, String userSex, String userAge, String userNickName) {
        ResultVO resultVO = new ResultVO();
        if (account == null){
            //账号不能为空
            resultVO.setCode(Code.REGISTER_ACCOUNT_ISNULL);
            resultVO.setError(Code.getError(Code.REGISTER_ACCOUNT_ISNULL));
            return resultVO;
        }
        if (password == null){
            //密码不能为空
            resultVO.setCode(Code.REGISTER_PASSWORD_ISNULL);
            resultVO.setError(Code.getError(Code.REGISTER_PASSWORD_ISNULL));
            return resultVO;
        }

        if (loginDao.findByAccount(account) != null){
            //账号已存在
            resultVO.setCode(Code.RE_REGISTER);
            resultVO.setError(Code.getError(Code.RE_REGISTER));
            return resultVO;
        }

        Login login = new Login();
        login.setAccount(account);
        login.setPassword(password);
        login.setToken(account);

        //获取系统时间戳
        long time = System.currentTimeMillis();

        login.setCreateTime(time);
        login.setUpdateTime(time);

        //将新用户保存至数据库
        Login backLogin = loginDao.save(login);

        if (backLogin == null){
            //注册失败
            resultVO.setCode(Code.REGISTER_FAIL);
            resultVO.setError(Code.getError(Code.REGISTER_FAIL));
            return resultVO;
        }

        User user = new User();
        user.setLoginId(backLogin.getLoginId());
        user.setUserName(userName);
        user.setUserSex(Integer.valueOf(userSex));
        user.setUserBirth(Integer.valueOf(userAge));
        user.setUserNick(userNickName);

        user.setCreateTime(time);
        user.setUpdateTime(time);
        User backUser;
        try {
            backUser = userDao.save(user);
        }catch (Exception e){
            loginDao.delete(backLogin);
            //注册失败
            resultVO.setCode(Code.REGISTER_FAIL);
            resultVO.setError(Code.getError(Code.REGISTER_FAIL));
            return resultVO;
        }
        if (backUser == null){
            loginDao.delete(backLogin);
            //注册失败
            resultVO.setCode(Code.REGISTER_FAIL);
            resultVO.setError(Code.getError(Code.REGISTER_FAIL));
            return resultVO;
        }
        //注册成功
        resultVO.setCode(Code.SUCCESS);
        return resultVO;
    }

    @Override
    public ResultVO changePassword(String account, String password, String newPassword) {
        ResultVO resultVO = new ResultVO();
        Login login;
        if (account == null){
            //账号不能为空
            resultVO.setCode(Code.REGISTER_ACCOUNT_ISNULL);
            resultVO.setError(Code.getError(Code.REGISTER_ACCOUNT_ISNULL));
            return resultVO;
        }
        if (password == null){
            //密码不能为空
            resultVO.setCode(Code.REGISTER_PASSWORD_ISNULL);
            resultVO.setError(Code.getError(Code.REGISTER_PASSWORD_ISNULL));
            return resultVO;
        }
        //根据账号查询账号信息
        login = loginDao.findByAccount(account);

        if (login == null){
            //用户不存在
            resultVO.setCode(Code.HAVE_NO_USER);
            resultVO.setError(Code.getError(Code.HAVE_NO_USER));
            return resultVO;
        }

        if (!login.getPassword().equals(password)){
            //密码错误
            resultVO.setCode(Code.PASSWORD_ERROR);
            resultVO.setError(Code.getError(Code.PASSWORD_ERROR));
            return resultVO;
        }
        int num = loginDao.updateLoginPassword(newPassword,account);

        if (num <= 0){
            resultVO.setCode(Code.CHANGE_PASSWORD_FAIL);
            resultVO.setError(Code.getError(Code.REGISTER_PASSWORD_ISNULL));
            return resultVO;
        }
        //修改成功
        resultVO.setCode(Code.SUCCESS);
        return resultVO;
    }

    @Override
    public ResultVO takeBackPassword(String account, String password) {
        ResultVO resultVO = new ResultVO();
        Login login;
        if (account == null){
            //账号不能为空
            resultVO.setCode(Code.REGISTER_ACCOUNT_ISNULL);
            resultVO.setError(Code.getError(Code.REGISTER_ACCOUNT_ISNULL));
            return resultVO;
        }
        if (password == null){
            //密码不能为空
            resultVO.setCode(Code.REGISTER_PASSWORD_ISNULL);
            resultVO.setError(Code.getError(Code.REGISTER_PASSWORD_ISNULL));
            return resultVO;
        }
        //根据账号查询账号信息
        login = loginDao.findByAccount(account);

        if (login == null){
            //用户不存在
            resultVO.setCode(Code.HAVE_NO_USER);
            resultVO.setError(Code.getError(Code.HAVE_NO_USER));
            return resultVO;
        }

        int num = loginDao.updateLoginPassword(password,account);

        if (num <= 0){
            resultVO.setCode(Code.CHANGE_PASSWORD_FAIL);
            resultVO.setError(Code.getError(Code.REGISTER_PASSWORD_ISNULL));
            return resultVO;
        }
        //修改成功
        resultVO.setCode(Code.SUCCESS);
        return resultVO;
    }
}
