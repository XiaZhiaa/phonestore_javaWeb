package cn.mrzhang.phonestore.dao.impl;

import cn.mrzhang.phonestore.dao.PhoneDao;
import cn.mrzhang.phonestore.entity.Phone;
import cn.mrzhang.phonestore.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PhoneDaoImpl implements PhoneDao {

    QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());


    @Override
    public int addPhone(Phone phone) throws SQLException {
        return qr.update("insert into phone (pName,pDescription,price,stock,photoPath,photoName,cid) values (?,?,?,?,?,?,?)",
                phone.getpName(),
                phone.getpDescription(),
                phone.getPrice(),
                phone.getStock(),
                phone.getPhotoPath(),
                phone.getPhotoName(),
                phone.getCategory().getCid());
    }

    @Override
    public int delPhone(Integer id) throws SQLException {
        return qr.update("delete from phone where pid = ?",id);
    }

    @Override
    public int updatePhone(Phone phone) throws SQLException {
        return qr.update("update phone set pname = ?,pdescription = ?,price = ?,stock = ?,photopath = ?,photoname = ?,cid = ?");
    }

    @Override
    public Phone findPhoneById(Integer id) throws SQLException {
        return qr.query("select * from phone where pid = ?",new BeanHandler<Phone>(Phone.class),id);
    }

    @Override
    public List<Map<String,Object>> findAllPhones(Integer startIndex, Integer pageSize) throws SQLException {
        List<Map<String, Object>> list = qr.query("SELECT p.*,c.* FROM phone p,category c WHERE p.cid=c.cid LIMIT ?,?", new MapListHandler(), startIndex, pageSize);
        return list;
    }

    @Override
    public int findAllPhoneRecords() throws SQLException {
        Object obj = qr.query("select count(*) from phone", new ScalarHandler<>(1));
        Long num = (Long)obj;
        int number =num.intValue();
        return number;
    }

    @Override
    public List<Phone> findPhonesByCategory(Integer startIndex, Integer pageSize, Integer categoryId) throws SQLException {
        return qr.query("select * from phone where cid = ? limit ?,?",
                new BeanListHandler<Phone>(Phone.class),categoryId,startIndex,pageSize
        );
    }

    @Override
    public int findRecordsByCategory(Integer categoryId) throws SQLException {
        Object obj = qr.query("select count(*) from phone where cid = ?", new ScalarHandler<>(1), categoryId);
        Long num = (Long)obj;
        int number = num.intValue();
        return number;
    }
}
