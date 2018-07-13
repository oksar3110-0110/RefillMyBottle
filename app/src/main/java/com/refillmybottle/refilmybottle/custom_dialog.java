package com.refillmybottle.refilmybottle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by abah on 12/07/18.
 */

public class custom_dialog extends Dialog{
   public custom_dialog(Context context){
       super(context);
       getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
       getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       requestWindowFeature(Window.FEATURE_NO_TITLE);
       setCancelable(false);
       setContentView(R.layout.layout_dialog);
   }
}
