package cn.mrzhang.phonestore.service.impl;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.dao.UserDao;
import cn.mrzhang.phonestore.dao.impl.UserDaoImpl;
import cn.mrzhang.phonestore.entity.User;
import cn.mrzhang.phonestore.exception.UserServiceImplException;
import cn.mrzhang.phonestore.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public int userRegister(User user) {

        try {
            return userDao.userRegister(user);
        } catch (SQLException e) {
            throw new UserServiceImplException(e+"userRegister");
        }
    }

    @Override
    public int delUser(Integer uid) {
        try {
            return userDao.delUser(uid);
        } catch (SQLException e) {
            throw new UserServiceImplException(e+"delUser");
        }
    }

    @Override
    public int updateUser(User user) {
        try {
            return userDao.updateUser(user);
        } catch (SQLException e) {
            throw new UserServiceImplException(e+"updateUser");
        }
    }

    @Override
    public User userLogin(String username, String password) {
        try {
            return userDao.userLogin(username,password);

        } catch (SQLException e) {
            throw new UserServiceImplException(e+"userLogin");
        }

    }

    /**
     * 根据激活码激活用户
     *
     * @param code 激活码
     * @return rows
     */
    @Override
    public User userActive(String code) {
        try {
            User user = userDao.findByCode(code);
            return user;

        } catch (SQLException e) {
            throw new UserServiceImplException(e+"userActive");
        }
    }

    @Override
    public Page findAllUsers(String pageNum) {
        try {
            int currentPage = Integer.parseInt(pageNum);
            if (currentPage<=0){
                currentPage = 1;
            }
            Page page = new Page(currentPage,userDao.findAllUsersRecords());
            List<User> list = userDao.findAllUsers(page.getStartIndex(),page.getPageSize());
            page.setRecords(list);
            return page;
        } catch (SQLException e) {
            throw new UserServiceImplException(e+"findAllUsers");
        }
    }

    /**
     * 根据用户进行模糊查询  并且分页
     *
     * @param username
     * @param pageNum
     * @return
     */
    @Override
    public Page findUserByLikeUsername(String username, String pageNum) {
        try {
            int currentPage = Integer.parseInt(pageNum);
            if (currentPage<=0){
                currentPage = 1;
            }
            Page page = new Page(currentPage,userDao.findUserByLikeUsernameRecords(username));
            List<User> list = userDao.findUserByLikeUsername(username,page.getStartIndex(),page.getPageSize());
            page.setRecords(list);
            return page;
        } catch (SQLException e) {
            throw new UserServiceImplException(e+"findUserByLikeUsername");
        }
    }

    @Override
    public User findUserById(Integer uid) {
        try {
            return userDao.findUserById(uid);
        } catch (SQLException e) {
            throw new UserServiceImplException(e+"findUserById");
        }
    }
}
