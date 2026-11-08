
package kelas.controller;

import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.produk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DaftarController {

    @FXML
    private TextField cariField;

    @FXML
    private TableView<produk> tabelProduk;

    @FXML
    private TableColumn<produk, String> kodeColumn;

    @FXML
    private TableColumn<produk, String> namaColumn;

    @FXML
    private TableColumn<produk, String> kategoriColumn;

    @FXML
    private TableColumn<produk, Number> hargaColumn;

    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;

        tabelProduk.setItems(data.getDaftar());
    }

    @FXML
    private void initialize() {

        kodeColumn.setCellValueFactory(
            new PropertyValueFactory<>("kode")
        );

        namaColumn.setCellValueFactory(
            new PropertyValueFactory<>("nama")
        );

        kategoriColumn.setCellValueFactory(
            new PropertyValueFactory<>("kategori")
        );

        hargaColumn.setCellValueFactory(
            new PropertyValueFactory<>("harga")
        );
    }

    @FXML
    private void cari() {

        String keyword = cariField.getText()
                .trim()
                .toLowerCase();

        if (keyword.isEmpty()) {
            tabelProduk.setItems(data.getDaftar());
            pesanLabel.setText("Menampilkan semua produk.");
            return;
        }

        ObservableList<produk> hasil =
                FXCollections.observableArrayList();

        for (produk produk : data.getDaftar()) {

            if (produk.getNama()
                    .toLowerCase()
                    .contains(keyword)) {

                hasil.add(produk);
            }
        }

        tabelProduk.setItems(hasil);

        if (hasil.isEmpty()) {
            pesanLabel.setText("Produk tidak ditemukan.");
        } else {
            pesanLabel.setText(
                "Ditemukan " + hasil.size() + " produk."
            );
        }
    }

    
    @FXML
    private void bukaDetail() {

        produk produk = tabelProduk.getSelectionModel()
                .getSelectedItem();

        if (produk == null) {
            pesanLabel.setText(
                    "Silakan pilih produk terlebih dahulu."
            );
            return;
        }

    try {
        navigator.bukaDetail(produk);
    } catch (Exception e) {
        pesanLabel.setText("Gagal membuka detail produk.");
        e.printStackTrace();
    }
}


    @FXML
    private void bukaForm() {
        try {
            navigator.bukaForm();
        } catch (Exception e) {
            pesanLabel.setText("Gagal membuka form produk.");
            e.printStackTrace();
        }
    }
}
