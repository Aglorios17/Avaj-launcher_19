package ro.academyplus.avaj.simulator;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.gettype() + "#" + p_flyable.getname() + "(" + p_flyable.getid() + ")" + " registered to weather tower.");
    }
    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println(p_flyable.gettype() + "#"+ p_flyable.getname() + "(" + p_flyable.getid() + ")" + " landing.");
        System.out.println("Tower says: " + p_flyable.gettype() + "#" + p_flyable.getname() + "(" + p_flyable.getid() + ")" + " unregistered from weather tower.");
    }
    protected void conditionChanged() {
        for (int j = 0; j < observers.size(); j++)
        {
                observers.get(j).updateConditions();
                if (observers.get(j).getcoordinates().getHeight() <= 0)
                    unregister(observers.get(j--));
        }
    }
}
