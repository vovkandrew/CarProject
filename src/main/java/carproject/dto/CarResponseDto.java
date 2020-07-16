package carproject.dto;

public class CarResponseDto {
    private String releaseDate;
    private String engineType;
    private int maxSpeed;
    private double accelerationTo100;
    private int numberOfSeats;

    public CarResponseDto(String releaseDate, String engineType,
                          int maxSpeed, double accelerationTo100,
                          int numberOfSeats) {
        this.releaseDate = releaseDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelerationTo100 = accelerationTo100;
        this.numberOfSeats = numberOfSeats;
    }

    public CarResponseDto() {
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAccelerationTo100() {
        return accelerationTo100;
    }

    public void setAccelerationTo100(double accelerationTo100) {
        this.accelerationTo100 = accelerationTo100;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
