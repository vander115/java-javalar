package system.planets;

public class Time {
    private double instantDuration;
    private double passedHours;

    public Time(double instantDuration) {
        this.instantDuration = instantDuration;
        this.passedHours = 0;
    }

    public double getDurationOfYear() {
        return instantDuration;
    }

    public double getPassedDays() {
        return passedHours / 24;
    }

    public double getPassedHours() {
        return passedHours;
    }

    public void incrementHours(int numberOfInstants) {

        passedHours += instantDuration * numberOfInstants;

    }
}
