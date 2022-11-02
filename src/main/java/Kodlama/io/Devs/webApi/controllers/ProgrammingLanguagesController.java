package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/language")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService languageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get")
    public List<ProgrammingLanguage> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/get/{id}")
    public ProgrammingLanguage getById(@PathVariable int id){
        return languageService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        languageService.add(programmingLanguage);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        languageService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        languageService.update(programmingLanguage);
    }
}
