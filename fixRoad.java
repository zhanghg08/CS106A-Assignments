import stanford.karel.*;

/*File: fixRoad.java
 * This is just try to practice chapter 2 problem: put beeper to the pothole
 * Use world file named: practice_chapter4
 * 
 */

public class fixRoad extends Karel {
/*	public void run() {
*		while (frontIsClear()){
*			checkForPothole();
*			move();
*		}
*		checkForPothole();
*	}
*/
	public void run() {
		collectAllBeepers();
		dropAllBeepers();
		returnHome();
	}
	
	/*collects beepers from every tower by moving along 1st street, calling collectOneTower()
	 * at every corner. the postcondition is that Karel is in the easternmost corner of 1st
	 * street facing east 
	 * 
	 */
	private void collectAllBeepers() {
		while (frontIsClear()) {
			collectOneTower();
			move();
		}
		collectOneTower();
	}
	/*make Karel collect all beepers in one tower and return to 1st street facing east.
	 * precondition: Karel is in 1st street facing east
	 * postcondition: Karel is in 1st street facing east at same corner
	 * 
	 * 
	 */
	
	private void collectOneTower() {
		turnLeft();
		collectLineOfBeepers();
		turnAround();
		moveToWall();
		turnLeft();
	}
	/*collect all beepers in this avenue.
	 * precondition: Karel is in 1st street facing north
	 * postcondition: Karel stops when there is no beeper at this corner
	 * 
	 */
	private void collectLineOfBeepers() {
		while (beepersPresent()) {
			pickBeeper();
			move();
		}
	}
	
	/*move back to 1st street
	 * precondition: facing south
	 * postcondition: karel is in 1st street facing south
	 * 
	 */
	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
	/*
	 * drop all beepers at this corner
	 * precondition: Karel is in easternmost corner in 1st street facing east
	 * postcondition: Karel is this corner and drop all beepers collected facing east
	 */
	
	private void dropAllBeepers() {
		while (beepersInBag()) {
			putBeeper();
		}
	}
	/*
	 * return back to starting point
	 * precondition: Karel is in easternmost corner in 1st street facing east
	 * postcondition: karel is in westernmost corner in 1st street facing east
	 */
	private void returnHome() {
		turnAround();
		moveToWall();
		turnAround();
	}
	
	/* turn karel to right
	 * 
	 */
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	/*turn karel around
	 * 
	 */
	private void turnAround() {
		turnLeft();
		turnLeft();
	}
	
	/*make Karel to fill pothole
	 * 
	 */
	private void fillPothole() {
		turnRight();
		move();
		if (noBeepersPresent()) {
			if (beepersInBag()) {
				putBeeper();
			}
		}
		turnAround();
		move();
		turnRight();
	}
	
	/*make Karel to check the pothole: if there is pothole, fill it
	 * 
	 */
	private void checkForPothole() {
		if (rightIsClear()) {
			fillPothole();
		}
	}
	
	
}

