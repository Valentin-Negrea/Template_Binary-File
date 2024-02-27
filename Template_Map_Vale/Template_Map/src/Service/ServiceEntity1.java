package Service;

import Domain.Entity;
import Domain.Entity1;

import Repository.AbstractRepository;
import Repository.IRepository;

import java.util.ArrayList;

public class ServiceEntity1 {
    IRepository<Entity1> repoEntity1;

    public ServiceEntity1(AbstractRepository<Entity1> repoEntity1) {
        this.repoEntity1 = repoEntity1;
    }

    public void add (Entity1 entity){
        repoEntity1.add(entity);
    }

    public void delete(Integer id){
        repoEntity1.delete(id);
    }

    public void update(Integer id,Entity1 entity){
        repoEntity1.update(id,entity);
    }

    public ArrayList<Entity> getAll(){
        return new ArrayList<>(repoEntity1.getAll());
    }
}
