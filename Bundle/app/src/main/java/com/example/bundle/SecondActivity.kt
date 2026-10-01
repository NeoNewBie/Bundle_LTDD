import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yourapp.databinding.ActivitySecondBinding // Đổi tên package của bạn

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Lấy Bundle (extras) từ Intent được gửi tới
        val bundle: Bundle? = intent.extras

        // 2. Kiểm tra Bundle có null không và lấy dữ liệu
        if (bundle != null) {
            val receivedMessage = bundle.getString("KEY_MESSAGE", "Không có dữ liệu")

            // 3. Hiển thị lên TextView
            binding.tvDisplay.text = receivedMessage
        }

        // 4. Xử lý nút Back để quay lại màn hình 1
        binding.btnBack.setOnClickListener {
            // Hàm finish() sẽ hủy SecondActivity hiện tại
            // và hệ thống tự động pop nó khỏi stack, hiển thị lại MainActivity
            finish()
        }
    }
}