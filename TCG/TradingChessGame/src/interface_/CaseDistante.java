package interface_;

import classeMetier.Partie;
import classeMetier.PartieLocale;

public class CaseDistante extends Case{
	
	private static Combat combat;
	private static Partie partie;

	public CaseDistante(int x, int y) {
		super(x, y);
	}
	
	public static void setCombat(Combat combat) {
		CaseDistante.combat=combat;
	}

	public static Combat getCombat2() {
		return combat;
	}
	
	public static void setPartie(Partie partie_) {
		partie=partie_;
	}

	public static PartieLocale getPartieLocale() {
		return partie;
	}

}
