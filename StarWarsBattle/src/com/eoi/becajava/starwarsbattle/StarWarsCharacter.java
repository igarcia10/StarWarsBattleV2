package com.eoi.becajava.starwarsbattle;

public abstract class StarWarsCharacter {
	
	int strength;

	int life;

	int doge;

	int lucky;
	
	int shield;

	int criticalImpact;
	
	public StarWarsCharacter(int strength, int life, int doge, int lucky, int shield, int criticalImpact) {
		
		this.strength=strength;
		this.life=life;
		this.doge=doge;
		this.lucky=lucky;
		this.shield=shield;
		this.criticalImpact=criticalImpact;
		
	}

}
