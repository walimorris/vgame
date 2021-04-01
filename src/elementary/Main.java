package elementary;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import elementary.Models.RandomCharacters;

import java.io.File;
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
         soundButton.setPrefSize(30, 30);
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

         GridPane gridPane = new GridPane();
         gridPane.addRow(0, label);
         gridPane.addRow(0, soundButton);
         gridPane.addRow(1, choicesBar);
         gridPane.setAlignment(Pos.CENTER);
         GridPane.setHalignment(soundButton, HPos.RIGHT);
         GridPane.setHalignment(label, HPos.CENTER);
         gridPane.setVgap(100);
         gridPane.setHgap(5);
         gridPane.setBackground(new Background(bgImage));

         A.setOnMouseClicked(event -> {
             try {
                 checkForAnswer(A, randomCharacterUppercase, x, primaryStage);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         B.setOnMouseClicked(event -> {
             try {
                 checkForAnswer(B, randomCharacterUppercase, x, primaryStage);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         C.setOnMouseClicked(event -> {
             try {
                 checkForAnswer(C, randomCharacterUppercase, x, primaryStage);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         D.setOnMouseClicked(event -> {
             try {
                 checkForAnswer(D, randomCharacterUppercase, x, primaryStage);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         soundButton.setOnMouseClicked(event -> {
             playParentLetter(label);
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
