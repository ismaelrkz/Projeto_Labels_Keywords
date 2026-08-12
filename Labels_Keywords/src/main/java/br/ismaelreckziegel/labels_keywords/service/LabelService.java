package br.ismaelreckziegel.labels_keywords.service;

import br.ismaelreckziegel.labels_keywords.exceptions.ConflictException;
import br.ismaelreckziegel.labels_keywords.exceptions.NotFoundException;
import br.ismaelreckziegel.labels_keywords.model.LabelModel;
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

    public LabelModel create(LabelModel newLabelModel){
        LabelModel existing = repoLabel.findByLabel(newLabelModel.getLabel());
        if(existing != null){
            throw new ConflictException("Label already exists!");
        }
        return repoLabel.save(newLabelModel);
    }

    public List<LabelModel> readAll(){
        return repoLabel.findAll();
    }

    public LabelModel readById(Integer id){
        return repoLabel.findById(id).orElseThrow(() -> new NotFoundException("Keyword not found!"));
    }

    public List<LabelModel> readByKeyword(String keyword){ // METODO que usa a relação associativa M:N para buscar Labels por Keyword
        repoKeyword.findByKeyword(keyword).orElseThrow(() -> new NotFoundException("Keyword not found!"));
        return repoLabel.findByKeywordsKeyword(keyword);
    }

    public LabelModel updateById(Integer id, LabelModel updateLabelModel){
        LabelModel existing = repoLabel.findById(id).orElseThrow(() -> new NotFoundException("Label not found!"));
        existing.setLabel(updateLabelModel.getLabel());
        return repoLabel.save(existing);
    }

    public void deleteById(Integer id){
        if(!repoLabel.existsById(id)){
            throw new NotFoundException("Keyword not found!");
        }
        repoLabel.deleteById(id);
    }

}
