import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ToDoList {
	private static final Item Item = null;
	static ArrayList<Item> itemList=new ArrayList<>();
	private static Scanner input=new Scanner(System.in);




	public static void printList(){
		for (Item item:itemList){
			if(itemList.size()<=0){
				System.out.println("List is empty");
			}else{
				System.out.println(item);
			}

		}
	}

	public static void itemsLeftToDo(){
		if(itemList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			int countLeft=0;

			int countTotal=0;
			for(Iterator<Item> iter=itemList.iterator();iter.hasNext();) {			
				countTotal++;
				if(iter.next().isDone()==false){
					countLeft++;
				}			
			}
			System.out.println(countLeft +" items left to do out of "+countTotal);
		}
	}


	public static void removeAllDone(){
		boolean itemsRemoved=false;
		if(itemList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			for ( Iterator<Item> iterator1=itemList.iterator();iterator1.hasNext();){
				boolean b=iterator1.next().isDone();

				if (b==true){
					itemsRemoved=true;
					iterator1.remove();				


				}

			}if(itemsRemoved){
				System.out.println("Removing all done items");
			}else{
				System.out.println("No items yet done to remove.");
			}
		}
	}



	public static void removeItem(){
		if(itemList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			System.out.println("Which item do you want to remove? OBS! If duplicats are found,the oldest will be removed.");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();
			for (Iterator<Item> iterator0=itemList.iterator();iterator0.hasNext();){
				String item=iterator0.next().getName();
				if (item.equals(asdf2)){
					System.out.print("Are you sure you want to remove "+item+"? yes/no");
					String asdf3=input.nextLine();
					if (asdf3.equals("yes")){

						iterator0.remove();
						System.out.println("Removing item '"+item+"'.");
						break;
					}
					else{System.out.println("What do you want to do then?");
					}





				}else if(item.equalsIgnoreCase(asdf2)){
					System.out.println("No such item found. type 'print' or 'search' to find the right one.");
					break;
				}
			}
		}



	}







	public static void searchItem() {

		if(itemList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			ArrayList<Item> list1=new ArrayList<>();

			System.out.println("Which item do you want to seach for?");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();

			for (Iterator<Item> iterator2=itemList.iterator();iterator2.hasNext();){

				Item s=iterator2.next();
				if(s.getName().contains(asdf2)){				
					list1.add(s);


				}else if(s.getName().equalsIgnoreCase(asdf2)){
					System.out.println("No match found for '"+asdf2+"'.");
					break;
				}
			}
			if(list1.isEmpty()){
				System.out.println("No match found!");
			}else{
				System.out.println("We found a match for '"+asdf2+"' in:");

				for (Iterator<Item> iter=list1.iterator(); iter.hasNext();){
					System.out.println(iter.next());
				}
			}
		}
	}
	public static void doneItem() { //TODO: fix error search -
		if(itemList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			System.out.println("Which item do you want to mark as done?");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();
			Item s = null;

			for (Iterator<Item> iterator2=itemList.iterator();iterator2.hasNext();){
				s=iterator2.next();			
				if(s.getName().equals(asdf2)){
					if(s.isDone()==true){
						System.out.println(s.getName()+" is already completed.");
						break;
					}else{
						s.setDone(true);
						System.out.println("Changed "+s.getName()+" status to done");
						break;
					}
				}

			}if(!s.getName().equals(asdf2)){
				System.out.println("No such item found. type 'print' or 'search' to find the correct one.");

			}
		}

	}



	//TODO: fix error search - 
	public static void notDoneItem() {
		if(itemList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			Item s=null;
			System.out.println("Which item do you want to mark as not done?");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();
			for (Iterator<Item> iterator2=itemList.iterator();iterator2.hasNext();){
				s=iterator2.next();
				if(s.getName().equals(asdf2)){
					if(s.isDone()==false){
						System.out.println(s.getName()+" is still not done.");
						break;
					}else{
						s.setDone(false);
						System.out.println("Changed "+s.getName()+" status to not done");
						break;
					}
				}

			}if(!s.getName().equals(asdf2)){
				System.out.println("No such item found. type 'print' or 'search' to find the correct one.");

			}
		}
	}
	public static void printOperationList() {

		System.out.println("The current avalible operations are:\nprint(1)\tadd(2)\t\tremove(3)\nsearch(4)\tclear(5)"
				+ "\tremaning(6)\noperations(7)\tdone(8)\t\tnot done(9)\nquit(0) \n What do you want to do? ");
	}

	public static void exitProgram() {
		System.out.println("Are you sure you want to leave? yes/no");

		String asdf2=input.nextLine();
		if (asdf2.equals("yes")){
			System.out.println("Goodbye");
			SaveXML toDoFile=new SaveXML();
			toDoFile.setFile("toDoList.xml");
			try{
				toDoFile.saveFile();
				System.out.println("Saving list...");
				System.exit(0);
			}catch(Exception e){
				e.printStackTrace();

			}
		}else{System.out.println("What do you want to do then?");
		}


	}

	public static void createItem() {

		System.out.println("What do you want to add?");
		String asdf2=input.nextLine();

		for(Item item: ToDoList.itemList){
			if(asdf2.equals(item.getName())){
				asdf2=asdf2.concat(" 1");
				System.out.println("Duplicate found, setting name to '"+asdf2);
			}}
			Item newItem=new Item(asdf2);
			itemList.add(newItem);

			System.out.println(asdf2+" added to list");


		


	}


}
