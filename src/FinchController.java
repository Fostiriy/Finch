import java.util.ArrayList;

public class FinchController implements Triggerable {
	private final Finch finch;
	private final State state;
	private final ArrayList<State> states;
	private final FinchTrigger trigger;

	public FinchController(Finch finch) {
		this.finch = finch;
		state = new State();
		states = new ArrayList<State>();
		trigger = new FinchTrigger(this);
	}

	public void go() {
		System.out.println("Go forward");
		move(State.LeftDirection, 20, 20);
		move(State.RightDirection, 40, 20);
		move(State.LeftDirection, 80, 40);
		move(State.RightDirection, 80, 40);
		goBack();
	}

	public void start() {
		System.out.println("Go recon");
		// Thread start
		trigger.start();

		// Randomized
		move(State.LeftDirection, 20, 20);
		move(State.RightDirection, 40, 20);
		move(State.LeftDirection, 80, 40);
		move(State.RightDirection, 80, 40);

		// Thread stop
		goBack();
	}

	public void goBack() {
		System.out.println("Go backward");
		state.setSpeed(100);
		String turnDirection = states.get(states.size() - 1).getTurnDirection();
		double angleDelta = 5;
		double distanceDelta = 10; // На большой скорости долго тормозит и не доезжает
		double angle = 180 + 5 * angleDelta;
		double distance = states.get(states.size() -1).getDistance();
		move(turnDirection, angle, distance, false);

		for (int i = states.size() - 2; i >= 0; --i) {
			turnDirection = states.get(i).getTurnDirection();
			angle = states.get(i + 1).getAngle();
			if (turnDirection.equals(State.LeftDirection)) // Предполагаем, что погрешность на поворот влево
				angle += angleDelta;
			distance = states.get(i).getDistance() + distanceDelta;
			move(turnDirection, angle, distance, false);
		}
	}

	public void move(String turnDirection, double angle, double distance) {
		move(turnDirection, angle, distance, true);
	}

	public void move(String turnDirection, double angle, double distance, boolean saveState) {
		state.setState(turnDirection, angle, distance);
		if (saveState) {
			State tempState = new State(state);
			states.add(tempState);
		}
		System.out.println(state.getState());
		move();
	}

	private void move() {
		finch.setTurn(state.getTurnDirection(), state.getAngle(), state.getSpeed());
		finch.setMove(state.getMoveDirection(), state.getDistance(), state.getSpeed());
	}

	@Override
	public boolean checkSensor() {
		// ПОЖАЛУЙСТВ ВСТАВЬТЕ ПРОВЕРКУ СЕНСОРА
		return true;
	}

	@Override
	public void trigger() {
		// ЗАВЕРШЕНИЕ РАБОТЫ
	}
}
