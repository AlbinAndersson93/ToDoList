import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args){
		SaveXML toDoFile=new SaveXML();


		Item item1=new Item(4, "create an awesome todolist!");
		Item item2=new Item(5," kill some leaves");


		//		ToDoList.addToList(item1);
		//		ToDoList.addToList(item2);
		//		ToDoList.addToList(item2);
		ArrayList<Item> list1=new ArrayList<>();  //not used yet

		for(Item item: ToDoList.itemList){
			System.out.println(item);
		}

		//		for (Iterator<Item> iterator=toDoList.itemList;iterator.hasNext();)){
		//		for (Item item: list1){

		
										//loading XMLfile
		LoadXML loadNew=new LoadXML();
		List<Item> loadFile=loadNew.loadFile("toDoList.xml");
		System.out.println("loading list...");
			

			
										//operations
		
		System.out.println("-----------");
		ToDoList.itemList.addAll(loadFile);
		for(Item ite:ToDoList.itemList){
			System.out.println(ite);
		}

//		ToDoList.addToList(item1);
//		ToDoList.addToList(item2);

		
		
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
