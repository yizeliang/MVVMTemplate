package com.jingchen.pulltorefresh;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class GifHeadView extends RelativeLayout
{
	private GifImageView gifImageView;

	public GifHeadView(Context context)
	{
		this(context, null, 0);
	}

	public GifHeadView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public GifHeadView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		LayoutInflater.from(context).inflate(R.layout.gif_headview, this, true);
		gifImageView = (GifImageView) findViewById(R.id.giv_anim);
	}

	/**
	 * 设置gif动画资源
	 * 
	 * @param gifDrawable
	 */
	public void setGifAnim(GifDrawable gifDrawable)
	{
		gifImageView.setImageDrawable(gifDrawable);
		// 停止自动播放
		gifDrawable.stop();
	}

	/**
	 * 获取gif
	 * 
	 * @return
	 */
	public GifDrawable getDrawable()
	{
		return (GifDrawable) gifImageView.getDrawable();
	}
}
