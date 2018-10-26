package com.skuniv.hangultfapi.repositories;

import com.skuniv.hangultfapi.domain.Custom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomRepository extends JpaRepository<Custom,Long> {

    List<Custom> findAll();
}
