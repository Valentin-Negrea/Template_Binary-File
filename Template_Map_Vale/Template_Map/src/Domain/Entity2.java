package Domain;

public class Entity2 extends Entity{
    private boolean truth;
    private int value2;
    public Entity2(Integer id, boolean truth, int value2) {
        super(id);
        this.truth = truth;
        this.value2 = value2;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public boolean isTruth() {
        return truth;
    }

    public void setTruth(boolean truth) {
        this.truth = truth;
    }

    @Override
    public String toString() {
        return "Entity2: " + id + ", " + truth + ", " + value2 + '\n';
    }
}
