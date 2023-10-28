package com.example.recyclerview_cardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TunisiaGovernorats : AppCompatActivity(), MyAdapter.OnItemClickListener {
    var values= arrayListOf<String>("Tunis", "Ariana" , "Ben Arous", "Manouba", "Nabeul","Zaghouan", "Bizerte" , "Béja", "Jendouba", "Kef","Siliana", "Kairouan" , "Kasserine", "Sidi Bouzid", "Sfax","Sidi Bouzid", "Gabès" , "Medenine", "Tataouine", "Gafsa","Tozeur", "Kebili" , "Mahdia", "Monastir")
    var images= arrayListOf<Int>(R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground ,
        R.drawable.ic_launcher_background ,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background)

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    private lateinit var deleteButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tunisia_governorats)
        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values, images,this)
        recyclerView = findViewById<RecyclerView>(R.id.tunisiaGovernoratsRecycler).apply {
            layoutManager = manager
            adapter = myAdapter
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "${values[position]} clicked ✅", Toast.LENGTH_SHORT).show()
        var governoratDetail = Intent(this, DetailActivity::class.java)
        governoratDetail.putExtra("governorat", values[position])
        startActivity(governoratDetail)
        myAdapter.notifyItemChanged(position)
    }

    override fun deleteItem(position: Int) {
        if (position < values.size) {
            val deletedItem = values.removeAt(position)
            Toast.makeText(this, "$deletedItem Deleted ✅", Toast.LENGTH_SHORT).show()
            myAdapter.notifyItemRemoved(position)
        }
    }

}