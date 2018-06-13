package com.eoi.becajava.starwarsbattle;

import java.util.Arrays;
import java.util.Scanner;

public class StarWarsGame {
	
	static int playerTeam;
	static int cpuTeam;
	static StarWarsCharacter[] playerHeroes = new StarWarsCharacter[3];
	static StarWarsCharacter[] cpuHeroes = new StarWarsCharacter[3];

	public static void main(String[] args) {
		
		
		playerTeam=selectTeam();
		
		pickHeroes();
		
		
		System.out.println("TEAMS COMPLETED:\n\n"+Arrays.toString(playerHeroes)+"\n"+Arrays.toString(cpuHeroes));
		

	}
	
	static public int selectTeam() {
		int team;
		Scanner sc = new Scanner(System.in);
		
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
		sc.close();
		return team;
	}
	
	static public void pickHeroes() {
		Scanner sc = new Scanner(System.in);
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
				}
			}
			
		} while (playerTeam<0 || playerTeam>4);
		
		sc.close();
		
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

}
