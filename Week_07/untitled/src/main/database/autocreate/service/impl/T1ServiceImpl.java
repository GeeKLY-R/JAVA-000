package main.database.autocreate.service.impl;

import main.database.autocreate.entity.T1;
import main.database.autocreate.mapper.T1Mapper;

import java.util.List;

@Service
public class T1ServiceImpl extends ServiceImpl<T1Mapper, T1> implements IT1Service {

    @Autowired
    private T1Mapper mapper;



    @readOnly(name = DataSourceNames.SECOND_DATASOURCE)
    @Override
    public List<Integer> getList() {
        return mapper.getList();
    }

    @Override
    public void add(Integer id) {
        mapper.add(id);
    }
}
