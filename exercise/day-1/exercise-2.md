## Soal 1: Sistem Penilaian Siswa

**Nama Project:** `SistemNilaiSiswa`

**Cerita:**
Pak Budi adalah seorang guru yang ingin membuat sistem penilaian otomatis untuk siswanya. Sistem ini akan menentukan grade berdasarkan nilai yang diinput:

- Nilai 90-100: Grade A
- Nilai 80-89: Grade B
- Nilai 70-79: Grade C
- Nilai 60-69: Grade D
- Nilai di bawah 60: Grade E

**Input yang diperlukan:**

- Nama siswa (String)
- Nilai siswa (int)

**Output yang diharapkan:**

- Nama siswa, nilai, dan grade yang diperoleh

---

## Soal 2: Kalkulator Tarif Parkir

**Nama Project:** `KalkulatorTarifParkir`

**Cerita:**
Mall XYZ memiliki sistem tarif parkir sebagai berikut:

- Motor: Rp 2.000 untuk 2 jam pertama, Rp 1.000 per jam berikutnya
- Mobil: Rp 5.000 untuk 2 jam pertama, Rp 2.000 per jam berikutnya
- Maksimal tarif per hari: Motor Rp 10.000, Mobil Rp 25.000

**Input yang diperlukan:**

- Jenis kendaraan (String: "motor" atau "mobil")
- Lama parkir dalam jam (int)

**Output yang diharapkan:**

- Jenis kendaraan, lama parkir, dan total biaya

---

## Soal 3: Sistem Absensi Karyawan

**Nama Project:** `SistemAbsensiKaryawan`

**Cerita:**
PT Maju Jaya ingin membuat sistem untuk menentukan status kehadiran karyawan berdasarkan jam masuk:

- Masuk sebelum atau tepat jam 08:00: "Tepat Waktu"
- Masuk jam 08:01 - 08:15: "Terlambat Ringan" (potongan 1% dari gaji harian)
- Masuk jam 08:16 - 08:30: "Terlambat Sedang" (potongan 3% dari gaji harian)
- Masuk setelah jam 08:30: "Terlambat Berat" (potongan 5% dari gaji harian)

**Input yang diperlukan:**

- Nama karyawan (String)
- Jam masuk (int, format 24 jam, contoh: 815 untuk jam 08:15)
- Gaji harian (double)

**Output yang diharapkan:**

- Nama karyawan, status kehadiran, potongan gaji, dan gaji yang diterima

---

## Soal 4: Sistem Diskon Belanja Online

**Nama Project:** `SistemDiskonBelanja`

**Cerita:**
Toko online "BelanjaMart" memberikan diskon berdasarkan total belanja dan status membership:

- Member Regular: Diskon 5% jika belanja ≥ Rp 100.000, diskon 10% jika belanja ≥ Rp 500.000
- Member Premium: Diskon 10% jika belanja ≥ Rp 100.000, diskon 15% jika belanja ≥ Rp 300.000, diskon 20% jika belanja ≥ Rp 500.000
- Non-member: Tidak ada diskon

**Input yang diperlukan:**

- Nama pembeli (String)
- Total belanja (double)
- Status membership (String: "regular", "premium", atau "non-member")

**Output yang diharapkan:**

- Nama pembeli, total belanja, persentase diskon, nominal diskon, dan total bayar

---

## Soal 5: Sistem Peminjaman Buku Perpustakaan

**Nama Project:** `SistemPeminjamanBuku`

**Cerita:**
Perpustakaan Kota memiliki aturan peminjaman buku berdasarkan jenis anggota dan lama peminjaman:

- Mahasiswa: Maksimal 14 hari, denda Rp 1.000/hari jika terlambat
- Dosen: Maksimal 21 hari, denda Rp 2.000/hari jika terlambat
- Umum: Maksimal 7 hari, denda Rp 500/hari jika terlambat

Jika keterlambatan lebih dari 30 hari, anggota akan dikenai sanksi suspensi.

**Input yang diperlukan:**

- Nama anggota (String)
- Jenis anggota (String: "mahasiswa", "dosen", atau "umum")
- Hari peminjaman yang sudah berlalu (int)

**Output yang diharapkan:**

- Nama anggota, status peminjaman ("tepat waktu", "terlambat", atau "suspensi"), dan total denda (jika ada)

---

## Tips Implementasi:

1. Gunakan `if-else if-else` untuk kondisi bertingkat
2. Gunakan `switch-case` untuk pilihan yang spesifik
3. Kombinasikan operator logika (`&&`, `||`) untuk kondisi kompleks
4. Gunakan `Scanner` untuk input dari user
5. Format output agar user-friendly dengan `System.out.printf()` atau `DecimalFormat`
