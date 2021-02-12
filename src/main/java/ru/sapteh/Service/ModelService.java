package ru.sapteh.Service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.Model;

import java.util.List;


public class ModelService implements DAO<Model,Integer> {
    private final SessionFactory factory;

    public ModelService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Model model) {
        try(Session session = factory.openSession()) {
            String sqlAdd = "insert into model(model,reg_date) values (:model,:reg_date)";
            NativeQuery<Model> query = session.createNativeQuery(sqlAdd, Model.class);
            query.setParameter("model",model.getModel()).setParameter("reg_date", model.getRegDate());
            session.getTransaction().commit();
        }

    }

    @Override
    public Model read(Integer integer) {
        try(Session session = factory.openSession()){
            String sqlRead = "SELECT * FROM model where id=:id";
            NativeQuery<Model> query = session.createNativeQuery(sqlRead,Model.class);
            query.setParameter("id", integer);
            return (Model) query;

        }
    }

    @Override
    public List<Model> readAllBy() {
        try(Session session = factory.openSession()){
            String sql = "select * from model";
            Query<Model> query = session.createNativeQuery(sql,Model.class);
            return query.list();
        }

    }

    @Override
    public void update(Model model) {
        try(Session session = factory.openSession()){
            String sqlUpdate = "UPDATE model set (model,reg_date) = (:model,:reg_date)";
            NativeQuery<Model> query = session.createNativeQuery(sqlUpdate, Model.class);
            query.setParameter("model",model.getModel()).setParameter("reg_date",model.getRegDate());
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Model model) {
        try (Session session = factory.openSession()){
            String sqlDelete = "DELETE FROM model WHERE id=:id";
            NativeQuery<Model> query = session.createNativeQuery(sqlDelete, Model.class);
            query.setParameter("id", model.getId());
            session.getTransaction().commit();
        }

    }
}
