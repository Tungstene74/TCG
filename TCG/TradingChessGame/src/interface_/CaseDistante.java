package interface_;

import classeMetier.Partie;

public class CaseDistante extends Case{
	
	private static Combat combat;

	public CaseDistante(int x, int y) {
		super(x, y);
	}
	
	public static void setCombat(Combat combat) {
		CaseDistante.combat=combat;
	}

	public static Combat getCombat2() {
		return combat;
	}

}
