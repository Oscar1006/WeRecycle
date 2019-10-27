package model;
import model.Residue;

public class Product {

 //ATRIBUTES
	private String id;
	private String name;
	private String description;

//RELATIONSHIP
	private Residue waste[];

	public Product(String id, String name, String description, Residue waste) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.waste = new Residue [100];
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Residue getWaste(int i) {
		return waste[i];
	}

}
