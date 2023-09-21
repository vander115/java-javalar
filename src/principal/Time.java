package principal;

public class Time {
	private double instantDuration;
	private double passedHours;
	private int passedDays;

	public Time(double instantDuration) {
		this.instantDuration = instantDuration;
		this.passedDays = 0;
		this.passedHours = 0;
	}

	public double getDurationOfYear() {
		return instantDuration;
	}

	public double getPassedDays() {
		return passedDays;
	}

	public double getPassedHours() {
		return passedHours;
	}

	public void incrementHours(int numberOfInstants) {

		passedHours = instantDuration * numberOfInstants;

		while (passedHours >= 24) {
			passedHours -= 24;
			passedDays++;
		}
	}
}
