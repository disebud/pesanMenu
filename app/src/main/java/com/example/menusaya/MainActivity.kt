package com.example.menusaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun hitungItem(view: View) {

        var  totalhargaMakanan : Int = 0
        var  totalhargaMinuman : Int = 0
        var  totalSemua : Int = 0

                // Melihat Status Kondisi Pada Pilihan Menu Nasi Goreng
                if(checkBox_nasi_goreng.isChecked && et_nasi_goreng.text.toString() != ""){
                        totalhargaMakanan += 15000 * et_nasi_goreng.text.toString().toInt()
                }

                // Melihat Status Kondisi Pada Pilihan Menu Mie Goreng
                if(checkBox_mie_goreng.isChecked && et_mie_goreng.text.toString() != ""){
                        totalhargaMakanan += 12000 * et_mie_goreng.text.toString().toInt()
                }

                // Melihat Status Kondisi Pada Pilihan Menu Ayam Bakar
                if(checkBox_ayam_bakar_nasi.isChecked && et_ayam_bakar_nasi.text.toString() != "") {
                        totalhargaMakanan += 16000 * et_ayam_bakar_nasi.text.toString().toInt()
                }

                // Melihat Status Kondisi Pada Pilihan Menu Ayam Bakar
                if(checkBox_ayam_goreng_nasi.isChecked && et_ayam_goreng_nasi.text.toString() != ""){
                        totalhargaMakanan += 15000 * et_ayam_goreng_nasi.text.toString().toInt()
                }

                // Melihat Status Kondisi Pada Pilihan Menu Teh
                if(checkBox_teh.isChecked && et_teh.text.toString() != ""){
                        totalhargaMinuman += 5000 * et_teh.text.toString().toInt()
                }

                // Melihat Status Kondisi Pada Pilihan Menu air mineral 250ml
                if(checkBox_air_mineral_250.isChecked && et_air_mineral_250.text.toString() != ""){
                        totalhargaMinuman += 1000 * et_air_mineral_250.text.toString().toInt()
                }

                // Melihat Status Kondisi Pada Pilihan Menu air mineral 600ml
                if(checkBox_air_mineral_600.isChecked && et_air_mineral_600.text.toString() != ""){
                        totalhargaMinuman += 3000 * et_air_mineral_600.text.toString().toInt()
                }

                // Melihat Status Kondisi Pada Pilihan Menu air jeruk
                if(checkBox_air_jeruk.isChecked && et_air_jeruk.text.toString() != ""){
                        totalhargaMinuman += 6000 * et_air_jeruk.text.toString().toInt()
                }

                totalSemua = totalhargaMakanan + totalhargaMinuman



                // Kondisi Jika Tidak Ada Salah Satupun Menu Makanan Yang Dipilih
                if(!checkBox_nasi_goreng.isChecked && !checkBox_mie_goreng.isChecked && !checkBox_ayam_goreng_nasi.isChecked && !checkBox_ayam_bakar_nasi.isChecked
                    && !checkBox_teh.isChecked && !checkBox_air_mineral_250.isChecked && !checkBox_air_mineral_600.isChecked && !checkBox_air_jeruk.isChecked){
                    Toast.makeText(applicationContext, "Tidak Ada Menu yang Dipesan", Toast.LENGTH_SHORT).show();
                }else{
                    // Menampilkan Hasil Pesanan Yang Di Input Dari User
//                    Toast.makeText(applicationContext, "Pesanan Terkirim", Toast.LENGTH_SHORT).show();
                    hargaMakanan.text = totalhargaMakanan.toString()
                    hargaMinuman.text = totalhargaMinuman.toString()
                    hargaTotalBiaya.text = totalSemua.toString()
//                    totalhargaMinuman = 0
//                    totalhargaMakanan = 0
//                    totalSemua = 0

                }
            }

    fun bayarPesanan(view: View) {

        var bayar = et_uangBayar.text.toString().toInt()
        var uangKembalian = bayar - hargaTotalBiaya.text.toString().toInt()


        if(uangKembalian == 0 ){
            Toast.makeText(applicationContext, "PEMBAYARAN SUKSES \n Uang Yang anda bayarkan sesuai", Toast.LENGTH_LONG).show()
        }else if (uangKembalian > 0){
            Toast.makeText(applicationContext, "PEMBAYARAN SUKSES \n Uang Kembalian Anda : $uangKembalian", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "PEMBAYARAN GAGAL \n Uang Anda Kurang : $uangKembalian", Toast.LENGTH_SHORT).show();
        }
    }


}