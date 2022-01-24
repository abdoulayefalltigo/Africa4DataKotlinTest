package com.test.africafordata.screens.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.test.africafordata.R
import com.test.africafordata.screens.fragments.home.HomeFragment
import com.test.africafordata.utils.ListenUpdates
import kotlinx.android.synthetic.main.light_dialog_layout.*

class LightDetailsDialog : DialogFragment() {


    private var listener: ListenUpdates? = null

    companion object {
        private const val LIGHT_ID = "LIGHT_ID"
        private const val LIGHT_NAME = "LIGHT_NAME"
        private const val LIGHT_MODE = "LIGHT_MODE"
        private const val LIGHT_INTENSITY = "LIGHT_INTENSITY"

        fun newInstance(
            id: Int,
            name: String,
            mode: String,
            intensity: Int
        ): LightDetailsDialog {
            val mFragment =
                LightDetailsDialog()
            val args = Bundle()
            args.putInt(LIGHT_ID, id)
            args.putString(LIGHT_NAME, name)
            args.putString(LIGHT_MODE, mode)
            args.putInt(LIGHT_INTENSITY, intensity)
            mFragment.arguments = args
            return mFragment

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.light_dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments!!.getInt(LIGHT_ID)
        val name = arguments!!.getString(LIGHT_NAME)!!
        val checked = arguments!!.getString(LIGHT_MODE) == "ON"
        val intensity = arguments!!.getInt(LIGHT_INTENSITY)
        device_name_input_light.setText(name)
        device_mode_switch_light.isChecked = checked



        device_seek_bar_light.setProgress(intensity.toFloat())

        action_ok_light.setOnClickListener {
            var mode = "OFF"
            if (device_mode_switch_light.isChecked) {
                mode = "ON"
            }

            if (dataChanged(
                    name,
                    device_name_input_light.text.toString(),
                    checked,
                    device_mode_switch_light.isChecked,
                    intensity,
                    device_seek_bar_light.progress
                )
            ) {
                listener?.lightUpdated(
                    id,
                    device_name_input_light.text.toString(),
                    mode,
                    device_seek_bar_light.progress
                )
            }
            dialog?.dismiss()
        }
        action_cancel_light.setOnClickListener { dialog?.dismiss() }
    }

    private fun dataChanged(
        name: String,
        newName: String,
        checked: Boolean,
        newChecked: Boolean,
        intensity: Int,
        newIntensity: Int
    ): Boolean {
        return (name != newName) or (checked != newChecked) or (intensity != newIntensity)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? HomeFragment
    }
}