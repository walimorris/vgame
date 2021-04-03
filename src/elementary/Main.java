package elementary;

import elementary.Models.RandomWordPicker;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import elementary.Models.RandomCharacters;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    private static final AtomicInteger x = new AtomicInteger();
    private final static String LETTER = "Letter";

    @Override
    public void start(Stage primaryStage) throws Exception {
        resetAll(primaryStage);
    }

     public static void resetAll(Stage primaryStage) {
         RandomCharacters randomCharacters = new RandomCharacters();
         char randomCharacterUppercase = randomCharacters.getUppercase();
         char randomCharacterA = randomCharacters.getA();
         char randomCharacterB = randomCharacters.getB();
         char randomCharacterC = randomCharacters.getC();
         char randomCharacterD = randomCharacters.getD();

         Button A = new Button(Character.toString(randomCharacterA));
         Button B = new Button(Character.toString(randomCharacterB));
         Button C = new Button(Character.toString(randomCharacterC));
         Button D = new Button(Character.toString(randomCharacterD));

         Image soundButtonImage = new Image("file:src/assets/icons/promotion.png");
         ImageView soundButtonView = new ImageView(soundButtonImage);
         soundButtonView.setFitHeight(30);
         soundButtonView.setPreserveRatio(true);

         Button soundButton = new Button();
         double radius = 30.5;
         soundButton.setShape(new Circle(radius));
         soundButton.setGraphic(soundButtonView);

         A.setPrefSize(60, 40);
         A.getProperties().put(LETTER, randomCharacterA);

         B.setPrefSize(60, 40);
         B.getProperties().put(LETTER,  randomCharacterB);

         C.setPrefSize(60, 40);
         C.getProperties().put(LETTER,  randomCharacterC);

         D.setPrefSize(60, 40);
         D.getProperties().put(LETTER,  randomCharacterD);

         ButtonBar choicesBar = new ButtonBar();
         ButtonBar.setButtonData(A, ButtonBar.ButtonData.APPLY);
         ButtonBar.setButtonData(B, ButtonBar.ButtonData.APPLY);
         ButtonBar.setButtonData(C, ButtonBar.ButtonData.APPLY);
         ButtonBar.setButtonData(D, ButtonBar.ButtonData.APPLY);


         choicesBar.getButtons().addAll(A, B, C, D);
         // <a href="https://www.vecteezy.com/free-vector/nature">Nature Vectors by Vecteezy</a>
         Image image = new Image("file:src/assets/backgrounds/bluesky.jpg");
         BackgroundImage bgImage = new BackgroundImage(image, null, null, null,
                 new BackgroundSize(1.0, 1.0, true, true, false, false));

         Label label = new Label(String.valueOf(randomCharacterUppercase));
         label.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

         /* Add word picker and input field */
         HBox wordHBox = new HBox();
         RandomWordPicker randomWordPicker = new RandomWordPicker();
         String randomWord = randomWordPicker.getRandomWord(randomCharacterUppercase);
         Label wordLabel = new Label(randomWord);
         wordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 60));

         // red arrow visual 1
         Image arrowImage1 = new Image("file:src/assets/icons/redarrow.png");
         ImageView arrowView1 = new ImageView(arrowImage1);
         arrowView1.setFitHeight(60);
         arrowView1.setPreserveRatio(true);
         arrowView1.setVisible(true);

         // red arrow visual 2
         Image arrowImage2 = new Image("file:src/assets/icons/redarrow.png");
         ImageView arrowView2 = new ImageView(arrowImage2);
         arrowView2.setFitHeight(60);
         arrowView2.setPreserveRatio(true);
         arrowView2.setVisible(false);

         // correct visual
         Image checkmarkImage = new Image("file:src/assets/icons/checkmark.png");
         ImageView checkmarkView = new ImageView(checkmarkImage);
         checkmarkView.setFitHeight(30);
         checkmarkView.setPreserveRatio(true);
         checkmarkView.setVisible(false);

         // incorrect visual
         Image wrongmarkImage = new Image("file:src/assets/icons/wrongmark.png");
         ImageView wrongmarkView = new ImageView(wrongmarkImage);
         wrongmarkView.setFitHeight(30);
         wrongmarkView.setPreserveRatio(true);
         wrongmarkView.setVisible(false);

         TextField wordTextField = new TextField();
         wordHBox.getChildren().addAll(arrowView1, wordLabel, wordTextField, checkmarkView, wrongmarkView);
         wordHBox.setSpacing(10);
         wordHBox.setAlignment(Pos.CENTER);

         HBox buttonBarBox = new HBox();
         buttonBarBox.getChildren().addAll(arrowView2, choicesBar);
         buttonBarBox.setSpacing(10);
         buttonBarBox.setAlignment(Pos.CENTER);


         GridPane gridPane = new GridPane();
         gridPane.addRow(0, soundButton);
         gridPane.addRow(1, label);
         gridPane.addRow(2, wordHBox);
         gridPane.addRow(3, buttonBarBox);
         gridPane.setAlignment(Pos.CENTER);
         GridPane.setHalignment(soundButton, HPos.RIGHT);
         GridPane.setHalignment(label, HPos.CENTER);
         gridPane.setVgap(50);
         gridPane.setHgap(5);
         gridPane.setBackground(new Background(bgImage));

         // Event setup
         AtomicBoolean wordSubmitted = new AtomicBoolean(false);

         A.setOnMouseClicked(event -> {
             if (wordSubmitted.get()) {
                 try {
                     checkForAnswer(A, randomCharacterUppercase, x, primaryStage);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             } else {
                 // add animation to toggle arrow on word submission form
                 event.consume();
             }
         });

         B.setOnMouseClicked(event -> {
             if (wordSubmitted.get()) {
                 try {
                     checkForAnswer(B, randomCharacterUppercase, x, primaryStage);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             } else {
                 // add animation to toggle arrow on word submission form
                 event.consume();
             }
         });

         C.setOnMouseClicked(event -> {
             if (wordSubmitted.get()) {
                 try {
                     checkForAnswer(C, randomCharacterUppercase, x, primaryStage);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             } else {
                 // add animation to toggle arrow on word submission form
                 event.consume();
             }
         });

         D.setOnMouseClicked(event -> {
             if (wordSubmitted.get()) {
                 try {
                     checkForAnswer(D, randomCharacterUppercase, x, primaryStage);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             } else {
                 // add animation to toggle arrow on word submission form
                 event.consume();
             }
         });

         soundButton.setOnMouseClicked(event -> {
             playParentLetter(label);
         });

         wordTextField.setOnKeyPressed( event -> {
             if (event.getCode() == KeyCode.ENTER) {
                 if (wordTextField.getText().equalsIgnoreCase(wordLabel.getText())) {
                     wrongmarkView.setVisible(false);
                     checkmarkView.setVisible(true);
                     wordTextField.setEditable(false);
                     arrowView1.setVisible(false);
                     arrowView2.setVisible(true);
                     wordSubmitted.set(true);
                 } else {
                     checkmarkView.setVisible(false);
                     wrongmarkView.setVisible(true);
                 }
             }
         });

         Scene scene = new Scene(gridPane, 1410.0,738.0);
         primaryStage.setTitle("Letters");
         primaryStage.setScene(scene);
         primaryStage.setMaximized(true);
         primaryStage.show();
         System.out.println(scene.getWidth());
         System.out.println(scene.getHeight());
         System.out.println(primaryStage.getWidth());
         System.out.println(primaryStage.getHeight());
     }

    /**
     * Validates answer when user clicks a button by taking the value of the selection,
     * the random uppercase letter show in UI, the number of chances x, and instance of
     * primary stage to reset if correct.
     *
     * @param b : {@link Button}
     * @param c1 : char
     * @param x : {@link AtomicInteger}
     * @param primaryStage {@link Stage}
     * @throws InterruptedException
     */
    public static void checkForAnswer(Button b, char c1, AtomicInteger x, Stage primaryStage)
            throws InterruptedException {
        if ( isEqualCharacters((char)b.getProperties().get(LETTER), c1)) {
            playCorrectAnswerSound();
            if (x.get() != 0) {
                x.getAndSet(0);
            }
            resetAll(primaryStage);
        } else {
            x.addAndGet(1);
            playIncorrectSound();
            if ( x.get() == 3 ) {
                x.getAndSet(0);
                resetAll(primaryStage);
            }
        }
    }

    /**
     * Plays the sound of the shown Parent(uppercase letter) in UI. The character
     * value of the label, the Parent Letter, is parsed to a {@link String} value
     * where that String is searched for in the 'src/assets/letter' directory.
     * When the character is found, it's appended to an instance of a new {@link File}.
     * Example: 'src/assets/letters/A.mp3' plays the sound for letter A.
     *
     * @param label : The value of Parent Letter shown in UI.
     */
    public static void playParentLetter(Label label) {
        String character = String.valueOf(label.getText().charAt(0));
        Media sound = new Media(new File("src/assets/letters/" + character + ".mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    /**
     * Plays correct answer sound, when user selects the correct answer. See directory
     * 'src/assets/buzzers/' for more sounds.
     */
    public static void playCorrectAnswerSound() {
        Media sound = new Media(new File("src/assets/buzzers/correct.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    /**
     * Plays incorrect answer sound, when user selects the incorrect answer. See directory
     * 'src/assets/buzzers/' for more sounds.
     */
    public static void playIncorrectSound() {
        Media sound = new Media(new File("src/assets/buzzers/incorrect.wav")
                .toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    /**
     * Returns true if characters are equal, false otherwise.
     *
     * @param c : char
     * @param c1 : char
     * @return : boolean
     */
    public static boolean isEqualCharacters(char c, char c1) {
        return String.valueOf(c).equalsIgnoreCase(String.valueOf(c1));
    }

     public static void main(String[] args) {
        launch(args);
    }
}
