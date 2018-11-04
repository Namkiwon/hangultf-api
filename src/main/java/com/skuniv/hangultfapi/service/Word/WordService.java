package com.skuniv.hangultfapi.service.Word;

import com.skuniv.hangultfapi.domain.Word;
import com.skuniv.hangultfapi.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordService {

    @Autowired
    WordRepository wordRepository;

    public List<String> getWordsByCategory(String category){
        return wordRepository.findAllByCategory(category).stream().map(word -> {
            return word.getName();
        }).collect(Collectors.toList());
    }

    public Word addWord(Word word) {
        return wordRepository.save(word);
    }

}
