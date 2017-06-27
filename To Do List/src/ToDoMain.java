import java.util.Iterator;
import java.util.Scanner;

public class ToDoMain {


	private static Scanner input=new Scanner(System.in);
	private static ToDoList toDoList=new ToDoList();
	private static boolean programRunning = true;

	public static void main(String[] args) {

		//for testing;
		Item item1=new Item("a");
		Item item2=new Item("b");
		Item item3=new Item("c");
		Item item4=new Item("d");


		//for testing;
		toDoList.addToList(item1);
		toDoList.addToList(item2);
		toDoList.addToList(item3);
		toDoList.addToList(item4);



		
		System.out.println("What do you want to do? Type 'operations' to see avalible calls.");
		String operation = "";
		while(programRunning){
			try{
				operation=input.nextLine();
			}
			catch (Exception e){
				System.out.println("Whoops! An error occured!");
			}


			switch(operation){
			case "print":toDoList.printList();
			break;
			case "add":createItem();
			break;
			case "remove":toDoList.removeItem();
			break;
			case "search":toDoList.searchItem();
			break;
			case "clear":toDoList.removeAllDone();
			break;
			case "remaining":toDoList.itemsLeftToDo();
			break;
			case "operations":printOperationList();
			break;
			case "quit": exitProgram();	
			break;
			case "done": toDoList.doneItem();
			break;
			case "not done": toDoList.notDoneItem();
			break;

			case "1":toDoList.printList();
			break;
			case "2":createItem();
			break;
			case "3":toDoList.removeItem();
			break;
			case "4":toDoList.searchItem();
			break;
			case "5":toDoList.removeAllDone();
			break;
			case "6":toDoList.itemsLeftToDo();
			break;
			case "7":printOperationList();
			break;
			case "8":toDoList.doneItem();
			break;
			case "9":toDoList.notDoneItem();
			break;
			case "0": exitProgram();
			break;
			
			default: System.out.println("That's not an operation, type 'operations' to show a list of operations.");
			}
		}

	}

	private static void printOperationList() {

		System.out.println("The current avalible operations are:\nprint(1)\tadd(2)\t\tremove(3)\nsearch(4)\tclear(5)"
				+ "\tremaning(6)\noperations(7)\tdone(8)\t\tnot done(9)\nquit(0) \n What do you want to do? ");
	}



	private static void exitProgram() {
		System.out.println("Are you sure you want to leave? yes/no");
		String asdf2=input.nextLine();
		if (asdf2.equals("yes")){
			System.out.println("Goodbye");
			System.exit(0);
		}else{System.out.println("What do you want to do then?");
		}
		
		
	}


	private static void createItem() {

		System.out.println("What do you want to add?");
		String asdf2=input.nextLine();

		Item newItem=new Item(asdf2);
		toDoList.addToList(newItem);
		System.out.println(asdf2+" added to list");

	}

}

















