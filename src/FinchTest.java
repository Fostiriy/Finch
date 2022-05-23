public class FinchTest {
	public static void main(String[] args) {
		Finch finch = new Finch();
		FinchController finchController = new FinchController(finch);

		System.out.printf("%15s%15s%15s%n", "Length", "LeftSpeed", "RightSpeed");

//		finchController.startTest();
		finchController.start();

		finch.stopAll();
		finch.disconnect();
	}
}
