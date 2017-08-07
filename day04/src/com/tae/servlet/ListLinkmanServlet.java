package com.tae.servlet;

import com.tae.domain.Linkman;
import com.tae.service.LinkmanService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Taeyeon-Serenity on 2017/8/2.
 */
/**
 * 查询所有的联系人
 * */
@WebServlet("/ListLinkman")
public class ListLinkmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        request.setCharacterEncoding("utf-8");
        String lkmName = request.getParameter("lkmName");
        //先创建离线条件查询的对象，脱离Session对象
        DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
        //添加查询的条件
        if(lkmName != null && !lkmName.trim().isEmpty()){
            //拼接查询的条件
            criteria.add(Restrictions.like("lkm_name","%"+lkmName+"%"));
        }
        //调用业务层，传递DetachedCriteria对象


        List<Linkman> mans=new LinkmanService().findAll(criteria);
        request.setAttribute("mans",mans);
        request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request,response);
    }
}
