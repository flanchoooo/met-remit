package com.remit.repository;

import com.remit.domain.User;
import com.remit.dto.user.CompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.companyId = ?1 ")
    User getAllBy(CompanyDto companyDto);

    User findByToken(String token);
}
