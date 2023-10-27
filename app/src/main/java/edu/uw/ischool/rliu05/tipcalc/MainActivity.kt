package edu.uw.ischool.rliu05.tipcalc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.util.Log
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val TAG: String = "bigTipper"
    lateinit var btnTip: Button
    lateinit var textInputAmount: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnTip = findViewById(R.id.btnTip)
        textInputAmount = findViewById(R.id.textInputAmount)
        btnTip.isEnabled = false

        textInputAmount.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) {
                // TODO Auto-generated method stub
                if (s.toString() == "") {
                    btnTip.setEnabled(false)
                } else {
                    btnTip.setEnabled(true)
                }
            }

            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int,
                after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable?) {
                // TODO Auto-generated method stub
            }

        })
        btnTip.setOnClickListener {
            val subTtl = textInputAmount.text.toString().toInt()
            val ttlCents = (subTtl * 115)
            val ttlDollars = ttlCents / 100
            val cents = ttlCents % 100
            Log.i(TAG, "Total is $ttlDollars.$cents")
            Toast.makeText(applicationContext, "You total is $$ttlDollars.$cents after a 15% tip", Toast.LENGTH_LONG).show()
        }
    }
}