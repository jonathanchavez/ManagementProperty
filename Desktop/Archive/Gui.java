/**
 * management company, where you can add properties from your company
 * @author jonathan
 */
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Gui extends Application {

	//initalize the variables
	private TextField txt1, txt2, txt3, ptxt1, ptxt2, ptxt3, ptxt4;
	private Label lab1, lab2, lab3, plab1, plab2, plab3, plab4;
	private Button mang, prop, max, total,list, exit;
	private String sone, tax, fee;
	private double fee2;
	ManagementCompany m;
	Property p1, p2, p3, p4, p5;
	int count = 0;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		//sets up borderpane
		BorderPane root = new BorderPane();

		 //makes the textfield and labels for the management company
		 txt1 = new TextField();
		 lab1 = new Label("Name:");
		 txt2 = new TextField();
		 lab2 = new Label("Tax Id:");
		 txt3 = new TextField();
		 lab3 = new Label("Fee %");
		 Text one = new Text("Management Company ");
		 
		 //sets the font of management company
		 one.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		 
		 
		//creates VBox and Hbox and add the nodes
		VBox top = new VBox();
		HBox topBox = new HBox(3);
		topBox.getChildren().addAll( lab1, txt1, lab2, txt2, lab3, txt3);
		
		//combines the two boxes
		top.getChildren().addAll(one, topBox);
		
		//sets up padding and the border
		root.setTop(top);
		top.setPadding(new Insets(10,0,15,0));
		topBox.setPadding( new Insets(10,0,10,0));
		topBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
		
		//creates the lower section buttons
		mang = new Button("New Management Company");
		HBox lowerBox = new HBox();		
		lowerBox.getChildren().addAll(mang);
		root.setBottom(lowerBox);
		
		//creates new buttons/disable them and adds to the lower section
		prop = new Button("Add Property");
		prop.setDisable(true);
		max = new Button("Max Rent");
		max.setDisable(true);
		total = new Button("Total Rent");
		total.setDisable(true);
		list = new Button("List of Properties");
		list.setDisable(true);
		exit = new Button("Exit");
		lowerBox.getChildren().addAll(prop,max,total,list,exit);
	
		//sets the margins of the buttons
		HBox.setMargin(mang, new Insets(10,5,10,5));
		HBox.setMargin(prop, new Insets(10,5,10,5));
		HBox.setMargin(max, new Insets(10,5,10,5));
		HBox.setMargin(total, new Insets(10,5,10,5));
		HBox.setMargin(list, new Insets(10,5,10,5));
		HBox.setMargin(exit, new Insets(10,5,10,5));
		
		
		//create new management company when button is clicked on, and undisable the other buttons
		mang.setOnAction(event -> {
			 sone = txt1.getText();
			 tax = txt2.getText();
			 fee = txt3.getText();
			 fee2 = Double.parseDouble(fee);
			m = new ManagementCompany(sone, tax, fee2);
			prop.setDisable(false);
			max.setDisable(false);
			total.setDisable(false);
			list.setDisable(false);
		});

		
		//creates the middle section textfields
		Text two = new Text("Property Information");
		ptxt1 = new TextField();
		plab1 = new Label("Property Name");
		ptxt2 = new TextField();
		plab2 = new Label("City");
		ptxt3 = new TextField();
		plab3 = new Label("Rent");
		ptxt4 = new TextField();
		plab4 = new Label("Owner");
		
		//sets the font to the text and makes two VBox 
		two.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		VBox middleBox = new VBox(10);
		middleBox.getChildren().addAll(two,plab1,ptxt1,plab2, ptxt2, plab3, ptxt3, plab4, ptxt4);
		VBox middle = new VBox();
		
		//combine the two VBoxes
		middle.getChildren().addAll(two, middleBox);
		
		//sets the style of the middle section
		root.setCenter(middle);
		middle.setMaxWidth(250);
		middle.setMaxHeight(175);
		middleBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		middleBox.setPadding(new Insets(10,10,10,10));
		
		//makes a new property and adds it when the button is clicked on
		prop.setOnAction(event -> {
			String pname = ptxt1.getText();
			String city= ptxt2.getText();
			String rent = ptxt3.getText();
			String owner = ptxt4.getText();
			double rent2 = Double.parseDouble(rent);
			count++;
			
			//checks to see if it has not past the limit of property
			if (count == 1){ 
				p1 = new Property(pname, city, rent2, owner);
				m.addProperty(p1);
			}
			else if (count == 2){
				p2 = new Property(pname, city, rent2, owner);
				m.addProperty(p2);
			}
			else if (count == 3){
				p3 = new Property(pname, city, rent2, owner);
				m.addProperty(p3);
			}
			else if (count == 4){
				p4 = new Property(pname, city, rent2, owner);
				m.addProperty(p4);
			}
			else if (count == 5){ 
				p5 = new Property(pname, city, rent2, owner);
				m.addProperty(p5);
			}
			else JOptionPane.showMessageDialog(null, "No more property can be added");

			//resets the text in the property infomration
			ptxt1.setText("");
			ptxt2.setText("");
			ptxt3.setText("");
			ptxt4.setText("");
			
		});
		
		//close the program when the exit button is clicked on
		exit.setOnAction(event ->{
			Platform.exit();
			System.exit(0);
		});
		
		//displays the max rent of a property when button is clicked on
		max.setOnAction(event -> {
			String b = m.displayPropertyAtIndex(m.maxPropertyRentIndex());
			JOptionPane.showMessageDialog(null, b, 
					"Management Company", JOptionPane.INFORMATION_MESSAGE);	
		});
		
		//displays the total rent of the properties when the total button is clicked on
		total.setOnAction(event ->{
			JOptionPane.showMessageDialog(null,"Total Rent of the properties: " + m.totalRent(),
			"Management Company", JOptionPane.INFORMATION_MESSAGE);
		});
		
		//list of the properties that were added when the list button is clicked on
		list.setOnAction(event ->{
			JOptionPane.showMessageDialog(null, m, "Management Company" , JOptionPane.INFORMATION_MESSAGE);
			
		});
		
		Scene scene = new Scene(root,700, 500);
		stage.setScene(scene);
		stage.setTitle("Rental Management");
		stage.show();
	}

}


