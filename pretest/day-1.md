## 🧠 **Pre-Test Backend Engineer (Java, OOP, Spring Boot)**

---

### 🔸 **A. Pilihan Ganda (5 Soal)**

1. Apa yang menjadi tanggung jawab utama seorang Backend Engineer?

   - A. Mendesain UI
   - B. Mengelola logika aplikasi dan komunikasi data dengan database
   - C. Membuat animasi
   - D. Membuat desain grafis

2. Dalam OOP Java, konsep **encapsulation** berarti:

   - A. Menyembunyikan detail implementasi dan menyediakan akses lewat method
   - B. Mewarisi method dari class lain
   - C. Menambahkan method ke dalam class
   - D. Menghubungkan dua class yang berbeda

3. `@Autowired` pada Spring Boot digunakan untuk:

   - A. Menjalankan program utama
   - B. Menyimpan konfigurasi properties
   - C. Meng-inject dependency otomatis ke dalam bean
   - D. Mendaftarkan endpoint baru

4. Mengapa sebaiknya logika bisnis diletakkan di service layer?

   - A. Agar controller lebih ringan dan fokus pada request/response
   - B. Agar lebih cepat dalam compile
   - C. Karena controller tidak mendukung operasi logika
   - D. Agar dapat digunakan langsung tanpa testing

5. Di bawah ini adalah cara yang benar membuat endpoint di Spring Boot:

   - A. `@Route("/api")`
   - B. `@Mapping("/api")`
   - C. `@GetMapping("/api")`
   - D. `@WebRoute("/api")`

---

### 🔸 **B. True / False (5 Soal)**

6. Dalam arsitektur backend, service biasanya dipanggil langsung dari frontend.
7. Constructor Injection adalah cara yang direkomendasikan untuk dependency injection di Spring.
8. `@Service` digunakan untuk menandai sebuah class sebagai penyedia logika bisnis.
9. Semua logika bisa ditaruh dalam controller agar tidak perlu membuat banyak file.
10. Spring Boot memerlukan `main()` method untuk menjalankan aplikasinya.

---

### 🔸 **C. Jawaban Singkat Penjelasan (10 Soal)**

11. Jelaskan apa itu Backend dan bagaimana perannya dalam aplikasi.
12. Apa perbedaan antara class dan object dalam Java?
13. Sebutkan dan jelaskan 2 prinsip OOP lainnya selain encapsulation.
14. Mengapa kita menggunakan annotation `@RestController`?
15. Apa keuntungan menggunakan Spring Boot dibanding membuat server dari nol di Java?
16. Jelaskan cara kerja dependency injection di Spring Boot secara sederhana.
17. Apa manfaat memisahkan controller dan service dalam arsitektur aplikasi?
18. Jelaskan apa yang terjadi jika Anda tidak menambahkan `@Service` pada class yang berisi logika.
19. Apa itu `@RequestParam` dan kapan digunakan?
20. Bagaimana cara menghubungkan controller ke service menggunakan constructor?

---

### 🔸 **D. Koreksi Kode (5 Soal)**

> Jelaskan kesalahan dan berikan versi yang benar.

21.

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello(); // error
    }
}
```

22.

```java
public class Person {
    public String name;

    public void Person(String name) {
        this.name = name;
    }
}
```

23.

```java
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody name) {
        return "Hello, " + name;
    }
}
```

24.

```java
@Service
public class InfoService {
    public String getInfo() {
        return "Info OK";
    }
}

// controller
@RestController
public class InfoController {
    @GetMapping("/info")
    public String get() {
        InfoService info = new InfoService();
        return info.getInfo();
    }
}
```

25.

```java
@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(int a, int b) {
        return a + b;
    }
}
```
