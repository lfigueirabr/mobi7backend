package com.mobi7.backend.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PosicaoRepository extends JpaRepository<Posicao, Long> {

    @Query("from Posicao p where p.data between :begin and :end")
    public List<Posicao> findByDataBetween(Date begin, Date end);

    @Query("from Posicao p where p.placa = :placa and p.data between :begin and :end")
    public List<Posicao> findByPlacaAndDataBetween(String placa, Date begin, Date end);

    @Query("select distinct p.placa from Posicao p order by p.placa asc")
    public List<String> findPlacas();
}