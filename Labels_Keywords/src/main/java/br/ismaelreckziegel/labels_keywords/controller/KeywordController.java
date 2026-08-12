package br.ismaelreckziegel.labels_keywords.controller;

import br.ismaelreckziegel.labels_keywords.model.KeywordModel;
import br.ismaelreckziegel.labels_keywords.service.KeywordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeywordController {

    private final KeywordService service;

    public KeywordController(KeywordService service) {
        this.service = service;
    }

    // ### MÉTODOS POST ####

    @PostMapping("/keyword")
    public ResponseEntity<KeywordModel> createNewKeyword(@RequestBody KeywordModel newKeywordModel){
        return ResponseEntity.status(201).body(service.create(newKeywordModel));
    }

    // ### MÉTODOS GET ####

    @GetMapping("/keyword")
    public ResponseEntity<List<KeywordModel>> readAllKeywords(){
        return ResponseEntity.status(200).body(service.readAll());
    }

    @GetMapping("/keyword/searchid/{id}")
    public ResponseEntity<KeywordModel> readById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.readById(id));
    }

    @GetMapping("/keyword/searchkeyword")
    public ResponseEntity<KeywordModel> readByKeyword(@RequestParam String keyword){
        return ResponseEntity.status(200).body(service.readByKeyword(keyword));
    }

    // ### MÉTODOS PUT ####

    @PutMapping("keyword/update/{id}")
    public ResponseEntity<KeywordModel> updateKeyword(@PathVariable Integer id, @RequestBody KeywordModel updateKeywordModel){
        return ResponseEntity.status(200).body(service.updateById(id, updateKeywordModel));
    }

    // ### MÉTODOS DELETE ####

    @DeleteMapping("/keyword/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
