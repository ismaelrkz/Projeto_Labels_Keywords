package br.ismaelreckziegel.labels_keywords.repo;

import br.ismaelreckziegel.labels_keywords.model.Keyword;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface KeywordRepo extends ListCrudRepository<Keyword, Integer> {

    public Optional<Keyword> findByKeyword(String keyword);

}
