package com.remit.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users", schema = "met_remit", catalog = "")
public class UsersEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String identification;
    private String kycBase64;
    private String status;
    private String userType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 68)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "identification", nullable = true, length = 255)
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Basic
    @Column(name = "kycBase64", nullable = true, length = 255)
    public String getKycBase64() {
        return kycBase64;
    }

    public void setKycBase64(String kycBase64) {
        this.kycBase64 = kycBase64;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "userType", nullable = true, length = 255)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (identification != null ? !identification.equals(that.identification) : that.identification != null)
            return false;
        if (kycBase64 != null ? !kycBase64.equals(that.kycBase64) : that.kycBase64 != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (identification != null ? identification.hashCode() : 0);
        result = 31 * result + (kycBase64 != null ? kycBase64.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
