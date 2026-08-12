package br.ismaelreckziegel.labels_keywords.controller;

import br.ismaelreckziegel.labels_keywords.model.LabelModel;
import br.ismaelreckziegel.labels_keywords.service.LabelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LabelController {

    private final LabelService service;

    public LabelController(LabelService service) {
        this.service = service;
    }

    // ### ----- MÉTODOS POST ----- ####

    @PostMapping("/label")
    public ResponseEntity<LabelModel> createNewLabel(@RequestBody LabelModel newLabelModel){
        return ResponseEntity.status(201).body(service.create(newLabelModel));
    }

    // ### ----- MÉTODOS GET ----- ####

    @GetMapping("/label")
    public ResponseEntity<List<LabelModel>> readAllLabels(){
        return ResponseEntity.status(200).body(service.readAll());
    }

    @GetMapping("/label/searchid/{id}")
    public ResponseEntity<LabelModel> readById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.readById(id));
    }

    @GetMapping("/label/searchlabel") // cliente: /label/searchlabel?keyword=xxx xxx xxx
    public ResponseEntity<List<LabelModel>> readByKeyword(@RequestParam String keyword){
        return ResponseEntity.status(200).body(service.readByKeyword(keyword));
    }

    // ### ----- MÉTODOS PUT ----- ####

    @PutMapping("label/update/{id}")
    public ResponseEntity<LabelModel> updateLabel(@PathVariable Integer id, @RequestBody LabelModel updateValue){
        return ResponseEntity.status(200).body(service.updateById(id, updateValue));
    }

    // ### ----- MÉTODOS DELETE ----- ####

    @DeleteMapping("/label/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
