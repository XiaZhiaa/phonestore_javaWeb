package cn.mrzhang.phonestore.servlet;

import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.service.CategoryService;
import cn.mrzhang.phonestore.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        System.out.println(method);
        switch (method){
            case "findAll":
                findAllCategories(request,response);
                break;
            case "findById":
                findCategoryById(request,response);
                break;
            case "addCategory":
                addCategory(request,response);
                break;
            case "delCategory":
                delCategory(request,response);
                break;
            case "updateCategory":
                updateCategory(request,response);
                break;
            default:
                System.out.println("参数传递错误");
        }
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sCid = request.getParameter("cid");
        Integer cid = Integer.parseInt(sCid);
        String cname = request.getParameter("cname");
        Category category = new Category(cid,cname);
        int rows = categoryService.updateCategory(category);
        if (rows>0){
//            List<Category> allCategories = categoryService.findAllCategories();
//            request.setAttribute("categoryList",allCategories);
            request.setAttribute("categoryData","修改成功");
            this.findAllCategories(request,response);
        }else {
            request.setAttribute("categoryData","修改失败");
            this.findAllCategories(request,response);
        }
    }

    private void delCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer cid = Integer.parseInt(id);

        int rows = categoryService.delCategory(cid);
        if (rows>0){
            request.setAttribute("categoryData","删除成功");
            this.findAllCategories(request,response);
        }else {
            request.setAttribute("categoryData","删除失败");
            this.findAllCategories(request,response);
//            request.getRequestDispatcher("msg").forward(request,response);
        }
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        if ("".equals(cname)||cname==null){
            this.findAllCategories(request,response);
            return;
        }
        Category category = new Category();
        category.setCname(cname);
        int rows = categoryService.addCategory(category);
        if (rows>0){
            request.setAttribute("categoryData","添加分类成功");
            this.findAllCategories(request,response);
        }else {
            request.setAttribute("data","添加失败");
            this.findAllCategories(request,response);
        }
    }

    private void findCategoryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sCid = request.getParameter("id");
        Integer cid = Integer.parseInt(sCid);

        Category category = categoryService.findCategoryById(cid);
        if (category!=null){
            request.setAttribute("category",category);
            request.setAttribute("categoryList",category);
            request.getRequestDispatcher("categoryView.jsp").forward(request,response);
        }else {
            request.setAttribute("data","查询失败");
        }
    }

    private void findAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> allCategories = categoryService.findAllCategories();
        if (allCategories!=null&&allCategories.size()!=0) {
            request.setAttribute("categoryList",allCategories);
            request.setAttribute("list",allCategories);
            request.getRequestDispatcher("categoryList.jsp").forward(request,response);
        }else {
            request.setAttribute("categoryData","查询失败");
            response.getWriter().write("查询失败");
        }
    }
}
