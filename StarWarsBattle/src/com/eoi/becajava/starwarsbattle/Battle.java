package com.eoi.becajava.starwarsbattle;

public class Battle {
	
	static int winner=0;
	static int playerRoll;
	static int cpuRoll;
	
	public static int getWinner(StarWarsCharacter[] team1, StarWarsCharacter[] team2) {
		
		int turn;
		
		turn = getFirstTurn();
		
		
		
		return winner;
	}
	
	public static int getFirstTurn() {
		int turn=0;
		
		do {
			playerRoll = Dice.rollDice(2, 6);
			cpuRoll = Dice.rollDice(2, 6);
			
			System.out.printf("\nLET'S ROLL THE DICES\nYOUR ROLL: %s\tCPU ROLL: %s", playerRoll, cpuRoll);
			
			
			if (playerRoll!=cpuRoll) {
				if(playerRoll>cpuRoll) {
					System.out.println("\nYOU START\n");
					turn=0;
				}else {
					System.out.println("\nTHE CPU STARTS\n");
					turn=1;
				}
				
			}else {
				System.out.println("\nDRAW\n");
			}
			
		}while(playerRoll==cpuRoll);
		
		return turn;
	}

}
