package com.company.Common.Commons;

import com.company.Common.Interfaces.IRepository;
import com.company.Common.Models.Repositories.EmailRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BaseRepository<Entity extends DomainObject> implements IRepository<Entity> {

    private List<Entity> dbSet = null;

    public BaseRepository(List<Entity> dbSet) {
        this.dbSet = dbSet;
    }


    @Override
    public Entity create(Entity entity) {
        entity.Key = generateID();
        dbSet.add(entity);
        return entity;
    }

    @Override
    public Entity update(Entity entity) {
        for (Entity object :
                dbSet) {
            if (object.Key == entity.Key) {
                object = entity;
                return object;
            }
        }
        return null;
    }

    @Override
    public void remove(Entity object) {
        remove(object.Key);
    }

    @Override
    public void remove(int key) {
        int index;
        for (int i = 0; i < dbSet.size(); i++) {
            if (dbSet.get(i).Key == key) {
                dbSet.remove(i);
                return;
            }
        }
    }

    @Override
    public Entity findById(int key) {
        for (Entity entity :
                dbSet) {
            if (entity.Key == key) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<Entity> get() {
        return dbSet;
    }

    @Override
    public Boolean ExistAny(Predicate<Entity> predicate) {
        return dbSet.stream().filter(predicate).collect(Collectors.toList()).size() > 0;
    }

    @Override
    public List<Entity> get(Predicate<Entity> predicate) {
        return dbSet.stream().filter(predicate).collect(Collectors.toList());
    }

    private int generateID() {
        int maxKey = 1;
        if (dbSet.size() > 0) {
            maxKey = dbSet.get(dbSet.size() - 1).Key + 1;
        }
        return maxKey;
    }
}
