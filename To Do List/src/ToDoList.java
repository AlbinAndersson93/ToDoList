import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//
public class ToDoList {

	Scanner input=new Scanner(System.in);
	private ArrayList<Item> toDoList;






	public ToDoList() {

		toDoList = new ArrayList<Item>();
	}


	public void addToList(Item item){
		toDoList.add(item);

	}

	public void itemsLeftToDo(){
		if(toDoList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			int countLeft=0;

			int countTotal=0;
			for(Iterator<Item> iter=toDoList.iterator();iter.hasNext();) {			
				countTotal++;
				if(iter.next().isDone()==false){
					countLeft++;
				}			
			}
			System.out.println(countLeft +" items left to do out of "+countTotal);
		}
	}


	public void removeAllDone(){
		if(toDoList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			for ( Iterator<Item> iterator1=toDoList.iterator();iterator1.hasNext();){
				boolean b=iterator1.next().isDone();

				if (b==true){
					System.out.println("Removing all done items.");
					iterator1.remove();				
				}						
			}
		}
	}



	public void printList(){
		for(Item item:toDoList){
			System.out.println(item.toString());
		}if(toDoList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}
	}

	public void removeItem(){
		if(toDoList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			System.out.println("Which item do you want to remove? OBS! If duplicats are found,the oldest will be removed.");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();
			for (Iterator<Item> iterator0=toDoList.iterator();iterator0.hasNext();){
				String item=iterator0.next().getName();
				if (item.equals(asdf2)){
					System.out.print("Are you sure you want to remove "+item+"? yes/no");
					String asdf3=input.nextLine();
					if (asdf3.equals("yes")){

						iterator0.remove();
						System.out.println("Removing item '"+item+"'.");
						break;
					}else{System.out.println("What do you want to do then?");
					}


				}else if(item.equalsIgnoreCase(asdf2)){
					System.out.println("No such item found. type 'print' or 'search' to find the right one.");
					break;
				}
			}
		}



	}







	public void searchItem() {

		if(toDoList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			ArrayList<Item> list1=new ArrayList<>();

			System.out.println("Which item do you want to seach for?");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();

			for (Iterator<Item> iterator2=toDoList.iterator();iterator2.hasNext();){

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
	public void doneItem() { //TODO: fix error search -
		if(toDoList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			System.out.println("Which item do you want to mark as done?");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();
			Item s = null;

			for (Iterator<Item> iterator2=toDoList.iterator();iterator2.hasNext();){
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
	public void notDoneItem() {
		if(toDoList.size()==0){
			System.out.println("No items in list. type 'add' to add new ones.");
		}else{
			Item s=null;
			System.out.println("Which item do you want to mark as not done?");
			Scanner input=new Scanner(System.in);
			String asdf2=input.nextLine();
			for (Iterator<Item> iterator2=toDoList.iterator();iterator2.hasNext();){
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
}

