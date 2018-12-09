package com.company.Common.Interfaces;

import com.company.Common.Commons.DomainObject;

import java.util.List;
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