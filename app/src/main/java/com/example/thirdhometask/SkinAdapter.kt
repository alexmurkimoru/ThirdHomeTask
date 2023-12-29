package com.example.thirdhometask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdhometask.databinding.FrogItemBinding
import com.example.thirdhometask.databinding.SkinItemBinding

class SkinAdapter : RecyclerView.Adapter<SkinAdapter.SkinHolder>() {
    public val skinList = ArrayList<Skin>()
    class SkinHolder(item: View) : RecyclerView.ViewHolder(item){
        val binding = SkinItemBinding.bind(item)
        companion object{
            var lastCall: CompoundButton? = null
        }
        fun bind(skin: Skin, list: List<Skin>){
            binding.radioButton.text = skin.name
            binding.skinPic.setImageResource(skin.imageId)
            binding.radioButton.setOnCheckedChangeListener { buttonView, isChecked ->
                for(i in list){
                    if(i.isChecked == true){
                        i.isChecked == false
                        lastCall?.isChecked = false
                    }
                }
                skin.isChecked = true
                lastCall = buttonView
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkinHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skin_item, parent, false)
        return SkinHolder(view)
    }

    override fun getItemCount(): Int {
        return skinList.size
    }

    override fun onBindViewHolder(holder: SkinHolder, position: Int) {
        holder.bind(skinList[position], skinList)
    }

    fun setListContent(images: List<Skin>){
        for (i in images){
          skinList.add(i)
            notifyItemInserted(skinList.size - 1)
        }
    }
}