package com.remit.repository;

import com.remit.domain.Access;
import com.remit.domain.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentEntityRepository extends JpaRepository<AgentEntity, Integer> {
    AgentEntity findByAgentName(String agentName);
}
