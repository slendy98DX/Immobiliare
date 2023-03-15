package org.example.controllers.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class ImmobileRequestDto {
    private String address;

    private Integer piani;

    private Integer mq;

    private BigDecimal prezzo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
