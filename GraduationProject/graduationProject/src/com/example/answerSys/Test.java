package com.example.answerSys;

import java.io.IOException;
import java.util.List;

import javax.security.auth.Subject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.Dao.QuestionDao;
import com.example.ItemBean.QuestionBean;
import com.example.customTool.DataBaseHelper;
import com.example.customTool.ImageButtonText;
import com.example.customTool.Judgement;
import com.example.customTool.NetTool;
import com.example.customTool.ShowDialogDouble;
import com.example.customTool.ShowDialogSingle;
import com.example.customTool.Table_HistoryTool;
import com.example.dialog.Dialog_double;
import com.example.dialog.Dialog_single;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.percent.PercentFrameLayout;
import android.support.percent.PercentRelativeLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends Activity {
	
	/**
	 * 底部按钮点击
	 * @author Assassin
	 *
	 */

	public class Bottom_btn implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.bottom_pre:{
				if(arrow>0){
					arrow--;
					QuestionBean q=list.get(arrow);
					questionId=q.getQB_ID();
					question.setText((arrow+1)+". "+q.getQuestion());
					String option[]=q.getChoiceStr().split("&&");
					radio[0].setText(option[0]);
					radio[1].setText(option[1]);
					radio[2].setText(option[2]);
					radio[3].setText(option[3]);
					answer_user.setText("你的答案是："+list.get(arrow).getUserAnswer());
					answer_system.setText("正确答案是："+list.get(arrow).getAnswer());
					analysis_textview.setText(list.get(arrow).getExplaination());
					if(q.getQuestionType()==0){
						questionType.setImageResource(R.drawable.answer_radio);
					}else{
						questionType.setImageResource(R.drawable.answer_multiselec);
					}
					if(list.get(arrow).getUserAnswer()!=null){
						for(int i=0;i<radio.length;i++){
							if(list.get(arrow).getUserAnswer().equals(String.valueOf(radio[i].getTag()))){
								radio[i].setChecked(true);
								break;
							}						
						}
					}else{
						radioGroup.clearCheck();
					}
				}else{
					Toast.makeText(Test.this, "没有上一题了！", Toast.LENGTH_SHORT).show();
				}				
			}
			break;
			case R.id.bottom_next:{
				bottom_pre.setEnabled(true);
				if(arrow<list.size()-1){
					arrow++;
					QuestionBean q=list.get(arrow);
					questionId=q.getQB_ID();
					question.setText((arrow+1)+". "+q.getQuestion());
					String option[]=q.getChoiceStr().split("&&");
					radio[0].setText(option[0]);
					radio[1].setText(option[1]);
					radio[2].setText(option[2]);
					radio[3].setText(option[3]);
					answer_user.setText("你的答案是："+list.get(arrow).getUserAnswer());
					answer_system.setText("正确答案是："+list.get(arrow).getAnswer());
					analysis_textview.setText(list.get(arrow).getExplaination());
					if(q.getQuestionType()==0){
						questionType.setImageResource(R.drawable.answer_radio);
					}else{
						questionType.setImageResource(R.drawable.answer_multiselec);
					}
					if(list.get(arrow).getUserAnswer()!=null){
						for(int i=0;i<radio.length;i++){
							if(list.get(arrow).getUserAnswer().equals(String.valueOf(radio[i].getTag()))){
								radio[i].setChecked(true);
								break;
							}
						}
					}else{
						radioGroup.clearCheck();
					}
				}else{
						Toast.makeText(Test.this, "没有下一题了！", Toast.LENGTH_SHORT).show();
				}		
			}
			break;
			case R.id.bottom_list:{
				Toast.makeText(Test.this, "显示列表!", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.bottom_uploadAndsubmit:{
				if(String.valueOf(bottom_uploadAndsubmit.getTag()).equals("提交")){
					if(count<list.size()){
						ShowDialogSingle single=new ShowDialogSingle();
						single.showDialog(Test.this, "提示", "亲，你还有题没有做完哦！", "确定");
					}else{
						Table_HistoryTool.collectMistakes(new Judgement().judge(list, vessel));
						checkAnalysis(Test.this, "提示", "你做对了"+vessel[0], "你做错了"+vessel[1], "查看解析");
						vessel[0]=vessel[1]=0;
					}
				}else{
//					System.out.println("这是上传！");
					new Thread(){
						public void run(){
							try {
								JSONObject json=new JSONObject();
								json.put("question_id", questionId);
								final String result=NetTool.upItem(json);
								if(result!=null){
									runOnUiThread(new Runnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
											Toast.makeText(Test.this, result, 0).show();
										}
									});
								}else{
									runOnUiThread(new Runnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
											Toast.makeText(Test.this, "请求失败！", 0).show();
										}
									});
								}
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();
				}
//				Toast.makeText(Test.this, "上传成功！", Toast.LENGTH_SHORT).show();
//				new Thread(){
//					public void run(){
//						try {
////						tool.items();
////							JSONArray arr=NetTool.downItem();
////							for(int i=0;i<arr.length();i++){
////								JSONObject obj=arr.getJSONObject(i);
////								Log.e("id", obj.getString("id"));
////								Log.e("name", obj.getString("name"));
////								Log.e("sex", obj.getString("sex"));
////
////							}
//							JSONObject json=new JSONObject();
//							json.put("id", "1");
//							json.put("name", "张事林");
//							NetTool.upItem(json);
//							
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}.start();
			}
			break;
			}
		}
		
		private void checkAnalysis(Context context,String title,String message1,String message2,String btn_text){
			final Dialog_single single=new Dialog_single(context, title, message1, message2, btn_text);
			single.show();
			single.setCallBack(new Dialog_single.MyCallBack() {
				
				@Override
				public void ok() {
					// TODO Auto-generated method stub
					single.dismiss();
					count=0;
					arrow=0;
					radioGroup.clearCheck();
					showItem(arrow);
					bottom_uploadAndsubmit.setImageResource(R.drawable.bottom_upload);
					bottom_uploadAndsubmit.setTextViewText("上传");
					bottom_uploadAndsubmit.setTag("上传");
					for(int i=0;i<radio.length;i++){
							radio[i].setEnabled(false);
					}
					floatlayout.setVisibility(View.GONE);
					main_analysis.setVisibility(View.VISIBLE);
					main_answer.setVisibility(View.VISIBLE);
					
				}
			});
		}

	}
	
	/**
	 * 在做题和背题之间切换
	 * @author Assassin
	 *
	 */
	public class Pattern_Change implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			if(buttonView.isChecked()){
				main_analysis.setVisibility(View.VISIBLE);
				main_answer.setVisibility(View.VISIBLE);
				answer_user.setVisibility(View.GONE);
				bottom_uploadAndsubmit.setImageResource(R.drawable.bottom_upload);
				bottom_uploadAndsubmit.setTextViewText("上传");
				bottom_uploadAndsubmit.setTag("上传");
				for(int i=0;i<radio.length;i++){
					radio[i].setEnabled(false);
				}
				Toast.makeText(Test.this, "背题！", Toast.LENGTH_SHORT).show();
			}else{
				main_analysis.setVisibility(View.GONE);
				main_answer.setVisibility(View.GONE);
				bottom_uploadAndsubmit.setImageResource(R.drawable.bottom_submit);
				bottom_uploadAndsubmit.setTextViewText("提交");
				bottom_uploadAndsubmit.setTag("提交");
				for(int i=0;i<radio.length;i++){
					radio[i].setEnabled(true);
				}
				Toast.makeText(Test.this, "做题！", Toast.LENGTH_SHORT).show();
			}
		}

	}

	/**
	 * 记录用户选项
	 * @author Assassin
	 *
	 */
	public class RemeberChioce implements android.widget.RadioGroup.OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub

			for(int i=0;i<radio.length;i++){
				if(radio[i].isChecked()==true){
					list.get(arrow).setUserAnswer(String.valueOf(radio[i].getTag()));
					count++;
					break;
				}
			}
		}

	}

	/**
	 * 收藏题目
	 * @author Assassin
	 *
	 */
	public class Collect_Question implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			if(buttonView.isChecked()){
				Toast.makeText(Test.this, "收藏成功！", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(Test.this, "取消收藏！", Toast.LENGTH_SHORT).show();
			}
		}

	}

	/**
	 * 返回上一个Activity
	 * @author Assassin
	 *
	 */
	public class Return_Activity implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
			list=null;
		}

	}

	//bottombar控件
	private ImageButtonText bottom_pre,bottom_next,bottom_list,bottom_uploadAndsubmit;
	//titlebar控件
	private ImageButton title_return;
	private TextView title_tv;
	private CheckBox title_checkbox;
	//main控件
	private ImageView questionType;
	private TextView question,answer_user,answer_system,analysis_textview;
	private PercentRelativeLayout main_analysis,main_answer;
	private PercentFrameLayout floatlayout;
	private RadioGroup radioGroup;
	private RadioButton[] radio=new RadioButton[4];
	//悬浮按钮
	private CheckBox pattern_btn;
	public static int width,height;//获取屏幕的宽和高
	
	public int arrow=0;
	public int count=0;//记录已做题数
	public int questionId=0;
	
	public static int[] vessel=new int[]{0,0};
	static QuestionDao server=new QuestionDao();
	public static List<QuestionBean> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.answer_activity);
		list=server.getItems();//拿到数据源
		DisplayMetrics dm=getResources().getDisplayMetrics();
		width=dm.widthPixels;
		height=dm.heightPixels;
		initView();
		addOnclik();
		showItem(arrow);
	}

	/**
	 * 加载控件
	 */
	//region 控件加载方法
	private void initView() {
//		===============加載title_bar内部控件==========================================
		title_return=(ImageButton) findViewById(R.id.title_return);
		title_tv=(TextView) findViewById(R.id.title_textview);
		title_checkbox=(CheckBox) findViewById(R.id.title_checkBox_collect);
//		===============加載title_bar内部控件==========================================
		
//		===============加载bottom_bar内部控件=======================================
		bottom_pre=(ImageButtonText) findViewById(R.id.bottom_pre);
		bottom_pre.setImageResource(R.drawable.bottom_pre);
		bottom_pre.setTextViewText("上一题");
		
		bottom_next=(ImageButtonText) findViewById(R.id.bottom_next);
		bottom_next.setImageResource(R.drawable.bottom_next);
		bottom_next.setTextViewText("下一题");
		
		bottom_list=(ImageButtonText) findViewById(R.id.bottom_list);
		bottom_list.setImageResource(R.drawable.bottom_list);
		bottom_list.setTextViewText("进度");
		
		bottom_uploadAndsubmit=(ImageButtonText) findViewById(R.id.bottom_uploadAndsubmit);
		bottom_uploadAndsubmit.setImageResource(R.drawable.bottom_submit);
		bottom_uploadAndsubmit.setTextViewText("提交");
		bottom_uploadAndsubmit.setTag("提交");
//		===============加载bottom_bar内部控件=======================================
		
//		===============加载main内部控件=============================================
		main_answer=(PercentRelativeLayout) findViewById(R.id.main_answer);
		main_answer.setVisibility(View.GONE);
		main_analysis=(PercentRelativeLayout) findViewById(R.id.main_analysis);
		main_analysis.setVisibility(View.GONE);
		
		floatlayout=(PercentFrameLayout) findViewById(R.id.floatlayout);
		pattern_btn=(CheckBox) findViewById(R.id.pattern_button);
		
		questionType=(ImageView) findViewById(R.id.questionType_imageview);
		
		question=(TextView) findViewById(R.id.question_textview);
		
		radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
		radio[0]=(RadioButton) findViewById(R.id.radioA);
		radio[1]=(RadioButton) findViewById(R.id.radioB);
		radio[2]=(RadioButton) findViewById(R.id.radioC);
		radio[3]=(RadioButton) findViewById(R.id.radioD);
		
		answer_user=(TextView) findViewById(R.id.answer_user);
		answer_system=(TextView) findViewById(R.id.answer_system);
		analysis_textview=(TextView) findViewById(R.id.analysis_textview);
//     ===============加载main内部控件==============================================
		
//		===============设置radiobutton大小============================================
		setView(radio[0], 0.917, 0.1);
		setView(radio[1], 0.917, 0.1);
		setView(radio[2], 0.917, 0.1);
		setView(radio[3], 0.917, 0.1);
//		===============设置radiobutton大小============================================
	}
	//end
	
	/**
	 * 动态调整radiobutton的大小
	 * @param view 表示radiobutton
	 * @param w 表示动态大小的宽度比例
	 * @param h 表示动态大小的高度比例
	 */
	private  void setView(View view,double w,double h){
		RadioGroup.LayoutParams radio=(LayoutParams) view.getLayoutParams();
		radio.width=(int) (width*w);
		radio.height=(int) (height*h);
		view.setLayoutParams(radio);
	}

	/**
	 * 为需要点击的控件添加监听器
	 */
	private void addOnclik(){
		title_return.setOnClickListener(new Return_Activity());
		title_checkbox.setOnCheckedChangeListener(new Collect_Question());
		radioGroup.setOnCheckedChangeListener(new RemeberChioce());
		bottom_pre.setOnClickListener(new Bottom_btn());
		bottom_list.setOnClickListener(new Bottom_btn());
		bottom_uploadAndsubmit.setOnClickListener(new Bottom_btn());
		bottom_next.setOnClickListener(new Bottom_btn());
		pattern_btn.setOnCheckedChangeListener(new Pattern_Change());
	}
	
	private void showItem(int n){
		QuestionBean q=list.get(n);
		if(q.getQuestionType()==0){
			questionType.setImageResource(R.drawable.answer_radio);
		}else{
			questionType.setImageResource(R.drawable.answer_multiselec);
		}
		questionId=q.getQB_ID();
		question.setText((arrow+1)+". "+q.getQuestion());
		String option[]=q.getChoiceStr().split("&&");
		radio[0].setText(option[0]);
		radio[1].setText(option[1]);
		radio[2].setText(option[2]);
		radio[3].setText(option[3]);
		answer_user.setText("你的答案是："+list.get(arrow).getUserAnswer());
		answer_system.setText("正确答案是："+list.get(arrow).getAnswer());
		analysis_textview.setText(list.get(arrow).getExplaination());
		if(q.getUserAnswer()!=null){
			for(int i=0;i<radio.length;i++){
				if(list.get(arrow).getUserAnswer().equals(String.valueOf(radio[i].getTag()))){
					radio[i].setChecked(true);
					break;
				}						
			}
		}
	}
	
}
