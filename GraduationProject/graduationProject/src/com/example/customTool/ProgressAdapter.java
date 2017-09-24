package com.example.customTool;

import java.util.List;

import com.example.ItemBean.QuestionBean;

import com.example.answerSys.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProgressAdapter extends BaseAdapter {
	private List<QuestionBean> list;
	private Context context;

	public ProgressAdapter(List<QuestionBean> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView=View.inflate(context, R.layout.progerss_item, null);
		TextView tv=(TextView) convertView.findViewById(R.id.textView1);
		QuestionBean b=list.get(position);
		tv.setText(String.valueOf(b.getQB_ID()));
		
		
		return convertView;
	}

}
