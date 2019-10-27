package model;
import model.Product;

public abstract class Residue {

//CONSTANTS
	public static final String INDUSTRIAL = "Industrial";
	public static final String DOMICILIARY = "Domiciliary";
	public static final String MUNICIPAL = "Municipal";
	public static final String CONSTRUCTION = "Construction";
	public static final String HOSPITAL = "Hospital";
	
	public static final double INDUSTRIALFACTOR = 0.1;
	public static final double DOMICILIARYFACTOR = 0.05;
	public static final double MUNICIPALFACTOR = 0.12;
	public static final double CONSTRUCTIONFACTOR = 0.08;
	public static final double HOSPITALFACTOR = 0.15;

//ATRIBUTES
	private String id;
	private String name;
	private String source;
	private String color;
	private int decompositionTime;
	
//RELATIONSHIP
	private Product product;

	public Residue(String id, String name, String source, String color, int decompositionTime, Product product) {
		this.id = id;
		this.name = name;
		this.source = source;
		this.color = color;
		this.decompositionTime = decompositionTime;
		this.product = product;
	}

	
	public double calcNoxiousness() {
		double noxiousness = 0;
		double dTime = (double) decompositionTime;
		
		if (source.equalsIgnoreCase(INDUSTRIAL))
			noxiousness = dTime * INDUSTRIALFACTOR;
		else if (source.equalsIgnoreCase(DOMICILIARY))
			noxiousness = dTime * DOMICILIARYFACTOR;
		else if (source.equalsIgnoreCase(MUNICIPAL))
			noxiousness = dTime * MUNICIPALFACTOR;
		else if (source.equalsIgnoreCase(CONSTRUCTION))
			noxiousness = dTime * CONSTRUCTIONFACTOR;
		else if (source.equalsIgnoreCase(HOSPITAL))
			noxiousness = dTime * HOSPITALFACTOR;
		
		return noxiousness;
	}
	
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSource() {
		return source;
	}

	public String getColor() {
		return color;
	}

	public int getDecompositionTime() {
		return decompositionTime;
	}

	public Product getProduct() {
		return product;
	}

	
	@Override
	public String toString() {
		return "		Residue \n id: " + id + "\n name: " + name + "\n source: " + source + "\n color: " + color
				+ "\n decompositionTime: " + decompositionTime + "\n product:" + product + "\n";
	}
}
