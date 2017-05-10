package com.demo.apply;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lib.sdk.demo.R;
import com.yline.base.BaseAppCompatActivity;
import com.yline.utils.UIScreenUtil;
import com.yline.view.apply.SimpleGridItemDecoration;
import com.yline.view.apply.SimpleHeadFootRecyclerAdapter;

import java.util.Arrays;

public class SimpleGridDecorationActivity extends BaseAppCompatActivity
{
	private SimpleHeadFootRecyclerAdapter recyclerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_decoration);

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_decoration);
		recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
		recyclerView.addItemDecoration(new SimpleGridItemDecoration(this)
		{
			@Override
			protected int getHeadNumber()
			{
				return 2;
			}

			@Override
			protected int getFootNumber()
			{
				return 2;
			}

			@Override
			protected int getDivideResourceId()
			{
				return R.drawable.widget_recycler_divider_black_normal;
			}
		});
		recyclerAdapter = new SimpleHeadFootRecyclerAdapter();
		recyclerView.setAdapter(recyclerAdapter);

		View viewA = new View(this);
		viewA.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIScreenUtil.dp2px(this, 10)));
		viewA.setBackgroundColor(Color.GREEN);
		recyclerAdapter.addHeadView(viewA);

		View viewB = new View(this);
		viewB.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIScreenUtil.dp2px(this, 10)));
		viewB.setBackgroundColor(Color.RED);
		recyclerAdapter.addHeadView(viewB);

		View viewC = new View(this);
		viewC.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIScreenUtil.dp2px(this, 10)));
		viewC.setBackgroundColor(Color.GREEN);
		recyclerAdapter.addFootView(viewC);

		View viewD = new View(this);
		viewD.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIScreenUtil.dp2px(this, 10)));
		viewD.setBackgroundColor(Color.RED);
		recyclerAdapter.addFootView(viewD);

		recyclerAdapter.addAll(Arrays.asList("yline", "Simple", "English", "fatenliyer", "sin", "cos", "baby", "piano", "tree", "sky", "the world"));
		recyclerAdapter.addAll(Arrays.asList("yline", "Simple", "English", "fatenliyer", "sin", "cos", "baby", "piano", "tree", "sky", "the world"));
		recyclerAdapter.addAll(Arrays.asList("yline", "Simple", "English", "fatenliyer", "sin", "cos", "baby", "piano", "tree", "sky", "the world"));
	}
	
	public static void actionStart(Context context)
	{
		context.startActivity(new Intent(context, SimpleGridDecorationActivity.class));
	}
}
