package com.netease.servlet;

import com.mysql.cj.PreparedQuery;
import com.netease.dao.UserDao;
import com.netease.domain.User;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        /*String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/
        HttpSession session = req.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
         String checkCode1 = req.getParameter("checkCode");
        System.out.println(checkCode);
        System.out.println(checkCode1);
        if (checkCode != null && checkCode.equalsIgnoreCase(checkCode1)) {
            req.setAttribute("checkCode_msg", "checkCode correct");
//            Map<String, String[]> parameterMap = req.getParameterMap();
            User loginUser = new User();
//            try {
//                BeanUtils.populate(loginUser, parameterMap);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
            loginUser.setUsername(req.getParameter("username"));
            loginUser.setPassword(req.getParameter("password"));
            System.out.println(loginUser);
            UserDao userDao = new UserDao();
            User user = userDao.login(loginUser);
            System.out.println(user);
            if (user != null) {
                session.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            } else {
                req.setAttribute("user_msg", "username or password incorrect");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("checkCode_msg", "checkCode incorrect");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
