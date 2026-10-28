package com.aaa.dao;

import com.aaa.entity.Orders;

import java.util.List;

public interface OrdersDao {

    public Orders getByNo(String no);

    public List<Orders> getAll();
}
