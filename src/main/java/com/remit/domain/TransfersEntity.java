package com.remit.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transfers", schema = "met_remit", catalog = "")
public class TransfersEntity {
    private int id;
    private Integer sender;
    private Integer agent;
    private Integer recipient;
    private BigDecimal amount;
    private String transferRef;
    private String otp;
    private Integer status;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sender", nullable = true)
    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "agent", nullable = true)
    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    @Basic
    @Column(name = "recipient", nullable = true)
    public Integer getRecipient() {
        return recipient;
    }

    public void setRecipient(Integer recipient) {
        this.recipient = recipient;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 4)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "transferRef", nullable = true, length = 255)
    public String getTransferRef() {
        return transferRef;
    }

    public void setTransferRef(String transferRef) {
        this.transferRef = transferRef;
    }

    @Basic
    @Column(name = "otp", nullable = true, length = 255)
    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransfersEntity that = (TransfersEntity) o;

        if (id != that.id) return false;
        if (sender != null ? !sender.equals(that.sender) : that.sender != null) return false;
        if (agent != null ? !agent.equals(that.agent) : that.agent != null) return false;
        if (recipient != null ? !recipient.equals(that.recipient) : that.recipient != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (transferRef != null ? !transferRef.equals(that.transferRef) : that.transferRef != null) return false;
        if (otp != null ? !otp.equals(that.otp) : that.otp != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (agent != null ? agent.hashCode() : 0);
        result = 31 * result + (recipient != null ? recipient.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (transferRef != null ? transferRef.hashCode() : 0);
        result = 31 * result + (otp != null ? otp.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
