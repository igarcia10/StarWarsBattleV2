package com.eoi.becajava.starwarsbattle;

public abstract class StarWarsCharacter {
	
	String name;
	
	
	/*
	 * TEAM
	 * ----
	 * 0 - EMPIRE
	 * 1 - REBEL
	 */
	
	int team; 
	
	int strength;

	int life;

	int doge;

	int lucky;
	
	int shield;

	int criticalImpact;
	
	public StarWarsCharacter(String name, int team, int strength, int life, int doge, int lucky, int shield, int criticalImpact) {
		
		this.team=team;
		this.strength=strength;
		this.life=life;
		this.doge=doge;
		this.lucky=lucky;
		this.shield=shield;
		this.criticalImpact=criticalImpact;
		
	}

}
