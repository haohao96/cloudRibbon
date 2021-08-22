package com.pyh.payment.mapper;

import com.pyh.payment.pojo.Payment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PayMapper {

    @Insert("insert into paymentservice values(#{id},#{serial});")
    @Options(useGeneratedKeys = true)
    public int create(Payment payment);

    @Select("select * from paymentservice where id = #{id};")
    public Payment getPaymentById(@Param("id")Long id);
}
