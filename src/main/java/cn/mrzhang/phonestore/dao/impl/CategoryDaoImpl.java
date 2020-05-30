package cn.mrzhang.phonestore.dao.impl;

import cn.mrzhang.phonestore.dao.CategoryDao;
import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao{

    QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public List<Category> findAllCategories() throws SQLException {
        return qr.query("select * from category",new BeanListHandler<Category>(Category.class));
    }

    @Override
    public Category findCategoryById(Integer id) throws SQLException {
        return qr.query("select * from category where cid = ?",new BeanHandler<Category>(Category.class),id);
    }

    @Override
    public int addCategory(Category category) throws SQLException {
        return qr.update("insert into category (cname) values (?)",category.getCname());
    }

    @Override
    public int delCategory(Integer id) throws SQLException {
        return qr.update("delete from category where cid = ?",id);
    }

    @Override
    public int updateCategory(Category category) throws SQLException {
        return qr.update("update category set cname = ? where cid = ?",category.getCname(),category.getCid());
    }
}
