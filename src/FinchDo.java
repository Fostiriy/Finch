import java.util.ArrayList;

public class FinchDo {
	private Finch finch;
	private State state;
	private ArrayList<State> states;

	public FinchDo(Finch finch) {
		this.finch = finch;
		state = new State();
		states = new ArrayList<State>();
	}

	public void go() {
		System.out.println("Go forward");
		move("L", 20, 20);
		move("R", 40, 20);
		move("L", 80, 40);
		move("R", 80, 40);
		goBack();
	}

	public void goBack() {
		System.out.println("Go backward");
		state.setSpeed(100);
		String turnDirection = states.get(states.size() - 1).turnDirection;
		double angleDelta = 5;
		double distanceDelta = 10; // На большой скорости долго тормозит и не доезжает
		double angle = 180 + 5 * angleDelta;
		double distance = states.get(states.size() -1).distance;
		move(turnDirection, angle, distance, false);
		for (int i = states.size() - 2; i >= 0; --i) {
			turnDirection = states.get(i).turnDirection;
			angle = states.get(i + 1).angle;
			if (turnDirection == "L") // Предполагаем, что погрешность на поворот влево
				angle += angleDelta;
			distance = states.get(i).distance + distanceDelta;
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
		finch.setTurn(state.turnDirection, state.angle, state.speed);
		finch.setMove(state.moveDirection, state.distance, state.speed);
	}

}
