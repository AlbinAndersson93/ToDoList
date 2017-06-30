import java.util.ArrayList;

public class ToDoList {
	static ArrayList<Item> itemList=new ArrayList<>();
	
	public static void addToList(Item item){
		itemList.add(item);
	}
	
	public void printList(){
		for (Item item:itemList){
			System.out.println(item);
		}
	}
}
