package com.haldomae.photo_album

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
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

    // Colormatrixクラスを使って画像をセピア色に加工するフィルター
    private val matrix = ColorMatrix(
        floatArrayOf(
            0.39f, 0.769f, 0.189f, 0f, 0f,
            0.349f, 0.686f, 0.168f, 0f, 0f,
            0.272f, 0.534f, 0.131f, 0f, 0f,
            0f, 0f, 0f, 1f, 0f
        )
    )
    private val filter = ColorMatrixColorFilter(matrix)
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
        binding.imageView.colorFilter = filter
    }
}