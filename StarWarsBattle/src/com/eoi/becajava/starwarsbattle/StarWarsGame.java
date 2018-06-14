package com.eoi.becajava.starwarsbattle;

import java.util.Scanner;

public class StarWarsGame {
	
	static int playerTeam;
	static int cpuTeam;
	static StarWarsCharacter[] playerHeroes = new StarWarsCharacter[3];
	static StarWarsCharacter[] cpuHeroes = new StarWarsCharacter[3];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int winnerTeam;
		playerTeam=selectTeam();
		
		pickHeroes();
		
		printTeams();
		
		winnerTeam = Battle.getWinner(playerHeroes, cpuHeroes);
		
		if (winnerTeam==0) {
			System.out.println("YOU WIN!!!");
		}else {
			System.out.println("CPU WINS...");
		}
		
		sc.close();

	}
	
	static public int selectTeam() {
		int team;
		
		do {
			
			System.out.println("\tSELECT TEAM\n\t-----------\n\n0 - EMPIRE\t1 - REBELS\n----------\t----------\n");
			team = sc.nextInt();
			
			if(team<0 || team>1) {
				System.out.println("\nINVALID OPTION. TRY AGAIN.\n");
			}
			
		} while (team<0 || team>1);
		
		if (team==0) {
			cpuTeam=1;
		} else {
			cpuTeam=0;
		}
		return team;
	}
	
	static public void pickHeroes() {
		int option;
		
		do {
			
			for(int i=0; i<playerHeroes.length; i++) {
				printPickMenu(playerTeam);
				option=sc.nextInt();
				
				if(playerTeam<0 || playerTeam>4) {
					System.out.println("\nINVALID OPTION. TRY AGAIN.\n");
					break;
				}else {
					playerHeroes[i] = StarWarsCharacter.newCharacter(playerTeam, option);
					cpuHeroes[i] = StarWarsCharacter.newCharacter(cpuTeam, option);
					
					System.out.println("\nYOUR PICK: "+playerHeroes[i].getName());
					System.out.println("CPU PICKS: "+cpuHeroes[i].getName()+"\n");
				}
			}
			
		} while (playerTeam<0 || playerTeam>4);
		
		
	}
	
	static public void printPickMenu(int choice) {
		if (choice==0) {
			System.out.println("\n\tEMPIRE");
			System.out.println("\n\t------\n\n  SELECT YOUR HEROES\n  ------------------\n");
			System.out.println("+---------------------------+");
			System.out.println("-     [0] - Darth Vader     -");
			System.out.println("-     [1] - Darth Sidious   -");
			System.out.println("-     [2] - Darth Maul      -");
			System.out.println("-     [3] - Jabba the Hutt  -");
			System.out.println("-     [4] - Bewil           -");
			System.out.println("+---------------------------+");
		} else {
			System.out.println("\n\tREBELS");
			System.out.println("\n\t------\n\n  SELECT YOUR HEROES\n  ------------------\n");
			System.out.println("+---------------------------+");
			System.out.println("-     [0] - Luke Skywalker  -");
			System.out.println("-     [1] - Yoda            -");
			System.out.println("-     [2] - Obi-Wan Kenobi  -");
			System.out.println("-     [3] - Chewbacca       -");
			System.out.println("-     [4] - Han Solo        -");
			System.out.println("+---------------------------+");
		}
	}
	
	static public void printTeams() {
		for (StarWarsCharacter heroe : cpuHeroes) {
			System.out.println(heroe.getName());
		}
		for (StarWarsCharacter heroe : playerHeroes) {
			System.out.println(heroe.getName());
		}
	}

}
