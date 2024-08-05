package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Category;
import com.SpringBoot.DemoProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    String RawQuery = "SELECT * FROM Category WHERE categoryId IN :categoryId";
    @Query(nativeQuery = true,value = RawQuery)
    List<Category> GetCategoryId(@Param("categoryId") Set<Long> categoryId);

}

