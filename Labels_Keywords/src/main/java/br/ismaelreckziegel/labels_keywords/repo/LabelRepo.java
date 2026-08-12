package br.ismaelreckziegel.labels_keywords.repo;

import br.ismaelreckziegel.labels_keywords.model.LabelModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface LabelRepo extends ListCrudRepository<LabelModel, Integer> {

    public LabelModel findByLabel(String Label);

    public List<LabelModel> findByKeywordsKeyword(String keyword);

}
