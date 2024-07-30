package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
