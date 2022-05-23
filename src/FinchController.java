import java.util.ArrayList;
import java.util.Random;

public class FinchController {
    private final Finch finch;
    private final ArrayList<MoveCommand> commands;

    public FinchController(Finch finch) {
        this.finch = finch;
        commands = new ArrayList<>();
    }

    public void startTest() { // Тестовый режим, Лёша писал в мейне
        System.out.println("Go forward");

        int temp = 50;
        int speed1 = 100, speed2 = 50;
        for (int i = 0; i < temp; i++) {
            finch.setMotors(0, speed1);
        }
        turnAround();
        for (int i = 0; i < temp; i++) {
            finch.setMotors(speed1, speed2);
        }

        goBack();
    }

    public void start() { // Рандомный режим
        int maxSpeed = 100; // Типа конфиг для значений рандомайзера
        int minSpeed = -100;
        int maxLength = 100;
        int minLength = 10;

        System.out.println("Go recon");
        Random random = new Random();
        boolean isActive = true;

        while (isActive) {
            int length = random.nextInt(maxLength - minLength) + minLength;
            int left = random.nextInt(maxSpeed - minSpeed) + minSpeed;
            int right = random.nextInt(maxSpeed - minSpeed) + minSpeed;

            for (int i = 0; i < length; i++) {
                finch.setMotors(left, right);
                if (isInterrupted()) {
                    isActive = false;
                    length = i + 1;
                    break;
                }
            }

            MoveCommand command = new MoveCommand(length, left, right);
            commands.add(command);
        }

        goBack();
    }

    private void goBack() {
        System.out.println("Go backward");
        turnAround();

        for (int i = commands.size() - 1; i >= 0; i--) {
            MoveCommand command = commands.get(i);
            int length = command.getLength();
            int left = command.getLeftSpeed();
            int right = command.getRightSpeed();

            for (int j = 0; i < length; i++) {
                finch.setMotors(left, right);
            }
        }
    }

    private void turnAround() {
        // поворот на 180 через правое плечо
        for (int i = 0; i < 30; i++) {
            finch.setMotors(100, -100);
        }
    }

    private boolean isInterrupted() {
        int lightLimit = 90;
//		System.out.println(finch.getLight(Direction.LEFT) + " " + finch.getLight(Direction.RIGHT));
        return finch.getLight(Direction.LEFT) <= lightLimit && finch.getLight(Direction.RIGHT) <= lightLimit;
    }
}
