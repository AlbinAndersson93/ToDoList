import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Item {

	private String idString;
	private Date startDate=new Date();
	private Date endDate=new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(14));	
	private DateFormat dateFormat=new SimpleDateFormat("EEE dd/MM-yy");		
	private String startDateString=dateFormat.format(startDate);
	private String endDateString=dateFormat.format(endDate);
	private String name;
	private boolean isDone=false;
	SaveXML saveXML=new SaveXML();
	public static Integer totalItems=0; //TODO:Change init;
	public static String totalItemsString="0";





	public static Integer getTotalItems() {
		return totalItems;
	}

	public static void setTotalItems(Integer totalItems) {
		Item.totalItems = totalItems;
	}

	public static void setTotalItemsString(String totalItemsString) {
		Item.totalItemsString = totalItemsString;
	}


	public Item(String name) {

		
		
		this.totalItems=totalItems.valueOf(totalItemsString)+1;
		this.totalItemsString=totalItemsString;
		
		this.startDate=startDate;
		this.endDate=endDate;			 
		this.name = name;
		this.isDone = isDone;
		this.idString=totalItems.toString();
		

		this.startDateString=dateFormat.format(startDate);
		this.endDateString=dateFormat.format(endDate);


	}

	@Override
	public String toString() {
		return "#"+getIdString()+"[created: "+startDateString+", deadline: "+endDateString+", "+name+" ,completed="+isDone+"]";

	}
	public String getTotalItemsString() {
		return totalItemsString;
	}




	public String getIdString(){
		return idString;
	}
	public String getStartDateString(){
		return startDateString;

	}		
	public String getEndDateString(){

		return endDateString;
	}		
	public String getIsDoneString(){
		if(isDone==false){
			return("false");
		}else{
			return("true");
		}
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
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

	public void setIdString(String data) {
		this.idString=data;


	}


}



