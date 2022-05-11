public class FinchTrigger extends Thread {
    private final Finch finch;
    private boolean isActive;

    public FinchTrigger(Finch finch) {
        this.finch = finch;
    }

    @Override
    public void run() {
        isActive = true;
        while (isActive) {
            System.out.println(finch.getLight("L"));
            //isActive = finch.checkSensor();
        }
    }

}
