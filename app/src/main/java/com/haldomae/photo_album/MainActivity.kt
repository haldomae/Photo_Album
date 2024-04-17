package com.haldomae.photo_album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haldomae.photo_album.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var position = 0

    private val imageList = listOf(R.drawable.dog, R.drawable.horse, R.drawable.kitten)
    private val quoteList = listOf(
        "準備をしておこう。チャンスはいつか訪れるものだ。\nエイブラハム・リンカーン",
        "楽しいから笑うのではない。笑うから楽しいのだ。\nウィリアム・ジェームズ",
        "幸せとは、健康で記憶力が悪いということだ。\nアルベルト・シュバイツァー",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        /*
        val textView: TextView = findViewById(R.id.textView)
        textView.text = "Hello"
        と書く必要がなくなり、
        binding.textView.text = "Hello"
        と書くことができる
        */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movePosition(0)

        binding.btnToLeft.setOnClickListener {
            movePosition(-1)
        }
        binding.bthToRight.setOnClickListener {
            movePosition(1)
        }
    }

    // 文言と画像を切り替えるメソッド
    private fun movePosition(num: Int){
        position += num

        // positionが画像の数を超えていたら、postionを0に戻す
        if (position >= imageList.size) {
            position = 0
        } else if (position < 0) {
            position = imageList.size -1
        }

        // 画像と文言を更新
        binding.textView.text = quoteList[position]
        binding.imageView.setImageResource(imageList[position])
    }
}