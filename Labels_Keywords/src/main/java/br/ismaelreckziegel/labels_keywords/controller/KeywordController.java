package br.ismaelreckziegel.labels_keywords.controller;

import br.ismaelreckziegel.labels_keywords.model.Keyword;
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
    public ResponseEntity<Keyword> createNewKeyword(@RequestBody Keyword newKeyword){
        return ResponseEntity.status(201).body(service.create(newKeyword));
    }

    // ### MÉTODOS GET ####

    @GetMapping("/keyword")
    public ResponseEntity<List<Keyword>> readAllKeywords(){
        return ResponseEntity.status(200).body(service.readAll());
    }

    @GetMapping("/keyword/searchid/{id}")
    public ResponseEntity<Keyword> readById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.readById(id));
    }

    @GetMapping("/keyword/searchkeyword")
    public ResponseEntity<Keyword> readByKeyword(@RequestParam String keyword){
        return ResponseEntity.status(200).body(service.readByKeyword(keyword));
    }

    // ### MÉTODOS PUT ####

    @PutMapping("keyword/update/{id}")
    public ResponseEntity<Keyword> updateKeyword(@PathVariable Integer id, @RequestBody Keyword updateKeyword){
        return ResponseEntity.status(200).body(service.updateById(id, updateKeyword));
    }

    // ### MÉTODOS DELETE ####

    @DeleteMapping("/keyword/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
