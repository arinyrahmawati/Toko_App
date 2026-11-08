
package kelas.controller;

import kelas.Navigator;
import kelas.model.produk;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailController {

    @FXML
    private Label kodeLabel;

    @FXML
    private Label namaLabel;

    @FXML
    private Label kategoriLabel;

    @FXML
    private Label hargaLabel;

    private Navigator navigator;

    private produk produk;

    public void setData(Navigator navigator, produk produk) {

        this.navigator = navigator;
        this.produk = produk;

        kodeLabel.setText(produk.getKode());
        namaLabel.setText(produk.getNama());
        kategoriLabel.setText(produk.getKategori());

        hargaLabel.setText(
            "Rp " + String.format("%,.0f", produk.getHarga())
        );
    }

    @FXML
    private void kembali() {

        try {
            navigator.bukaDaftar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
