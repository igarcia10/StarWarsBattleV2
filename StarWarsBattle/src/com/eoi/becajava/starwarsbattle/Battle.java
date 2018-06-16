package com.eoi.becajava.starwarsbattle;

import java.util.List;
import java.util.Random;

public class Battle {
	
	static private int playerRoll;
	static private int cpuRoll;
	static private Random destiny = new Random();
	static private int prob=400;
	static private int turn;
	static private int cTeam1=0;
	static private int cTeam2=0;
	
	public static int getWinner(List<StarWarsCharacter> team1, List<StarWarsCharacter> team2) {
		
		getFirstTurn();
		
		fight(team1, team2);
		
		return cTeam1>cTeam2?  1 :  0;
	}
	
	public static void getFirstTurn() {
		
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
				
			}
			
		}while(playerRoll==cpuRoll);
	}
	
	static void fight(List<StarWarsCharacter> team1, List<StarWarsCharacter> team2) {
		
		for (StarWarsCharacter heroe1 : team1) {
			for (StarWarsCharacter heroe2 : team2) {
				if(heroe1.getLife()>0 && heroe2.getLife()>0) {
					System.out.printf("\n%s WILL FIGHT %s\n----------------------------------------\n\n"
							, heroe1.getName().toUpperCase(), heroe2.getName().toUpperCase());
				}
				while (heroe1.getLife()>0 && heroe2.getLife()>0) {
					
					if(turn==0) {
						
						System.out.printf("%s TRIES TO ATTACK ", heroe1.getName().toUpperCase());
						tryAttack(heroe1,heroe2);
						turn=1;
						
					} else {
						
						System.out.printf("%s TRIES TO ATTACK ", heroe2.getName().toUpperCase());
						tryAttack(heroe2,heroe1);
						turn=0;
						
					}
					if (heroe1.getLife()<=0) {
						cTeam1++;
					}else if (heroe2.getLife()<=0) {
						cTeam2++;
					}
				}
			}
		}
	}
	
	public static void tryAttack(StarWarsCharacter heroe1, StarWarsCharacter heroe2) {
		
		if(heroe1.getLuck()>0 && destiny.nextDouble()*prob <= heroe1.getLuck()) {
			
			tryDefense(0, heroe1, heroe2);
			
		} else if(heroe1.getCriticalImpact()>0 && destiny.nextDouble()*prob<=heroe1.getCriticalImpact()) {
			
			tryDefense(1, heroe1, heroe2);
			
		} else {
			
			tryDefense(2, heroe1, heroe2);
			
		}
		
	}
	
	static void tryDefense(int attack, StarWarsCharacter heroe1, StarWarsCharacter heroe2) {
		
		int damage;
		int counterAttack;
		
		damage=getDamage(heroe1.getStrength(), heroe2.getShield());
		counterAttack=getDamage(heroe2.getStrength(), heroe1.getShield());
		
		if(heroe2.getLuck()>0 && destiny.nextDouble()*prob<=heroe2.getLuck()) {
			
			printDoge(0, heroe2);
			heroe1.setLife((int)(heroe1.getLife()-counterAttack));
			printHit(4, heroe1, counterAttack);
			
		} else if (heroe2.getDoge()>0 && destiny.nextDouble()*prob<=heroe2.getDoge()) {
			
			printDoge(1, heroe2);
			
		} else {
			
			switch(attack) {
			case 0:
				heroe2.setLife((int)(heroe2.getLife()-(damage*2)));
				break;
			case 1:
				heroe2.setLife(0);
				break;
				
			case 2:
				heroe2.setLife((int)(heroe2.getLife()-damage));
				break;
			}
			printHit(attack, heroe2, damage);
		}
	}
	
	static int getDamage(int strength, int shield)	{
		int hit=0;
		
		if(shield!=0) {
			hit=strength*shield/100;
		}
			
		
		return strength-hit;
	}
	
	static void printHit(int action, StarWarsCharacter heroe, int damage) {
		
		switch(action) {
		case 0:
			System.out.printf("AND HITS %s TWICE!\n%s HP IN DAMAGE!\n", heroe.getName().toUpperCase(), damage);
			break;
		case 1:
			System.out.printf("AND HITS A CRITICAL IMPACT!\n", heroe.getName().toUpperCase());
			break;
		case 2:
			System.out.printf("AND HITS %s!\n%s HP IN DAMAGE!\n", heroe.getName().toUpperCase(), damage);
			break;
		case 4:
			System.out.printf("HE CAUSES %s HP IN DAMAGE!\n", damage);
			break;
		}
		if(heroe.getLife()<=0) {
			System.out.printf("%s HAS DIED!\n\n", heroe.getName().toUpperCase());
		}else {
			System.out.printf("%s HAS NOW %s HP.\n\n", heroe.getName().toUpperCase(), heroe.getLife());
		}
	}
	
	static void printDoge(int action, StarWarsCharacter heroe) {
		
		switch(action) {
		case 0:
			System.out.printf("BUT %s DOGES THE ATTACK AND COUNTERATTACKS!\n", heroe.getName().toUpperCase());
			break;
		case 1:
			System.out.printf("BUT %s DOGES THE ATTACK!\n\n", heroe.getName().toUpperCase());
			break;
		case 2:
			
		
		}
	}
	
}
