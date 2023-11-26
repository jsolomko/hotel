package com.example.hotelapplication.app.ui.room

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapplication.app.model.room.Room
import com.example.hotelapplication.app.ui.hotel.SliderAdapter
import com.example.hotelapplication.databinding.ItemRoomBinding


typealias RoomListener = () -> Unit

class RoomAdapter(
    private val rooms: List<Room>,
    val context: Context,
    val roomListener: RoomListener
) : RecyclerView.Adapter<RoomAdapter.RoomVH>() {
    class RoomVH(val binding: ItemRoomBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRoomBinding.inflate(inflater)
        return RoomVH(binding)
    }

    override fun onBindViewHolder(holder: RoomVH, position: Int) {
        val room = rooms[position]
        with(holder.binding) {
            tvHotelName.text = room.name
            tvPeculiarities1.text = room.peculiarities?.get(0)
            tvPeculiarities2.text = room.peculiarities?.get(1)
            tvPrice.text = room.price.toString()
            tvPricePerNight.text = room.price_per

            viewpagerRoom.adapter = SliderAdapter(room.image_urls!!, context)

            btnToRooms.setOnClickListener {
                roomListener.invoke()
            }

        }
    }

    override fun getItemCount(): Int = rooms.size
}