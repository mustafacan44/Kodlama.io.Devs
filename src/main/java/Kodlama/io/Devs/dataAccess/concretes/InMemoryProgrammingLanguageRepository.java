package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
    List<ProgrammingLanguage> programmingLanguageList;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguageList = new ArrayList<ProgrammingLanguage>();
        programmingLanguageList.add(new ProgrammingLanguage(1, "java"));
        programmingLanguageList.add(new ProgrammingLanguage(2, "C#"));
        programmingLanguageList.add(new ProgrammingLanguage(3, "javascript"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageList;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguageList.add(programmingLanguage);

    }

    @Override
    public void delete(int id) {
        for (ProgrammingLanguage language : programmingLanguageList) {
            if (language.getId() == id) {
                programmingLanguageList.remove(id-1);
            }
        }
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage language : programmingLanguageList) {
            if (language.getId() == programmingLanguage.getId()) {
               programmingLanguageList.set(language.getId()-1,programmingLanguage);
            }
        }


    }

    @Override
    public ProgrammingLanguage getById(int id) {

        return programmingLanguageList.get(id-1);
    }
}
