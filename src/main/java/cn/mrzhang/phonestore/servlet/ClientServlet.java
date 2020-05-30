package cn.mrzhang.phonestore.servlet;

import cn.mrzhang.phonestore.commons.Page;
import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.service.CategoryService;
import cn.mrzhang.phonestore.service.PhoneService;
import cn.mrzhang.phonestore.service.impl.CategoryServiceImpl;
import cn.mrzhang.phonestore.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();
    PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println(method);
        switch (method){
            case "showIndex":
                showIndex(request,response);
                break;
            case "showCategoryPhones":
                showCategoryPhones(request,response);
                break;
            case "toAdmin":
                toAdmin(request,response);
                break;
//            case "":
            default:
                System.out.println("参数传递错误");
        }
    }

    private void toAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }

    private void showCategoryPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        String cid = request.getParameter("cid");
        int id = Integer.parseInt(cid);
        Page page = phoneService.findPhonesByCategory(id, pageNum);
        page.setUrl("/clientServlet?method=showCategoryPhones&cid="+cid);
        List<Category> categoryList = categoryService.findAllCategories();
        request.setAttribute("page",page);
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("main.jsp").forward(request,response);

    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");

        Page page = phoneService.findAllPhones(pageNum);
        page.setUrl("/clientServlet?method=showIndex");
        List<Category> categoryList = categoryService.findAllCategories();
        request.setAttribute("categoryList",categoryList);  //存储到请求的域对象中去
        request.setAttribute("page",page);
        request.getRequestDispatcher("main.jsp").forward(request,response);
    }
}
