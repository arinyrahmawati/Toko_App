
package kelas.controller;

import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.produk;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class FormController {

    @FXML
    private TextField namaField;

    @FXML
    private ComboBox<String> kategoriBox;

    @FXML
    private TextField hargaField;

    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void initialize() {
        kategoriBox.getItems().addAll("Makanan", "Minuman");
        kategoriBox.setValue("Makanan");
    }

    @FXML
    private void simpan() {

        try {
            String nama = namaField.getText();
            String kategori = kategoriBox.getValue();
            double harga = Double.parseDouble(hargaField.getText());

            produk produk = data.tambah(nama, kategori, harga);

            pesanLabel.setText(
                "Produk berhasil disimpan! Kode: " + produk.getKode()
            );

            namaField.clear();
            hargaField.clear();

        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga harus berupa angka.");

        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (Exception e) {
            pesanLabel.setText("Gagal membuka daftar produk.");
            e.printStackTrace();
        }
    }
}
