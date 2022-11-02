package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private ProgrammingLanguageRepository languageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {
        for(ProgrammingLanguage language : languageRepository.getAll()){
            if(language.getName().equals(programmingLanguage.getName())){
                throw new Exception("Aynı isimde program dili olamaz.");
            }
        }
        if(programmingLanguage.getName().isEmpty()){
            throw new Exception("Programlama dili boş geçilemez.");
        }
        languageRepository.add(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) throws Exception {

        if(programmingLanguage.getName().isEmpty()){
            throw new Exception("Programlama dili boş geçilemez.");
        }
        for(ProgrammingLanguage language :languageRepository.getAll()){
            if(language.getName().equals(programmingLanguage.getName())){
                throw new Exception("Aynı isimde program dili olamaz.");
            }
        }

        languageRepository.update(programmingLanguage);
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return languageRepository.getById(id);
    }
}
