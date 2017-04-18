package com.coffee.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by nsvid on 07.03.2017.
 */
@Entity
@Table(name="coffees")
public class Coffee {

    @Column
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private Integer volume;

    @Column
    private String name;

    @Column
    private String vendor;

    @Column
    private String country;

    @Column
    private Double price;

    @Column
    private String notes;

    @Column
    private Date introduced;

    @OneToMany(mappedBy = "coffee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    Set<Review> reviews;

    @OneToMany(mappedBy = "coffee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    Set<Image> images;

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Date getIntroduced() {
        return introduced;
    }

    public void setIntroduced(Date introduced) {
        this.introduced = introduced;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id) &&
                Objects.equals(volume, coffee.volume) &&
                Objects.equals(name, coffee.name) &&
                Objects.equals(vendor, coffee.vendor) &&
                Objects.equals(country, coffee.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volume, name, vendor, country);
    }
}
