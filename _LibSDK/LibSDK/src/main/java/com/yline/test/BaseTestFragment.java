package com.yline.test;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yline.base.BaseFragment;
import com.yline.sdk.R;
import com.yline.utils.UIResizeUtil;
import com.yline.utils.UIScreenUtil;

public abstract class BaseTestFragment extends BaseFragment implements ITestCallback
{
	protected LinearLayout linearLayout;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_test_base, container, false);
		this.linearLayout = (LinearLayout) view.findViewById(R.id.ll_base_content);
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		testStart(view, savedInstanceState);
	}
	
	@Override
	public Button addButton(String content, View.OnClickListener listener)
	{
		Button button = new Button(getContext());
		button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		UIResizeUtil.build().setBottomMargin(20).commit(button);
		button.setText(content);
		button.setAllCaps(false);
		button.setOnClickListener(listener);
		linearLayout.addView(button);
		return button;
	}
	
	@Override
	public EditText addEditText(String hintContent)
	{
		EditText editText = new EditText(getContext());
		editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		editText.setHint(hintContent);
		editText.setAllCaps(false);
		linearLayout.addView(editText);
		return editText;
	}
	
	@Override
	public EditText addEditText(String hintContent, String content)
	{
		EditText editText = new EditText(getContext());
		editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		editText.setHint(hintContent);
		editText.setText(content);
		editText.setAllCaps(false);
		linearLayout.addView(editText);
		return editText;
	}
	
	@Override
	public EditText addEditNumber(String hintContent)
	{
		EditText editText = new EditText(getContext());
		editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		editText.setHint(hintContent);
		editText.setInputType(InputType.TYPE_CLASS_NUMBER);
		editText.setAllCaps(false);
		linearLayout.addView(editText);
		return editText;
	}
	
	@Override
	public EditText addEditNumber(String hintContent, String content)
	{
		EditText editText = new EditText(getContext());
		editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		editText.setHint(hintContent);
		editText.setText(content);
		editText.setInputType(InputType.TYPE_CLASS_NUMBER);
		editText.setAllCaps(false);
		linearLayout.addView(editText);
		return editText;
	}
	
	@Override
	public ImageView addImageView(int width, int height)
	{
		ImageView imageView = new ImageView(this.getContext());
		imageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(UIScreenUtil.dp2px(getContext(), width), UIScreenUtil.dp2px(getContext(), height)));
		this.linearLayout.addView(imageView);
		return imageView;
	}
	
	@Override
	public TextView addTextView(String initContent)
	{
		TextView textView = new TextView(this.getContext());
		textView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
		textView.setHint(initContent);
		textView.setAllCaps(false);
		this.linearLayout.addView(textView);
		return textView;
	}
}
