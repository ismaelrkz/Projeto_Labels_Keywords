package br.ismaelreckziegel.labels_keywords.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_keyword")
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_keyword")
    private Integer id;

    @Column(name = "keyword_value",  nullable = false, unique = true)
    private String keyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
