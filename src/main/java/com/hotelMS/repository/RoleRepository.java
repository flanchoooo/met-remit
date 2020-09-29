package com.hotelMS.repository;

import com.hotelMS.domain.Role;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


 Role findAllByAccessId(Integer accessId);
}
