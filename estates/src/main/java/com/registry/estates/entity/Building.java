package com.registry.estates.entity;

import javax.persistence.*;

@Entity
@Table(name = "building")

public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String city;
    private String street;
    private short number;
    private double size;
    @Column(name = "market_value")
    private double marketValue;
    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    public Building(String city, String street, short number, double size, double marketValue, PropertyType propertyType, Owner owner) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.size = size;
        this.marketValue = marketValue;
        this.propertyType = propertyType;
        this.owner = owner;

    }

    public Building() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyTypeId) {
        this.propertyType = propertyTypeId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
