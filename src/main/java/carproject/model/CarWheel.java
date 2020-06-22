package carproject.model;

public class CarWheel {
    private double wheelState;

    public CarWheel(double wheelState) {
        this.wheelState = wheelState;
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
                + "wheelState="
                + wheelState
                + '}';
    }
}
