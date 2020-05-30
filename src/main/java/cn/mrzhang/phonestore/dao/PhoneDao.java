package cn.mrzhang.phonestore.dao;

import cn.mrzhang.phonestore.entity.Phone;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PhoneDao {

    int addPhone(Phone phone) throws SQLException;

    int delPhone(Integer id) throws SQLException;

    int updatePhone(Phone phone) throws SQLException;

    Phone findPhoneById(Integer id) throws SQLException;

//    List<Phone> findAllPhones(Integer startIndex, Integer pageSize) throws SQLException;
    List<Map<String,Object>> findAllPhones(Integer startIndex, Integer pageSize) throws SQLException;
    int findAllPhoneRecords() throws SQLException;

    List<Phone> findPhonesByCategory(Integer startIndex,Integer pageSize,Integer categoryId) throws SQLException;

    int findRecordsByCategory(Integer categoryId) throws SQLException;



}

