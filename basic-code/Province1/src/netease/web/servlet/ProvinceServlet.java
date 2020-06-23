package netease.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import netease.domain.Province;
import netease.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        String provinceJson = provinceService.findAllJson();
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(provinceJson);
    }
}
