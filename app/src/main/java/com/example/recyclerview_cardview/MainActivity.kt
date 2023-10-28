package com.example.recyclerview_cardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    var values= arrayListOf<String>("Item 1", "Item 2" , "Item 3", "Item 4", "Item 5")
    var images= arrayListOf<Int>(R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground ,
        androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha ,
        androidx.constraintlayout.widget.R.drawable.abc_btn_check_to_on_mtrl_015)
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    lateinit var myButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values, images,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            layoutManager = manager
            adapter = myAdapter
        }
        myButton = this.findViewById(R.id.button1)
        myButton.setOnClickListener {
            var n:Int = values.size + 1
            values.add("Item $n")
            myAdapter.notifyItemInserted(values.size)
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item ${position + 1} clicked ✅", Toast.LENGTH_SHORT).show()
        values[position]="Clicked✅"
        myAdapter.notifyItemChanged(position)
    }

    override fun deleteItem(position: Int) {
        TODO("Not yet implemented")
    }

    fun GoToTunisiaGovernorats(view: View) {
        var tunisiaGovernoratsIntent = Intent(this, TunisiaGovernorats::class.java)
        startActivity(tunisiaGovernoratsIntent)
    }
}