package com.company.Interfaces;

import com.company.Commons.DomainObject;
import com.sun.javafx.fxml.expression.Expression;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface IRepository<Entity extends DomainObject>  {
    Entity create(Entity object);
    Entity update(Entity object);
    void remove(Entity object);
    void remove(int key);
    Entity findById(int key);
    List<Entity> get(Predicate<Entity> predicate);
    List<Entity> get();
    Boolean ExistAny(Predicate<Entity> predicate);
}