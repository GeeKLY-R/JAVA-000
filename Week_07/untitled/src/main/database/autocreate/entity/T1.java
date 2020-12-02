package main.database.autocreate.entity;

import java.io.Serializable;

public class T1 extends Model<T1> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "T1{" +
                "id=" + id +
                "}";
    }
}