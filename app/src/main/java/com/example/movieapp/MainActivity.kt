package com.example.movieapp
import MyMovieAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.databinding.ActivityAddBinding
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.models.MyMovie
import com.example.movieapp.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myMovieAdapter: MyMovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        MySharedPreference.MySharedPreference.init(this)
        val list = MySharedPreference.MySharedPreference.list
        myMovieAdapter = MyMovieAdapter(object : MyMovieAdapter.RvAction{
            override fun myItemtemClick(myMovie: MyMovie, position: Int) {
                val intent = Intent(this@MainActivity, InfoActivity::class.java)
                intent.putExtra("keyMovie", myMovie)
                startActivity(intent)
            }

            override fun edit( position: Int) {
                val intent = Intent(this@MainActivity, ActivityAddBinding::class.java)
                intent.putExtra("position", position)
                startActivity(intent)

            }


        },list)
        binding.rv.adapter = myMovieAdapter
    }

}