package com.example.customTool;

import com.example.answerSys.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageButtonText  extends LinearLayout{
	private ImageView iv;
	private TextView tv;

	public ImageButtonText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public ImageButtonText(Context context,AttributeSet attrs) {
		super(context,attrs);
		LayoutInflater.from(context).inflate(R.layout.custom_btn, this,  
                true);  
        iv = (ImageView) findViewById(R.id.imageView_btn);  
        tv = (TextView) findViewById(R.id.textView_tv);
        
        this.setClickable(true);
        this.setFocusable(true);
	}
	
	public void setDefaultImageResource(int resId){
		iv.setImageResource(resId);
	}
	
	public void setDefaultTextViewText(String text) {  
        tv.setText(text);  
    } 
	
	/** 
     * @param resId 
     */  
    public void setImageResource(int resId) {  
        iv.setImageResource(resId);  
    }  
  
    /** 
     * @param text 
     */  
    public void setTextViewText(String text) {  
        tv.setText(text);  
    }  
  
    /** 
     * @param color 
     */  
    public void setTextColor(int color) {  
        tv.setTextColor(color);  
    }  

}
