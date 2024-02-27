package Service;

import Domain.Entity;
import Domain.Entity2;
import Repository.IRepository;

import java.util.ArrayList;

public class ServiceEntity2 {
    IRepository<Entity2> repoEntity2;

    public ServiceEntity2(IRepository<Entity2> repoEntity2) {
        this.repoEntity2 = repoEntity2;
    }

    public void add (Entity2 entity){
        repoEntity2.add(entity);
    }

    public void delete(Integer id){
        repoEntity2.delete(id);
    }

    public void update(Integer id,Entity2 entity){
        repoEntity2.update(id,entity);
    }

    public ArrayList<Entity> getAll(){
        return new ArrayList<>(repoEntity2.getAll());
    }
}
