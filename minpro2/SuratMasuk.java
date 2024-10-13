package com.unmul.surat;

// Kelas SuratMasuk yang mewarisi dari kelas Surat
public class SuratMasuk extends Surat {
    public SuratMasuk(String nomorSurat, String pengirim, String perihal) {
        super(nomorSurat, pengirim, perihal);
    }

    @Override
    public void tipeSurat() {
        System.out.println("Tipe Surat: Surat Masuk");
    }
}
