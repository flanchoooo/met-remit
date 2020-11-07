package com.remit.repository;

import com.remit.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
