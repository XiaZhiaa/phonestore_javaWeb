import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.entity.Phone;
import cn.mrzhang.phonestore.service.CategoryService;
import cn.mrzhang.phonestore.service.PhoneService;
import cn.mrzhang.phonestore.service.impl.CategoryServiceImpl;
import cn.mrzhang.phonestore.service.impl.PhoneServiceImpl;
import org.junit.Test;

import java.util.List;

public class CategoryTest {

    CategoryService categoryService = new CategoryServiceImpl();
//    PhoneService phoneService = new PhoneServiceImpl();


    @Test
    public void testFindAll(){
        List<Category> allCategories = categoryService.findAllCategories();
        for (Category c :
                allCategories) {
            System.out.println(c);
        }
    }

    @Test
    public void testFindById(){
        Category category= categoryService.findCategoryById(2);
        System.out.println(category);
    }

    @Test
    public void testAdd(){
        Category category = new Category();
        category.setCname("耳机");
        int rows = categoryService.addCategory(category);
        if (rows>0){
            System.out.println("成功插入"+rows+"条");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testDel(){
        int rows = categoryService.delCategory(4);
        if (rows>0){
            System.out.println("成功删除"+rows+"条");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testUpdate(){
        Category category = new Category();
        category.setCid(4);
        category.setCname("耳机耳机");
        int rows = categoryService.updateCategory(category);
        if (rows>0){
            System.out.println("成功修改"+rows+"条");
        }else {
            System.out.println("修改失败");
        }
    }


}
