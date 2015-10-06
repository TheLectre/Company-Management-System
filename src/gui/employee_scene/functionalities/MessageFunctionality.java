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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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

    //modules
    private HBox head;
    private VBox sending;
    private VBox receiving;
    private VBox reading;

    //sending
    private AutoCompleteTextField addressee;
    private ComboBox<String> type;
    private TextField topic;
    private Label letterCounter;
    private TextArea messageArea;
    private Button submit;

    //receiving
    private TableView messageList;

    //reading
    private MessageDisplay processedMessage; // to avoid creating a lot of parameters in methods
    private Label senderLabel;
    private Label dateLabel;
    private Label topicLabel;
    private TextArea deliveredMessage;
    private Button backButton;

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
        loadReceivingMode();

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
                loadSendingMode();
                mainPane.setCenter(sending);
            }
        });

        mailBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                loadReceivingMode();
                mainPane.setCenter(receiving);
            }
        });

        head.getChildren().add(newMessage);
        head.getChildren().add(mailBox);
    }

    private void loadSendingMode() {
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

    private void loadReceivingMode() {
        receiving = new VBox();

        messageList = createMessageList();

        receiving.getChildren().add(messageList);
    }

    private void loadReadingMode() {
        reading = new VBox();
        reading.setAlignment(Pos.CENTER);

        senderLabel = createSenderLabel();
        dateLabel = createDateLabel();
        topicLabel = createTopicLabel();
        deliveredMessage = createDeliveredMessage();
        backButton = createBackButton();

        reading.getChildren().add(senderLabel);
        reading.getChildren().add(dateLabel);
        reading.getChildren().add(topicLabel);
        reading.getChildren().add(deliveredMessage);
        reading.getChildren().add(backButton);
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
                } else if (type.getValue().equals(MessageType.EMPLOYEE.toString())) {
                    if (addressee.isDisable()) {
                        addressee.setDisable(false);
                    }

                    List<Employee> employees = rManager.getAllAcceptedEmployees();
                    addressee.getEntries().clear();

                    for (Employee p : employees) {
                        addressee.getEntries().add(p.getFirstName() + " " + p.getLastName() + " (" + p.getExperience() + ") id: " + p.getID());
                    }

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
                String topicName = topic.getText().equals("") ? "Empty topic" : topic.getText();
                String message = messageArea.getText().equals("") ? "Empty message" : messageArea.getText();
                int senderID = root.getEmployee().getID();
                String messageType = type.getValue();

                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());

                if (type.getValue().equals("Company member") && isNameValid()) {
                    rManager.addNewMessage(new Message(topicName, message, senderID, messageType, Integer.parseInt(addressee.getText().split("id: ")[1]), null, ts));
                    printResultStage("Message sent to", addressee.getText().split("id: ")[0], true);
                } else if (type.getValue().equals("Team") && isNameValid()) {
                    rManager.addNewMessage(new Message(topicName, message, senderID, messageType, null, Integer.parseInt(addressee.getText().split("id: ")[1]), ts));
                    printResultStage("Message sent to", addressee.getText().split("id: ")[0], true);
                } else if (type.getValue().equals("All")) {
                    rManager.addNewMessage(new Message(topicName, message, senderID, messageType, null, null, ts));
                    printResultStage("Message sent to", "All", true);
                } else {
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
        //table and columns
        TableView<MessageDisplay> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.setCursor(Cursor.HAND);
        tableView.setEditable(false);

        TableColumn dateColumn = new TableColumn("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.35f));

        TableColumn fromColumn = new TableColumn("Sender");
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));
        fromColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.25f));

        TableColumn topicColumn = new TableColumn("Topic");
        topicColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
        topicColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.4f));

        //to the selected message
        tableView.setRowFactory(tView -> {
            TableRow<MessageDisplay> tableRow = new TableRow<>();
            tableRow.setOnMouseClicked(event -> {
                if (tableRow.getItem() != null) {
                    this.processedMessage = tableRow.getItem();
                    loadReadingMode();
                    mainPane.setCenter(reading);
                }
            });
            return tableRow;
        });

        //data
        Integer empl_id = root.getEmployee().getID();
        Integer team_id = root.getEmployee().getTeam() != null ? root.getEmployee().getTeam().getID() : null;
        ArrayList<Message> messages = rManager.getMessagesByReceiver(empl_id, team_id != null ? team_id : null);
        ObservableList<MessageDisplay> data = FXCollections.observableArrayList();

        for (Message p : messages) {
            Employee senderEmpl = rManager.getEmployeeByID(p.getSenderID());
            SimpleDateFormat sdf = new SimpleDateFormat("d MMM K:m a", Locale.ENGLISH);
            data.add(new MessageDisplay(p.getID(), sdf.format(p.getTimeStamp()), senderEmpl.getFirstName() + " " + senderEmpl.getLastName(), p.getTopic()));
        }

        //visualization
        tableView.getColumns().addAll(dateColumn, fromColumn, topicColumn);
        tableView.setItems(data);

        return tableView;
    }

    private Label createSenderLabel() {
        Label label = new Label(processedMessage.getSender());

        return label;
    }

    private Label createDateLabel() {
        Label label = new Label(processedMessage.getDate());

        return label;
    }

    private Label createTopicLabel() {
        Label label = new Label(processedMessage.getTopic());

        return label;
    }

    private TextArea createDeliveredMessage() {
        TextArea textArea = new TextArea(rManager.getMessageByID(processedMessage.getID()).getText());

        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxHeight(100);
        textArea.setMaxWidth(200);

        return textArea;
    }

    private Button createBackButton() {
        Button button = new Button("Back");

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                loadReceivingMode();
                mainPane.setCenter(receiving);
            }
        });

        return button;
    }

    private boolean isNameValid() {
        for (String p : addressee.getEntries()) {
            if (p.equals(addressee.getText())) {
                return true;
            }
        }
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
                if (success) {
                    addressee.setText("");
                    topic.setText("");
                    messageArea.setText("");
                    letterCounter.setText("250 characters left.");
                } else {
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
    //================================================================================
    // Inner class
    //================================================================================
    public static class MessageDisplay {

        private final int ID;
        private final SimpleStringProperty date;
        private final SimpleStringProperty sender;
        private final SimpleStringProperty topic;

        MessageDisplay(int ID, String date, String sender, String topic) {
            this.ID = ID;
            this.date = new SimpleStringProperty(date);
            this.sender = new SimpleStringProperty(sender);
            this.topic = new SimpleStringProperty(topic);
        }

        @Override
        public String toString() {
            return "MessageDisplay{" + "ID=" + ID + ", date=" + date + ", sender=" + sender + ", topic=" + topic + '}';
        }

        public int getID() {
            return ID;
        }

        public String getDate() {
            return date.get();
        }

        public String getSender() {
            return sender.get();
        }

        public String getTopic() {
            return topic.get();
        }

    }

}
