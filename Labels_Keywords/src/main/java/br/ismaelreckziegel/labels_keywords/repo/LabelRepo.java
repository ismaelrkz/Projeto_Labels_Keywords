package br.ismaelreckziegel.labels_keywords.repo;

import br.ismaelreckziegel.labels_keywords.model.Label;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface LabelRepo extends ListCrudRepository<Label, Integer> {

    public Label findByLabel(String Label);

    public List<Label> findByKeywordsKeyword(String keyword);

}
