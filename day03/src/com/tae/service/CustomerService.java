package com.tae.service;

import com.tae.dao.CustomerDao;
import com.tae.domain.Customer;

import java.util.List;

/**
 * Created by Taeyeon-Serenity on 2017/7/29.
 */
public class CustomerService {
    /**
     * 保存客户
     * */
    public void saveCustomer(Customer c){
        new CustomerDao().save(c);
    }

    public List<Customer> findAll(){
        return new CustomerDao().findAll();
    }
    public List<Customer> findAll(String custName){
        return new CustomerDao().findAll(custName);
    }
}
