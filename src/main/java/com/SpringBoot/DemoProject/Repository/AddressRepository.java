package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
