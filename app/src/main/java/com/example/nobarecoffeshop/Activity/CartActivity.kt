package com.example.nobarecoffeshop.Activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nobarecoffeshop.Adapter.CartAdapter
import com.example.nobarecoffeshop.Helper.ChangeNumberItemsListener
import com.example.nobarecoffeshop.Helper.ManagmentCart
import com.example.nobarecoffeshop.R
import com.example.nobarecoffeshop.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    lateinit var managmentCart: ManagmentCart
    private var tax: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart= ManagmentCart(this)

        calculateCart()
        setVariabel()
        initCartList()
    }

    private fun initCartList() {
        binding.apply {
            listView.layoutManager=
                LinearLayoutManager(this@CartActivity, LinearLayoutManager.VERTICAL, false)
            listView.adapter= CartAdapter(
                managmentCart.getListCart(),
                this@CartActivity,
                object : ChangeNumberItemsListener{
                    override fun onChanged() {
                        calculateCart()
                    }
                }
            )
        }
    }

    private fun setVariabel() {
        binding.backBtn.setOnClickListener { finish() }
    }

    private fun calculateCart() {
        val percentTax=0.02
        val delivery=15
        tax = ((managmentCart.getTotalFee()*percentTax)*100)/100.0
        val total=((managmentCart.getTotalFee()+tax+delivery)*100)/100
        val  itemtotal= (managmentCart.getTotalFee()*100)/100
        binding.apply {
            totalFeeTxt.text="Rp$itemtotal"
            totalTaxTxt.text="Rp$tax"
            deliveryTxt.text="Rp$delivery"
            totalTxt.text="Rp$total"

        }
    }
}