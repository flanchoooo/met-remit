package com.hotelMS.repository;

import com.hotelMS.domain.User;
import com.hotelMS.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
