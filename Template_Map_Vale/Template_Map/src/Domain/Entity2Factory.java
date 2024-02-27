package Domain;

public class Entity2Factory implements IEntityFactory<Entity2>{
    @Override
    public String entityToString(Entity2 entity) {
        return entity.getId() + "," + entity.isTruth() + "," + entity.getValue2();
    }

    @Override
    public Entity2 StringToEntity(String line) {
        int id = Integer.parseInt(line.split(",")[0]);
        Boolean truth = Boolean.parseBoolean(line.split(",")[1]);
        int value2 = Integer.parseInt(line.split(",")[2]);

        return new Entity2(id, truth, value2);
    }
}
