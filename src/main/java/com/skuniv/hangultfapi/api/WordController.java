package com.skuniv.hangultfapi.api;

import com.skuniv.hangultfapi.api.responses.BaseResponse;
import com.skuniv.hangultfapi.domain.Word;
import com.skuniv.hangultfapi.service.Word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words")
public class WordController {

    @Autowired
    WordService wordService;

    /**
     * GET /words/{category}.
     * @param category id of notices
     * @return Member
     */
    @GetMapping("/{category}")
    public BaseResponse<List<String>> getMember(@PathVariable String category) {
        List<String> words = wordService.getWordsByCategory(category);
        return responseFindWordsSuccess(words);
    }

    @GetMapping
    public BaseResponse<String> tokenExsist(String token){
        BaseResponse<String> response = new BaseResponse<>();
        response.setHttpStatus(200);
        response.setMessage("toekn exist");
        return response;
    }

    @PostMapping
    public BaseResponse<Word> addWord(String name,String category){

            Word word = wordService.addWord(new Word(name,category));
            return responseAddWordsSuccess(word);
    }

    private BaseResponse<Word> responseAddWordsSuccess(Word word) {
        BaseResponse<Word> result = new BaseResponse<>();
        result.setResponseCode(0);
        result.setHttpStatus(200);
        result.setMessage("단어를 추가하였습니다.");
        result.setResult(word);
        return result;
    }
    private BaseResponse<List<String>> responseFindWordsSuccess(List<String> words) {
        BaseResponse<List<String>> result = new BaseResponse<>();
        result.setResponseCode(0);
        result.setHttpStatus(200);
        result.setMessage("단어 리스트를 찾았습니다.");
        result.setResult(words);
        return result;
    }
}
