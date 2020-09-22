package com.hotelMS.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Access extends AbstractAuditingEntity{
    private Integer id;
    private String name;
    private String description;
    private Collection<Role> rolesById;
    private Collection<User> usersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @OneToMany(mappedBy = "accessByAccessId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "access-role")
    public Collection<Role> getRolesById() {
        return rolesById;
    }

    public void setRolesById(Collection<Role> rolesById) {
        this.rolesById = rolesById;
    }

    @OneToMany(mappedBy = "accessByAccessId")
    @JsonManagedReference(value = "access-user")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Access access = (Access) o;
        return Objects.equals(id, access.id) &&
                Objects.equals(name, access.name) &&
                Objects.equals(description, access.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
