package ru.sapteh.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "model")
@Entity
public class Model {
    public Model() {
    }

    public Model(int id, String model, Date regDate) {
        this.id = id;
        this.model = model;
        this.regDate = regDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String model;

    @Column(name = "reg_date")
    private Date regDate;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark marks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
