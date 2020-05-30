package cn.mrzhang.phonestore.dao.impl;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.dao.UserDao;
import cn.mrzhang.phonestore.entity.User;
import cn.mrzhang.phonestore.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public int userRegister(User user) throws SQLException {
        return qr.update("insert into user (username,password,telephone,email,address,code,actived) values (?,?,?,?,?,?,?)",
                user.getUsername(),
                user.getPassword(),
                user.getTelephone(),
                user.getEmail(),
                user.getAddress(),
                user.getCode(),
                user.getActived());
    }

    @Override
    public int delUser(Integer uid) throws SQLException {
        return qr.update("delete from user where id = ?",uid);
    }

    @Override
    public int updateUser(User user) throws SQLException {
        return qr.update("update user set username=?,password=?,telephone=?,email=?,address=?,code=?,actived=? where uid=?",
                user.getUsername(),
                user.getPassword(),
                user.getTelephone(),
                user.getEmail(),
                user.getAddress(),
                user.getCode(),
                user.getActived(),
                user.getUid()
                );
    }

    @Override
    public User userLogin(String username, String password) throws SQLException {
        return qr.query("select * from user where username=? and password=?",new BeanHandler<User>(User.class),username,password);
    }



    @Override
    public List<User> findAllUsers(Integer startIndex,Integer pageSize) throws SQLException {
        return qr.query("select * from user limit ?,?",new BeanListHandler<User>(User.class),startIndex,pageSize);
    }

    @Override
    public int findAllUsersRecords() throws SQLException {
        Object obj = qr.query("select count(*) from user", new ScalarHandler<>(1));
        Long number = (Long)obj;
        int num = number.intValue();
        return num;
    }

    /**
     * 根据用户进行模糊查询  并且分页
     *
     * @param username
     * @param startIndex
     * @param pageSize
     * @return list
     */
    @Override
    public List<User> findUserByLikeUsername(String username, Integer startIndex,Integer pageSize) throws SQLException {
        return qr.query("select * from user where username like ? limit ?,?",new BeanListHandler<User>(User.class),
                username,startIndex,pageSize);
    }

    @Override
    public int findUserByLikeUsernameRecords(String username) throws SQLException {
        Object obj = qr.query("select count(*) from user where username like ?", new ScalarHandler<>(1), username);
        Long number = (Long)obj;
        int num = number.intValue();
        return num;

    }

    @Override
    public User findUserById(Integer uid) throws SQLException {
        return qr.query("select * from user where uid = ?",new BeanHandler<User>(User.class),uid);
    }

    @Override
    public User findByCode(String code) throws SQLException {
        User user = qr.query("select * from user where code = ?", new BeanHandler<User>(User.class), code);
        if (user!=null){
            qr.update("update user set actived=1 where code = ?",code);
        }
        return user;
    }
}
