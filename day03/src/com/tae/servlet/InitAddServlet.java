package com.tae.servlet;

import com.tae.domain.Customer;
import com.tae.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Taeyeon-Serenity on 2017/7/31.
 */
@WebServlet("/InitAdd")
public class InitAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有的客户
        List<Customer> list = new CustomerService().findAll();
        //保存request
        request.setAttribute("list",list);
        request.getRequestDispatcher("/jsp/linkman/add.jsp").forward(request,response);
    }
}
