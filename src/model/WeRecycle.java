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
	
	public String addWaste(String id, String name, String source, String color, int decompositionTime, 
Product product, String adviceToReduce) {
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
	
	public String addWaste(String id, String name, String source, String color, int decompositionTime, 
Product product, String type, String description) {
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
	
	public String addWaste(String id, String name, String source, String color, int decompositionTime, 
Product product, boolean suitableForComposting) {
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
	
	public String addProduct(String id, String name, String description) {
		String info = "";
		boolean added = false;
		Product x = new Product(id, name, description);
		
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
	
	public String generateReportOfWaste() {
		String report = "";
		
		Inert x;
		Recyclable y;
		Biodegradable z;
		
		report += "INERT PRODUCTS \n ";
		for(int i=0; i<waste.length; i++) {
			if(waste[i] instanceof Inert) {
				x = (Inert) waste[i];
				report += "* \n" + x.toString();
			}
		}
		
		report += "RECYCLABLE PRODUCTS \n ";
		for(int i=0; i<waste.length; i++) {
			if(waste[i] instanceof Recyclable) {
				y = (Recyclable) waste[i];
				report += "* \n" + y.toString();
			}
		}
		
		report += "BIODEGRADABLE PRODUCTS \n ";
		for(int i=0; i<waste.length; i++) {
			if(waste[i] instanceof Biodegradable) {
				z = (Biodegradable) waste[i];
				report += "* \n" + z.toString();
			}
		}
		
		return report;
	}

	public String searchInfoWasteByName(String name) {
		String info = "\n Not found \n";
		
		Inert x;
		Recyclable y;
		Biodegradable z;
		
		boolean stop = false;
		
		for (int i=0; !stop && i<waste.length;i++) {
			if (waste[i] != null) {
				if (waste[i].getName().equalsIgnoreCase(name)) {
					if (waste[i] instanceof Inert) {
						x = (Inert)waste[i];
						info = "\n"+ x.toString() + "\n";
					}
					else if (waste[i] instanceof Recyclable) {
						y = (Recyclable)waste[i];
						info = "\n" + y.toString() + "\n";
					}
					else if (waste[i] instanceof Biodegradable) {
						z = (Biodegradable)waste[i];
						info = "\n" + z.toString() + "\n";
					}
					stop = true;
				}
			}
		}
		return info;
	}
	
	public String searchInfoWasteById(String id) {

		String info = "\n Not found \n";
		
		Inert x;
		Recyclable y;
		Biodegradable z;
		
		boolean stop = false;
		
		for (int i=0; !stop && i<waste.length;i++) {
			if (waste[i] != null) {
				if (waste[i].getName().equalsIgnoreCase(id)) {
					if (waste[i] instanceof Inert) {
						x = (Inert)waste[i];
						info = "\n"+ x.toString() + "\n";
					}
					else if (waste[i] instanceof Recyclable) {
						y = (Recyclable)waste[i];
						info = "\n" + y.toString() + "\n";
					}
					else if (waste[i] instanceof Biodegradable) {
						z = (Biodegradable)waste[i];
						info = "\n" + z.toString() + "\n";
					}
					stop = true;
				}
			}
		}
		return info;
	
	}

	public String showListOfProducts() {
		String list = "";
			
		for (int i=0; i<products.length && products[i]!=null; i++) 
				list += "\n		" + products[i].getName();
			
		return list;
	}

	public double calculateHarmfulEffectOnPlanetOfResidue(String id) {
		double noxiousness = 0;
		
		Recyclable y;
		Biodegradable z;
		
		boolean stop = false;
		
		for (int i=0; !stop && i<waste.length;i++) {
			if (waste[i] != null) {
				if (waste[i].getName().equalsIgnoreCase(id)) {
					if (waste[i] instanceof Recyclable) {
						y = (Recyclable)waste[i];
						noxiousness = y.calcNoxiousness();
					}
					else if (waste[i] instanceof Biodegradable) {
						z = (Biodegradable)waste[i];
						noxiousness = z.calcNoxiousness();
					}
					else 
						noxiousness = waste[i].calcNoxiousness();
					stop = true;
				}
			}
		}
		return noxiousness;
	}

	public String isThisResidueUsable(String id){
		String info = "\n This product may be inert, does not exists or is not usable \n";
		boolean usable = false;
	
		Recyclable y;
		Biodegradable z;
		
		boolean stop = false;
		
		for (int i=0; !stop && i<waste.length; i++) {
			if (waste[i] != null) {
				if (waste[i].getId().equalsIgnoreCase(id)) {
					
					if (waste[i] instanceof Recyclable) {
						y = (Recyclable)waste[i];
						usable = y.isUsable();
					}
					else if (waste[i] instanceof Biodegradable) {
						z = (Biodegradable)waste[i];
						usable = z.isUsable();
					}
					stop = true;
				}
			}
		}
		if (usable)
			info = "The residue is usable";
		
		return info;
	}

	public String listResiduesByNoxiousness() {
		String list = "";
		Recyclable y;
		Biodegradable z;
		
		double ordenedNoxiousness[] = new double[1000];
		
		for (int i=0;i<waste.length && waste[i]!=null; i++) {
			if(waste[i] instanceof Recyclable) {
				y = (Recyclable)waste[i];
				ordenedNoxiousness[i]=y.calcNoxiousness();
			}
			else if (waste[i] instanceof Biodegradable) {
				z = (Biodegradable)waste[i];
				ordenedNoxiousness[i]=z.calcNoxiousness();
			}
			else 
				ordenedNoxiousness[i]=waste[i].calcNoxiousness();			
		}
		
		int a = 0;
		double b = 0;
		for (int i=0; i<ordenedNoxiousness.length && ordenedNoxiousness[i] != 0 ;i++) {
			a = i;
			for(int j=i+1; j<=ordenedNoxiousness.length;j++) {
				if (ordenedNoxiousness[j] > ordenedNoxiousness[a]) {
					a = j;
				}
			b = ordenedNoxiousness[i];
			ordenedNoxiousness[i] = ordenedNoxiousness[a];
			ordenedNoxiousness[a] = b;
			}
		}
		
		for (int i=0; i<ordenedNoxiousness.length && ordenedNoxiousness[i]!=0;i++) {
			for(int j=0; j<waste.length && waste[i]!=null;j++)
				if (((Recyclable)waste[j]).calcNoxiousness()==ordenedNoxiousness[i]) 
					list += waste[j].getName();
				
				else if (((Biodegradable)waste[j]).calcNoxiousness()==ordenedNoxiousness[i]) 
					list += waste[j].getName();
				
				else if (waste[j].calcNoxiousness()== ordenedNoxiousness[i])
					list += waste[j].getName();
					
					
		}
		
		
		return list;
		
	}

	public Product searchProduct(String id) {
		Product x = null;
		boolean stop = false;
		for (int i=0;i<products.length && !stop;i++) {
			if(products[i].getId().equalsIgnoreCase(id)) {
				x = products[i];
				stop = true;
			}
		}
		
		return x;
	}

	public Product createProduct(String id, String name, String descrition) {
		Product x = new Product(id, name, descrition);
		return x;
	}

}
