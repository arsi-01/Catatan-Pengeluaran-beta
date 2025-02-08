# Dokumentasi Aplikasi Pencatat Pengeluaran Sederhana

## Latar Belakang
Pencatatan pengeluaran merupakan salah satu langkah penting dalam mengelola keuangan pribadi. Banyak individu dan keluarga menghadapi tantangan dalam memonitor dan mengendalikan pengeluaran mereka, yang sering kali mengarah pada pemborosan atau kekurangan dana untuk kebutuhan prioritas. Dengan menyediakan alat yang sederhana dan mudah digunakan, aplikasi ini bertujuan untuk membantu pengguna dalam mencatat, mengelola, dan memahami pengeluaran mereka. Langkah ini sejalan dengan **SDG 1: Tanpa Kemiskinan**, yang berfokus pada pengurangan kemiskinan melalui pengelolaan keuangan yang lebih baik, dan **SDG 8: Pekerjaan Layak dan Pertumbuhan Ekonomi**, yang mendorong inklusi finansial dan pertumbuhan ekonomi yang berkelanjutan.

## Tujuan
1. Membantu pengguna mencatat pengeluaran sehari-hari dengan mudah.
2. Memberikan wawasan kepada pengguna tentang pola pengeluaran mereka.
3. Mendukung pengelolaan keuangan pribadi yang lebih baik guna mencegah pemborosan.

## Fitur Utama
- **Mencatat Pengeluaran**: Tambahkan nama pengeluaran, deskripsi, dan harga.
- **Riwayat Pengeluaran**: Lihat daftar pengeluaran sebelumnya.
- **Menghapus Pengeluaran**: Hapus data yang tidak diperlukan.

## Arsitektur
### Diagram

### Teknologi:
- Bahasa Pemrograman: Kotlin/Java (untuk Android).
- Database: SQLite.
- Framework: Android Jetpack.
### Database
| Kolom         | Tipe Data       | Deskripsi                              |
|---------------|----------------|---------------------------------------|
| `id`          | INTEGER (PK)   | ID unik untuk setiap pengeluaran       |
| `pengeluaran` | TEXT           | Nama atau kategori pengeluaran         |
| `deskripsi`   | TEXT           | Keterangan tambahan                    |
| `harga`       | INTEGER           | Jumlah pengeluaran                     |

## Demo

### 1. Halaman Utama
Halaman utama menampilkan daftar pengeluaran.

| Tampilan Awal | Tampilan dengan Data |
|---------------|-----------------------|
| <img src="https://github.com/user-attachments/assets/de360514-8d15-4150-b5ae-e46988a3d419" alt="Tampilan awal" width="300"/> | <img src="https://github.com/user-attachments/assets/71eb556d-0f58-444a-aefb-32da5d73b5d7" alt="Tampilan ada data" width="300"/> |

---

### 2. Formulir Tambah Pengeluaran
Formulir untuk menambah pengeluaran baru.

| Tambah Catatan | Konfirmasi Tambahan |
|----------------|----------------------|
| <img src="https://github.com/user-attachments/assets/77612e17-10d5-4418-b899-1a050a62284c" alt="Tambah catatan" width="300"/> | <img src="https://github.com/user-attachments/assets/9c89789d-b62c-4314-8b47-6de7bd7f63b9" alt="Tambah catatan 1" width="300"/> |

---

### 3. Formulir Edit atau Hapus Pengeluaran
Formulir untuk mengedit pengeluaran atau menghapus.

<img src="https://github.com/user-attachments/assets/f9987597-72a1-442f-99b8-9ddbfe275df7" alt="Tampilan edit data" width="400"/>

---

### 4. Tombol Hapus Pengeluaran
Tombol untuk menghapus seluruh pengeluaran.

<img src="https://github.com/user-attachments/assets/3f8ce43c-ef52-4bba-8c27-905a7b74f45f" alt="Tombol delete all" width="400"/>


## Kesimpulan
Aplikasi Pencatat Pengeluaran Sederhana dirancang untuk membantu pengguna mencatat dan mengelola pengeluaran mereka dengan lebih baik. Dengan fitur yang mudah digunakan dan arsitektur yang sederhana, aplikasi ini memberikan solusi praktis untuk meningkatkan kesadaran finansial pengguna. Proyek ini memberikan wawasan tentang pentingnya pengelolaan keuangan yang baik untuk mendukung keberlanjutan ekonomi individu.







