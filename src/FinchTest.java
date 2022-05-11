public class FinchTest {
	public static void main(String[] args) {
		Finch finch = new Finch();
		FinchController finchController = new FinchController(finch);

		// TODO
		// Threads here or in Controller


		System.out.printf("%15s%15s%15s%15s%15s%n", "moveDirection", "turnDirection", "speed", "angle", "distance");
		int temp = 50;
		int speed1 = 100, speed2 = 50;
//		for (int i = 0; i < temp; i++) {
//			finch.setMotors(0, speed1);
//		}
//		for (int i = 0; i < 10; i++) {
//			finch.setTurn("L", 180 + 1, 20);
//			finch.setTurn("R", 180, 20);
//		}
		// поворот на 180 через правое плечо
		for (int i = 0; i < 30; i++) {
			finch.setMotors(100, -100);
		}
//		for (int i = 0; i < temp; i++) {
//			finch.setMotors(speed1, speed2);
//		}

		//finchController.start();


//        finch.setMove("F", 50, 100);
//        finch.setTurn("L", 180, 100);
//        finch.setMove("F", 50, 100);

		finch.stopAll();
		finch.disconnect();
	}
}
