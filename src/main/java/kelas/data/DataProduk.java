
package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.produk;

public class DataProduk {

    private final ObservableList<produk> daftar =
            FXCollections.observableArrayList();

    private int urutan = 1;

    public ObservableList<produk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public produk tambah(String nama, String kategori, double harga) {

        String kode = String.format("PR%03d", urutan);

        produk produk = new produk(kode, nama, kategori, harga);

        daftar.add(produk);

        urutan++;

        return produk;
    }
}
