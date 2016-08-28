/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		if (noBeepersPresent()) {
			putBeeper();
		}
		while (frontIsClear()) {
			checkEachStreet();
			backToStartingPoint();
			goToNextStreet();
		}
		
		while (leftIsClear()) {
			checkEachStreet();
			backToStartingPoint();
			goToNextStreet();
		}
	}
	
	/*checkEachStreet()
	 * make Karel check each street
	 * precondition: Karel is at westernmost corner in street facing east
	 * postcondition: Karel is at easternmost corner in steet facing east
	 */
	private void checkEachStreet () {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				move();
				putBeeper();
			}		
		}
	}
	
	/*backToStartingPoint()
	 * make Karel 
	 * precondition: Karel is at easternmost corner in street facing east
	 * postcondition: Karel is at westernmost corner in street facing west
	 */
	private void backToStartingPoint() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
	}
	
	/*goToNextStreet
	 * make Karel go to next street and decide whether to put initial beeper
	 * precondition: Karel is at westernmost corner facing west
	 * postcondition: Karel is at next north street facing east
	 */
	private void goToNextStreet() {
		turnRight();
		if (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				move();
				putBeeper();
			}
			turnRight();
		}
	}

}
