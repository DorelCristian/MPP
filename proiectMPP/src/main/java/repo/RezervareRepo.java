package repo;

import domain.Rezervare;

public interface RezervareRepo extends IRepository<Integer, Rezervare>{
    Rezervare findByName(String name);
    void add(Rezervare elem);
    void update(Integer integer, Rezervare elem);
}
