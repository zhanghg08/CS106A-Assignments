/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run() {
		fixArch();
		while (frontIsClear()) {
			goToArch();
			fixArch();
		}

	}
	
	/*goToArch()
	 * make Karel to find next arch
	 * precondition: Karel is at westernmost corner in 1st street facing east
	 * postcondition: Karel is at arch in 1st street facing east OR blocked by wall 
	 */
	private void goToArch() {
		for (int i = 0; i < 4; i++) {
			if (frontIsBlocked()) {
				turnAround();
				turnAround();
			} else {
				move();
			}
		}
	}
	
	/*checkArch()
	 * check if this corner is arch
	 * precondition: Karel is at 1st street facing east
	 * postcondition: Karel is at same corner 
	 */
	private void checkArch() {
		
	}
	
	/*fixArch()
	 * make Karel to fix arch
	 * precondition: Karel is at arch position in 1st street facing east
	 * postcondition: Karel fixed the arch and back to 1st street facing east
	 */
	private void fixArch() {
		turnLeft();
		fixEachArch();
		backToGround();
		turnLeft();
	}
	
	/*fixEachArch()
	 * make Karel to fix each arch
	 * precondition: Karel is at arch position in 1st street facing north
	 * postcondition: Karel finishes fixing and blocked by wall facing north
	 */
	private void fixEachArch() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}

	}
	
	/*backToGround()
	 * make Karel go back to 1st facing south
	 * precondition: Karel is blocked by upper wall facing north
	 * postcondition: Karel is in 1st street facing south
	 */
	private void backToGround() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
	}
	
	
}
