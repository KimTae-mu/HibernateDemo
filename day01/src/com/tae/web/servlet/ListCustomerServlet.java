package com.tae.web.servlet;

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
 * Created by Taeyeon-Serenity on 2017/7/30.
 */
/**
 * 查询所有的客户
 * */
@WebServlet("/ListCustomer")
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String custName = request.getParameter("custName");
        System.out.println(custName);
        List<Customer> list = new CustomerService().findAll(custName);
        request.setAttribute("list",list);
        System.out.println(list);
        //转发
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request,response);
    }
}
