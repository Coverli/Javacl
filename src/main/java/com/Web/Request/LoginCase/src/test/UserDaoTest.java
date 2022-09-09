package com.Web.Request.LoginCase.src.test;

import com.Web.Request.LoginCase.src.dao.UserDao;
import com.Web.Request.LoginCase.src.domain.User;
import org.testng.annotations.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();

        loginuser.setUsername("cl");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
