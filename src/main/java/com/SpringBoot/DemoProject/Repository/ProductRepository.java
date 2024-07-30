package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
