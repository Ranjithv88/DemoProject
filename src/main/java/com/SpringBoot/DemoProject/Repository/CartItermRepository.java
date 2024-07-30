package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.CartIterm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItermRepository extends JpaRepository<CartIterm,Long> {
}
