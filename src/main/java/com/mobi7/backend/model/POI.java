package com.mobi7.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class POI {

    private @Id @GeneratedValue Long id;
    private String nome;
    private Integer raio;
    private Double latitude;
    private Double longitude;

    public POI(String nome, Integer raio, Double latitude, Double longitude) {
        this.nome = nome;
        this.raio = raio;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public POI() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRaio() {
        return raio;
    }

    public void setRaio(Integer raio) {
        this.raio = raio;
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

    @Override
    public String toString() {
        return "POI{" + "id=" + this.id + ", nome='" + this.nome + '\'' + ", raio='" + this.raio + '\'' + ", latitude='" + this.latitude + '\'' + ", longitude='" + this.longitude + '\'' + '}';
    }    

}
