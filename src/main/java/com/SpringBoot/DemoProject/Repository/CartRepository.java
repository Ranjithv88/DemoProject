package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Cart;
import com.SpringBoot.DemoProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    String RawQuery = "SELECT * FROM Cart WHERE cartId IN :cartId;";
    @Query(nativeQuery = true,value = RawQuery)
    List<Cart> GetCartId(@Param("cartId") Set<Long> cartId);

}

