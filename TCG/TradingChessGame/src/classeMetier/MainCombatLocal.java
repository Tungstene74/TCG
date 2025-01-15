package classeMetier;

import interface_.*;

public class MainCombatLocal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TCG fen=new TCG();
		fen.combatLocal(new PartieLocale());
		fen.setVisible(true);
		 
	}

}
