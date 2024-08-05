package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.Address;
import com.SpringBoot.DemoProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    String RawQuery = "SELECT * FROM Address WHERE addressId IN :addressId";
    @Query(nativeQuery = true,value = RawQuery)
    List<Address> getAddressId(@Param("addressId") Set<Long> addressId);

}

