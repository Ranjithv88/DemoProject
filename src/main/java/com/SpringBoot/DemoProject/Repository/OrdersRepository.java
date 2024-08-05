package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    String RawQuery = "SELECT * FROM Orders WHERE orderId IN :orderId";
    @Query(nativeQuery = true,value = RawQuery)
    List<Orders> GetOrderId(@Param("orderId") Set<Long> orderId);

}

