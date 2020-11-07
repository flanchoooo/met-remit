package com.remit.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "usersClass", schema = "met_remit", catalog = "")
public class UsersClassEntity {
    private int id;
    private Integer name;
    private BigDecimal weeklyMax;
    private BigDecimal monthlyMax;
    private BigDecimal dailyMax;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true)
    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    @Basic
    @Column(name = "weeklyMax", nullable = true, precision = 4)
    public BigDecimal getWeeklyMax() {
        return weeklyMax;
    }

    public void setWeeklyMax(BigDecimal weeklyMax) {
        this.weeklyMax = weeklyMax;
    }

    @Basic
    @Column(name = "monthlyMax", nullable = true, precision = 4)
    public BigDecimal getMonthlyMax() {
        return monthlyMax;
    }

    public void setMonthlyMax(BigDecimal monthlyMax) {
        this.monthlyMax = monthlyMax;
    }

    @Basic
    @Column(name = "dailyMax", nullable = true, precision = 4)
    public BigDecimal getDailyMax() {
        return dailyMax;
    }

    public void setDailyMax(BigDecimal dailyMax) {
        this.dailyMax = dailyMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersClassEntity that = (UsersClassEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (weeklyMax != null ? !weeklyMax.equals(that.weeklyMax) : that.weeklyMax != null) return false;
        if (monthlyMax != null ? !monthlyMax.equals(that.monthlyMax) : that.monthlyMax != null) return false;
        if (dailyMax != null ? !dailyMax.equals(that.dailyMax) : that.dailyMax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (weeklyMax != null ? weeklyMax.hashCode() : 0);
        result = 31 * result + (monthlyMax != null ? monthlyMax.hashCode() : 0);
        result = 31 * result + (dailyMax != null ? dailyMax.hashCode() : 0);
        return result;
    }
}
