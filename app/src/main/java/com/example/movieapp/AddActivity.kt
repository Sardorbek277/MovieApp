package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.databinding.ActivityAddBinding
import com.example.movieapp.models.MyMovie
import com.example.movieapp.utils.MySharedPreference

class AddActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
    private lateinit var list:ArrayList<MyMovie>
    var position = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        list = ArrayList()
        position = intent.getIntExtra("position", -1)

        MySharedPreference.MySharedPreference.init(this)
        val list = MySharedPreference.MySharedPreference.list

        if (position!=-1){
            edt()
        }else{
            save()
        }

        binding.apply {
            btnSave.setOnClickListener {
                val myMovie = MyMovie(
                    edtName.text.toString(),
                    edtAuthors.text.toString(),
                    edtAboutMovie.text.toString()
                )

                list.add(myMovie)
                MySharedPreference.MySharedPreference.list = list
                Toast.makeText(this@AddActivity, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
    fun save(){
        binding.apply {
            btnSave.setOnClickListener {
                val myMovie = MyMovie(
                    edtName.text.toString(),
                    edtAuthors.text.toString(),
                    edtAboutMovie.text.toString()
                )

                list.add(myMovie)
                MySharedPreference.MySharedPreference.list = list
                Toast.makeText(this@AddActivity, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
    fun edt(){
        val list1 = MySharedPreference.MySharedPreference.list
        binding.edtName.setText(list1[position].name)
        binding.edtAuthors.setText(list1[position].authors)
        binding.edtAboutMovie.setText(list1[position].aboutMovie)
        binding.btnSave.setOnClickListener {
            val myMovie = MyMovie(
                binding.edtName.text.toString(),
                binding.edtAuthors.text.toString(),
                binding.edtAboutMovie.text.toString()
            )

            list.add(myMovie)
            MySharedPreference.MySharedPreference.list = list
            Toast.makeText(this@AddActivity, "Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}