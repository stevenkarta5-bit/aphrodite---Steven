# Pre-Test: Spring Data JPA & Spring Web Development

## Bagian A – Pilihan Ganda (10 Soal)

1. Annotation apa yang digunakan untuk menandai sebuah class sebagai **Entity** di JPA?

```
 a) `@Table`
** b) `@Entity`**
 c) `@Column`
 d) `@Repository`

```

2. Untuk membuat **primary key** otomatis bertambah di JPA, annotation yang digunakan adalah:

```
** a) `@GeneratedValue`**
 b) `@Id`
 c) `@PrimaryKey`
 d) `@AutoIncrement`
```

3. Apa fungsi `JpaRepository` di Spring Data JPA?

```
   a) Menyediakan konfigurasi database
**b) Menyediakan implementasi CRUD secara otomatis**
   c) Membuat koneksi HTTP
   d) Mengganti controller
```

4. Annotation apa yang digunakan untuk **REST Controller** di Spring Web?

```
   a) `@Controller`
   **b) `@RestController`**
   c) `@Service`
   d) `@Component`
```

5. Untuk membuat mapping endpoint `/api/users` dengan method GET, digunakan:

```
   **a)'@GetMapping("/api/users")`**
   b) `@PostMapping("/api/users")`
   c) `@RequestMapping("/api/users", method=POST)`
   d) `@RestMapping("/api/users")`
```

6. Annotation `@Column(nullable = false)` berarti:

   ```
   a) Kolom boleh kosong
 **b) Kolom tidak boleh `null`**
   c) Kolom tidak akan muncul di tabel
   d) Kolom adalah primary key
   ```

7. Apa kegunaan `@Autowired` dalam Spring?

   ```
   a) Mengatur database schema
   **b) Melakukan dependency injection**
   c) Menambahkan logging
   d) Membuat endpoint REST
   ```

8. Saat kita menggunakan `findById(id)` pada `JpaRepository`, return type biasanya adalah:

```
 a) `Entity`
 **b) `Optional<Entity>`**
 c) `List<Entity>`
 d) `Map<String, Entity>`
```

9. Annotation `@RequestBody` digunakan untuk:

```
 a) Mengambil query parameter dari URL
 **b) Mengambil data JSON dari body request**
 c) Mengambil header request
 d) Mengambil path variable
```

10. Spring Boot secara default menggunakan database apa untuk **in-memory testing**?

```
    a) MySQL
    b) PostgreSQL
    **c) H2**
    d) MongoDB
```

---

## Bagian B – True / False (5 Soal)

1. `@Entity` hanya bisa digunakan sekali di satu aplikasi. (T/F) **False**
2. `@Repository` digunakan untuk menandai interface JPA repository. (T/F) **True**
3. `@RestController` sudah termasuk `@ResponseBody` secara default. (T/F) **True**
4. `JpaRepository` harus selalu diimplementasikan secara manual. (T/F) **False**
5. `@PathVariable` digunakan untuk mengambil nilai dari URL. (T/F) **True**

---

## Bagian C – Isian Singkat (5 Soal)

1. Sebutkan perbedaan utama antara `@Controller` dan `@RestController` di Spring Web. "@controller" digunakan untuk web MVC tradisional, sedangkan @restcontroller untuk membuat RESTful API
2. Apa perbedaan `save()` dan `saveAll()` di JPA? untuk save()
save() adalah untuk menyimpan satu entitas saja ke database, sedangkan saveAll() untuk menyimpan banyak entitas sekaligus dalam database.
3. Bagaimana cara membuat relasi **OneToMany** antara `User` dan `Order` di JPA? pada user :
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}

pada order:

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

4. Apa fungsi dari `application.properties` di Spring Boot?
untuk mengatur konfigurasi aplikasi, seperti Koneksi database, port server, konfigurasi JPA, logging, path, securit
5. Sebutkan 2 keuntungan menggunakan Spring Data JPA dibanding JDBC manual.
- query method dengan nama method saja
- otomatisasi operasi CRUD

---

## Bagian D – Perbaikan Kode (5 Soal)

**Soal 1**

```java
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) // ← Auto increment
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

   private final UserRepository userRepository;

   public UserController(UserRepository userRepository) {
       this.userRepository = userRepository;
   }

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
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User findByName(String name);
}
```

Ubah agar bisa menggunakan Spring Data JPA.

---

**Soal 4**

```java
@PostMapping("/users")
public User addUser(@RequestBody User user) {
   return userRepository.save(user);
}
```

Perbaiki agar data bisa diterima dari request body JSON.

---

**Soal 5**

```java
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @OneToMany(mappedBy = "user")
   private List<Order> orders;
}
```

Tambahkan mapping di sisi `User` agar relasi bidirectional.

---
