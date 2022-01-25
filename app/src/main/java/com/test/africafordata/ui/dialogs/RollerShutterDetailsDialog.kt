package com.test.africafordata.ui.dialogs


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.test.africafordata.R
import com.test.africafordata.ui.fragments.home.HomeFragment
import com.test.africafordata.utils.ListenUpdates
import kotlinx.android.synthetic.main.roller_shutter_dialog_layout.*

class RollerShutterDetailsDialog : DialogFragment() {


    private var listener: ListenUpdates? = null

    companion object {
        private const val ROLLER_SHUTTER_ID = "ROLLER_SHUTTER_ID"
        private const val ROLLER_SHUTTER_NAME = "ROLLER_SHUTTER_NAME"
        private const val ROLLER_SHUTTER_POSITION = "ROLLER_SHUTTER_POSITION"

        fun newInstance(
            id: Int,
            name: String,
            position: Int
        ): RollerShutterDetailsDialog {
            val mFragment =
                RollerShutterDetailsDialog()
            val args = Bundle()
            args.putInt(ROLLER_SHUTTER_ID, id)
            args.putString(ROLLER_SHUTTER_NAME, name)
            args.putInt(ROLLER_SHUTTER_POSITION, position)
            mFragment.arguments = args
            return mFragment

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.roller_shutter_dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments!!.getInt(ROLLER_SHUTTER_ID)
        val name = arguments!!.getString(ROLLER_SHUTTER_NAME)!!

        val intensity = arguments!!.getInt(ROLLER_SHUTTER_POSITION)
        device_name_input_roller_shutter.setText(name)

        //Le référenciel est fermé (Du haut vers le bas !)
        device_seek_bar_roller_shutter.setProgress(intensity.toFloat().toInt())

        action_ok_roller_shutter.setOnClickListener {

            if (dataChanged(
                    name,
                    device_name_input_roller_shutter.text.toString(),
                    intensity,
                    100 - device_seek_bar_roller_shutter.progress
                )
            ) {
                listener?.rollerShutterUpdated(
                    id,
                    device_name_input_roller_shutter.text.toString(),
                    100 - device_seek_bar_roller_shutter.progress
                )
            }
            dialog?.dismiss()
        }
        action_cancel_roller_shutter.setOnClickListener { dialog?.dismiss() }
    }
    private fun dataChanged(
        name: String,
        newName: String,
        position: Int,
        newPosition: Int
    ): Boolean {
        return (name != newName) or (position != newPosition)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? HomeFragment
    }
}