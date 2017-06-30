import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class LoadXML {

	private String ITEM="item";
	private String ENDDATE="endDate";
	private String STARTDATE="startDate";
	private String ISDONE="isDone";
	private String ID="id";
	private String NAME="name";
	private String TOTALITEMS="totalItems";		//TODO:implement
	Date newDate;


	
	@SuppressWarnings({"unchecked","null"})
	
	
	public List<Item> loadFile(String listFile){
		List<Item> itemList=new ArrayList<>();
		try{
			XMLInputFactory inputFactory=XMLInputFactory.newInstance();
			InputStream in=new FileInputStream(listFile);
			XMLEventReader eventReader=inputFactory.createXMLEventReader(in);
			Item item=null;			//TODO: wat

			while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    if (startElement.getName().getLocalPart().equals(ITEM)) {
						item= new Item(0,"null");
					}


				}
				if(event.isStartElement()){
					if (event.asStartElement().getName().getLocalPart().equals(ID)){
						event=eventReader.nextEvent();
						item.setId(3);		//TODO:fix value
						continue;
					}
				}
				if(event.isStartElement()){
					if (event.asStartElement().getName().getLocalPart().equals(NAME)){
						event=eventReader.nextEvent();
						item.setName(event.asCharacters().getData());
						continue;
					}
				}
				if(event.isStartElement()){
					if (event.asStartElement().getName().getLocalPart().equals(STARTDATE)){
						event=eventReader.nextEvent();
						//						item.setStartDate(event.asCharacters().getData());		//TODO: cant change to date
						continue;
					}
				}
				if(event.isStartElement()){
					if (event.asStartElement().getName().getLocalPart().equals(ENDDATE)){
						event=eventReader.nextEvent();
						//						item.setEndDate(event.asCharacters().getData());		TODO: cant change to date
						continue;
					}
				}
				if(event.isStartElement()){
					if (event.asStartElement().getName().getLocalPart().equals(ISDONE)){
						event=eventReader.nextEvent();
						if(event.equals("true")){
							item.setDone(true);
						}else{
							item.setDone(false);
						}					
						continue;
					}
				}
				if(event.isEndElement()){
					EndElement endElement=event.asEndElement();
					if (endElement.getName().getLocalPart().equals(ITEM)){
						itemList.add(item);
					}
				}
			}



		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(XMLStreamException xmlse){
			xmlse.printStackTrace();
		}
		return itemList;
	}





}




