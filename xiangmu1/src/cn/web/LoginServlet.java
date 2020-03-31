package cn.web;

import cn.don.Users;
import cn.sevice.UserService;
import cn.sevice.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        String usercheck = request.getParameter("usercheck");
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(usercheck)){
            request.setAttribute("msg","验证码错误，请重新输入");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        Users users=new Users();
        try {
            BeanUtils.populate(users,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService=new UserServiceImpl();
        Users loginusers=userService.findUsernameAndPassword(users);
        if (loginusers==null){
               request.setAttribute("msg","用户名或密码错误，请重新输入");
               request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            session.setAttribute("loginusers",loginusers);
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
