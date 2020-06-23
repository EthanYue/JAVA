package com.netease.servlet;

import com.netease.servlet.util.DownloadUtils;
import com.sun.org.apache.xml.internal.utils.res.XResources_es;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String filename = req.getParameter("filename");
        System.out.println(filename);
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/static/" + filename);
        System.out.println(realPath);

        String mimeType = servletContext.getMimeType(filename);
        resp.setContentType(mimeType);

        String header = req.getHeader("user-agent");
        String filename1 = DownloadUtils.getFilename(filename, header);
        resp.setHeader("content-disposition", "attachment;filename=" + filename1);

        FileInputStream fileInputStream = new FileInputStream(realPath);
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
        fileInputStream.close();

    }
}
