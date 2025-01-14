package classeMetier;

public abstract class Pouvoir {
	private String nom;
	private String description;
	private Boolean estClassique;

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
	
	public abstract void pouvoirSiCondition(Plateau plateau);

}
