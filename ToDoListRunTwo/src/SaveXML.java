import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class SaveXML {

	private String toDoFile;
	private Integer totalItems=0;
	public void setFile(String createdFile){
		this.toDoFile=createdFile;
		
	}
	
	
	public Integer getTotalItems() {
		return totalItems;
	}


	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}


	public void saveFile() throws Exception{
		XMLOutputFactory outputFactory=XMLOutputFactory.newInstance();
		XMLEventFactory eventFactory=XMLEventFactory.newInstance();
		XMLEvent end=eventFactory.createDTD("\n");
		
		StartDocument startDocument=eventFactory.createStartDocument();
		XMLEventWriter eventWriter=outputFactory.createXMLEventWriter(new FileOutputStream(toDoFile));
		
		eventWriter.add(startDocument);
		
		StartElement toDoListStartElement=eventFactory.createStartElement("", "", "ToDoList");
		eventWriter.add(end);
		eventWriter.add(toDoListStartElement);
		
//		StartElement startTotalItems = eventFactory.createStartElement("", "", "totalItems");
//		EndElement endTotalItems= eventFactory.createEndElement("", "", "totalItems");
//		Characters valueTotalItems=eventFactory.createCharacters(totalItems.toString());
//		eventWriter.add(startTotalItems);
//		eventWriter.add(valueTotalItems);
//		eventWriter.add(endTotalItems);
//		eventWriter.add(end);
		


//		createNode(eventWriter, item.getIdString(),item.getName(),item.getStartDateString(),item.getEndDateString(),item.getIsDoneString());
		
		for (Item item: ToDoList.itemList){
			createNode(eventWriter, item.getIdString(),item.getName(),item.getStartDateString(),item.getEndDateString(),item.getIsDoneString());
			
		}
		
//		createNode(eventWriter, "id","name","startDate","EndDate","isDone");
	
		eventWriter.add(eventFactory.createEndElement("", "","item"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
		
	}
	


	private void createNode(XMLEventWriter eventWriter, String idString, String name, String startDateString,String endDateString, String isDone) throws XMLStreamException {
		XMLEventFactory eventFactory=XMLEventFactory.newInstance();
		XMLEvent end=eventFactory.createDTD("\n");
		XMLEvent doubleTab=eventFactory.createDTD("\t\t");
		XMLEvent tab=eventFactory.createDTD("\t");
	
		StartElement itemStartElement=eventFactory.createStartElement("", "", "item");
		EndElement	itemEndElement=eventFactory.createEndElement("", "","item");
		
		eventWriter.add(tab);
		eventWriter.add(itemStartElement);
		eventWriter.add(end);

		
		StartElement idStartElement=eventFactory.createStartElement("", "", "id");
		Characters idValue=eventFactory.createCharacters(idString);
		EndElement	idEndElement=eventFactory.createEndElement("", "","id");
		
		StartElement nameStartElement=eventFactory.createStartElement("", "", "name");
		Characters nameValue=eventFactory.createCharacters(name);
		EndElement	nameEndElement=eventFactory.createEndElement("", "","name");
		
		StartElement startDateStartElement=eventFactory.createStartElement("", "", "startDate");
		Characters startDateValue=eventFactory.createCharacters(startDateString);
		EndElement	startDateEndElement=eventFactory.createEndElement("", "","startDate");
		
		StartElement endDateStartElement=eventFactory.createStartElement("", "", "endDate");
		Characters endDateValue=eventFactory.createCharacters(endDateString);
		EndElement	endDateEndElement=eventFactory.createEndElement("", "","endDate");
		
		StartElement isDoneStartElement=eventFactory.createStartElement("", "", "isDone");
		Characters isDoneValue=eventFactory.createCharacters(isDone);
		EndElement	isDoneEndElement=eventFactory.createEndElement("", "","isDone");
		
		eventWriter.add(doubleTab);
		eventWriter.add(idStartElement);
		eventWriter.add(idValue);
		eventWriter.add(idEndElement);
		eventWriter.add(end);
	
		eventWriter.add(doubleTab);
		eventWriter.add(nameStartElement);
		eventWriter.add(nameValue);
		eventWriter.add(nameEndElement);
		eventWriter.add(end);
		
		eventWriter.add(doubleTab);
		eventWriter.add(startDateStartElement);
		eventWriter.add(startDateValue);
		eventWriter.add(startDateEndElement);
		eventWriter.add(end);
		
		eventWriter.add(doubleTab);
		eventWriter.add(endDateStartElement);
		eventWriter.add(endDateValue);
		eventWriter.add(endDateEndElement);
		eventWriter.add(end);
		
		eventWriter.add(doubleTab);
		eventWriter.add(isDoneStartElement);
		eventWriter.add(isDoneValue);
		eventWriter.add(isDoneEndElement);
		eventWriter.add(end);
	
		eventWriter.add(tab);
		eventWriter.add(itemEndElement);
		eventWriter.add(end);
		

		
	
		
		
		
	}
	
	
}
