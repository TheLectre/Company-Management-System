package gui.employee_scene.functionalities;

import business_logic.Employee;
import business_logic.Message;
import business_logic.MessageType;
import business_logic.Team;
import core.ResourcesManager;
import gui.custom_components.AutoCompleteTextField;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessageFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    private BorderPane mainPane;

    private HBox head;
    private VBox sending;
    private VBox receiving;

    //sending
    private AutoCompleteTextField addressee;
    private ComboBox<String> type;
    private TextField topic;
    private Label letterCounter;
    private TextArea messageArea;
    private Button submit;
    
    //receiving
    private TableView messageList;

    //================================================================================
    // Constructors
    //================================================================================
    public MessageFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Messages";
    }

    @Override
    public Pane loadContent() {
        mainPane = new BorderPane();

        initializeHead();
        initializeSendingMode();
        initializeReceivingMode();

        mainPane.setTop(head);
        mainPane.setCenter(receiving);

        return mainPane;
    }

    private void initializeHead() {
        head = new HBox();

        head.setAlignment(Pos.CENTER);

        Button newMessage = new Button("New Message");
        Button mailBox = new Button("Mail Box");

        newMessage.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mainPane.setCenter(sending);
            }
        });

        mailBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mainPane.setCenter(receiving);
            }
        });

        head.getChildren().add(newMessage);
        head.getChildren().add(mailBox);
    }

    private void initializeSendingMode() {
        sending = new VBox();
        sending.setAlignment(Pos.CENTER);

        addressee = createAddressee();
        type = createMessageType();
        topic = createTopic();
        letterCounter = createLetterCounter();
        messageArea = createMessageArea();
        submit = createSubmitButton();

        sending.getChildren().add(type);
        sending.getChildren().add(addressee);
        sending.getChildren().add(topic);
        sending.getChildren().add(messageArea);
        sending.getChildren().add(letterCounter);
        sending.getChildren().add(submit);
    }

    private void initializeReceivingMode() {
        receiving = new VBox();
        
        messageList = createMessageList();
        
        receiving.getChildren().add(messageList);
    }

    private ComboBox<String> createMessageType() {
        ComboBox<String> type = new ComboBox<>();
        type.setPromptText("Message type");

        type.getItems().add(MessageType.EMPLOYEE.toString());
        type.getItems().add(MessageType.TEAM.toString());
        type.getItems().add(MessageType.ALL.toString());

        type.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                addressee.setText("");

                topic.setDisable(false);
                messageArea.setDisable(false);
                letterCounter.setDisable(false);
                submit.setDisable(false);

                if (type.getValue().equals(MessageType.ALL.toString())) {
                    addressee.setDisable(true);

                } else if (type.getValue().equals(MessageType.TEAM.toString())) {
                    if (addressee.isDisable()) {
                        addressee.setDisable(false);
                    }

                    List<Team> teams = rManager.getAllTeams();
                    addressee.getEntries().clear();

                    for (Team p : teams) {
                        addressee.getEntries().add(p.getName() + " id: " + p.getID());
                    }
                    System.out.println(addressee.getEntries().toString());
                } else if (type.getValue().equals(MessageType.EMPLOYEE.toString())) {
                    if (addressee.isDisable()) {
                        addressee.setDisable(false);
                    }

                    List<Employee> employees = rManager.getAllEmployees();
                    addressee.getEntries().clear();

                    for (Employee p : employees) {
                        addressee.getEntries().add(p.getFirstName() + " " + p.getLastName() + " (" + p.getExperience() + ") id: " + p.getID());
                    }
                    System.out.println(addressee.getEntries().toString());

                }
            }
        });
        return type;
    }

    private TextArea createMessageArea() {

        TextArea message = new TextArea();
        message.setDisable(true);
        message.setWrapText(true);
        message.setMaxHeight(100);
        message.setMaxWidth(200);
        message.setPromptText("Your message");

        EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                letterCounter.setText("" + (250 - message.getText().length()) + " characters left.");
                while (message.getText().length() >= 250) {
                    message.setText(message.getText().substring(0, 249));
                }
            }
        };

        message.setOnKeyReleased(eventHandler);
        message.setOnKeyTyped(eventHandler);

        return message;
    }

    private Label createLetterCounter() {
        Label lettersCounter = new Label("250 characters left.");
        lettersCounter.setDisable(true);
        return lettersCounter;
    }

    private AutoCompleteTextField createAddressee() {
        AutoCompleteTextField addressee = new AutoCompleteTextField();
        addressee.setDisable(true);
        addressee.setMaxWidth(200);
        addressee.setPromptText("Name");

        return addressee;
    }

    private Button createSubmitButton() {
        Button submitButton = new Button("Send");
        submitButton.setDisable(true);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("handling");
                String topicName = topic.getText().equals("") ? "Empty topic" : topic.getText();
                String message = messageArea.getText().equals("") ? "Empty message" : messageArea.getText();
                int senderID = root.getEmployee().getID();
                String messageType = type.getValue();

                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());

                if (type.getValue().equals("Company member") && isNameValid()) {
                    rManager.addNewMessage(new Message(topicName, message, senderID, messageType, Integer.parseInt(addressee.getText().split("id: ")[1]), 0, ts));
                    printResultStage("Message sent to", addressee.getText().split("id: ")[0], true);
                } else if (type.getValue().equals("Team") && isNameValid()) {
                    rManager.addNewMessage(new Message(topicName, message, senderID, messageType, 0, Integer.parseInt(addressee.getText().split("id: ")[1]), ts));
                    printResultStage("Message sent to", addressee.getText().split("id: ")[0], true);
                } else if (type.getValue().equals("All")) {
                    rManager.addNewMessage(new Message(topicName, message, senderID, messageType, 0, 0, ts));
                    printResultStage("Message sent to", "All", true);
                }
                else {
                    printResultStage("Invalid name.", "Pick valid receiver", false);
                }
            }
        });

        return submitButton;
    }

    private TextField createTopic() {
        TextField topic = new TextField();
        topic.setDisable(true);
        topic.setPromptText("Topic");

        return topic;
    }

    private TableView createMessageList() {
        TableView tableView = new TableView();
        
        TableColumn dateColumn = new TableColumn("Date");
        dateColumn.setCellFactory(new PropertyValueFactory<>("date"));
        
        
        TableColumn fromColumn = new TableColumn("From");
        fromColumn.setCellFactory(new PropertyValueFactory<>("from"));
        
        TableColumn topicColumn = new TableColumn("Topic");
        topicColumn.setCellFactory(new PropertyValueFactory<>("topic"));
        
        ObservableList<>
        
        tableView.getColumns().addAll(dateColumn, fromColumn, topicColumn);

        return tableView;
    }
    
    private boolean isNameValid() {
        for (String p : addressee.getEntries()) {
            if (p.equals(addressee.getText())) {
                return true;
            }
        }
        System.out.println("name invalid");
        return false;
    }
    
    private void printResultStage(String information, String secondInformation, boolean success) {
        Stage resultStage = new Stage();
        resultStage.setTitle("Information");

        Button okButton = new Button("OK");
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultStage.close();
                if(success) {
                    addressee.setText("");
                    topic.setText("");
                    messageArea.setText("");
                    letterCounter.setText("250 characters left.");
                }
                else {
                    addressee.setText("");
                }
            }
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(0, 10, 0, 10));
        vBox.getChildren().add(new Label(information));
        vBox.getChildren().add(new Label(secondInformation));
        vBox.getChildren().add(okButton);

        resultStage.setScene(new Scene(vBox, 280, 150));
        resultStage.show();
    }

    //================================================================================
    // Accessors
    //================================================================================
}
