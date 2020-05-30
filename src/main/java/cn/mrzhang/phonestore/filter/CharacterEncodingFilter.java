package cn.mrzhang.phonestore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {

    private FilterConfig filterConfig;

    /**
     * 初始化阶段
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    /**
     * 做过滤
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(req, resp);
        //获取初始化参数
        String encoding = filterConfig.getInitParameter("encoding");
        if (encoding==null){
            encoding = "utf-8";
        }
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 放行
        chain.doFilter(req,resp);
    }

    /**
     * 销毁阶段
     */
    public void destroy() {

    }

}
