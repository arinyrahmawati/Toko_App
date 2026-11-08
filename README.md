# TokoApp - Toko Arin

Aplikasi desktop sederhana berbasis JavaFX untuk mengelola daftar produk Toko Arin. Pengguna dapat menambah produk, melihat daftar produk, mencari produk berdasarkan nama, dan melihat detail produk.

## Fitur

- Tambah Produk: input nama, kategori (Makanan / Minuman), dan harga. Kode produk dibuat otomatis (PR001, PR002, dst.).
- Daftar Produk: menampilkan semua produk dalam tabel.
- Cari Produk: pencarian berdasarkan nama produk.
- Detail Produk: menampilkan kode, nama, kategori, dan harga produk yang dipilih.
- Validasi input: nama tidak boleh kosong, harga harus berupa angka dan lebih dari nol.

## Teknologi

- Java (JDK) 17 atau lebih baru
- JavaFX 21
- Apache Maven
- Apache NetBeans

## Struktur Proyek

TokoApp
- pom.xml
- src/main/java/kelas
  - MainApp.java (titik masuk aplikasi)
  - Navigator.java (perpindahan antar halaman)
  - controller/FormController.java (halaman tambah produk)
  - controller/DaftarController.java (halaman daftar produk)
  - controller/DetailController.java (halaman detail produk)
  - data/DataProduk.java (penyimpanan data di memori)
  - model/produk.java (model data produk)
- src/main/resources/kelas
  - form.fxml
  - daftar.fxml
  - detail.fxml
  - styles/app.css (tampilan aplikasi)

## Cara Menjalankan

Lewat NetBeans:
1. Buka proyek TokoApp (File > Open Project).
2. Klik kanan proyek, pilih Clean and Build.
3. Klik kanan proyek, pilih Run.

Lewat terminal (pastikan JDK 17+ dan Maven sudah terpasang):
mvn clean javafx:run

## Cara Penggunaan

1. Aplikasi dibuka di halaman Tambah Produk.
2. Isi nama produk, pilih kategori, isi harga, lalu klik SIMPAN.
3. Klik Lihat Daftar Produk untuk melihat semua produk.
4. Di halaman daftar, ketik nama di kolom cari lalu klik Cari.
5. Pilih satu baris produk, lalu klik Lihat Detail.
6. Klik Kembali ke Daftar untuk kembali ke tabel, atau Tambah Produk untuk menambah produk baru.

## Catatan

- Data produk disimpan di memori, jadi hilang saat aplikasi ditutup.
- Ukuran jendela mengikuti desain di Scene Builder (461 x 400).
- Gaya tampilan (warna, tombol, tabel) diatur di styles/app.css.
