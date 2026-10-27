package com.vanlang.kiemtra_laptrinhungdungdidong_2474802010331

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() && password.isEmpty() ->
                    tvStatus.text = "Vui lòng nhập Email và Mật khẩu!"

                email.isEmpty() ->
                    tvStatus.text = "Email không được để trống!"

                password.isEmpty() ->
                    tvStatus.text = "Mật khẩu không được để trống!"

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                    tvStatus.text = "Email sai định dạng!"

                password.length < 6 ->
                    tvStatus.text = "Mật khẩu phải có ít nhất 6 ký tự!"

                else ->
                    tvStatus.text = "Xác thực thành công!"
            }
        }
    }
}