package carproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wheelId;
    private double wheelState;

    public CarWheel() {
    }

    public CarWheel(double wheelState) {
        this.wheelState = wheelState;
    }

    public long getWheelId() {
        return wheelId;
    }

    public void setWheelId(long wheelId) {
        this.wheelId = wheelId;
    }

    public double getWheelState() {
        return wheelState;
    }

    public void setWheelState(double wheelState) {
        this.wheelState = wheelState;
    }

    public void setNewWheel() {
        setWheelState(1);
    }

    public void eraseWheel(int percentage) {
        int newWheelState = (int) (getWheelState() * (100 - percentage));
        setWheelState((double) newWheelState / 100);
    }

    public String returnCurrentWheelState() {
        return ((int)(getWheelState() * 100)) + "%";
    }

    @Override
    public String toString() {
        return "CarWheel{"
                + "wheelID="
                + wheelId
                + ", wheelState="
                + wheelState
                + '}';
    }
}
