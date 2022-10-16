package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SampleList : AppCompatActivity() {
    lateinit var btnSList : Button
    lateinit var btnSampleRecycler : Button
    lateinit var btnCardView: Button
    lateinit var btnGetAPI : Button
    lateinit var btnMahasiswa : Button
    lateinit var rvPost : RecyclerView
    lateinit var tvResponseCode: Text
    lateinit var text: Text

    private val list = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)

        showPosts()
        createPost()

        btnSList = findViewById(R.id.btnShowList)
        btnSampleRecycler = findViewById(R.id.btnSampleRV)
        btnCardView = findViewById(R.id.btnCardView)
        btnGetAPI = findViewById(R.id.btnGetAPI)
        btnMahasiswa = findViewById(R.id.btnMahasiswa)

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getUsers().enqueue(object: Callback<ArrayList<PostResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val responseCode = response.code().toString()
                tvResponseCode.textContent = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

            }

        })

        btnSList.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList,SampleListView::class.java)
            startActivity(intent)})

        btnCardView.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList,SampleCardView::class.java)
            startActivity(intent)})

        btnGetAPI.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList,GetAPIActivity::class.java)
            startActivity(intent)})

        btnMahasiswa.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList,Mahasiswa::class.java)
            startActivity(intent)})

        btnSampleRecycler.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList,SampleRecyclerView::class.java)
            startActivity(intent)})
        }

    private fun <T> Call<T>.enqueue(callback: Callback<ArrayList<PostResponse>>) {

    }

    private fun createPost() {
        RetrofitClient.instance
    }

    private fun showPosts() {
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance
    }
}