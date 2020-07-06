package com.registry.estates.entity;


import javax.persistence.*;

@Entity
@Table(name = "property_type")
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @Column
    private String propertyType;
    @Column
    private double taxRate;


    public PropertyType(short id, String propertyType, double taxRate) {
        this.id = id;
        this.propertyType = propertyType;
        this.taxRate = taxRate;

    }

    public PropertyType() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String property_Type) {
        this.propertyType = property_Type;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
