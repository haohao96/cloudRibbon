package com.pyh.payment_nacos.dao;

import com.pyh.comutils.pojo.Payment;
import com.pyh.payment_nacos.mapper.PayMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PaymentDao {
    @Resource
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
