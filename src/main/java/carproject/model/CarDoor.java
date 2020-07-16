package carproject.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doorId;
    @Enumerated(value = EnumType.STRING)
    private DoorState doorState;
    @Enumerated(value = EnumType.STRING)
    private WindowState windowState;

    public enum WindowState {
        OPEN, CLOSED
    }

    public enum DoorState {
        OPEN, CLOSED
    }

    public CarDoor() {
    }

    public CarDoor(DoorState doorState, WindowState windowState) {
        this.doorState = doorState;
        this.windowState = windowState;
    }

    public long getDoorId() {
        return doorId;
    }

    public void setDoorId(long doorId) {
        this.doorId = doorId;
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
