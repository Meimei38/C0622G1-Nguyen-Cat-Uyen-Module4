package dictionary.repository.impl;

import dictionary.model.Word;
import dictionary.repository.IDictionaryRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepo implements IDictionaryRepo {
    static List<Word> wordList = new ArrayList<>();
    static {
        wordList.add(new Word("car","xe hơi"));
        wordList.add(new Word("cat","mèo"));
        wordList.add(new Word("dog","chó"));
        wordList.add(new Word("mouse","chuột"));
    }

    @Override
    public String checkUp(String english) {
        for (int i = 0; i <wordList.size() ; i++) {
            if(english== wordList.get(i).getEnglish()){
                return wordList.get(i).getVietnamese();
            }
        }
        return "Không có từ này, vui lòng thử lại!";
    }
}
