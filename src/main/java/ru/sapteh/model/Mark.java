package ru.sapteh.model;


import javax.persistence.*;
import java.util.Set;

@Table(name = "mark")
@Entity
public class Mark {

    public Mark() {
    }

    public Mark(int id, String concern, String mark) {
        this.id = id;
        this.concern = concern;
        this.mark = mark;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String concern;

    @Column
    private String mark;

    @OneToMany(mappedBy = "marks")
    private Set<Model> models;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", concern='" + concern + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
