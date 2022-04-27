public class FinchTrigger extends Thread {
    private final Triggerable controller;
    private boolean isActive;

    public FinchTrigger(Triggerable controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        isActive = true;
        while (isActive) {
            isActive = controller.checkSensor();
        }
    }

}
