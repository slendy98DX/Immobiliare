package org.example.controllers.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class ImmobileResponseDto {
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
