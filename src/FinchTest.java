public class FinchTest {
    public static void main(String[] args) {
        Finch finch = new Finch("A");
        FinchDo finchDo = new FinchDo(finch);

        System.out.printf("%15s%15s%15s%15s%15s%n", "moveDirection", "turnDirection", "speed", "angle", "distance");
        finchDo.go();


//        finch.setMove("F", 50, 100);
//        finch.setTurn("L", 180, 100);
//        finch.setMove("F", 50, 100);

        finch.stopAll();
        finch.disconnect();
    }
}
