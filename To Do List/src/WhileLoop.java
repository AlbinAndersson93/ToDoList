import java.util.ArrayList;
import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args){
		boolean running=true;
		Scanner input=new Scanner(System.in);
		String asdf;
		ArrayList<Item> itemList=new ArrayList<>();
		
		while(running){
			
			asdf=input.next();
			if (asdf.equals("create")){
				
				createItem();
				addToList();
			}else{
				System.out.println("Wrong input");
				System.out.println(asdf);
			}
			if (asdf.equals("show")){
				showItems();
			}
			
			

		}

		


	}

	private static void addToList() {
		
		
	}

	private static void showItems() {
		
		
	}

	private static void createItem() {
		Scanner input=new Scanner(System.in);
		String asdf2=input.next();

		Item newItem=new Item(asdf2);
		
		System.out.println(newItem.toString());
		System.out.println();
	}

}






