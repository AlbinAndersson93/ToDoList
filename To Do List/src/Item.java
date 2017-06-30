import java.util.Date;
import java.util.Scanner;

public class Item {

	private String name;
	private Date date;
	private boolean isDone;
	public int id;
	private Scanner input=new Scanner(System.in);
	


	
	

	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String getName() {
		return name;
	}
	public Date getDate() {
		return date;
	}
	public Item(String name) {
		
		this.name = name;
		this.date = new Date();
		this.isDone=false;
	
		
	}
	@Override
	public String toString() {
		if (this.isDone==true){
			return  "["+date+"] ToDo: "+name+" \tCompleted";
		}else{
			return  "["+date+"] ToDo: "+name;
		}
	}	
}
