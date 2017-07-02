import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;

public class TestMain {

	private static boolean programRunning = true;
	private static Scanner input=new Scanner(System.in);


	public static void main(String[] args){
		SaveXML toDoFile=new SaveXML();




		//		ToDoList.addToList(item1);
		//		ToDoList.addToList(item2);
		//				ToDoList.addToList(item2);


		//loading XMLfile
		LoadXML loadNew=new LoadXML();
		List<Item> loadFile=loadNew.loadFile("toDoList.xml");
		System.out.println("loading list...");
		ToDoList.itemList.addAll(loadFile);
		
//		System.out.println("getTotalItems"+Item.getTotalItems());
//
//		
//		Application.launch(ToDoGUI.class,args);
//
//
//		ToDoList.printList();
		//program start
		

		for(Item item:ToDoList.itemList){
			if("asd".equals(item.getName())){
				System.out.println("Duplicate found");
			}
		}
		
		
		
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
			case "print":ToDoList.printList();
			break;
			case "add":ToDoList.createItem();
			break;
			case "remove":ToDoList.removeItem();
			break;
			case "search":ToDoList.searchItem();
			break;
			case "clear":ToDoList.removeAllDone();
			break;
			case "remaining":ToDoList.itemsLeftToDo();
			break;
			case "operations":ToDoList.printOperationList();
			break;
			case "quit": ToDoList.exitProgram();	
			break;
			case "done": ToDoList.doneItem();
			break;
			case "not done": ToDoList.notDoneItem();
			break;
			case "1":ToDoList.printList();
			break;
			case "2":ToDoList.createItem();
			break;
			case "3":ToDoList.removeItem();
			break;
			case "4":ToDoList.searchItem();
			break;
			case "5":ToDoList.removeAllDone();
			break;
			case "6":ToDoList.itemsLeftToDo();
			break;
			case "7":ToDoList.printOperationList();
			break;
			case "8":ToDoList.doneItem();
			break;
			case "9":ToDoList.notDoneItem();
			break;
			case "0": ToDoList.exitProgram();
			break;

			default: System.out.println("That's not an operation, type 'operations' to show a list of operations.");
			}
		}



	





		//		for (Iterator<Item> iterator=toDoList.itemList;iterator.hasNext();)){
		//		for (Item item: list1){





//		Item item1=new Item("olga");
//		ToDoList.addToList(item1);
//
//		System.out.println(Item.totalItems+"int");
//		System.out.println(Item.totalItemsString+"string");
//		System.out.println("--12-");
//
//		System.out.println("--");
//		ToDoList.printList();
//		System.out.println("--");
		//operations




		//saving list

		toDoFile.setFile("toDoList.xml");
		try{
			for(Item item:ToDoList.itemList){
				System.out.println(item);
			}
			toDoFile.saveFile();
			System.out.println("Saving list...");
		}catch(Exception e){
			e.printStackTrace();

		}




	}



}
