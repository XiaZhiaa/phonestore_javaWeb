package cn.mrzhang.phonestore.dao;

import cn.mrzhang.phonestore.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategories() throws SQLException;
    Category findCategoryById(Integer id) throws SQLException;
    int addCategory(Category category) throws SQLException;
    int delCategory(Integer id) throws SQLException;
    int updateCategory(Category category) throws SQLException;
}
