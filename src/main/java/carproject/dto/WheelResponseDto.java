package carproject.dto;

public class WheelResponseDto {
    private double wheelState;

    public WheelResponseDto(double wheelState) {
        this.wheelState = wheelState;
    }

    public WheelResponseDto() {
    }

    public double getWheelState() {
        return wheelState;
    }

    public void setWheelState(double wheelState) {
        this.wheelState = wheelState;
    }
}
