package ru.sapteh.DAO;

import java.util.List;
public interface DAO <Entity,Key>{

    void create(Entity entity);
    Entity read(Key key);
    List<Entity> readAllBy ();
    void update (Entity entity);
    void delete (Entity entity);

}
