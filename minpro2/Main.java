package com.unmul.main;

import com.unmul.surat.CRUD;
import com.unmul.surat.Surat;
import com.unmul.surat.SuratMasuk;
import com.unmul.surat.SuratKeluar;
import java.util.ArrayList;
import java.util.Scanner;

public final class Main implements CRUD {
    private static final ArrayList<Surat> daftarSurat = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main mainProgram = new Main();
        int pilihan;
        do {
            System.out.println("=== ESuratUnmul ===");
            System.out.println("1. Tambah Surat");
            System.out.println("2. Tampilkan Semua Surat");
            System.out.println("3. Hapus Surat");
            System.out.println("4. Jumlah Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1 -> mainProgram.tambahSurat();
                case 2 -> mainProgram.tampilkanSemuaSurat();
                case 3 -> mainProgram.hapusSurat();
                case 4 -> System.out.println("Jumlah Surat: " + Surat.getJumlahSurat());
                case 5 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

   // @Override
    public void tambahSurat() {
        System.out.print("Nomor Surat: ");
        String nomor = scanner.nextLine();
        System.out.print("Pengirim: ");
        String pengirim = scanner.nextLine();
        System.out.print("Perihal: ");
        String perihal = scanner.nextLine();
        System.out.print("Tipe Surat (1. Masuk, 2. Keluar): ");
        int tipe = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        Surat suratBaru;
        if (tipe == 1) {
            suratBaru = new SuratMasuk(nomor, pengirim, perihal);
        } else {
            suratBaru = new SuratKeluar(nomor, pengirim, perihal);
        }

        daftarSurat.add(suratBaru);
        System.out.println("Surat berhasil ditambahkan.");
    }

    //@Override
    public void tampilkanSemuaSurat() {
        if (daftarSurat.isEmpty()) {
            System.out.println("Belum ada surat.");
        } else {
            System.out.println("Daftar Surat:");
            for (Surat surat : daftarSurat) {
                surat.tampilkanInfoSurat();
                surat.tipeSurat();
                System.out.println("-------------------");
            }
        }
    }

//@Override
    public void hapusSurat() {
        System.out.print("Masukkan nomor surat yang akan dihapus: ");
        String nomor = scanner.nextLine();
        boolean ditemukan = false;

        for (Surat surat : daftarSurat) {
            if (surat.getNomorSurat().equals(nomor)) {
                daftarSurat.remove(surat);
                Surat.kurangiJumlahSurat(); // Kurangi jumlah surat
                System.out.println("Surat dengan nomor " + nomor + " berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Surat dengan nomor tersebut tidak ditemukan.");
        }
    }
}