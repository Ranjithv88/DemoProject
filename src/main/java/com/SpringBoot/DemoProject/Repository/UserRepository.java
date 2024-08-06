package com.SpringBoot.DemoProject.Repository;

import com.SpringBoot.DemoProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    String RawQuery = "SELECT * FROM user WHERE user_id IN :userid";
    @Query(nativeQuery = true,value = RawQuery)
    List<User> GetId(@Param("userid") Set<Long> id);

}

