package com.remit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
//@Audited
public abstract class AbstractAuditingEntity implements Serializable {

    @Transient
    private static final long serialVersionUID = 2711428149016729163L;

    @Version
    @Column(name = "version", nullable = false)
    private Long version = 0L;

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 64, updatable = false)
    @JsonIgnore
    private String createdBy = "system";

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 64)
    @JsonIgnore
    private String lastModifiedBy = "system";

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();
}
