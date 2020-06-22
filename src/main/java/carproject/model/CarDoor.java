package carproject.model;

public class CarDoor {
    private DoorState doorState;

    public enum DoorState {
        OPEN, CLOSED
    }

    private WindowState windowState;

    public enum WindowState {
        OPEN, CLOSED
    }

    public CarDoor(DoorState doorState, WindowState windowState) {
        this.doorState = doorState;
        this.windowState = windowState;
    }

    public DoorState getDoorState() {
        return doorState;
    }

    public void setDoorState(DoorState doorState) {
        this.doorState = doorState;
    }

    public WindowState getWindowState() {
        return windowState;
    }

    public void setWindowState(WindowState windowState) {
        this.windowState = windowState;
    }

    @Override
    public String toString() {
        return "CarDoor{"
                + "doorState="
                + doorState
                + ", windowState="
                + windowState
                + '}';
    }

    public void openTheDoor() {
        if (getDoorState().equals(DoorState.CLOSED)) {
            setDoorState(DoorState.OPEN);
        }
    }

    public void closeTheDoor() {
        if (getDoorState().equals(DoorState.OPEN)) {
            setDoorState(DoorState.CLOSED);
        }
    }

    public void openOrCloseTheDoor() {
        if (getDoorState().equals(DoorState.OPEN)) {
            closeTheDoor();
        } else {
            openTheDoor();
        }
    }

    public void openTheWindow() {
        if (getWindowState().equals(WindowState.CLOSED)) {
            setWindowState(WindowState.OPEN);
        }
    }

    public void closeTheWindow() {
        if (getWindowState().equals(WindowState.OPEN)) {
            setWindowState(WindowState.CLOSED);
        }
    }

    public void openOrCloseTheWindow() {
        if (getWindowState().equals(WindowState.OPEN)) {
            closeTheWindow();
        } else {
            openTheWindow();
        }
    }
}
