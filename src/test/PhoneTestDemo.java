import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.entity.Phone;
import cn.mrzhang.phonestore.service.PhoneService;
import cn.mrzhang.phonestore.service.impl.PhoneServiceImpl;
import org.junit.Test;

import java.util.List;

public class PhoneTestDemo {

    PhoneService phoneService = new PhoneServiceImpl();

    @Test
    public void addPhoneTest(){
        Phone phone = new Phone();
        phone.setpName("小米10");
        Category category = new Category();
        category.setCid(1);
        phone.setCategory(category);
        int rows = phoneService.addPhone(phone);
        System.out.println("数据库添加了"+rows+"条数据");

    }

    @Test
    public void delPhone(){
        int id = 18;
        int rows = phoneService.delPhone(id);
        System.out.println("数据库删除了"+rows+"条数据");
    }

    @Test
    public void updatePhone(){
        Phone phone = new Phone();
        phone.setPid(18);
        phone.setpName("小米11");
        int rows = phoneService.updatePhone(phone);
        System.out.println("数据库修改了"+rows+"条数据");

    }

    @Test
    public void findById(){
        int id = 18;
        Phone phone = phoneService.findPhoneById(18);
        System.out.println(phone);
    }


    @Test
    public void findAll(){
        String pageNum = "2";
        Page page = phoneService.findAllPhones(pageNum);
        List<Phone> list = page.getRecords();
        for (Phone p :
                list) {
            System.out.println(list.toString());
        }
    }


}
