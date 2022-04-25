public class State {
	public String moveDirection = "F";
	public String turnDirection;
	public double speed;
	public double angle;
	public double distance;

	public State() {
		this.moveDirection = "F";
		this.speed = 50;
	}

	public State(String moveDirection, String turnDirection, double speed, double angle, double distance) {
		this.moveDirection = moveDirection;
		this.turnDirection = turnDirection;
		this.speed = speed;
		this.angle = angle;
		this.distance = distance;
	}

	public State(State anotherState) {
		this.moveDirection = anotherState.moveDirection;
		this.turnDirection = anotherState.turnDirection;
		this.speed = anotherState.speed;
		this.angle = anotherState.angle;
		this.distance = anotherState.distance;
	}

	public void setState(String turnDirection, double angle, double distance) {
		this.turnDirection = turnDirection;
		this.angle = angle;
		this.distance = distance;
	}
	public void setState(String moveDirection, String turnDirection, double speed, double angle, double distance) {
		this.moveDirection = moveDirection;
		this.turnDirection = turnDirection;
		this.speed = speed;
		this.angle = angle;
		this.distance = distance;
	}

	public String getState() {
		String result = "";

		result += String.format("%15s",moveDirection);
		result += String.format("%15s",turnDirection);
		result += String.format("%15s",speed);
		result += String.format("%15s",angle);
		result += String.format("%15s",distance);

		return result;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
