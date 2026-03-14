import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatBot extends Application {
	
	// HashMap to store chatbot keywords and responses
	private static final HashMap<String, String> reply = new HashMap<>();
	
   @Override
   public void start(Stage stage) {
	  
        
	   //Title label
	   Label label = new Label("Artificial Intelligence ChatBot");
	   label.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #000080; -fx-border-color: #1E90FF; -fx-border-width:2; -fx-padding:7,10,7,10; ");
	   label.setUnderline(true);
	   
	   // Chat area to display conversation
	   TextArea ta = new TextArea();
	   ta.setFont(Font.font("Algerian", 18));
	   ta.setPrefHeight(350);
	   ta.setEditable(false);
	   ta.setWrapText(true);
	   
	  // Input field for user messages
       TextField input = new TextField();
	   input.setPromptText("Type your message...");
	   input.setFont(Font.font("Verdana", 16));
	   input.setPrefWidth(400);

	   // Send button
	   Button bt1 = new Button("Send");
	   bt1.setPrefSize(80, 30);
	   
	   bt1.setOnAction(e -> {
		   String userText = input.getText().toLowerCase();
           ta.appendText("You: " + userText + "\n");
        
          String botReply = getBotResponse(userText);
          ta.appendText("Bot: " + botReply + "\n\n");
           ta.positionCaret(ta.getText().length()); 
          input.clear();
       });
	   input.setOnAction(e -> bt1.fire());// allow enter button to work
	   
	   // Clear button
	   Button bt2 = new Button("Clear");
	   bt2.setPrefSize(80, 30);
	   bt2.setOnAction(e -> {
		   ta.clear();
	   });
	   
	   
	// Main layout VBox  and  HBox
	   HBox bottom = new HBox(10, input, bt1,bt2);
	   HBox.setHgrow(input, Priority.ALWAYS);
	   
	   VBox root = new VBox(10);
	   VBox.setVgrow(ta, Priority.ALWAYS);
	   root.getChildren().addAll(label, ta, bottom);
	   root.setAlignment(Pos.CENTER);
       root.setPadding(new Insets(25));
       root.setStyle("-fx-background-color: linear-gradient(to bottom, #E0FFFF, #87CEFA);");
			   
       // Scene and stage setup
	   Scene scene = new Scene(root,500,500);
	   stage.setTitle("ChatBot");
	   stage.setScene(scene);
	   stage.show();}
   
	   // Private static method to get bot response
	  private static String getBotResponse(String text) {
		  String[] unknownReplies = {
			        "Hmm… I'm not sure about that. Can you ask differently?",
			        "Oops! My circuits didn’t catch that 🤖",
			        "Interesting… I haven't learned that yet!",
			        "I don’t know that one… teach me, please!",
			        "🤔 Huh? I’m confused!"
			    };
		  
			for(String key: reply.keySet()) {
				
				if(text.contains(key))
				   return reply.get(key);
            	 
             }
			 int rand = (int)(Math.random() * unknownReplies.length);//get random unknown replies when bot is not trained against specific msg
			 return unknownReplies[rand];
   
}
   
   
   

	public static void main(String[] args) {
    	
    	 // Fill HashMap with chatbot keywords and responses
    	reply.put("hello", "Hi there! How can I help you today?");
    	reply.put("hi", "Hello! Nice to see you!");
    	reply.put("hey", "Hey! How's it going?");
    	reply.put("how are you", "I'm just a bot, but I'm doing great! 😄");
    	reply.put("what is your name", "I am ChatBot 1.0, your friendly assistant.");
    	reply.put("who are you", "I am your chatbot, here to answer your questions!");
    	reply.put("bye", "Goodbye! Talk to you later.");
    	reply.put("see you", "See you! Have a great day!");
    	reply.put("thanks", "You're welcome! 😊");
    	reply.put("thank you", "No problem! Happy to help.");
    	reply.put("what can you do", "I can chat with you, answer simple questions, and make you smile!");
    	reply.put("weather", "I can't check real-time weather yet, but I hope it's sunny!");
    	reply.put("time", "I don't have a watch, but it's always chatbot o'clock 😎");
    	reply.put("age", "I was created recently, so I’m very young!");
    	reply.put("favorite color", "I like all colors, but I feel blue sometimes 😅");
    	reply.put("help", "Sure! You can ask me about my name, time, jokes, or just chat!");
    	reply.put("i love you", "Aww, I love our chats too! 💖");
    	reply.put("who created you", "I was made by a developer learning JavaFX and chatbot logic.");
    	reply.put("sorry", "No worries! It's okay 🙂");
    	reply.put("good morning", "Good morning! Hope you have a wonderful day!");
    	reply.put("good night", "Good night! Sleep tight 🌙");
    	reply.put("how old are you", "I don’t age like humans, I’m timeless 😎");
    	reply.put("your hobby", "Talking with you is my favorite hobby!");
    	reply.put("play game", "I can’t play games yet, but we can chat!");
    	reply.put("funny", "I try! 😄 Want to hear a joke?");
    	reply.put("love", "Love makes everything better 💖");
    	reply.put("ok", "👍 Ok! Let’s continue!");

    	  
        launch(args);
    }
}
;