package carproject.dto;

public class CarDoorRequestDto {
    private String doorState;
    private String windowState;

    public CarDoorRequestDto(String doorState, String windowState) {
        this.doorState = doorState;
        this.windowState = windowState;
    }

    public CarDoorRequestDto() {
    }

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public String getWindowState() {
        return windowState;
    }

    public void setWindowState(String windowState) {
        this.windowState = windowState;
    }
}
