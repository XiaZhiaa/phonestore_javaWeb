package cn.mrzhang.phonestore.dao;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    int userRegister(User user) throws SQLException;

    int delUser(Integer uid) throws SQLException;

    int updateUser(User user) throws SQLException;

    User userLogin(String username,String password) throws SQLException;


    List<User> findAllUsers(Integer startIndex,Integer pageSize) throws SQLException;

    int findAllUsersRecords() throws SQLException;

    /**
     * 根据用户进行模糊查询  并且分页
     * @param username
     * @param startIndex
     * @param pageSize
     * @return list
     */
    List<User> findUserByLikeUsername(String username,Integer startIndex,Integer pageSize) throws SQLException;

    int findUserByLikeUsernameRecords(String username) throws SQLException;

    User findUserById(Integer uid) throws SQLException;

    User findByCode(String code) throws SQLException;
}
