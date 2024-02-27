package Domain;

public class Entity1 extends Entity{

    private String name;
    private String value;
    public Entity1(Integer id, String name, String value) {
        super(id);
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity1: " + id + ", " + name + ", " + value + '\n';
    }
}
