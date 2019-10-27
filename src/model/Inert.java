package model;

public class Inert extends Residue {
	private String adviceToReduce;

	public Inert(String id, String name, String source, String color, int decompositionTime, Product product,
			String adviceToReduce) {
		super(id, name, source, color, decompositionTime, product);
		this.adviceToReduce = adviceToReduce;
	}


	public String getAdviceToReduce() {
		return adviceToReduce;
	}
 

	@Override
	public String toString() {
		return super.toString() + "\n	Inert\n adviceToReduce: " + adviceToReduce + "\n" ;
	}
	
}
