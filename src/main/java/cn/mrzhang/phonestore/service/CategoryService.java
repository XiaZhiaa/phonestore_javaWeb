package cn.mrzhang.phonestore.service;

import cn.mrzhang.phonestore.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Integer id);
    int addCategory(Category category);
    int delCategory(Integer id);
    int updateCategory(Category category);
}
