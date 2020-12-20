package cn.edu.jlu.dao;

import cn.edu.jlu.Utils.JDBCUtils;
import cn.edu.jlu.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *操作数据库user表的类
 */
public class Userdao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     *
     *登陆方法
     * @param loginUser 只包含usernameh和password
     * @return
     */
    public User login(User loginUser){
        //编写sql
        String sql="select * from user where username=? and password=?";
        //2.调用Query()方法
        try{
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        }catch (Exception  e){
            e.printStackTrace();//记录日志
            return null;
        }

    }
}
