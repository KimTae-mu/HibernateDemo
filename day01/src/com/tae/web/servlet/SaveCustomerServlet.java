package com.tae.web.servlet;

import com.tae.domain.Customer;
import com.tae.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Taeyeon-Serenity on 2017/7/29.
 */
/**
 * 添加客户的控制器
 * */
@WebServlet("/SaveCustomer")
public class SaveCustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求的参数
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> map = request.getParameterMap();

        Customer c=new Customer();
        try {
            //封装数据，使用BeanUtils
            BeanUtils.populate(c,map);
            //调用业务层
            new CustomerService().saveCustomer(c);
            System.out.println("添加客户成功了~~");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
