package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.CartIterm;
import com.SpringBoot.DemoProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface CartItermRepository extends JpaRepository<CartIterm,Long> {

    String RawQuery = "SELECT * FROM CartIterm WHERE cartItermId IN :cartItermId";
    @Query(nativeQuery = true,value = RawQuery)
    List<CartIterm> GetCartItermId(@Param("cartItermId") Set<Long> cartItermId);

}

