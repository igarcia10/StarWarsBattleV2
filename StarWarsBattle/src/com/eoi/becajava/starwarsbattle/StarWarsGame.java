package com.eoi.becajava.starwarsbattle;

import java.util.Arrays;
import java.util.Scanner;

public class StarWarsGame {

	public static void main(String[] args) {
		int playerTeam;
		int cpuTeam;
		int option;
		StarWarsCharacter[] playerHeroes = new StarWarsCharacter[3];
		StarWarsCharacter[] cpuHeroes = new StarWarsCharacter[3];
		Scanner sc = new Scanner(System.in);
		
		
		
		do {
			
			System.out.println("\tSELECT TEAM\n\t-----------\n\n0 - EMPIRE\t1 - REBELS\n----------\t----------\n");
			playerTeam = sc.nextInt();
			
			if(playerTeam<0 || playerTeam>1) {
				System.out.println("\nINVALID OPTION. TRY AGAIN.\n");
			}
			
		} while (playerTeam<0 || playerTeam>1);
		
		if (playerTeam==0) {
			cpuTeam=1;
		} else {
			cpuTeam=0;
		}
		
		do {
			
			for(int i=0; i<playerHeroes.length; i++) {
				printPickMenu(playerTeam);
				option=sc.nextInt();
				
				if(playerTeam<0 || playerTeam>4) {
					System.out.println("\nINVALID OPTION. TRY AGAIN.\n");
					break;
				}else {
					playerHeroes[i] = CharacterFactory.newCharacter(playerTeam, option);
					cpuHeroes[i] = CharacterFactory.newCharacter(cpuTeam, option);
				}
			}
			
		} while (playerTeam<0 || playerTeam>4);
		
		System.out.println("TEAMS COMPLETED:\n\n"+Arrays.toString(playerHeroes)+"\n"+Arrays.toString(cpuHeroes));

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
