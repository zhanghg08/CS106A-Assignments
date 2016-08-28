import stanford.karel.*;
public class DoubleBeepersKarel extends SuperKarel{
	public void run() {
		move();
		doubleBeepers();
	}
	/*
	 * double beepers at this corner
	 * precondition: Karel is at corner with beepers
	 * postcondition: karel is at same corner with doubled beepers
	 */
	private void doubleBeepers() {
		doubleIntoStorehouse();
		move();
		transferBeepersBack();
	}
	
	/*
	 * pick 1 beeper at this corner and put 2 beepers at next corner
	 * precondition: no beepers at next corner
	 * postcondition: Karel at same corner with next corner has doubled beepers
	 */
	private void doubleIntoStorehouse() {
		while (beepersPresent()) {
			pickBeeper();
			move();
			putBeeper();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
	}
	
	/*
	 * transfer all beepers in storehouse back to previous corner
	 * precondition: Karel is at storehouse with doubled beepers
	 * postcondition: Karel is at storehouse with no beepers
	 */
	private void transferBeepersBack() {
		while (beepersPresent()) {
			pickBeeper();
			turnAround();
			move();
			putBeeper();
			turnAround();
			move();
		}
	}
	
	
}
