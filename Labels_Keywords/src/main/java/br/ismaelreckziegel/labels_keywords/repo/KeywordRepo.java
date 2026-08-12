package br.ismaelreckziegel.labels_keywords.repo;

import br.ismaelreckziegel.labels_keywords.model.KeywordModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface KeywordRepo extends ListCrudRepository<KeywordModel, Integer> {

    public Optional<KeywordModel> findByKeyword(String keyword);

}
