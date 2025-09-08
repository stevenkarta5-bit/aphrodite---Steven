# Pre-Test: Spring Data JPA & Spring Web Development

## Bagian A – Pilihan Ganda (10 Soal)

1. Annotation apa yang digunakan untuk menandai sebuah class sebagai **Entity** di JPA?

```
 a) `@Table`
 b) `@Entity`
 c) `@Column`
 d) `@Repository`

```

2. Untuk membuat **primary key** otomatis bertambah di JPA, annotation yang digunakan adalah:

```
 a) `@GeneratedValue`
 b) `@Id`
 c) `@PrimaryKey`
 d) `@AutoIncrement`
```

3. Apa fungsi `JpaRepository` di Spring Data JPA?

```
   a) Menyediakan konfigurasi database
   b) Menyediakan implementasi CRUD secara otomatis
   c) Membuat koneksi HTTP
   d) Mengganti controller
```

4. Annotation apa yang digunakan untuk **REST Controller** di Spring Web?

```
   a) `@Controller`
   b) `@RestController`
   c) `@Service`
   d) `@Component`
```

5. Untuk membuat mapping endpoint `/api/users` dengan method GET, digunakan:

```
   a) `@GetMapping("/api/users")`
   b) `@PostMapping("/api/users")`
   c) `@RequestMapping("/api/users", method=POST)`
   d) `@RestMapping("/api/users")`
```

6. Annotation `@Column(nullable = false)` berarti:

   ```
   a) Kolom boleh kosong
   b) Kolom tidak boleh `null`
   c) Kolom tidak akan muncul di tabel
   d) Kolom adalah primary key
   ```

7. Apa kegunaan `@Autowired` dalam Spring?

   ```
   a) Mengatur database schema
   b) Melakukan dependency injection
   c) Menambahkan logging
   d) Membuat endpoint REST
   ```

8. Saat kita menggunakan `findById(id)` pada `JpaRepository`, return type biasanya adalah:

```
 a) `Entity`
 b) `Optional<Entity>`
 c) `List<Entity>`
 d) `Map<String, Entity>`
```

9. Annotation `@RequestBody` digunakan untuk:

```
 a) Mengambil query parameter dari URL
 b) Mengambil data JSON dari body request
 c) Mengambil header request
 d) Mengambil path variable
```

10. Spring Boot secara default menggunakan database apa untuk **in-memory testing**?

```
    a) MySQL
    b) PostgreSQL
    c) H2
    d) MongoDB
```

---

## Bagian B – True / False (5 Soal)

1. `@Entity` hanya bisa digunakan sekali di satu aplikasi. (T/F)
2. `@Repository` digunakan untuk menandai interface JPA repository. (T/F)
3. `@RestController` sudah termasuk `@ResponseBody` secara default. (T/F)
4. `JpaRepository` harus selalu diimplementasikan secara manual. (T/F)
5. `@PathVariable` digunakan untuk mengambil nilai dari URL. (T/F)

---

## Bagian C – Isian Singkat (5 Soal)

1. Sebutkan perbedaan utama antara `@Controller` dan `@RestController` di Spring Web.
2. Apa perbedaan `save()` dan `saveAll()` di JPA?
3. Bagaimana cara membuat relasi **OneToMany** antara `User` dan `Order` di JPA?
4. Apa fungsi dari `application.properties` di Spring Boot?
5. Sebutkan 2 keuntungan menggunakan Spring Data JPA dibanding JDBC manual.

---

## Bagian D – Perbaikan Kode (5 Soal)

**Soal 1**

```java
@Entity
public class User {
   @Id
   private Long id;
   private String name;
}
```

Buat agar id auto increment.

---

**Soal 2**

```java
@RestController
public class UserController {
   @GetMapping("/users")
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }
}
```

Perbaiki error dependency injection `userRepository`.

---

**Soal 3**

```java
public interface UserRepository {
   User findByName(String name);
}
```

Ubah agar bisa menggunakan Spring Data JPA.

---

**Soal 4**

```java
@PostMapping("/users")
public User addUser(User user) {
   return userRepository.save(user);
}
```

Perbaiki agar data bisa diterima dari request body JSON.

---

**Soal 5**

```java
@Entity
public class Order {
   @Id
   @GeneratedValue
   private Long id;

   @ManyToOne
   private User user;
}
```

Tambahkan mapping di sisi `User` agar relasi bidirectional.

---
