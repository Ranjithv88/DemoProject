package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    String RawQuery = "SELECT * FROM Product WHERE productId IN :productId";
    @Query(nativeQuery = true,value = RawQuery)
    List<Product> GetProductId(@Param("productId") Set<Long> productId);

}

