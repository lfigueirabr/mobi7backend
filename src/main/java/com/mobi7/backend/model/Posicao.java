package com.mobi7.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Posicao {
    private @Id @GeneratedValue Long id;
    private String placa;
    private Date data;
    private Integer velocidade;
    private Double latitude;
    private Double longitude;
    private Boolean ignicao;

    public Posicao(String placa, Date data, Integer velocidade, Double latitude, Double longitude,
            Boolean ignicao) {
        this.placa = placa;
        this.data = data;
        this.velocidade = velocidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ignicao = ignicao;
    }

    public Posicao() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getIgnicao() {
        return ignicao;
    }

    public void setIgnicao(Boolean ignicao) {
        this.ignicao = ignicao;
    }

    @Override
    public String toString() {
        return "Posicao{" + "id=" + this.id + ", placa='" + this.placa + '\'' + ", data='" + this.data + '\'' + ", latitude='" + this.latitude + '\'' + ", longitude='" + this.longitude + '\'' + ", ignicao='" + this.ignicao + '\'' + '}';
    } 
    
}
