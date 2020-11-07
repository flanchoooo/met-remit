package com.remit.repository;

import com.remit.domain.UsersClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersClassEntityRepository extends JpaRepository<UsersClassEntity, Integer> {
}
