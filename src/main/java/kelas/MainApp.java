
package kelas;

import kelas.data.DataProduk;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        DataProduk data = new DataProduk();

        Navigator navigator = new Navigator(stage, data);

        navigator.bukaForm();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
