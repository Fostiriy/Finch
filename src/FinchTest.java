public class FinchTest {
    public static void main(String[] args) {
        Finch myFinch = new Finch("A");

//        for (int i = 0; i < 10; i++) {
//            myFinch.setBeak(100, 100, 0);
//            myFinch.pause(1);
//            myFinch.setBeak(0, 0, 0);
//            myFinch.pause(1);
//        }

        int angle = 90;
        int speed = 100;
        int distance = 50;

//        myFinch.setBeak(100, 100, 0);
//        myFinch.setTurn("R",45,50);
//
//        for (int i = 0; i < 5; i++) {
//            if (i % 2 == 0) {
//                myFinch.setTurn("L",angle,speed);
//            }
//            else {
//                myFinch.setTurn("R",angle,speed);
//            }
//            myFinch.setMove("F", distance, speed);
//        }

//        for (int i = 0; i < 5; i++) {
//            myFinch.setMove("F", 50, 100);
//            myFinch.setTurn("L",180,speed);
//        }
//        myFinch.setTurn("L",180,speed);

        myFinch.stopAll();
        while(myFinch.getLight("R") < 150) {
            System.out.println(myFinch.getLight("R"));
        }

//        for (int i = 0; i < 5; i++) {
//            if (i % 2 == 0) {
//                myFinch.setTurn("L",angle,speed);
//            }
//            else {
//                myFinch.setTurn("R",angle,speed);
//            }
//            myFinch.setMove("F", distance, speed);
//        }

        myFinch.stopAll();
        myFinch.disconnect();
    }
}
