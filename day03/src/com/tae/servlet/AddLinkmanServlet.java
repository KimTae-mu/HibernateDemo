package com.tae.servlet;

import com.tae.domain.Linkman;
import com.tae.service.LinkmanService;
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
 * Created by Taeyeon-Serenity on 2017/7/31.
 */
@WebServlet("/AddLinkman")
public class AddLinkmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //接收数据
        Map<String, String[]> map = request.getParameterMap();
        //先把联系人的id值获取到
        String scust_id = map.get("cust_id")[0];
        long cust_id = Long.parseLong(scust_id);

        Linkman man=new Linkman();
        try {
            //封装数据
            BeanUtils.populate(man,map);

            //调用业务层 保存联系人
            new LinkmanService().save(man,cust_id);
            System.out.println("保存联系人成功了。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
