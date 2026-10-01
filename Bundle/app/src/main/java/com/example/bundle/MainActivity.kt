package com.example.bundle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yourapp.databinding.ActivityMainBinding // Đổi tên package của bạn

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Xử lý khi bấm nút Gửi
        binding.btnSend.setOnClickListener {
            val message = binding.etMessage.text.toString()

            // 1. Tạo Intent trỏ tới SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // 2. Tạo Bundle và put dữ liệu vào (Key - Value)
            val bundle = Bundle()
            bundle.putString("KEY_MESSAGE", message)

            // 3. Đính kèm Bundle vào Intent thông qua extras
            intent.putExtras(bundle)

            // 4. Bắt đầu chuyển màn hình
            startActivity(intent)
        }
    }
}