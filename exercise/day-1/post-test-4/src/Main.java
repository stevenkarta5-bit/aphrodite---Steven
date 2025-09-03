import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double diskon = 0.0;

        System.out.println("Masukan nama pembeli: ");
        String namaPembeli = input.nextLine();

        System.out.println("Masukan total belanja: ");
        double totalBelanja = input.nextDouble();
        input.nextLine();

        System.out.println("Masukan status membership: ");
        String statusPembeli = input.nextLine();


        if(statusPembeli.equals("regular")){
            if (totalBelanja >= 500000) {
                diskon = 10;
            } else if (totalBelanja >= 100000) {
                diskon = 5;
            }
        } else if (statusPembeli.equals("premium")) {
            if (totalBelanja >= 500000) {
                diskon = 20;
            } else if (totalBelanja >= 300000) {
                diskon = 15;
            } else if (totalBelanja >=100000) {
                diskon = 10;
            }
        } else if (statusPembeli.equals("non member")) {
            diskon = 0;
        } else {
            System.out.println("Salah input membership");
            input.close();
            return;
        }

        double potongan = (diskon / 100) * totalBelanja;
        double totalHargaBersih = totalBelanja - potongan;

        System.out.println("- " + namaPembeli + ", " + totalBelanja + ", " + diskon + "%, " + potongan + ", " + totalHargaBersih);

    }
}