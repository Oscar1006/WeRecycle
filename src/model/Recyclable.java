package model;

public class Recyclable extends Residue implements Usable{

//CONSTANTS
	public static final String PAPER = "Paper";
	public static final String PAPERBOARD = "Paperboard";
	public static final String GLASS = "Glass";
	public static final String PLASTIC = "Plastic";
	public static final String METAL = "Metal";

	public static final double FACTORRECYCLABLE = 0.02;

//ATRIBUTES

	private String type;
	private String description;

//CONSTRUCTOR
	public Recyclable(String id, String name, String source, String color, int decompositionTime, Product product,
			String type, String description) {
		super(id, name, source, color, decompositionTime, product);
		this.type = type;
		this.description = description;
	}


	@Override
	public double calcNoxiousness() {
		double noxiousness = 0;
		double dTime = (double) super.getDecompositionTime();

		if (super.getSource().equalsIgnoreCase(INDUSTRIAL))
			noxiousness = dTime * (INDUSTRIALFACTOR - FACTORRECYCLABLE);
		else if (super.getSource().equalsIgnoreCase(DOMICILIARY))
			noxiousness = dTime * (DOMICILIARYFACTOR - FACTORRECYCLABLE);
		else if (super.getSource().equalsIgnoreCase(MUNICIPAL))
			noxiousness = dTime * (MUNICIPALFACTOR - FACTORRECYCLABLE);
		else if (super.getSource().equalsIgnoreCase(CONSTRUCTION))
			noxiousness = dTime * (CONSTRUCTIONFACTOR - FACTORRECYCLABLE);
		else if (super.getSource().equalsIgnoreCase(HOSPITAL))
			noxiousness = dTime * (HOSPITALFACTOR - FACTORRECYCLABLE);

		return noxiousness;
	}


	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}


	@Override
	public String toString() {
		return super.toString() + "		Recyclable\n type: " + type + "\n description: " + description + "\n";
	}


	public boolean isUsable() {
		boolean usable = true;

		if (description.equalsIgnoreCase(""))
			usable = false;

		return usable;
	}

}
