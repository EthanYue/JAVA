package com.netease.controller;

import com.netease.domain.User;
import com.netease.exception.SysException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString");

        User user = new User();
        user.setName("yuefeiyu");
        user.setAge(18);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        response.sendRedirect(request.getContextPath() + "/index.jsp");

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("testVoid");
        return;
    }

    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("testForward");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println(user);

        return user;
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) file.mkdirs();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        for (FileItem item : fileItems) {
            if(item.isFormField()) {
                System.out.println("normal form");
            } else {
                System.out.println("upload file");
                String filename = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = filename + "_" + uuid;
                item.write(new File(path, filename));
                item.delete();
            }
        }

        return "success";
    }

    /**
     * upload by springMVC
     * @param request
     * @param upload
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) file.mkdirs();

        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        upload.transferTo(new File(path, filename));
        return "success";
    }

    @RequestMapping("/exceptionHandle")
    public String exceptionHandle() throws SysException {
        try {
            int a = 1/0;
        } catch (Exception e) {
            throw new SysException("has exception");
        }
        return "success";
    }
}
