package com.eoi.becajava.starwarsbattle;

public class CharacterFactory {
	
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
