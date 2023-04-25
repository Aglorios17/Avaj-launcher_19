package srcs;
import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers;
    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_Flyable) {}
    protected void conditionChanged() {}
}
