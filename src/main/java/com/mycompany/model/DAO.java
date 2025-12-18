package com.mycompany.model;

import java.util.List;

public interface DAO <Objeto> {
    public boolean create(Objeto object);
    public boolean delete(Objeto object);
    public boolean update(Objeto object);
    public Objeto read(Objeto object);
    public List<Objeto> readAll();
}   
