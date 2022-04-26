public class FinchTest {
    public static void main(String[] args) {
        Finch finch = new Finch("A");
        FinchController finchController = new FinchController(finch);

        // TODO
        // Threads here or in Controller

        System.out.printf("%15s%15s%15s%15s%15s%n", "moveDirection", "turnDirection", "speed", "angle", "distance");
        finchController.go();


//        finch.setMove("F", 50, 100);
//        finch.setTurn("L", 180, 100);
//        finch.setMove("F", 50, 100);

        finch.stopAll();
        finch.disconnect();
    }
}
