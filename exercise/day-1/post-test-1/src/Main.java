import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String gradeSiswa;
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan nama siswa: ");
        String namaSiswa = input.nextLine();

        System.out.println("Masukan nilai siswa: ");
        int nilaiSiswa = input.nextInt();

        if (nilaiSiswa >= 90 && nilaiSiswa <= 100){
            gradeSiswa = "A";
        } else if (nilaiSiswa >= 80 && nilaiSiswa <= 89) {
            gradeSiswa = "B";
        } else if (nilaiSiswa >= 70 && nilaiSiswa <= 79) {
            gradeSiswa = "C";
        } else if (nilaiSiswa >= 60 && nilaiSiswa <= 69) {
            gradeSiswa = "D";
        } else {
            gradeSiswa = "E";
        }

        System.out.println("- " + namaSiswa + ", " + nilaiSiswa + ", " + gradeSiswa);

    }
}