package com.test.africafordata.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.africafordata.R
import com.test.africafordata.model.device.Devices
import com.test.africafordata.model.device.Heater
import com.test.africafordata.model.device.Light
import com.test.africafordata.model.device.RollerShutter
import kotlinx.android.synthetic.main.heater_item.view.*
import kotlinx.android.synthetic.main.light_item.view.*
import kotlinx.android.synthetic.main.roller_shutter_item.view.*
import javax.inject.Inject

class DevicesAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var devices = listOf<Devices>()
        set(devices) {
            field = devices
            notifyDataSetChanged()
        }
    var listener: OnItemClickListener? = null

    inner class LightHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewName = itemView.light_device_name
        private val textViewMode = itemView.light_device_mode
        private val textViewIntensity = itemView.light_device_intensity
        private val lightModeIcon = itemView.light_mode_icon

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (RecyclerView.NO_POSITION != position) {
                    listener?.onItemClick(devices[position])
                }
            }
        }

        fun bind(position: Int) {
            val light = devices[position] as Light
            textViewName.text = light.deviceName
            textViewName.isSelected = true
            val text = "${textViewMode.resources.getString(R.string.device_mode)} ${light.mode}"
            textViewMode.text = text
            textViewIntensity.text = light.intensity.toString()
            if (light.mode == "ON") {
                lightModeIcon.setImageResource(R.drawable.device_light_on_icon)
            } else {
                lightModeIcon.setImageResource(R.drawable.device_light_off_icon)
            }
        }


    }

    inner class HeaterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewName = itemView.heater_device_name
        private val textViewMode = itemView.heater_device_mode
        private val textViewTemperature = itemView.heater_device_temperature
        private val modeIcon = itemView.id_image_heater
        val text = itemView.resources.getString(R.string.device_mode)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (RecyclerView.NO_POSITION != position) {
                    listener?.onItemClick(devices[position])
                }
            }
        }

        fun bind(position: Int) {
            val heater = devices[position] as Heater
            textViewName.text = heater.deviceName
            textViewName.isSelected = true
            val text = "${textViewMode.resources.getString(R.string.device_mode)} ${heater.mode}"
            textViewMode.text = text
            //textViewMode.text = "Device mode : ${heater.mode}"
            textViewTemperature.text = heater.temperature.toString()
            if (heater.mode == "ON")
                modeIcon.setImageResource(R.drawable.device_heater_on)
            else
                modeIcon.setImageResource(R.drawable.device_heater_off)
        }

    }

    inner class RollerShutterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewName = itemView.roller_shutter_name
        private val textViewPosition = itemView.roller_shutter_position

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (RecyclerView.NO_POSITION != position) {
                    listener?.onItemClick(devices[position])
                }
            }
        }

        fun bind(position: Int) {
            val rollerShutter = devices[position] as RollerShutter
            textViewName.text = rollerShutter.deviceName
            textViewName.isSelected = true
            textViewPosition.text = rollerShutter.position.toString()
        }

    }


    override fun getItemViewType(position: Int) = devices[position].getType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            Devices.TYPE_LIGHT -> {
                val itemView =
                    LayoutInflater.from(parent.context).inflate(R.layout.light_item, parent, false)
                return LightHolder(itemView)
            }
            Devices.TYPE_Heater -> {
                val itemView =
                    LayoutInflater.from(parent.context).inflate(R.layout.heater_item, parent, false)
                return HeaterHolder(itemView)
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.roller_shutter_item, parent, false)
                return RollerShutterHolder(itemView)
            }

        }
    }

    override fun getItemCount() = devices.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            Devices.TYPE_LIGHT -> {
                (holder as (LightHolder)).bind(position)
            }
            Devices.TYPE_Heater -> {
                (holder as (HeaterHolder)).bind(position)
            }
            Devices.TYPE_ROLLER_SHUTTER -> {
                (holder as (RollerShutterHolder)).bind(position)
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(devices: Devices)
    }


}