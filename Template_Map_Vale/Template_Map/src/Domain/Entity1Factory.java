package Domain;

public class Entity1Factory implements IEntityFactory<Entity1>{
    @Override
    public String entityToString(Entity1 entity) {
        return entity.getId() + "," + entity.getName() + "," + entity.getValue();
    }

    @Override
    public Entity1 StringToEntity(String line) {
        int id = Integer.parseInt(line.split(",")[0]);
        String name = line.split(",")[1];
        String value = line.split(",")[2];

        return new Entity1(id, name,value);
    }
}
