import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ToDoGUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane border=new BorderPane();
		VBox headerPane=new VBox();
		Text headerText=new Text("ToDoList");
		headerText.setFont(new Font("Arial black",24));
		VBox addItemPane=new VBox();
		
		
		TableView<Item>tablePane=new TableView<>();
	
		TableColumn columnID=new TableColumn("ID");
		columnID.setPrefWidth(40);
		columnID.setResizable(false);
		columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn columnStartDate=new TableColumn("Start Date");
		columnStartDate.setPrefWidth(100);
		columnStartDate.setResizable(false);
		columnStartDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
		TableColumn columnEndDate=new TableColumn("End Date");
		columnEndDate.setPrefWidth(100);
		columnEndDate.setResizable(false);
		columnEndDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
		TableColumn columnName=new TableColumn("Name");
		columnName.setPrefWidth(400);
		columnName.setResizable(false);
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn columnIsDone=new TableColumn("Is Done");
		columnIsDone.setPrefWidth(80);
		columnIsDone.setResizable(false);
		columnIsDone.setCellValueFactory(new PropertyValueFactory<>("IsDone"));
		
		ObservableList<Item> obsList=FXCollections.observableArrayList() ;
		obsList.addAll(ToDoList.itemList);
		tablePane.setItems(obsList);
		
		System.out.println("--");
		for(Item item:obsList){
			System.out.println(item);	}
		System.out.println("--");
		
		tablePane.getColumns().addAll(columnID,columnStartDate,columnEndDate,columnName, columnIsDone);
		
		
		
		
		
		
		//testing
		for(Item item:ToDoList.itemList){
			System.out.println(item.getName());
		}
		ToDoList.printList();
		
		HBox buttonPane=new HBox();
		
		
		border.setTop(headerPane);
		border.setCenter(tablePane);
		border.setRight(buttonPane);
		border.setBottom(addItemPane);
		
		headerPane.getChildren().add(headerText);
		
		Scene sceneToDo=new Scene(border,700,300);
		primaryStage.setScene(sceneToDo);
		primaryStage.setResizable(false);
		
		primaryStage.show();
	}

}
