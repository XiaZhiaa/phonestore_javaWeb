package cn.mrzhang.phonestore.servlet;

import cn.mrzhang.phonestore.entity.Category;
import cn.mrzhang.phonestore.entity.User;
import cn.mrzhang.phonestore.exception.UserServletException;
import cn.mrzhang.phonestore.service.CategoryService;
import cn.mrzhang.phonestore.service.UserService;
import cn.mrzhang.phonestore.service.impl.CategoryServiceImpl;
import cn.mrzhang.phonestore.service.impl.UserServiceImpl;
import cn.mrzhang.phonestore.util.MailUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    User user = new User();
    UserService userService = new UserServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println(method);
        switch (method){
            case "toRegister":
                toRegister(request,response);
                break;
            case "toLogin":
                toLogin(request,response);
                break;
            case "userRegister":
                userRegister(request,response);
                break;
            case "userLogin":
                userLogin(request,response);
                break;
            case "userLogout":
                userLogout(request,response);
                break;
            case "userActive":
                userActive(request,response);
                break;
            default:
                System.out.println("参数传递错误");
        }
    }

    private void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> allCategories = categoryService.findAllCategories();
        request.setAttribute("categoryList",allCategories);
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    private void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> allCategories = categoryService.findAllCategories();
        request.setAttribute("categoryList",allCategories);
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    private void userActive(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取激活码
        String code = request.getParameter("code");
        // 如果code 不是 null  并且不是 空的字符串（会自动去除空格）
        if (StringUtils.isNotBlank(code)) {
            user = userService.userActive(code);
            if (user!=null) {
                request.setAttribute("activeData","激活成功，即将跳转到登录页面");
                request.setAttribute("user",user);
//                response.getWriter().write("激活成功");
                request.getRequestDispatcher("activeSuccess.jsp").forward(request,response);
            } else {
                request.setAttribute("activeData","激活失败");
            }
        }else {
            request.setAttribute("activeData", "激活码无效");
        }
    }

    private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("USER_SESSION");
        session.setAttribute("data","您已注销");
        response.sendRedirect(request.getContextPath());
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user = userService.userLogin(username, password);
        if (user!=null){
            boolean actived = user.getActived();
            if (actived){
                request.getSession().setAttribute("USER_SESSION",user);
                response.sendRedirect(request.getContextPath());
            }else {
                request.setAttribute("loginData","您的账户还为激活，请到邮箱激活");
                String code = user.getCode();
                MailUtil mail = new MailUtil(user);
                mail.start();
                toLogin(request,response);
            }

        }else {
            request.setAttribute("loginData","登录失败，请检查账号和密码是否正确");
            toLogin(request,response);
        }
    }

    private void userRegister(HttpServletRequest request, HttpServletResponse response) {

        try {
            BeanUtils.populate(user,request.getParameterMap());
            // 生成激活码
            String code = UUID.randomUUID().toString();
            user.setCode(code);
            MailUtil mail = new MailUtil(user);
            mail.start();

            int rows = userService.userRegister(user);
            if (rows>0){
                request.setAttribute("regdata","恭喜，注册成功！我们已向您的"+user.getEmail()+"邮箱发送了一封激活邮件，请及时激活。");
                toRegister(request,response);
                System.out.println("注册好了");
            }else {
                request.setAttribute("regdata","注册失败，用户名已经被占用");
            }
        } catch (Exception e) {
            throw new UserServletException(e+"userRegister");
        }

    }
}
