package com.coffee.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Objects;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nsvid on 08.03.2017.
 */
@Entity
@Table(name="reviews")
public class Review {

    @Column
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String comment;

    @Column
    private Integer rate;

    @Column
    private Integer aroma;

    @Column
    private Integer taste;

    @Column
    private Integer acidity;

    @Column
    private Integer aftertaste;

    @Column
    private Integer saturation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "coffee_id", referencedColumnName = "id")
    private Coffee coffee;

    @Column
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getAroma() {
        return aroma;
    }

    public void setAroma(Integer aroma) {
        this.aroma = aroma;
    }

    public Integer getTaste() {
        return taste;
    }

    public void setTaste(Integer taste) {
        this.taste = taste;
    }

    public Integer getAcidity() {
        return acidity;
    }

    public void setAcidity(Integer acidity) {
        this.acidity = acidity;
    }

    public Integer getAftertaste() {
        return aftertaste;
    }

    public void setAftertaste(Integer aftertaste) {
        this.aftertaste = aftertaste;
    }

    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Review review = (Review) o;
        return Objects.equals(id, review.id) &&
            Objects.equals(username, review.username) &&
            Objects.equals(comment, review.comment) &&
            Objects.equals(rate, review.rate) &&
            Objects.equals(aroma, review.aroma) &&
            Objects.equals(taste, review.taste) &&
            Objects.equals(acidity, review.acidity) &&
            Objects.equals(aftertaste, review.aftertaste) &&
            Objects.equals(saturation, review.saturation) &&
            Objects.equals(coffee, review.coffee) &&
            Objects.equals(timestamp, review.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects
            .hash(id, username, comment, rate, aroma, taste, acidity, aftertaste, saturation,
                coffee,
                timestamp);
    }
}

