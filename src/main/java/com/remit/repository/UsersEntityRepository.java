package com.remit.repository;


import com.remit.domain.AgentEntity;
import com.remit.domain.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersEntityRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByMobile(String mobile);
}
