# Dokumentasi Aplikasi Pencatat Pengeluaran Sederhana

## Latar Belakang
Pencatatan pengeluaran merupakan langkah penting dalam pengelolaan keuangan. Aplikasi ini mendukung **SDG 1: Tanpa Kemiskinan** dan **SDG 8: Pekerjaan Layak dan Pertumbuhan Ekonomi**.

## Tujuan
1. Membantu mencatat pengeluaran sehari-hari.
2. Memberikan wawasan pola pengeluaran.
3. Mendukung pengelolaan keuangan pribadi.

## Fitur Utama
- **Mencatat Pengeluaran**: Tambahkan nama pengeluaran, deskripsi, dan harga.
- **Riwayat Pengeluaran**: Lihat daftar pengeluaran sebelumnya.
- **Menghapus Pengeluaran**: Hapus data yang tidak diperlukan.

## Arsitektur
| Kolom         | Tipe Data       | Deskripsi                              |
|---------------|----------------|---------------------------------------|
| `id`          | INTEGER (PK)   | ID unik untuk setiap pengeluaran       |
| `pengeluaran` | TEXT           | Nama atau kategori pengeluaran         |
| `deskripsi`   | TEXT           | Keterangan tambahan                    |
| `harga`       | REAL           | Jumlah pengeluaran                     |

## Demo

### 1. Halaman Utama
Halaman utama menampilkan daftar pengeluaran.

| Tampilan Awal | Tampilan dengan Data |
|---------------|-----------------------|
| <img src="https://github.com/user-attachments/assets/674f9118-447f-4866-8f65-f407c980872c" alt="Tampilan awal" width="300"/> | <img src="https://github.com/user-attachments/assets/e22095e2-6669-4584-bc33-1c8d73b5f8c8" alt="Tampilan ada data" width="300"/> |

---

### 2. Formulir Tambah Pengeluaran
Formulir untuk menambah pengeluaran baru.

| Tambah Catatan | Konfirmasi Tambahan |
|----------------|----------------------|
| <img src="https://github.com/user-attachments/assets/67d80742-d061-4edd-a200-a777014827c8" alt="Tambah catatan" width="300"/> | <img src="https://github.com/user-attachments/assets/7ac89eb8-c1eb-4549-9127-9427977a4e9f" alt="Tambah catatan 1" width="300"/> |

---

### 3. Formulir Edit atau Hapus Pengeluaran
Formulir untuk mengedit pengeluaran atau menghapus.

<img src="https://github.com/user-attachments/assets/dc3a77e6-2495-4655-aeac-caa786b3d1db" alt="Tampilan edit data" width="400"/>

---

### 4. Tombol Hapus Pengeluaran
Tombol untuk menghapus seluruh pengeluaran.

<img src="https://github.com/user-attachments/assets/9d40b092-3e74-41e8-b00b-dd8f5cee25f3" alt="Tombol delete all" width="400"/>


## Kesimpulan
Aplikasi ini dirancang untuk mempermudah pengelolaan keuangan, mendukung pencapaian SDG, dan meningkatkan kesadaran pengguna terhadap pola pengeluaran mereka.







