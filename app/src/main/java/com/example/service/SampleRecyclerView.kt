package com.example.service

import adapter.PetaniAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Petani

class SampleRecyclerView : AppCompatActivity() {
    lateinit var rvSample : RecyclerView
    lateinit var varpetaniadapter : PetaniAdapter
    lateinit var lPetani : List<Petani.Petani>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_recycler_view)

        rvSample = findViewById(R.id.rvpetani)

        lPetani = listOf(
            Petani.Petani(user = "U01", nama = "Udin", jumlahLahan = "100", identifikasi = "50", tambahLahan = "50")
        )

        varpetaniadapter = PetaniAdapter(lPetani)

        rvSample.apply {
            layoutManager = LinearLayoutManager(this@SampleRecyclerView)
            adapter = varpetaniadapter
        }
    }
}