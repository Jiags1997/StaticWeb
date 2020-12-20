package cn.edu.jlu.test;

import cn.edu.jlu.dao.Userdao;
import cn.edu.jlu.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("1234567");

        Userdao userdao = new Userdao();
        User login = userdao.login(user);
        System.out.println(login);


    }
}
