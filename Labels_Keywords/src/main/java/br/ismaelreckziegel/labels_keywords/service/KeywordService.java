package br.ismaelreckziegel.labels_keywords.service;

import br.ismaelreckziegel.labels_keywords.exceptions.ConflictException;
import br.ismaelreckziegel.labels_keywords.exceptions.NotFoundException;
import br.ismaelreckziegel.labels_keywords.model.KeywordModel;
import br.ismaelreckziegel.labels_keywords.repo.KeywordRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeywordService {

    private final KeywordRepo repoKeyword;

    public KeywordService(KeywordRepo repoKeyword) {
        this.repoKeyword = repoKeyword;
    }

    public KeywordModel create(KeywordModel newKeywordModel){
        Optional<KeywordModel> existing = repoKeyword.findByKeyword(newKeywordModel.getKeyword());
        if(existing.isPresent()){
            throw new ConflictException("Keyword already exists!");
        }
        return repoKeyword.save(newKeywordModel);
    }

    public List<KeywordModel> readAll(){
        return repoKeyword.findAll();
    }

    public KeywordModel readById(Integer id){
        return repoKeyword.findById(id).orElseThrow(() -> new NotFoundException("Keyword not found!"));
    }

    public KeywordModel readByKeyword(String keyword){
        return repoKeyword.findByKeyword(keyword).orElseThrow(() -> new NotFoundException("Keyword not found!"));
    }

    public KeywordModel updateById(Integer id, KeywordModel updatekeyword){
        KeywordModel existing = repoKeyword.findById(id).orElseThrow(() -> new NotFoundException("Keyword not found!"));
        existing.setKeyword(updatekeyword.getKeyword());
        return repoKeyword.save(existing);
    }

    public void deleteById(Integer id){
        if(!repoKeyword.existsById(id)){
            throw new NotFoundException("Keyword not found!");
        }
        repoKeyword.deleteById(id);
    }

}
