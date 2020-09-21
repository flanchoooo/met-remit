package com.hotelMS.domain;

import com.hotelMS.audit.Auditable;

import javax.persistence.*;

@Entity
public class Platform extends Auditable<String> {
    private Integer id;
    private String company;
    private String domain;
    private String ipAddress;
    private String version;
    private String logoUrl;
    private String port;

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
    @Column(name = "company", nullable = false, length = 64)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "domain", nullable = false, length = 64)
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Basic
    @Column(name = "ip_address", nullable = false, length = 16)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "version", nullable = false, length = 8)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "logo_url", nullable = false, length = 128)
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Basic
    @Column(name = "port", nullable = false, length = 8)
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
