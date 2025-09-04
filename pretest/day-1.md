## 🧠 **Pre-Test Backend Engineer (Java, OOP, Spring Boot)**

---

### 🔸 **A. Pilihan Ganda (5 Soal)**

1. Apa yang menjadi tanggung jawab utama seorang Backend Engineer?

   - A. Mendesain UI
   **- B. Mengelola logika aplikasi dan komunikasi data dengan database**
   - C. Membuat animasi
   - D. Membuat desain grafis

2. Dalam OOP Java, konsep **encapsulation** berarti:

   **- A. Menyembunyikan detail implementasi dan menyediakan akses lewat method**
   - B. Mewarisi method dari class lain
   - C. Menambahkan method ke dalam class
   - D. Menghubungkan dua class yang berbeda

3. `@Autowired` pada Spring Boot digunakan untuk:

   - A. Menjalankan program utama
   - B. Menyimpan konfigurasi properties
   - **C. Meng-inject dependency otomatis ke dalam bean**
   - D. Mendaftarkan endpoint baru

4. Mengapa sebaiknya logika bisnis diletakkan di service layer?

   - **A. Agar controller lebih ringan dan fokus pada request/response**
   - B. Agar lebih cepat dalam compile
   - C. Karena controller tidak mendukung operasi logika
   - D. Agar dapat digunakan langsung tanpa testing

5. Di bawah ini adalah cara yang benar membuat endpoint di Spring Boot:

   - A. `@Route("/api")`
   - B. `@Mapping("/api")`
   - **C. `@GetMapping("/api")`**
   - D. `@WebRoute("/api")`

---

### 🔸 **B. True / False (5 Soal)**

6. Dalam arsitektur backend, service biasanya dipanggil langsung dari frontend. **False**
7. Constructor Injection adalah cara yang direkomendasikan untuk dependency injection di Spring. **True**
8. `@Service` digunakan untuk menandai sebuah class sebagai penyedia logika bisnis. **True**
9. Semua logika bisa ditaruh dalam controller agar tidak perlu membuat banyak file. **False**
10. Spring Boot memerlukan `main()` method untuk menjalankan aplikasinya. **True**

---

### 🔸 **C. Jawaban Singkat Penjelasan (10 Soal)**

11. Jelaskan apa itu Backend dan bagaimana perannya dalam aplikasi. **berperan dalam logika bisnis, desain database atau penyimpanan data, dan pengolahan request data**
12. Apa perbedaan antara class dan object dalam Java? **class merupakan, suatu blueprint sedangkan object adalah hasail dari running blueprint atau class**
13. Sebutkan dan jelaskan 2 prinsip OOP lainnya selain encapsulation. **Polymorphism adalah kemampuan object untuk dapat memiliki banyak bentuk, inheritance memiliki sifat parent.**
14. Mengapa kita menggunakan annotation `@RestController`? **Digunakan untuk menggabungkan @Controller dan @ResponseBody**
15. Apa keuntungan menggunakan Spring Boot dibanding membuat server dari nol di Java? **Dengan springboot akan menyederhanakan konfigurasi dan penyusunan server**
16. Jelaskan cara kerja dependency injection di Spring Boot secara sederhana. **Spring membuat dan mengelola object, lalu akan menginject ke class lain.**
17. Apa manfaat memisahkan controller dan service dalam arsitektur aplikasi? **Agar kode dapat mudah dibaca**
18. Jelaskan apa yang terjadi jika Anda tidak menambahkan `@Service` pada class yang berisi logika. **Spring tidak akan mengenali class tersebut sebagai bean**
19. Apa itu `@RequestParam` dan kapan digunakan? **digunakan untuk mengambil dari parameter query di URL**
20. Bagaimana cara menghubungkan controller ke service menggunakan constructor? **Dengan menyuntikan service lewat constructor**

---

### 🔸 **D. Koreksi Kode (5 Soal)**

> Jelaskan kesalahan dan berikan versi yang benar.

21.

```java
@RestController
public class HelloController {

    private final HelloService helloService;

    // Constructor injection (rekomendasi)
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }
}
```

22.

```java
public class Person {
    private String name;

    // Konstruktor tanpa void
    public Person(String name) {
        this.name = name;
    }
}
```

23.

```java
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody String name) {
        return "Hello, " + name;
    }
}
```

24.

```java
@RestController
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/info")
    public String get() {
        return infoService.getInfo();
    }
}
```

25.

```java
@RestController
public class MathController {

    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}
```
