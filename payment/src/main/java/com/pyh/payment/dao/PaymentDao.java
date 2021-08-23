package com.pyh.payment.dao;

import com.pyh.comutils.pojo.Payment;
import com.pyh.payment.mapper.PayMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDao {
    @Autowired
    private PayMapper mapper;

    public int create(Payment payment)
    {
        return mapper.create(payment);
    }

    public Payment getPaymentById(@Param("id")Long id)
    {
        return mapper.getPaymentById(id);
    }
}
