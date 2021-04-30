package com.treatachallenge.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.treatachallenge.R

class CommonUtils {
    companion object{
        fun loadingDialog(context: Context?): ProgressDialog{
            val progressDialog = ProgressDialog(context)
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)
            return progressDialog
        }

    }
}