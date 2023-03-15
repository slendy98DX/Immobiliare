package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Immobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String venditore;

    private Integer piani;

    private Integer mq;

    private BigDecimal prezzo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVenditore() {
        return venditore;
    }

    public void setVenditore(String venditore) {
        this.venditore = venditore;
    }

    public Integer getPiani() {
        return piani;
    }

    public void setPiani(Integer piani) {
        this.piani = piani;
    }

    public Integer getMq() {
        return mq;
    }

    public void setMq(Integer mq) {
        this.mq = mq;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}
