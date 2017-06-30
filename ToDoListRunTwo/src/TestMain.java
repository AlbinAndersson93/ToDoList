import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args){
		SaveXML toDoFile=new SaveXML();




		//		ToDoList.addToList(item1);
		//		ToDoList.addToList(item2);
		//				ToDoList.addToList(item2);



	


		
		

		//		for (Iterator<Item> iterator=toDoList.itemList;iterator.hasNext();)){
		//		for (Item item: list1){


		//loading XMLfile
		LoadXML loadNew=new LoadXML();
		List<Item> loadFile=loadNew.loadFile("toDoList.xml");
		System.out.println("loading list...");
		
	
		
		ToDoList.itemList.addAll(loadFile);
		

		Item item1=new Item("olga");
		ToDoList.addToList(item1);

		System.out.println(Item.totalItems+"int");
		System.out.println(Item.totalItemsString+"string");
		System.out.println("--12-");

		System.out.println("--");
		ToDoList.printList();
		System.out.println("--");
		//operations


		

		//saving list
		toDoFile.setFile("toDoList.xml");
		try{
			toDoFile.saveFile();
			System.out.println("Saving list...");
		}catch(Exception e){
			e.printStackTrace();

		}




	}



}
