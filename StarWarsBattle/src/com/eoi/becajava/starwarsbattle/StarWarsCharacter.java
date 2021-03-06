package com.eoi.becajava.starwarsbattle;

public abstract class StarWarsCharacter {
	
	private String name;

	private int strength;

	private int life;

	private int doge;

	private int luck;
	
	private int shield;

	private int criticalImpact;
	
	public StarWarsCharacter(String name, int strength, int life, int doge, int luck, int shield, int criticalImpact) {
		
		this.name=name;
		this.strength=strength;
		this.life=life;
		this.doge=doge;
		this.luck=luck;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDoge() {
		return doge;
	}

	public void setDoge(int doge) {
		this.doge = doge;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int lucky) {
		this.luck = lucky;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public int getCriticalImpact() {
		return criticalImpact;
	}

	public void setCriticalImpact(int criticalImpact) {
		this.criticalImpact = criticalImpact;
	}
	
	

}
