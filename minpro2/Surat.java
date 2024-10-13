package com.unmul.surat;

// Kelas abstrak untuk surat
public abstract class Surat {
    private final String nomorSurat;
    private String pengirim;
    private String perihal;

    // Static variable untuk menghitung jumlah surat
    private static int jumlahSurat = 0;

    // Constructor
    public Surat(String nomorSurat, String pengirim, String perihal) {
        this.nomorSurat = nomorSurat;
        this.pengirim = pengirim;
        this.perihal = perihal;
        jumlahSurat++;
    }

    // Getter dan Setter
    public String getNomorSurat() {
        return nomorSurat;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getPerihal() {
        return perihal;
    }

    public void setPerihal(String perihal) {
        this.perihal = perihal;
    }

    // Method untuk menampilkan info surat
    public void tampilkanInfoSurat() {
        System.out.println("Nomor Surat: " + nomorSurat);
        System.out.println("Pengirim: " + pengirim);
        System.out.println("Perihal: " + perihal);
    }
    
        // Metode untuk mengurangi jumlah surat
    public static void kurangiJumlahSurat() {
        if (jumlahSurat > 0) {
            jumlahSurat--;
        }
    }

    // Method static untuk menghitung jumlah surat
    public static int getJumlahSurat() {
        return jumlahSurat;
    }

    // Method abstrak untuk tipe surat
    public abstract void tipeSurat();
}
