package main.database.autocreate.service.impl;

import main.database.autocreate.entity.T1;

import java.util.List;

public interface IT1Service extends IService<T1> {

    public List<Integer> getList();

    public void add(Integer id);
}