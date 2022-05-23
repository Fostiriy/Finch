public class MoveCommand {

	private final int leftSpeed;
	private final int rightSpeed;
	private final int length;

	public MoveCommand(int length, int leftSpeed, int rightSpeed) {
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		this.length = length;
	}

	public int getLeftSpeed() {
		return leftSpeed;
	}

	public int getRightSpeed() {
		return rightSpeed;
	}

	public int getLength() {
		return length;
	}

	public String printCommand() {
		String result = "";

		result += String.format("%15s", length);
		result += String.format("%15s", leftSpeed);
		result += String.format("%15s", rightSpeed);

		return result;
	}
}
