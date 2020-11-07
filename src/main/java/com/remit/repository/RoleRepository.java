package com.remit.repository;

import com.remit.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


 Role findAllByAccessId(Integer accessId);
}
