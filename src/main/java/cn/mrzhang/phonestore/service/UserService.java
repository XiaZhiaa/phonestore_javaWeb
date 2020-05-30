package cn.mrzhang.phonestore.service;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.entity.User;

public interface UserService {

    int userRegister(User user);

    int delUser(Integer uid);

    int updateUser(User user);

    User userLogin(String username,String password);

    /**
     * 根据激活码激活用户
     * @param code 激活码
     * @return rows
     */
    User userActive(String code);

    Page findAllUsers(String pageNum);

    /**
     * 根据用户进行模糊查询  并且分页
     * @param username
     * @param pageNum
     * @return
     */
    Page findUserByLikeUsername(String username,String pageNum);

    User findUserById(Integer uid);


}
