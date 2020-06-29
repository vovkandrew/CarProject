package carproject.dto;

public class CarDoorResponseDto {
    private String doorState;
    private String windowState;

    public CarDoorResponseDto(String doorState, String windowState) {
        this.doorState = doorState;
        this.windowState = windowState;
    }

    public CarDoorResponseDto() {
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
