package com.eoi.becajava.starwarsbattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StarWarsGame {
	
	
	static private int numHeroes;
	static private int playerTeam;
	static private int cpuTeam;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int winnerTeam;
		numHeroes=3;
		
		List<StarWarsCharacter> playerHeroes = new ArrayList<>();
		List<StarWarsCharacter> cpuHeroes = new ArrayList<>();
		
		playerTeam=selectTeam();
		
		if (playerTeam==0) {
			cpuTeam=1;
		} else {
			cpuTeam=0;
		}
		
		for (int i=0; i<numHeroes; i++) {
			pickHeroes(playerHeroes, cpuHeroes);
			System.out.println("\nYOUR PICK: "+playerHeroes.get(i).getName());
			System.out.println("CPU PICKS: "+cpuHeroes.get(i).getName()+"\n");
		}
		
		printTeams(playerHeroes, cpuHeroes);
		
		winnerTeam = Battle.getWinner(playerHeroes, cpuHeroes);
		
		if (winnerTeam==0) {
			System.out.println("\n\t\t+--------------+\n\t\t|  YOU WIN!!!  |\n\t\t+--------------+");
		}else {
			System.out.println("\n\t\t+---------------+\n\t\t|  CPU WINS...  |\n\t\t+---------------+");
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
		
		
		return team;
	}
	
	static public void pickHeroes(List<StarWarsCharacter> team1, List<StarWarsCharacter> team2) {
		int option;
		
		do {
			
			printPickMenu(playerTeam);
			option=sc.nextInt();
			
			if(option<0 || option>4) {
				System.out.println("\nINVALID OPTION. TRY AGAIN.\n");
			}else {
				team1.add(StarWarsCharacter.newCharacter(playerTeam, option));
				team2.add(StarWarsCharacter.newCharacter(cpuTeam, option));
			}
			
		} while (option<0 || option>4);
		
		
	}
	
	static public void printPickMenu(int choice) {
		if (choice==0) {
			System.out.println("\n\tEMPIRE");
			System.out.println("\n\t------\n\n  SELECT YOUR HEROES\n  ------------------\n");
			System.out.println("+---------------------------+");
			System.out.println("|     [0] - Darth Vader     |");
			System.out.println("|     [1] - Darth Sidious   |");
			System.out.println("|     [2] - Darth Maul      |");
			System.out.println("|     [3] - Jabba the Hutt  |");
			System.out.println("|     [4] - Bewil           |");
			System.out.println("+---------------------------+");
		} else {
			System.out.println("\n\tREBELS");
			System.out.println("\n\t------\n\n  SELECT YOUR HEROES\n  ------------------\n");
			System.out.println("+---------------------------+");
			System.out.println("|     [0] - Luke Skywalker  |");
			System.out.println("|     [1] - Yoda            |");
			System.out.println("|     [2] - Obi-Wan Kenobi  |");
			System.out.println("|     [3] - Chewbacca       |");
			System.out.println("|     [4] - Han Solo        |");
			System.out.println("+---------------------------+");
		}
	}
	
	static public void printTeams(List<StarWarsCharacter> team1, List<StarWarsCharacter> team2) {
		
		System.out.println("\nYOUR TEAM\tVS\tCPU TEAM\n---------\t\t--------\n");
		for (int i=0; i<team1.size(); i++) {
			System.out.println(team1.get(i).getName()+"\t\t"+team2.get(i).getName());
		}
	}

}
