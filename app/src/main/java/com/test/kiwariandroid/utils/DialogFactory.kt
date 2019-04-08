package com.test.kiwariandroid.utils

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AlertDialog
import com.test.kiwariandroid.R

class DialogFactory {

    fun createProgressDialog(context: Context, message: String): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage(message)
        progressDialog.setCancelable(false)
        return progressDialog
    }

    fun errorDialog(context: Context, message: String): Dialog {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle(context.getString(R.string.sorry))
            .setMessage(message)
            .setNeutralButton("Ok", null)
        return alertDialog.create()
    }

}