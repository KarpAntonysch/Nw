package com.example.nw.dialogs

import androidx.fragment.app.FragmentManager
import com.example.cft.dialogs.DialogFragment

interface DialogInterface {
    fun showDialog(title: Int, description:Int, posText:Int,fragmentManager: FragmentManager){
        val dialog = DialogFragment(title,description,posText)
        dialog.show(fragmentManager, DialogFragment.TAG)
    }
}