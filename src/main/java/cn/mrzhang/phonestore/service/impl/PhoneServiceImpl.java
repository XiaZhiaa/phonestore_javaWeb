package cn.mrzhang.phonestore.service.impl;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.dao.PhoneDao;
import cn.mrzhang.phonestore.dao.impl.PhoneDaoImpl;
import cn.mrzhang.phonestore.entity.Phone;
import cn.mrzhang.phonestore.exception.CategoryServiceImplException;
import cn.mrzhang.phonestore.exception.PhoneServiceImplException;
import cn.mrzhang.phonestore.service.PhoneService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PhoneServiceImpl implements PhoneService {

    PhoneDao phoneDao = new PhoneDaoImpl();

    @Override
    public int addPhone(Phone phone) {
        try {
            return phoneDao.addPhone(phone);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public int delPhone(Integer id) {
        try {
            return phoneDao.delPhone(id);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public int updatePhone(Phone phone) {
        try {
            return phoneDao.updatePhone(phone);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public Phone findPhoneById(Integer id) {
        try {
            return phoneDao.findPhoneById(id);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public Page findAllPhones(String pageNum) {
        int currentPage = 0;
        if (pageNum!=null){
             currentPage = Integer.parseInt(pageNum);
        }else {
            currentPage = 1;
        }

        try {
            Page page = new Page(currentPage,phoneDao.findAllPhoneRecords());
            List<Map<String,Object>> list = phoneDao.findAllPhones(page.getStartIndex(), page.getPageSize());
            page.setRecords(list);
            return page;
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public Page findPhonesByCategory(Integer categoryId, String pageNum) {
        int currentPage = 0;
        if (pageNum!=null){
            currentPage = Integer.parseInt(pageNum);
        }else currentPage = 1;

        try {
            Page page = new Page(currentPage,phoneDao.findRecordsByCategory(categoryId));
            List<Phone> list = phoneDao.findPhonesByCategory(page.getStartIndex(), page.getPageSize(), categoryId);
            page.setRecords(list);
            return page;
        } catch (SQLException e) {
            throw new PhoneServiceImplException(e);
        }

    }
}
