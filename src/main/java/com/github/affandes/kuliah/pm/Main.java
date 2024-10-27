package com.github.affandes.kuliah.pm;

package browserhistory;

import java.util.Scanner;
import java.util.Stack;

public class browser {
    private Stack<String> history;

    public browser() {
        history = new Stack<>();
    }

    // Menambahkan website baru ke dalam history
    public void browse(String website) {
        history.push(website);
        System.out.println("Website \"" + website + "\" telah ditambahkan ke history.");
    }

    // Kembali ke website sebelumnya dan menghapus history terakhir
    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
            return;
        }
        String lastWebsite = history.pop(); // Menghapus website terakhir
        System.out.println("Kembali dari website \"" + lastWebsite + "\".");
    }

    // Menampilkan semua history browser dari yang paling baru
    public void view() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk ditampilkan.");
            return;
        }
        System.out.println("History Browser (dari yang terbaru):");
        Stack<String> tempStack = new Stack<>(); // Temporary stack untuk membalik urutan
        while (!history.isEmpty()) {
            String website = history.pop();
            System.out.println(website);
            tempStack.push(website); // Menyimpan ke temporary stack
        }
        // Mengembalikan elemen ke stack asli
        while (!tempStack.isEmpty()) {
            history.push(tempStack.pop());
        }
    }

    // Fungsi utama untuk menjalankan program
    public static void main(String[] args) {
        browser browser = new browser();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nPilihan:");
            System.out.println("1. Browse website");
            System.out.println("2. Kembali ke website sebelumnya");
            System.out.println("3. Tampilkan history");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan (1/2/3/4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan URL website: ");
                    String website = scanner.nextLine();
                    browser.browse(website);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.view();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}

