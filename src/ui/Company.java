package ui;

import model.Recyclable;
import model.WeRecycle;
import java.util.Scanner;

public class Company {
	
	private WeRecycle weRecycle;
	
	private Scanner inputString;
	private Scanner inputInt;
	private Scanner inputDouble;
	
	public Company() {
		weRecycle = new WeRecycle();
		
		inputString = new Scanner(System.in);
		inputInt = new Scanner(System.in);
		inputDouble = new Scanner(System.in);
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
				+ " 10.Ordenate the residues of a product by their nocive effect, showing the most nocive first\n"
				+ " 11.Exit\n");
		
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
						recycler.searchInfoByName();
					break;
				case 5:
						recycler.searchInfoByName();	
					break;
				case 6:
						recycler.showListOfProducts();
					break;
				case 7:
						recycler.calculateHarmfulEffect();
					break;
				case 8:
						recycler.detrmineUsability();
					break;
				case 9:
						recycler.ordenateAllResiduesNoxiousness();
					break;
				case 10:
						recycler.odenateResiduesOfAProductNoxiousness();
					break;
				case 11:
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
		
		Product x = null;
		String idProduct = "";
		
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
			System.out.print
		}
			
				
		switch (category) {
			case 1:
				System.out.println("Enter an advice to reduce this residue\n");
				adviceToReduce = inputString.nextLine();
				info = addWaste(id, name, source, color, decompositionTime, x, adviceToReduce);
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
			case 3:
				System.out.println("Is this residue suitable for composting?\n 1.Yes\n 2.Not");
				pick = inputInt.nextInt();
				if (pick == 1)
					suitableForComposting = true;
			}
	}
	
	

	private void generateReport() {
			
	}

	private void addProduct() {
			
	}

	private void searchInfoByName() {
			
	}

	private void showListOfProducts() {
			
	}

	private void calculateHarmfulEffect() {
			
	}

	private void detrmineUsability() {
			
	}

	private void ordenateAllResiduesNoxiousness() {
			
	}

	private void odenateResiduesOfAProductNoxiousness() {
			
	}

}
