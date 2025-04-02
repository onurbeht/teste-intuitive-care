package com.desafio04.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio04.domain.entity.Operadoras;

public interface OperadorasRepository extends JpaRepository<Operadoras, Integer> {

    Page<Operadoras> findAll(Pageable pageable);

}
