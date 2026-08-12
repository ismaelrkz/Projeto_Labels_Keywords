package br.ismaelreckziegel.labels_keywords.service;

import br.ismaelreckziegel.labels_keywords.exceptions.ConflictException;
import br.ismaelreckziegel.labels_keywords.exceptions.NotFoundException;
import br.ismaelreckziegel.labels_keywords.model.Label;
import br.ismaelreckziegel.labels_keywords.repo.KeywordRepo;
import br.ismaelreckziegel.labels_keywords.repo.LabelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService{

    private final LabelRepo repoLabel;
    private final KeywordRepo repoKeyword;

    public LabelService(LabelRepo repoLabel, KeywordRepo repoKeyword) {
        this.repoLabel = repoLabel;
        this.repoKeyword = repoKeyword;
    }

    public Label create(Label newLabel){
        Label existing = repoLabel.findByLabel(newLabel.getLabel());
        if(existing != null){
            throw new ConflictException("Label already exists!");
        }
        return repoLabel.save(newLabel);
    }

    public List<Label> readAll(){
        return repoLabel.findAll();
    }

    public Label readById(Integer id){
        return repoLabel.findById(id).orElseThrow(() -> new NotFoundException("Keyword not found!"));
    }

    public List<Label> readByKeyword(String keyword){ // METODO que usa a relação associativa M:N para buscar Labels por Keyword
        repoKeyword.findByKeyword(keyword).orElseThrow(() -> new NotFoundException("Keyword not found!"));
        return repoLabel.findByKeywordsKeyword(keyword);
    }

    public Label updateById(Integer id, Label updateLabel){
        Label existing = repoLabel.findById(id).orElseThrow(() -> new NotFoundException("Label not found!"));
        existing.setLabel(updateLabel.getLabel());
        return repoLabel.save(existing);
    }

    public void deleteById(Integer id){
        if(!repoLabel.existsById(id)){
            throw new NotFoundException("Keyword not found!");
        }
        repoLabel.deleteById(id);
    }

}
