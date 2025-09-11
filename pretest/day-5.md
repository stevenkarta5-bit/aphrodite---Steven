## _Java Spring Boot & Spring Security_

### ✳️ Bagian 1: Pilihan Ganda (Dasar)

1. Apa anotasi yang digunakan untuk mendefinisikan sebuah REST controller?

   - A. `@Service`
   - B. `@Component`
   **- C. `@RestController`**
   - D. `@Repository`

2. Di Spring, anotasi apa yang digunakan untuk menyuntikkan dependency ke dalam class?

  ** - A. `@Autowired`**
   - B. `@Injectable`
   - C. `@Import`
   - D. `@Mapper`

3. Di lapisan arsitektur Spring, Service berfungsi untuk:

   - A. Menangani permintaan HTTP
   - B. Menyimpan data ke database langsung
   - C. Menyimpan log aplikasi
   **- D. Menyimpan logika bisnis**

4. Class model di Java Spring biasanya digunakan untuk:

   - A. Menyimpan konfigurasi Spring
   - B. Menyimpan logika controller
 **  - C. Menyimpan struktur data (seperti data user, produk, dll.)**
   - D. Mengatur pemetaan URL

5. Jika kita ingin membuat method yang bisa diakses oleh endpoint `/hello`, anotasi apa yang digunakan?

   - A. `@RestEndpoint("/hello")`
   - B. `@Path("/hello")`
   **- C. `@GetMapping("/hello")`**
   - D. `@Route("/hello")`

---

### ✳️ Bagian 2: Benar / Salah

6. `@Service` digunakan untuk menandai class sebagai lapisan Controller. **False**
7. Kita bisa membuat class model tanpa anotasi apapun jika hanya digunakan sebagai POJO.  **True**
8. `@Autowired` bisa digunakan di constructor maupun field. **True**
9. Spring Boot membutuhkan file `application.yml` agar bisa berjalan. **False**
10. `@GetMapping` hanya bisa digunakan di class dengan anotasi `@Service`. **False**

---

### ✳️ Bagian 3: Isian Singkat

11. Anotasi apa yang digunakan agar method bisa menangani permintaan POST? **anotasi PostMapping**
12. Apa nama file konfigurasi default di Spring Boot? **application.properties**
13. Apa yang dimaksud dengan Dependency Injection? **Konsep objek atau komponen dilakukan injeksi dengan dependensi oleh containernya**
14. Bagaimana cara mendeklarasikan class `UserService` agar dikenali Spring sebagai Service? **Anotasi service**
15. Apa perbedaan `@RestController` dan `@Controller`? controller untuk mengembalikan view seperti halaman HTML

---

### ✳️ Bagian 4: Perbaiki Kode / Output

16. Perbaiki kode berikut agar dapat dijalankan sebagai Controller:

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

17. Perbaiki kesalahan pada model berikut:

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private int price;
}
```

18. Apa output dari method berikut?

```java
@GetMapping("/sum")
public int sum() {
    return 2 + 3;
}
```

19. Kode service berikut error. Apa yang salah?

```java
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

20. Apa masalah pada potongan kode berikut?

```java
@RestController
public class BookController {

    @GetMapping("/books")
    public String listBooks() {
        return "books";
    }
}
```

---

### Bagian 5: Spring Security

#### Pilihan Ganda

21. Apa anotasi yang digunakan untuk mengaktifkan Spring Security di aplikasi Spring Boot?

- A. `@EnableSecurity`
- B. `@SpringSecurity`
**- C. `@EnableWebSecurity`**
- D. `@ActivateSecurity`

22. Komponen mana yang bertugas mengatur izin akses berdasarkan role atau otorisasi di Spring Security?

- A. `SecurityConfig`
- B. `UserDetailsService`
- C. `AuthenticationManager`
**- D. `HttpSecurity`**

23. Untuk membuat otentikasi berbasis user login yang dikustomisasi, interface apa yang harus diimplementasi?

- A. `UserRepository`
- B. `UserSecurity`
**- C. `UserDetailsService`**
- D. `SecurityService`

#### Benar / Salah

24. Spring Security hanya bisa digunakan untuk REST API yang menggunakan JWT. **False**
25. `@PreAuthorize("hasRole('ADMIN')")` digunakan untuk membatasi method agar hanya bisa diakses oleh pengguna dengan role ADMIN. **True**
26. `BCryptPasswordEncoder` digunakan untuk mengenkripsi password agar tidak disimpan dalam bentuk plain text. **True**

#### Isian Singkat

27. Apa class konfigurasi yang umum dibuat untuk menyesuaikan aturan login, logout, dan authorization di Spring Security? @Configuration + SecurityFilterChain UsernamePasswordAuthenticationFilter
28. Apa anotasi yang digunakan agar method hanya bisa diakses jika pengguna memiliki hak tertentu? @PreAuthorize

#### Perbaiki Kode / Analisis

29. Perbaiki potongan konfigurasi ini:

```java
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin();
        return http.build();
    }
}
```

30. Apa yang salah dengan konfigurasi login berikut?

```java
http
  .authorizeHttpRequests(auth -> auth
      .requestMatchers("/public").permitAll()
      .anyRequest().authenticated()
  )
  .formLogin();
```

---
