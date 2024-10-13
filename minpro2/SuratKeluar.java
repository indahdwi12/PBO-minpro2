package com.unmul.surat;

// Kelas SuratKeluar yang mewarisi dari kelas Surat
public class SuratKeluar extends Surat {
    public SuratKeluar(String nomorSurat, String pengirim, String perihal) {
        super(nomorSurat, pengirim, perihal);
    }

    @Override
    public void tipeSurat() {
        System.out.println("Tipe Surat: Surat Keluar");
    }
}
