package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.Mark;
import ru.sapteh.model.Model;

import java.util.List;

public class MarkService implements DAO<Mark, Integer> {
    private final SessionFactory factory;

    public MarkService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Mark mark) {
        try(Session session = factory.openSession()){
            String sqlCreate = "INSERT INTO mark (concern,mark) VALUES (':concern',':mark')";
            Query<Mark> query = session.createNativeQuery(sqlCreate,Mark.class);
            query.setParameter("concern",mark.getConcern()).setParameter("mark",mark.getMark());

            session.getTransaction().commit();
        }

    }

    @Override
    public Mark read(Integer integer) {
        try(Session session = factory.openSession()){
            String sqlRead = "SELECT * FROM mark WHERE id=:id";
            NativeQuery<Mark> query = session.createNativeQuery(sqlRead,Mark.class);
            query.setParameter("id", integer);
            return (Mark) query;
        }

    }

    @Override
    public List<Mark> readAllBy() {
        try(Session session = factory.openSession()) {
            String sql = "select * from mark";
            Query<Mark> query = session.createNativeQuery(sql, Mark.class);
            return query.list();
        }
    }

    @Override
    public void update(Mark mark) {
        try(Session session = factory.openSession()){
            String sqlUpdate = "UPDATE mark set (concern,mark) = (:concern,:mark)";
            NativeQuery<Mark> query = session.createNativeQuery(sqlUpdate, Mark.class);
            query.setParameter("concern",mark.getConcern()).setParameter("mark",mark.getMark());
            session.getTransaction().commit();
        }


    }

    @Override
    public void delete(Mark mark) {
        try (Session session = factory.openSession()){
            String sqlDelete = "DELETE FROM mark WHERE id=:id";
            NativeQuery<Mark> query = session.createNativeQuery(sqlDelete, Mark.class);
            query.setParameter("id", mark.getId());
            session.getTransaction().commit();
        }

    }
}
