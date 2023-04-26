package srcs;
import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers;
    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.println("REGISTER IN TOWER");
    }
    public void unregister(Flyable p_Flyable) {}
    protected void conditionChanged() {}
}
