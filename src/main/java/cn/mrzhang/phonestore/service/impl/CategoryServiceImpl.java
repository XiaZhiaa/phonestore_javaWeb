package cn.mrzhang.phonestore.service.impl;

import cn.mrzhang.phonestore.dao.CategoryDao;
import cn.mrzhang.phonestore.dao.impl.CategoryDaoImpl;
import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.exception.CategoryServiceImplException;
import cn.mrzhang.phonestore.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAllCategories() {
        try {
            return categoryDao.findAllCategories();
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public Category findCategoryById(Integer id) {
        try {
            return categoryDao.findCategoryById(id);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public int addCategory(Category category) {
        try {
            return categoryDao.addCategory(category);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public int delCategory(Integer id) {
        try {
            return categoryDao.delCategory(id);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }

    @Override
    public int updateCategory(Category category) {
        try {
            return categoryDao.updateCategory(category);
        } catch (SQLException e) {
            throw new CategoryServiceImplException(e);
        }
    }
}
