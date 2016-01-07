package com.example.calen;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ImageView prevMonth;
	private ImageView nextMonth;
	private TextView currentMonth;
	
	Calendar c;
	
	int mCurrentYear;
	int mCurrentMonth;
	int	mCurrentDay;
	
	
	int mYear;
	int mMonth;
	int	mDay;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		c = Calendar.getInstance();
		initView();
		initData();
		setListener();


	}

	private void initView() {
		prevMonth=(ImageView) findViewById(R.id.prevMonth);
		nextMonth=(ImageView) findViewById(R.id.nextMonth);
		currentMonth=(TextView) findViewById(R.id.currentMonth);
	}

	private void initData() {


		addTextToTextView(currentMonth);


	}
	/**
	 * 添加头部的年份 闰哪月等信息
	 * 
	 * @param view
	 */
	public void addTextToTextView(TextView view) {
		
		
		mCurrentYear = c.get(Calendar.YEAR);
		mCurrentMonth= c.get(Calendar.MONTH)+1;
		mCurrentDay = c.get(Calendar.DAY_OF_MONTH);


		c.set(Calendar.DAY_OF_MONTH,mCurrentDay+6);
		mYear = c.get(Calendar.YEAR);
		mMonth= c.get(Calendar.MONTH)+1;
	    mDay = c.get(Calendar.DAY_OF_MONTH);
		StringBuffer sb = new StringBuffer();

		sb.append(mCurrentYear+"."+mCurrentMonth+"."+mCurrentDay).append("-").append(mYear+"."+mMonth+"."+mDay).append("\t");
		view.setText(sb);
	}

	private void setListener() {
		
		prevMonth.setOnClickListener(mOnClickListener);
		nextMonth.setOnClickListener(mOnClickListener);
	}
	OnClickListener mOnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			
			switch (view.getId()) {
			case R.id.prevMonth:
				enterPreWeek();
				break;
			case R.id.nextMonth:
				Toast.makeText(getApplicationContext(), "下一个", 0).show();
				enterNextWeek();
				break;

			default:
				break;
			}
		}
	};

	protected void enterNextWeek() {
		Toast.makeText(getApplicationContext(), "下..", 0).show();
		c.set(Calendar.DAY_OF_MONTH,mCurrentDay+6);
		addTextToTextView(currentMonth);
	}

	protected void enterPreWeek() {
		Toast.makeText(getApplicationContext(), "上..", 0).show();
		c.set(Calendar.DAY_OF_MONTH,mCurrentDay-6);
		addTextToTextView(currentMonth);
	}



}
