package com.hotelMS.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Role {
    private Integer id;
    private String name;
    private String description;
    private Integer accessId;
    private com.hotelMS.domain.Access accessByAccessId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 64)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "access_id", nullable = true)
    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    @ManyToOne
    @JsonBackReference(value = "access-role")
    @JoinColumn(name = "access_id", referencedColumnName = "id", insertable = false, updatable = false)
    public com.hotelMS.domain.Access getAccessByAccessId() {
        return accessByAccessId;
    }

    public void setAccessByAccessId(Access accessByAccessId) {
        this.accessByAccessId = accessByAccessId;
    }
}
