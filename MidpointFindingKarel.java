/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		putBeepersInStreet();
		moveAllBeepersToStartingPoint();
		halfBeepers();
		distributeBeepers();
		move();
		moveUntilNoBeeper();
		turnAround();
		move();
		move();
		turnAround();
		pickBeepersBehind();
		moveToBeeper();
	}
	/*putBeepersInStreet()
	 * make Karel put 1 beeper to each corner along 1st street
	 * precondition: Karel is at westernmost corner in 1st street and there is no beeper in 1st street 
	 * facing east
	 * postcondition: Karel is at easternmost corner in 1st street and each corner has a beeper in 1st street
	 * facing east
	 */
	private void putBeepersInStreet() {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
	}
	
	/*moveAllBeepersToStartingPoint()
	 * make Karel collect all beepers in 1st street and put them back to westernmost corner in 1st street
	 * precondition: Karel is at easternmost corner in 1st street and each corner has a beeper in 1st street
	 * facing east
	 * postcondition: Karel is at easternmost corner in 1st street and all beepers are at this corner
	 * facing east
	 */
	private void moveAllBeepersToStartingPoint() {
		turnAround();
		while (frontIsClear()) {
			moveAllBeepersForward();
		}
		turnAround();
	}
	
	/*moveAllBeepersForward()
	 * make Karel put all beepers at this corner to forward corner
	 * postcondition: Karel is at this corner with all beepers at previous corner empty
	 */
	private void moveAllBeepersForward() {
		while (beepersPresent()) {
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
		move();
	}
	
	/*halfBeepers()
	 * make Karel half beepers 
	 * precondition: Karel is at corner with some beepers facing east
	 * postcondition: Karel is at same corner with half beepers facing east
	 * 
	 */
	private void halfBeepers() {
		while (beepersPresent()) {
			moveOneBeeperRight();
			if (beepersPresent()) {
				moveOneBeeperUp();
			}
		}
		moveStoreHouseBack();
	}
	
	/*moveOneBeeperUp()
	 * pick one beeper and put it to upper corner and back facing east
	 * precondition: Karel is facing east
	 * postcondition: Karel is at same corner with N-1 beeper facing east
	 */
	private void moveOneBeeperUp() {
		pickBeeper();
		turnLeft();
		move();
		putBeeper();
		pickBeeper();
		turnAround();
		move();
		turnLeft();
	}
	
	/*moveOneBeeperRight()
	 * pick one beeper and put it to right corner and back facing east
	 * precondition: Karel is facing east
	 * postcondition: Karel is at same corner with N-1 beeper facing east
	 */
	private void moveOneBeeperRight() {
		pickBeeper();
		move();
		putBeeper();
		turnAround();
		move();
		turnAround();
	}

	/*moveStoreHouseBack()
	 * Karel move all storehouse beepers back
	 * precondition: Karel facing east, storehouse is in front
	 * postcondition: Karel facing east, all beepers are at same corner
	 */
	private void moveStoreHouseBack() {
		move();
		while (beepersPresent()) {
			pickBeeper();
			turnAround();
			move();
			putBeeper();
			turnAround();
			move();
		}
		turnAround();
		move();
		turnAround();
	}
	
	/*distributeBeepers()
	 * Karel distribute all beepers at this corner along 1st street
	 * precondition: karel is at a corner with some beepers
	 * postcondition: karel distributed beepers along street to east starting from ave2, 
	 * there is no beeper left in previous corner
	 */
	private void distributeBeepers() {
		while (beepersPresent()) {
			pickBeeper();
			if (beepersPresent()) {
				moveUntilNoBeeper();
				putBeeper();
				turnAround();
				while (frontIsClear()) {
					move();
				}
				turnAround();
			}
		}
	}
	
	/*moveUntilNoBeeper()
	 * Karel keep moving until no beeper present
	 * postcondition: there is a beeper behind karel
	 */
	private void moveUntilNoBeeper() {
		while (beepersPresent()) {
			move();
		}
	}
	
	/*pickBeepersBehind()
	 * pick all beepers behind this corner
	 * precondition: Karel is at the easternmost corner with beeper facing east
	 * postcondition: Karel is at the westernmost corner which had a beeper before, facing east
	 */
	private void pickBeepersBehind() {
		moveAllBeepersToStartingPoint();
		while (beepersPresent()) {
			pickBeeper();
		}
	}
	
	/*moveToBeeper()
	 * move to THE beeper(midpoint)
	 * precondition: karel facing east
	 * postcondition: done
	 */
	private void moveToBeeper() {
		while (noBeepersPresent()) {
			move();
		}
	}
	
}
