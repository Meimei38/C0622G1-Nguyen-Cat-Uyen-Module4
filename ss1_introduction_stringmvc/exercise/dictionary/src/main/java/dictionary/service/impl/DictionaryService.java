package dictionary.service.impl;

import dictionary.repository.IDictionaryRepo;
import dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    IDictionaryRepo dictionaryRepo;
    @Override
    public String checkUp(String englishWord) {
        return dictionaryRepo.checkUp(englishWord);
    }
}
