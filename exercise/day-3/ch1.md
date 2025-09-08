## 🧩 Soal 1 – Event Registration System

### 📁 Repository: `event-registration-api`

### 🎯 Product Requirement:

Aplikasi untuk manajemen event dan pendaftaran peserta.

### 📡 Endpoint (Minimal 8):

| Method | Endpoint                    | Description                        |
| ------ | --------------------------- | ---------------------------------- |
| POST   | `/events`                   | Buat event baru                    |
| GET    | `/events`                   | List semua event (search & paging) |
| GET    | `/events/{id}`              | Detail event                       |
| PUT    | `/events/{id}`              | Update event                       |
| DELETE | `/events/{id}`              | Hapus event                        |
| POST   | `/participants`             | Daftar peserta ke event            |
| GET    | `/events/{id}/participants` | List peserta event                 |
| DELETE | `/participants/{id}`        | Hapus peserta                      |
| GET    | `/stats/events`             | Jumlah peserta per event           |

### 🧪 Validasi:

- `@NotBlank` → title, name, location
- `@Email` → email peserta
- `@Pattern` → phone number
- Custom: `start_date < end_date`

---

## 🧩 Soal 2 – Feedback & Rating System

### 📁 Repository: `feedback-rating-api`

### 🎯 Product Requirement:

Sistem untuk menerima feedback dari user terhadap layanan atau produk.

### 📡 Endpoint (Minimal 8):

| Method | Endpoint                | Description                         |
| ------ | ----------------------- | ----------------------------------- |
| POST   | `/feedbacks`            | Kirim feedback                      |
| GET    | `/feedbacks`            | List semua feedback (filter rating) |
| GET    | `/feedbacks/{id}`       | Lihat detail feedback               |
| PUT    | `/feedbacks/{id}`       | Edit feedback                       |
| DELETE | `/feedbacks/{id}`       | Hapus feedback                      |
| GET    | `/ratings-summary`      | Rata-rata rating                    |
| POST   | `/users`                | Buat user (dummy relasi)            |
| GET    | `/users/{id}/feedbacks` | Feedback dari user tertentu         |

### 🧪 Validasi:

- `@NotBlank`, `@Size(min=10)` → message
- `@Min(1)`, `@Max(5)` → rating
- `@Email` → user

---

## 🧩 Soal 3 – Hotel Booking System

### 📁 Repository: `hotel-booking-api`

### 🎯 Product Requirement:

Sistem reservasi kamar hotel oleh pelanggan.

### 📡 Endpoint (Minimal 8):

| Method | Endpoint                   | Description                   |
| ------ | -------------------------- | ----------------------------- |
| POST   | `/rooms`                   | Tambah kamar                  |
| GET    | `/rooms`                   | Lihat semua kamar             |
| POST   | `/bookings`                | Buat booking                  |
| GET    | `/bookings`                | List booking (filter by date) |
| GET    | `/bookings/{id}`           | Detail booking                |
| PUT    | `/bookings/{id}`           | Ubah tanggal booking          |
| DELETE | `/bookings/{id}`           | Batalkan booking              |
| GET    | `/rooms/{id}/availability` | Cek ketersediaan kamar        |

### 🧪 Validasi:

- `@NotBlank` → customer name
- `@Future` → check-in/check-out
- Custom: `check_in < check_out`
