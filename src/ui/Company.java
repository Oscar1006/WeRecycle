package ui;

import model.Recyclable;
import model.Product;
import model.WeRecycle;
import java.util.Scanner;

public class Company {
	
	private WeRecycle weRecycle;
	
	private Scanner inputString;
	private Scanner inputInt;
	
	public Company() {
		weRecycle = new WeRecycle();
		
		inputString = new Scanner(System.in);
		inputInt = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Company recycler = new Company();
		int pick = 0;
		boolean loop = true;
		
		System.out.println("		Menu\n"
				+ " 1.Add residue\n"
				+ " 2.Generate report about the registred waste\n"
				+ " 3.Add product and the residues that may generate\n"
				+ " 4.Search information of a residue with its name\n"
				+ " 5.Search information of a residue with its id\n"
				+ " 6.Show list of the resistred products\n"
				+ " 7.Calculate harmful effect of a residue\n"
				+ " 8.Determine if a biodegradable or recyclable residue is usable\n"
				+ " 9.Ordenate all the residues by their nocive effect, showing the most nocive first\n"
				+ " 10.Exit\n");
		
		while(loop) {
			System.out.println("Please enter a number to choose an option of the menu\n");
			pick = recycler.inputInt.nextInt();
			
			switch (pick){
				case 1:
						recycler.addResidue();
					break;
				case 2:
						recycler.generateReport();
					break;
				case 3:
						recycler.addProduct();
					break;
				case 4:
						System.out.println(" Enter the name of the residue:");
						String name = recycler.inputString.nextLine();
						recycler.searchInfoByName(name);
					break;
				case 5:
						System.out.println(" Enter the id of the residue:");
						String id = recycler.inputString.nextLine();
						recycler.searchInfoById(id);	
					break;
				case 6:
						recycler.showListOfProducts();
					break;
				case 7:
						System.out.println("Enter the id of the residue you want to calculate");
						String idToCalculate = recycler.inputString.nextLine();
						recycler.calculateHarmfulEffect(idToCalculate);
					break;
				case 8:
					System.out.println("Enter the id of the residue you want to know if its usable");
					String idToDetermine = recycler.inputString.nextLine();
						recycler.detrmineUsability(idToDetermine);
					break;
				case 9:
						recycler.ordenateAllResiduesNoxiousness();
					break;
					
				case 10:
					loop = false;
					break;
				default:
					System.out.println("\n	Please enter a valid number\n");
					
			}
		}
	}


	private void addResidue() {
		String info = "";
		
		String adviceToReduce = "";
		int pick = 0;
		String type ="";
		String description = "";
		boolean suitableForComposting = false;
		
		Product x;
		String idProduct = "";
		String nameProduct = "";
		String descriptionProduct = "";
		
		System.out.println("Choose the category of the residue:\n "
				+ "1.Inert\n"
				+ "2.Recyclable\n"
				+ "3.Biodegradable\n");	
		int category = inputInt.nextInt();
		System.out.println("Enter the id of the residue: ");
		String id = inputString.nextLine();
		System.out.println("Enter the name of the residue: ");
		String name = inputString.nextLine();
		System.out.println("Enter the source of the residue: ");
		String source = inputString.nextLine();
		System.out.println("Enter the color of the residue: ");
		String color = inputString.nextLine();
		System.out.println("Enter the decomposition time of the residue (days): ");
		int decompositionTime = inputInt.nextInt();
		
		System.out.println("Asociated product\n"
				+ " Does it alredy exists the product in the data base?\n   1.Yes\n   2.No\n");
		pick = inputString.nextInt();
		if (pick==1) {
			System.out.println("Enter the id of the product: ");
			idProduct = inputString.nextLine();
			x = weRecycle.searchProduct(idProduct);
		}
		else {
			System.out.println("	Create a new product\n - Enter id of product: ");
			idProduct = inputString.nextLine();
			System.out.println(" - Enter the name of the product: ");
			nameProduct = inputString.nextLine();
			System.out.println(" - Enter a description: ");
			descriptionProduct = inputString.nextLine();
			x = weRecycle.createProduct(idProduct, nameProduct, descriptionProduct);
		}
			
				
		switch (category) {
			case 1:
				System.out.println("Enter an advice to reduce this residue\n");
				adviceToReduce = inputString.nextLine();
				info = weRecycle.addWaste(id, name, source, color, decompositionTime, x, adviceToReduce);
					break;
			case 2: 
				System.out.println("Choose its type:\n"
						+ " 1.Paper\n"
						+ " 2.Paperboard\n"
						+ " 3.Glass\n"
						+ "	4.Plastic\n"
						+ " 5.Metal\n");
				pick = inputInt.nextInt();
				switch(pick) {
					case 1:
						type = Recyclable.PAPER;
							break;
					case 2:
						type = Recyclable.PAPERBOARD;
							break;
					case 3:
						type = Recyclable.GLASS;
							break;
					case 4:
						type = Recyclable.PLASTIC;
							break;
					case 5: 
						type = Recyclable.METAL;
							break;
				}
				System.out.println("Enter a description of this residue\n");
				description = inputString.nextLine();
				info = weRecycle.addWaste(id, name, source, color, decompositionTime, x, type, description);
					break;
			case 3:
				System.out.println("Is this residue suitable for composting?\n 1.Yes\n 2.Not");
				pick = inputInt.nextInt();
				if (pick == 1)
					suitableForComposting = true;
				info = weRecycle.addWaste(id, name, source, color, decompositionTime, x, suitableForComposting);
			}
		System.out.println(info);
	}
	
	

	private void generateReport() {
		String info = weRecycle.generateReportOfWaste();
		System.out.println(info); 	
	}

	private void addProduct() {
		System.out.println(" - Enter the id of the product: ");
		String id = inputString.nextLine();
		System.out.println(" - Enter the name of the product: ");
		String name = inputString.nextLine();
		System.out.println(" - Enter a description: ");
		String description = inputString.nextLine();
		String info = weRecycle.addProduct(id, name, description);
		System.out.println(info);
	}

	private void searchInfoByName(String name) {
		String info = weRecycle.searchInfoWasteByName(name);
		System.out.println(info);
	}
	
	private void searchInfoById(String id) {		
		String info = weRecycle.searchInfoWasteById(id);
		System.out.println(info);
		}

	private void showListOfProducts() {
		String info = weRecycle.showListOfProducts();
		System.out.println(info);	
	}

	private void calculateHarmfulEffect(String id) {
		double info = weRecycle.calculateHarmfulEffectOnPlanetOfResidue(id);
		System.out.println("Its harmful effect on the planet is: "+info);
	}

	private void detrmineUsability(String id)  {
		String info = weRecycle.isThisResidueUsable(id);
		System.out.println(info);
	}

	private void ordenateAllResiduesNoxiousness() {
		String info = weRecycle.listResiduesByNoxiousness();
		System.out.println(info);
	}


}
