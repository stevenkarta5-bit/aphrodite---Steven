# Soal 1 — Book Module (semua method dalam 1 kasus) kel 1

**Entity:**
`Book { Long id, String title, Long authorId, int year, boolean available }` (default `available=true`)

**Repository:** `BookRepository` (custom, in-memory)

## Task

Bangun API manajemen buku.

### Endpoints & Spesifikasi

1. **GET /api/books**

   - Query opsional: `authorId`, `yearFrom`, `yearTo`, `available`, `page`, `size`, `sort` (mis: `title,asc` atau `year,desc`).
   - **Respons 200**:

     ```json
     {
       "success": true,
       "data": {
         "content": [
           {
             "id": 1,
             "title": "...",
             "authorId": 10,
             "year": 2020,
             "available": true
           }
         ],
         "page": 0,
         "size": 10,
         "totalElements": 1,
         "totalPages": 1,
         "sort": "title,asc"
       },
       "error": null,
       "timestamp": "...",
       "path": "/api/books"
     }
     ```

2. **GET /api/books/{id}**

   - **404** bila tidak ditemukan.
   - **200**: objek `Book`.

3. **POST /api/books**

   - Body:

     ```json
     { "title": "Clean Code", "authorId": 10, "year": 2008 }
     ```

   - Aturan: `title` non-blank, `year>0`, `authorId` valid (exist & active di Author Module).
   - Unik: kombinasi `(title, authorId, year)` tidak boleh duplikat → **409**.
   - **201**: objek `Book` (set `available=true`).

4. **PUT /api/books/{id}**

   - Body penuh:

     ```json
     { "title": "Clean Coder", "authorId": 10, "year": 2011, "available": true }
     ```

   - Validasi sama seperti POST. **404** bila tidak ada.

5. **PATCH /api/books/{id}/availability**

   - Body:

     ```json
     { "available": false }
     ```

   - **200**: objek `Book` terkini.

6. **DELETE /api/books/{id}**

   - **204** bila sukses, **404** bila tidak ada.
   - **409** bila buku sedang dipinjam (cek Loan Module).

### Error & Envelope (berlaku global)

- Pakai wrapper:

  ```json
  {
    "success": false,
    "data": null,
    "error": { "code": "CONFLICT", "message": "..." },
    "timestamp": "...",
    "path": "/api/..."
  }
  ```

- Mapping umum:

  - Validasi → **400**
  - Tidak ditemukan → **404**
  - Konflik bisnis (duplikat/terpinjam) → **409**

---

# Soal 2 — Author Module (relasi & proteksi hapus) kel 1

**Entity:**
`Author { Long id, String name, String country, boolean active }` (default `active=true`)

**Repository:** `AuthorRepository`

## Task

Kelola author & integrasi dengan Book Module.

### Endpoints

1. **GET /api/authors**

   - Query: `country`, `active`, `q` (search `name`), `page`, `size`, `sort`.

2. **GET /api/authors/{id}** — **404** bila tidak ada.

3. **POST /api/authors**

   - Body:

     ```json
     { "name": "Robert C. Martin", "country": "US" }
     ```

   - Set `active=true`.

4. **PUT /api/authors/{id}**

   - Body penuh:

     ```json
     { "name": "Bob Martin", "country": "US", "active": true }
     ```

5. **PATCH /api/authors/{id}/active**

   - Body:

     ```json
     { "active": false }
     ```

6. **DELETE /api/authors/{id}**

   - **409** bila masih ada **Book.available=true** milik author tsb.
   - Alternatif: `DELETE ...?force=true` → jangan hapus; set `active=false`, **200**.

---

# Soal 3 — Member Module (validasi, unique, status) kel 2

**Entity:**
`Member { Long id, String fullName, String email, String phone, MemberStatus status /* ACTIVE|SUSPENDED */ }`

**Repository:** `MemberRepository`

## Task

Kelola member dengan aturan email unik & status.

### Endpoints

1. **GET /api/members**

   - Query: `status`, `q` (search `fullName/email`), `page`, `size`, `sort`.

2. **GET /api/members/{id}** — **404** bila tidak ada.

3. **POST /api/members**

   - Body:

     ```json
     { "fullName": "Khalid", "email": "khalid@example.com", "phone": "+62..." }
     ```

   - Validasi: format email benar, **email unik** → duplikat **409**.
   - Set `status=ACTIVE` default.

4. **PUT /api/members/{id}**

   - Full update (kecuali `id`). Email tetap unik.

5. **PATCH /api/members/{id}/status**

   - Body:

     ```json
     { "status": "SUSPENDED" }
     ```

   - Perubahan status mempengaruhi Loan Module (tidak boleh pinjam jika `SUSPENDED`).

6. **DELETE /api/members/{id}**

   - **409** bila masih ada Loan aktif (belum `returned`).
   - **204** jika sukses.

---

# Soal 4 — Loan Module (aturan pinjam/kembali, overdue)

**Entity:**
`Loan { Long id, Long memberId, Long bookId, LocalDate loanDate, LocalDate dueDate, boolean returned }` (default `returned=false`)

**Repository:** `LoanRepository` (serta akses ke `MemberRepository`, `BookRepository`)

## Task

Kelola peminjaman & pengembalian buku + filter overdue.

### Endpoints

1. **GET /api/loans**

   - Query: `memberId`, `bookId`, `returned`, `overdue`, `page`, `size`, `sort`
   - `overdue=true` → `!returned && dueDate < today`

2. **GET /api/loans/{id}** — **404** bila tidak ada.

3. **POST /api/loans**

   - Body:

     ```json
     {
       "memberId": 1,
       "bookId": 5,
       "loanDate": "2025-09-01",
       "dueDate": "2025-09-15"
     }
     ```

   - Aturan:

     - `Member.status` harus `ACTIVE` → jika tidak, **403**.
     - `Book.available` harus `true` → jika tidak, **409**.
     - `dueDate >= loanDate` → jika tidak, **400**.
     - Jika ok: buat Loan, set `Book.available=false`, **201**.

4. **PUT /api/loans/{id}**

   - Full update (mis. ubah `dueDate` sebelum `returned=true`). **409** bila sudah `returned=true`.

5. **PATCH /api/loans/{id}/return**

   - Body:

     ```json
     { "returned": true }
     ```

   - Aturan: set `returned=true`, set `Book.available=true`, **200**.
   - **409** jika sudah dikembalikan sebelumnya (idempotensi boleh dibuat mengembalikan `200` dengan keadaan sama).

6. **DELETE /api/loans/{id}**

   - Hanya bila `returned=true` → **204**.
   - Jika `returned=false` → **409**.

---

# Soal 5 — Category Module (many-to-many ke Book) kel 3

**Entity:**
`Category { Long id, String name, String description, List<Long> bookIds }` (`name` unik)

**Repository:** `CategoryRepository` (akses `BookRepository` untuk validasi id buku)

## Task

Kelola kategori + pemetaan buku.

### Endpoints

1. **GET /api/categories**

   - Query: `q` (search `name`), `page`, `size`, `sort`.

2. **GET /api/categories/{id}** — detail + `bookIds`.

3. **POST /api/categories**

   - Body:

     ```json
     { "name": "Engineering", "description": "Software books" }
     ```

   - `name` unik → **409** jika duplikat.

4. **PUT /api/categories/{id}**

   - Full update (tetap jaga unik `name`).

5. **PATCH /api/categories/{id}/books**

   - Body:

     ```json
     { "addBookIds": [1, 2], "removeBookIds": [3] }
     ```

   - Semua `bookIds` harus valid → jika ada yang tidak valid, **400**.
   - Return kategori terbaru.

6. **DELETE /api/categories/{id}**

   - Hapus kategori, **204** (tidak menghapus buku).

---

# Soal 6 — System Module (health, config, bulk ops, flags) kel 3

**Repos dipakai:** `BookRepository`, `AuthorRepository`, `MemberRepository`, `LoanRepository`, `CategoryRepository`

## Task

Sediakan endpoint sistem utilitas & operasi massal.

### Endpoints

1. **GET /api/system/health**

   - Return uptime (detik), versi app, waktu server. **200**.

2. **GET /api/system/config**

   - Return config publik, mis:

     ```json
     { "pageMaxSize": 100, "featureFlags": { "allowBulkAvailability": true } }
     ```

3. **POST /api/system/bulk/books/availability**

   - Body:

     ```json
     { "bookIds": [1, 2, 3], "available": true }
     ```

   - Batas maksimal `bookIds` = 100 → **413** jika lebih.
   - Balikkan ringkasan:

     ```json
     { "updated": [1, 2], "skipped": [3], "invalidIds": [999] }
     ```

4. **PUT /api/system/rebuild-index**

   - Simulasikan rebuild (idempotent). **200**:

     ```json
     { "status": "REBUILT", "lastRebuild": "2025-09-08T10:00:00Z" }
     ```

5. **PATCH /api/system/flags**

   - Body:

     ```json
     { "flags": { "allowBulkAvailability": false, "maintenanceMode": true } }
     ```

   - Partial update feature flags. **200**.

6. **DELETE /api/system/data**

   - Body:

     ```json
     { "modules": ["books", "authors", "members", "loans", "categories"] }
     ```

   - Hard-clear data modul terpilih. Wajib header sederhana `X-ADMIN-TOKEN`.
   - **401** bila header salah/absen, **200** dengan ringkasan jumlah record terhapus.

---

## ✅ Ketentuan Umum (berlaku untuk semua soal)

- **Response Envelope (wajib):**

  ```json
  {
    "success": true,
    "data": ...,
    "error": null,
    "timestamp": "2025-09-08T10:00:00Z",
    "path": "/api/..."
  }
  ```

  Untuk error: `success=false`, `data=null`, `error={code,message,fields?}`.

- **Global Error Handling (`@ControllerAdvice`)**:

  - Validasi request → **400** + detail field.
  - Resource not found → **404**.
  - Conflict bisnis (duplikat, sedang dipinjam, email exists, dll.) → **409**.
  - Forbidden (status member tidak ACTIVE) → **403**.
  - Payload terlalu besar/batch berlebihan → **413**.
  - Illegal state/argument khusus → **422** atau **400** (pilih konsisten).

- **Validasi Umum**:

  - String wajib: non-blank.
  - Angka wajib: > 0.
  - Tanggal: `dueDate >= loanDate`.
  - Unik: `Member.email`, `Category.name`, kombinasi `(Book.title, authorId, year)`.

---

tips response

```
@Getter @Builder
public class ApiResponse<T> {
  private final boolean success;
  private final T data;
  private final ApiError error;    // null jika success
  private final String timestamp;  // ISO-8601
  private final String path;

  public static <T> ApiResponse<T> ok(T data, String path) {
    return ApiResponse.<T>builder()
        .success(true).data(data).error(null)
        .timestamp(Instant.now().toString())
        .path(path)
        .build();
  }
}
```

```
kel 1: maik ,varrel
kel 2: rian, steven
kel 3:roy , yehez

github: khalidalhabibie
```
