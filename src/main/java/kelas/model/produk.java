
package kelas.model;

public class produk {

    private String kode;
    private String nama;
    private String kategori;
    private double harga;

    public produk(String kode, String nama, String kategori, double harga) {

        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama produk wajib diisi.");
        }

        if (harga <= 0) {
            throw new IllegalArgumentException("Harga produk harus lebih dari nol.");
        }

        this.kode = kode;
        this.nama = nama.trim();
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }
}
