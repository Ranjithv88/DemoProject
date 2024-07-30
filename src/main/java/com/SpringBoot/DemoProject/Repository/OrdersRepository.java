package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
