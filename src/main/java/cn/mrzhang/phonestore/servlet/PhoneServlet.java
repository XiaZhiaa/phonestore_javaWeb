package cn.mrzhang.phonestore.servlet;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.entity.Phone;
import cn.mrzhang.phonestore.service.CategoryService;
import cn.mrzhang.phonestore.service.PhoneService;
import cn.mrzhang.phonestore.service.impl.CategoryServiceImpl;
import cn.mrzhang.phonestore.service.impl.PhoneServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet("/phoneServlet")
public class PhoneServlet extends HttpServlet {

    PhoneService phoneService = new PhoneServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    Category category = new Category();
    Phone phone = new Phone();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println(method);
        switch (method){
            case "toAddPhone":
                toAddPhone(request,response);
                break;
            case "addPhone":
                try {
                    addPhone(request,response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delPhone":
                delPhone(request,response);
                break;
            case "updatePhone":
                try {
                    updatePhone(request,response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "findPhoneById":
                findPhoneById(request,response);
                break;
            case "findAllPhones":
                findAllPhones(request,response);
                break;
            default:
                System.out.println("参数传递错误");
        }
    }

    /**
     * 添加商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addPhone(HttpServletRequest request, HttpServletResponse response)
            throws Exception {


//        System.out.println("准备搞cid");
//        String cid = request.getParameter("hidden");
//        System.out.println(cid);
//        Integer id = Integer.parseInt(cid);
//        System.out.println("字符串转换为Int");
//        category.setCid(id);
//        System.out.println("设置值");
//        phone.setCategory(category);
//        System.out.println("设置phone");
        /*1*/
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        /*2*/
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);

        /*3*/
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (item.isFormField()) {
                /*4*/
                String name = item.getFieldName();
                String value = item.getString(request.getCharacterEncoding());
                /*5. 手写以下代码*/
                BeanUtils.copyProperty(phone,name,value);

            } else {

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

                /*6*/
                String fileName = UUID.randomUUID().toString()+sdf.format(date)+item.getName();
                /*7*/
                String photoPath = getServletContext().getRealPath("/pic");

                /*8 实例化file*/
                File file = new File(photoPath);

                /*9如果不存在该文件夹，则自动创建出来*/
                if (!file.exists()){
                    file.mkdirs();
                }
                // 将图片的名称放到phone的对象中去
                phone.setPhotoName(fileName);
                // 将图片的路径放到phone的对象中去
                phone.setPhotoPath(photoPath);

                // 这个代码 等会是要删除的！  手动设置一个分了id

                category.setCid(1);
                phone.setCategory(category);

                // 已经在上传了
                item.write(new File(photoPath+"/"+fileName));
            }
        }

        int number = phoneService.addPhone(phone);
        if (number>0){
            request.setAttribute("data","添加成功");
//            request.getSession().setAttribute("data","添加成功");
//            request.getRequestDispatcher("msg.jsp").forward(request,response);
            this.findAllPhones(request,response);
        }else {
            request.setAttribute("data","添加失败");
//            request.getSession().setAttribute("data","失败");
//            request.getRequestDispatcher("msg.jsp").forward(request,response);
            this.findAllPhones(request,response);
        }
    }

    private void toAddPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = categoryService.findAllCategories();
        request.setAttribute("categories",categories);
        request.setAttribute("categoryList",categories);  //存储到请求的域对象中去
        request.getRequestDispatcher("addPhone.jsp").forward(request,response);
    }

    private void delPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer pid = Integer.parseInt(id);
        int rows = phoneService.delPhone(pid);
        if (rows>0){
            request.setAttribute("data","删除成功");
            this.findAllPhones(request,response);
        }else {
            request.setAttribute("data","删除失败");
            this.findAllPhones(request,response);
        }

    }

    private void updatePhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");
        int id = Integer.parseInt(pid);
        /*1*/
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        /*2*/
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);

        /*3*/
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (item.isFormField()) {
                /*4*/
                String name = item.getFieldName();
                String value = item.getString(request.getCharacterEncoding());
                /*5. 手写以下代码*/
                phone.setPid(id);
                BeanUtils.copyProperty(phone,name,value);



            } else {

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

                /*6*/
                String fileName = UUID.randomUUID().toString()+sdf.format(date)+item.getName();
                /*7*/
                String photoPath = getServletContext().getRealPath("/pic");

                /*8 实例化file*/
                File file = new File(photoPath);

                /*9如果不存在该文件夹，则自动创建出来*/
                if (!file.exists()){
                    file.mkdirs();
                }
                // 将图片的名称放到phone的对象中去
                phone.setPhotoName(fileName);
                // 将图片的路径放到phone的对象中去
                phone.setPhotoPath(photoPath);

                // 这个代码 等会是要删除的！  手动设置一个分了id

                category.setCid(1);
                phone.setCategory(category);

                // 已经在上传了
                item.write(new File(photoPath+"/"+fileName));
            }
        }
        System.out.println("gaigai");
        int rows = phoneService.updatePhone(phone);
        if (rows>0){
            request.setAttribute("修改成功","data");
//            request.getRequestDispatcher("msg.jsp").forward(request,response);
            this.findAllPhones(request,response);
        }else {
            request.setAttribute("修改失败","data");
//            request.getRequestDispatcher("msg.jsp").forward(request,response);
            this.findAllPhones(request,response);
        }
    }

    private void findPhoneById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        int id = Integer.parseInt(pid);
        Phone phone = phoneService.findPhoneById(id);
        List<Category> categories = categoryService.findAllCategories();
        request.setAttribute("categoryList",categories);  //存储到请求的域对象中去
        request.setAttribute("categories",categories);
        request.setAttribute("phone",phone);
        request.getRequestDispatcher("updatePhone.jsp").forward(request,response);
    }

    private void findAllPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        Page page = phoneService.findAllPhones(pageNum);
        List<Category> categoryList = categoryService.findAllCategories();
        request.setAttribute("categoryList",categoryList);  //存储到请求的域对象中去
        page.setUrl("/phoneServlet?method=findAllPhones");
        if (page!=null){
            request.setAttribute("page",page);
            request.getRequestDispatcher("phoneList.jsp").forward(request,response);
        }else {
            request.setAttribute("data","查找失败");
        }
    }
}
