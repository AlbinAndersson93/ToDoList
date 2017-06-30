import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

	private int id;
	private Date startDate;
	private Date endDate;
	DateFormat dateFormat=new SimpleDateFormat("dd-MM/yy");		//TODO:implement
	private String name;
	private boolean isDone=false;
	SaveXML saveXML=new SaveXML();
	public int totalItems=4; //TODO:Change init;
	
	public Item(int id,String name) {

		
		this.id = saveXML.getTotalItems()+1;
		this.startDate = new Date();
		this.endDate = startDate; //TODO:+14 days;
		this.name = name;
		this.isDone = isDone;
		saveXML.setTotalItems(this.getTotalItems()+1);
		
		
	}

	@Override
	public String toString() {
		return "#"+id+"[created: "+startDate+", deadline: "+endDate+", "+name+" ,completed="+isDone+"]";
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public String getIdString(){
		Integer ide=id;
		return ide.toString();
	}
	public String getStartDateString(){
		return startDate.toString();

	}		
	public String getEndDateString(){

		return endDate.toString();
	}		
	public String getIsDoneString(){
		if(isDone==false){
			return("false");
		}else{
			return("true");
		}
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
