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
        turnAround();
    }

    public void start() { // Рандомный режим
        int maxSpeed = 100; // Типа конфиг для значений рандомайзера
        int minSpeed = 0;
        int maxLength = 200;
        int minLength = 50;

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
                    System.out.printf("%15d%15d%15d%n", length, left, right);
                    MoveCommand command = new MoveCommand(length, left, right);
                    commands.add(command);
                    break;
                }
            }

            System.out.printf("%15d%15d%15d%n", length, left, right);
            MoveCommand command = new MoveCommand(length, left, right);
            commands.add(command);
        }

        goBack();
    }

    private void goBack() {
        System.out.println("Go backward");
        finch.pause(0.2);
        turnAround();
        finch.pause(0.2);

        for (int i = commands.size() - 1; i >= 0; i--) {
            MoveCommand command = commands.get(i);
            int length = command.getLength();
            int left = command.getRightSpeed(); // Зеркально, чтобы пойти по тому же пути
            int right = command.getLeftSpeed();

            System.out.printf("%15d%15d%15d%n", length, left, right);

            for (int j = 0; j < length; j++) {
                finch.setMotors(left, right);
            }
        }
    }

    private void turnAround() {
        // поворот на 180 через правое плечо
        for (int i = 0; i < 55; i++) {
            finch.setMotors(100, -100);
        }
    }

    private boolean isInterrupted() {
        int lightLimit = 90;
//		System.out.println(finch.getLight(Direction.LEFT) + " " + finch.getLight(Direction.RIGHT));
        return finch.getLight(Direction.LEFT) >= lightLimit || finch.getLight(Direction.RIGHT) >= lightLimit;
    }
}
