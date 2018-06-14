package com.eoi.becajava.starwarsbattle;

import java.util.Random;

public class Dice {
	
	public static int rollDice(int number, int nSides){ 
        int num = 0;
        int roll = 0;
        Random  r = new Random(); 
        if(nSides >=3){ 
            for(int i = 0; i < number; i++){ 
            	do{
            		roll = r.nextInt(nSides+1);
            	}while (roll==0);
            	
                //System.out.println("Roll is:  "+roll);
                num = num + roll; 
            }
            //System.out.print("DICE ROLL: "+num);
        } 
        else{ 
            System.out.println("Error num needs to be from 3"); 
        } 
        return num;  
    }
}
