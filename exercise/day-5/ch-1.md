
---

## 🧩 Soal 1 – Event Ticketing & Check-in

### 📁 Repository: `event-ticketing-api`

### 🎯 Product Requirement

Platform penjualan tiket acara dengan QR check-in dan jenis tiket (Regular/VIP).

### 📡 Endpoint (Minimal 8)

| Method | Endpoint                    | Description                       |
| ------ | --------------------------- | --------------------------------- |
| POST   | `/events`                   | Buat event baru                   |
| GET    | `/events`                   | List semua event (filter by date) |
| GET    | `/events/{id}`              | Detail event                      |
| PUT    | `/events/{id}`              | Update event                      |
| POST   | `/events/{id}/ticket-types` | Tambah tipe tiket                 |
| POST   | `/orders`                   | Buat order tiket                  |
| GET    | `/orders/{id}`              | Detail order + QR code            |
| POST   | `/checkins`                 | Validasi tiket QR (check-in)      |
| GET    | `/events/{id}/statistics`   | Statistik penjualan & check-in    |

### 🧪 Validasi

- `@Future` → event start/end time
- `@DecimalMin("0.00")` → harga tiket
- `@PositiveOrZero` → kapasitas tiket
- `@Email` → email pembeli
- Enum: `status` (DRAFT, PUBLISHED, CANCELED), `order_status` (PENDING, PAID, REFUNDED)

---

## 🧩 Soal 2 – Library Borrowing System

### 📁 Repository: `library-borrowing-api`

### 🎯 Product Requirement

Sistem peminjaman buku perpustakaan untuk anggota.

### 📡 Endpoint (Minimal 8)

| Method | Endpoint                   | Description                     |
| ------ | -------------------------- | ------------------------------- |
| POST   | `/members`                 | Tambah anggota baru             |
| GET    | `/members/{id}`            | Detail anggota                  |
| POST   | `/books`                   | Tambah buku baru                |
| GET    | `/books`                   | List buku (filter by available) |
| POST   | `/borrowings`              | Pinjam buku                     |
| GET    | `/borrowings`              | List semua peminjaman           |
| GET    | `/borrowings/{id}`         | Detail peminjaman               |
| PUT    | `/borrowings/{id}/return`  | Kembalikan buku                 |
| GET    | `/members/{id}/borrowings` | List peminjaman milik anggota   |

### 🧪 Validasi

- `@NotBlank` → judul buku, nama anggota
- `@Pattern` → ISBN buku
- Enum: `borrowing_status` (BORROWED, RETURNED, LATE)
- Custom: max 5 buku per anggota

---

## 🧩 Soal 3 – Online Food Delivery

### 📁 Repository: `food-delivery-api`

### 🎯 Product Requirement

Aplikasi pemesanan makanan dengan restoran dan kurir.

### 📡 Endpoint (Minimal 8)

| Method | Endpoint                    | Description                     |
| ------ | --------------------------- | ------------------------------- |
| POST   | `/restaurants`              | Tambah restoran                 |
| GET    | `/restaurants`              | List restoran                   |
| POST   | `/restaurants/{id}/menus`   | Tambah menu makanan             |
| GET    | `/restaurants/{id}/menus`   | List menu makanan per restoran  |
| POST   | `/orders`                   | Buat pesanan                    |
| GET    | `/orders/{id}`              | Detail pesanan                  |
| PUT    | `/orders/{id}/status`       | Update status pesanan           |
| GET    | `/customers/{id}/orders`    | Pesanan milik customer          |
| GET    | `/couriers/{id}/deliveries` | List pesanan yang dikirim kurir |

### 🧪 Validasi

- `@DecimalMin("0.00")` → harga menu
- `@NotBlank` → nama restoran, nama menu
- Enum: `order_status` (PENDING, ACCEPTED, ON_DELIVERY, COMPLETED, CANCELED)
- Custom: hanya restoran `OPEN` yang bisa menerima order

---
