package model;

public class Biodegradable extends Residue implements Usable {

//CONSTANT
	public static final double FACTORBIODEGRADABLE = 0.01;

//ATRIBUTES
	private boolean suitableForComposting;

//CONSTRUCTOR
	public Biodegradable(String id, String name, String source, String color, int decompositionTime, Product product,
			boolean suitableForComposting) {
		super(id, name, source, color, decompositionTime, product);
		this.suitableForComposting = suitableForComposting;
	}


	@Override
	public double calcNoxiousness() {
		double noxiousness = 0;
		double dTime = (double) super.getDecompositionTime();

		if (super.getSource().equalsIgnoreCase(INDUSTRIAL))
			noxiousness = dTime * (INDUSTRIALFACTOR - FACTORBIODEGRADABLE);
		else if (super.getSource().equalsIgnoreCase(DOMICILIARY))
			noxiousness = dTime * (DOMICILIARYFACTOR - FACTORBIODEGRADABLE);
		else if (super.getSource().equalsIgnoreCase(MUNICIPAL))
			noxiousness = dTime * (MUNICIPALFACTOR - FACTORBIODEGRADABLE);
		else if (super.getSource().equalsIgnoreCase(CONSTRUCTION))
			noxiousness = dTime * (CONSTRUCTIONFACTOR - FACTORBIODEGRADABLE);
		else if (super.getSource().equalsIgnoreCase(HOSPITAL))
			noxiousness = dTime * (HOSPITALFACTOR - FACTORBIODEGRADABLE);

		return noxiousness;
	}


	public boolean getSuitableForConposting() {
		return suitableForComposting;
	}


	@Override
	public String toString() {
		return super.toString() + "		Biodegradable\n Is suitable for composting: " + suitableForComposting + "\n";
	}


	public boolean isUsable() {
		boolean usable = false;

		if(super.getDecompositionTime()<365 && suitableForComposting)
			usable = true;

		return usable;

	}//Comentario de prueba
}
