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
	
	public static StarWarsCharacter newCharacter(int team, int option) {
		
		StarWarsCharacter heroe = null;		
		
		if (team==0) {
			
			switch (option) {
			case 0:		
				heroe=new DarthVader();
				break;
			case 1:		
				heroe=new DarthSidious();
				break;
			case 2:		
				heroe=new DarthMaul();
				break;
			case 3:		
				heroe=new JabbaTheHutt();
				break;
			case 4:		
				heroe= new Bewil();
				break;
			default:
				break;
			}
			
		} else {
			
			switch (option) {
			case 0:		
				heroe=new LukeSkywalker();
				break;
			case 1:		
				heroe=new Yoda();
				break;
			case 2:		
				heroe=new ObiWanKenobi();
				break;
			case 3:		
				heroe=new Chewbacca();
				break;
			case 4:		
				heroe= new HanSolo();
				break;
			default:
				break;
			}
			
		}
		
		return heroe;
		
	}

}
