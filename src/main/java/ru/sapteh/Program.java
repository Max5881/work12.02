package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Service.MarkService;
import ru.sapteh.Service.ModelService;
import ru.sapteh.model.Mark;
import ru.sapteh.model.Model;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        DAO<Model,Integer> modelDAO = new ModelService(factory);
        DAO<Mark, Integer> markDAO = new MarkService(factory);

        Mark mark = new Mark();
        mark.setConcern("VAG");
        mark.setMark("X5M");

        markDAO.create(mark);

//        Model model = new Model();
//        model.setModel("BMW");
//        model.setRegDate(new Date(23098754109237591L));
//
//        modelDAO.create(model);
    }
}
