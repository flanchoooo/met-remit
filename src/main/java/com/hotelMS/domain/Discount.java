package com.hotelMS.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discount extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public String publicHoliday;
    public String weekends;
    public String companyRates;
    public String memberRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicHoliday() {
        return publicHoliday;
    }

    public void setPublicHoliday(String publicHoliday) {
        this.publicHoliday = publicHoliday;
    }

    public String getWeekends() {
        return weekends;
    }

    public void setWeekends(String weekends) {
        this.weekends = weekends;
    }

    public String getCompanyRates() {
        return companyRates;
    }

    public void setCompanyRates(String companyRates) {
        this.companyRates = companyRates;
    }

    public String getMemberRate() {
        return memberRate;
    }

    public void setMemberRate(String memberRate) {
        this.memberRate = memberRate;
    }
}
