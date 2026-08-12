package br.ismaelreckziegel.labels_keywords.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_label")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_label")
    private Integer id;

    @Column(name = "label_value", nullable = false, unique = true)
    private String label;

    @ManyToMany
    @JoinTable(name = "tbl_label_keyword",
            joinColumns = @JoinColumn(name = "tbl_label_id_label"),
            inverseJoinColumns = @JoinColumn(name = "tbl_keyword_id_keyword"))
    private List<Keyword> keywords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }
}
