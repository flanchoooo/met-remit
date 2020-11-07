package com.remit.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "agent", schema = "met_remit", catalog = "")
public class AgentEntity {
    private int id;
    private String agentName;
    private String email;
    private String mobile;
    private String tax;
    private String companyReg;
    private BigDecimal balance;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "agentName", nullable = true, length = 255)
    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 64)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "tax", nullable = true, length = 64)
    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "companyReg", nullable = true, length = 64)
    public String getCompanyReg() {
        return companyReg;
    }

    public void setCompanyReg(String companyReg) {
        this.companyReg = companyReg;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 4)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentEntity that = (AgentEntity) o;

        if (id != that.id) return false;
        if (agentName != null ? !agentName.equals(that.agentName) : that.agentName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (tax != null ? !tax.equals(that.tax) : that.tax != null) return false;
        if (companyReg != null ? !companyReg.equals(that.companyReg) : that.companyReg != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (agentName != null ? agentName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        result = 31 * result + (companyReg != null ? companyReg.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}
