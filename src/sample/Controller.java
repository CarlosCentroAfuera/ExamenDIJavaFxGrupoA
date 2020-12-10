package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Controller {


    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;


    @FXML
    public void initialize() {
        ArrayList<Button> lista = new ArrayList<>();
        lista.add(b1);
        lista.add(b2);
        lista.add(b3);
        lista.add(b4);
        lista.add(b5);
        Collections.shuffle(lista);
        for (int i = 0; i<lista.size(); i++) {
            lista.get(i).setText(""+ (i + 1));
        }
    }

    private int numeroEsperado = 1;

    @FXML
    private void bClicked(MouseEvent event){
        Button b = (Button) event.getSource();
        if (Integer.parseInt(b.getText()) == numeroEsperado) {
            numeroEsperado++;
            if (numeroEsperado> 5) {
                System.out.println("Abriendo Ventana");
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root, 300, 275);
                    primaryStage.setTitle("Hello World");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
           }
        } else {
            System.out.println("Has fallado, inútil");
            numeroEsperado = 1;
        }
    }
}
