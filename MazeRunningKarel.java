import stanford.karel.*;
public class MazeRunningKarel extends SuperKarel{
	public void run() {
		while (noBeepersPresent()) {
			turnRight();
			while (frontIsBlocked()) {
				turnLeft();
			}
			move();
		}
	}
}
