package classeMetier;

import interface_.Combat;
import interface_.CombatLocal;

public abstract class Pouvoir {
	private String nom;
	private String description;
	private Boolean estClassique;
	private static CombatLocal combatLocal;
	private static Combat combat;
	
	public static void setCombat(CombatLocal combat_) {
		combatLocal=combat_;
	}
	
	public static void setCombat(Combat combat_) {
		combat=combat_;
	}

	public static CombatLocal getCombatLocal() {
		return combatLocal;
	}
	
	public static Combat getCombat() {
		return combat;
	}

	public Pouvoir(String nom, Boolean estClassique) {
		super();
		this.nom = nom;
		this.estClassique=estClassique;
	}
	
	public Pouvoir(String nom,String description, Boolean estClassique) {
		super();
		this.nom = nom;
		this.description = description;
		this.estClassique=estClassique;
	}
	
	public abstract void pouvoirSiCondition(Piece piece,Plateau plateau);
	
	public String toString() {
		return "power on";
	}

}
