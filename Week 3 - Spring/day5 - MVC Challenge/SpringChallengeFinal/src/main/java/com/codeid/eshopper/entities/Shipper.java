package com.codeid.eshopper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="shippers",schema="oe")
public class Shipper {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "shipper_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipper_seq")
    @SequenceGenerator(name = "shipper_seq", sequenceName = "oe.shippers_shipper_id_seq", allocationSize = 1)
    @Column(name = "shipper_id")
    private Long shipperId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;
    public Long getShipperId() {
        return shipperId;
    }
    public void setShipperId(Long shipperId) {
        this.shipperId = shipperId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Shipper() {
    }
    public Shipper(Long shipperId, String companyName, String phone) {
        this.shipperId = shipperId;
        this.companyName = companyName;
        this.phone = phone;
    }
    
    
}
