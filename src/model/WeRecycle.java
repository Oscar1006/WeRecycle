package model;
import model.Residue;
import model.Product;

public class WeRecycle {

//RELATIONSHIPS
	private Residue waste[];
	private Product products[];
	
//CONSTRUCTOR
	public WeRecycle(){
		waste = new Residue[1000];
		products = new Product[1000];
	}
	
	public String addWaste(String id, String name, String source, String color, int decompositionTime, Product product, String adviceToReduce) {
		String info = "";
		boolean added = false;
		Inert x = new Inert(id, name, source, color, decompositionTime, product, adviceToReduce);
		
		for(int i=0; i<waste.length && !added; i++) {
			if (waste[i] == null) {
				waste[i] = x;
				added = true;
			}
		}
		
		if (added)
			info = "Residue added";
		else
			info = "Error";
		
		return info;
	}
	
	public String addWaste(String id, String name, String source, String color, int decompositionTime, Product product,
			String type, String description) {
		String info = "";
		boolean added = false;
		Recyclable x = new Recyclable(id, name, source, color, decompositionTime, product, type, description);
		
		for(int i=0; i<waste.length && !added; i++) {
			if (waste[i] == null) {
				waste[i] = x;
				added = true;
			}
		}
		
		if (added)
			info = "Residue added";
		else
			info = "Error";
		
		return info;
	}
	
	public String addWaste(String id, String name, String source, String color, int decompositionTime, Product product,
			boolean suitableForComposting) {
		String info = "";
		boolean added = false;
		Biodegradable x = new Biodegradable(id, name, source, color, decompositionTime, product, suitableForComposting);
		
		for(int i=0; i<waste.length && !added; i++) {
			if (waste[i] == null) {
				waste[i] = x;
				added = true;
			}
		}
		
		if (added)
			info = "Residue added";
		else
			info = "Error";
		
		return info;
	}
	
	public String addProduct(String id, String name, String description, Residue waste) {
		String info = "";
		boolean added = false;
		Product x = new Product(id, name, description, waste);
		
		for(int i=0; i<products.length && !added; i++) {
			if (products[i] == null) {
				products[i] = x;
				added = true;
			}
		}
		
		if (added)
			info = "Product added";
		else
			info = "Error";
		
		return info;
	}


}
