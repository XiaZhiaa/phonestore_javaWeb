package cn.mrzhang.phonestore.service;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.entity.Phone;

import java.sql.SQLException;
import java.util.List;

public interface PhoneService {
    int addPhone(Phone phone);

    int delPhone(Integer id);

    int updatePhone(Phone phone);

    Phone findPhoneById(Integer id);

    Page findAllPhones(String pageNum);

    Page findPhonesByCategory(Integer categoryId,String pageNum);


}
