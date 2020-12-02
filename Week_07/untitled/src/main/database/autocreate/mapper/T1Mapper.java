package main.database.autocreate.mapper;

import main.database.autocreate.entity.T1;

import java.util.List;

public interface T1Mapper extends BaseMapper<T1> {

    void add(Integer id);

    List<Integer> getList();
}
