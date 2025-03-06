package com.example.a2_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.example.a2_4.databinding.ContainBinding
import kotlinx.coroutines.NonDisposableHandle.parent

data class Item(
    val name : String
)

class NewAdapter(
    private val container : LinearLayout,
    private val context : Context,
    val array : List<String>
) {
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    fun update(count : Int){
        container.removeAllViews()
        val validCount = count.coerceAtLeast(0)
        for (i in 0..validCount){
            val item = createItem(i)
            container.addView(item)
        }
    }

    private fun createItem(pos:Int): View {
        val binding = ContainBinding.inflate(inflater, container, false)
        binding.viewText.text = array[pos]
        return binding.root
    }

}
