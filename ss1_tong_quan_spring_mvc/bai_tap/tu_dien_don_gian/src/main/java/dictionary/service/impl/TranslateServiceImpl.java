package dictionary.service.impl;

import dictionary.service.ITranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateServiceImpl implements ITranslateService {
    @Override
    public Map<String, String> storeDictionary() {
        Map<String,String> mapDictionary = new HashMap<>();
        mapDictionary.put("Hello","Xin Chao");
        mapDictionary.put("Good Bye","Chao Tam Biet");
        mapDictionary.put("Thanks","Cam On");

        return mapDictionary;
    }
}
