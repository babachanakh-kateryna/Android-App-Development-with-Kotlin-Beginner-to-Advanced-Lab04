package com.example.userinteractions

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var showToast: Button
    lateinit var showSnackbar: Button
    lateinit var showDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showToast = findViewById(R.id.btn)
        showSnackbar = findViewById(R.id.btn2)
        showDialog = findViewById(R.id.btn3)

        showToast.setOnClickListener() {
            Toast.makeText(applicationContext, "This is a toast message", Toast.LENGTH_LONG).show()
        }

        showSnackbar.setOnClickListener() {
            Snackbar.make(findViewById(R.id.main), "This is a snackbar message", Snackbar.LENGTH_SHORT).setAction("Close", View.OnClickListener {

            })
                .show()
        }

        showDialog.setOnClickListener() {
            showAlertDialog()
        }
    }

    fun showAlertDialog() {
        var alertDialog = AlertDialog.Builder(this@MainActivity)

        alertDialog.setTitle("Alert Dialog").setMessage("Do you want to change the text of the button?")
            .setIcon(R.drawable.warning).setCancelable(false)
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, which ->
                dialogInterface.cancel() })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, which ->
                showToast.text = "Button text changed"
            })
        alertDialog.create().show()
    }
}