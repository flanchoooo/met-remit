package com.hotelMS.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public String item;
    public Double quantity;
    public String UserReference;
    public String dateAdded;
    public String itemcategory;
    public Double stockLevel;
    public String auditlog;
    public String newStock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserReference() {
        return UserReference;
    }

    public void setUserReference(String userReference) {
        UserReference = userReference;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getItemcategory() {
        return itemcategory;
    }

    public void setItemcategory(String itemcategory) {
        this.itemcategory = itemcategory;
    }

    public Double getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Double stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getAuditlog() {
        return auditlog;
    }

    public void setAuditlog(String auditlog) {
        this.auditlog = auditlog;
    }

    public String getNewStock() {
        return newStock;
    }

    public void setNewStock(String newStock) {
        this.newStock = newStock;
    }
}
