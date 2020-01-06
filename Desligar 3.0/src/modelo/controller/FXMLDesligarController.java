package modelo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import modelo.model.Desligar;

public class FXMLDesligarController implements Initializable {

    @FXML
    private TextField txt_tempo;
    private int controler = 0;
    @FXML
    private Button bt_desligar;
    @FXML
    private Button bt_horas_M;
    @FXML
    private Button bt_horas_MN;
    @FXML
    private Button bt_minutos_MN;
    @FXML
    private Button bt_minutos_M;
    @FXML
    private TextField txt_tempo1;
    @FXML
    private Button bt_segundos_MN;
    @FXML
    private Button bt_segundos_M;
    @FXML
    private TextField txt_tempo2;

    private int valorH, valorM, valorS;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void btDesligar() {
        Desligar desligar = new Desligar(txt_tempo.getText(),txt_tempo1.getText(),txt_tempo2.getText());
        if (controler == 0) {
            desligar.Desligar();
            bt_desligar.setText("Cancelar");
            controler = 1;
        } else if (controler == 1) {
            desligar.cancelar();
            bt_desligar.setText("Desligar");
            txt_tempo.setDisable(false);
            controler = 0;
        }
    }

    @FXML
    public void horasMais() {
        valorH = Integer.valueOf(txt_tempo.getText());
        valorH += 1;
        txt_tempo.setText(String.valueOf(valorH));
    }

    @FXML
    public void horasMenos() {
        valorH = Integer.valueOf(txt_tempo.getText());
        if (valorH > 0) {
            valorH -= 1;
            txt_tempo.setText(String.valueOf(valorH));
        }
    }
    
    @FXML
    public void minutosMais() {
        valorM = Integer.valueOf(txt_tempo1.getText());
        if (valorM < 59) {
            valorM += 1;
            txt_tempo1.setText(String.valueOf(valorM));
        }
    }

    @FXML
    public void minutosMenos() {
        valorM = Integer.valueOf(txt_tempo1.getText());
        if (valorM > 0) {
            valorM -= 1;
            txt_tempo1.setText(String.valueOf(valorM));
        }
    }
    
    @FXML
    public void segundosMais() {
        valorS = Integer.valueOf(txt_tempo2.getText());
        if (valorS < 59) {
            valorS += 1;
            txt_tempo2.setText(String.valueOf(valorS));
        }
    }

    @FXML
    public void segundosMenos() {
        valorS = Integer.valueOf(txt_tempo2.getText());
        if (valorS > 0) {
            valorS -= 1;
            txt_tempo2.setText(String.valueOf(valorS));
        }
    }
}
