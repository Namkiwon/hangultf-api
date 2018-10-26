package com.skuniv.hangultfapi.repositories;

import com.skuniv.hangultfapi.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word,Long> {

    List<Word> findAll();
}
