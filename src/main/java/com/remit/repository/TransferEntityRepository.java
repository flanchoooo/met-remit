package com.remit.repository;

import com.remit.domain.TransfersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferEntityRepository extends JpaRepository<TransfersEntity, Integer> {
}
