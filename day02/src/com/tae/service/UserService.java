package com.tae.service;

import com.tae.dao.UserDao;
import com.tae.domain.User;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Taeyeon-Serenity on 2017/7/30.
 */
public class UserService {
    public void save(User u1, User u2) {
        UserDao dao=new UserDao();

        //获取session
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction tr = session.beginTransaction();

        try {
            dao.save1(u1);
            int a=10/0;
            dao.save2(u2);

            //提交事务
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }finally {
            //自己释放资源，现在，session不用关闭，线程结束了，session自动关闭
        }
    }
}
