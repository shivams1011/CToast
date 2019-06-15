package com.developertechie.ctoast;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/**
 * Created by ShivamSharma on 5/25/19.
 */
public class CToast {

	private Context mContext;
	private @StringRes
	int msg;

	private @DrawableRes
	int leftDrawable;

	private @DrawableRes
	int rightDrawable;

	private @DrawableRes
	int topDrawable;

	private @DrawableRes
	int bottomDrawable;

	private @ColorRes
	int toastBgColor;

	private @ColorRes
	int textColor;

	private int duration;
	private int gravity;
	private int xOffSet;
	private int yOffSet;


	public CToast(Context context, @StringRes int msg, int leftDrawable, int topDrawable,int rightDrawable, int bottomDrawable,
				  int toastBgColor, int textColor, int duration, int gravity, int xOffSet, int yOffSet) {
		this.msg = msg;
		this.leftDrawable = leftDrawable;
		this.topDrawable = topDrawable;
		this.rightDrawable = rightDrawable;
		this.bottomDrawable = bottomDrawable;
		this.toastBgColor = toastBgColor;
		this.textColor = textColor;
		this.duration = duration;
		this.mContext = context;
		this.gravity = gravity;
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;
	}

	public void show() {
		Toast toast = Toast.makeText(mContext, "", duration);
		LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = layoutInflater.inflate(R.layout.activity_ctoast, null);

		LinearLayout relativeLayout = view.findViewById(R.id.toastRelativeLayout);
		ImageView imgLeft = view.findViewById(R.id.imgToastLeft);
		ImageView imgRight = view.findViewById(R.id.imgToastRight);
		ImageView imgTop = view.findViewById(R.id.imgToastTop);
		ImageView imgBottom = view.findViewById(R.id.imgToastBottom);
		TextView txtMsg = view.findViewById(R.id.toastMsgText);

		if (toastBgColor != 0) {
			Drawable bgRoundCorner = mContext.getResources().getDrawable(R.drawable.toast_bg_corner);
			bgRoundCorner.setColorFilter(new
					PorterDuffColorFilter(mContext.getResources().getColor(toastBgColor), PorterDuff.Mode.MULTIPLY));
			relativeLayout.setBackground(bgRoundCorner);
		}

		if (msg != 0) {
			txtMsg.setText(msg);
		} else {
			txtMsg.setText("");
		}

		setImageDrawable(imgLeft, leftDrawable);
		setImageDrawable(imgRight, rightDrawable);
		setImageDrawable(imgTop, topDrawable);
		setImageDrawable(imgBottom, bottomDrawable);


		if (textColor != 0) {
			txtMsg.setTextColor(mContext.getResources().getColor(textColor));
		}

		if (gravity != 0) {
			toast.setGravity(gravity, xOffSet, yOffSet);
		}

		if (duration > 0) {
			toast.setDuration(duration);
		} else {
			toast.setDuration(Toast.LENGTH_SHORT);
		}

		toast.setView(view);
		toast.show();
	}

	private void setImageDrawable(ImageView imgView, int imgResourse) {
		if (imgResourse != 0) {
			imgView.setImageResource(imgResourse);
			imgView.setVisibility(View.VISIBLE);
		} else {
			imgView.setVisibility(View.GONE);
		}
	}


	/**
	 * Follow Builder Pattern for getting  multiple user requirement for Custom toast.
	 */

	public static class Builder {
		private @StringRes
		int msg;
		private int leftDrawable;
		private int rightDrawable;

		private int topDrawable;
		private int bottomDrawable;

		private int toastBgColor;
		private int textColor;
		private int duration;
		private Context context;

		private int gravity;

		private int xOffSet;
		private int yOffSet;

		public Builder(Context context) {
			this.context = context;
		}

		public Builder setMsg(@StringRes int msg) {
			this.msg = msg;
			return this;
		}

		public Builder setLeftDrawable(int leftDrawable) {
			this.leftDrawable = leftDrawable;
			return this;
		}

		public Builder setToastBgColor(int toastBgColor) {
			this.toastBgColor = toastBgColor;
			return this;
		}

		public Builder setTextColor(int textColor) {
			this.textColor = textColor;
			return this;
		}

		public Builder setDuration(int duration) {
			this.duration = duration;
			return this;
		}

		public Builder setGravity(int gravity) {
			this.gravity = gravity;
			return this;
		}

		public Builder setRightDrawable(int rightDrawable) {
			this.rightDrawable = rightDrawable;
			return this;
		}

		public Builder setXYoffSet(int xOffSet, int yOffSet) {
			this.xOffSet = xOffSet;
			this.yOffSet = yOffSet;
			return this;
		}

		public Builder setTopDrawable(int topDrawable) {
			this.topDrawable = topDrawable;
			return this;
		}

		public Builder setBottomDrawable(int bottomDrawable) {
			this.bottomDrawable = bottomDrawable;
			return this;
		}

		public CToast build() {
			return new CToast(context, msg, leftDrawable, topDrawable,rightDrawable, bottomDrawable, toastBgColor, textColor, duration, gravity, xOffSet, yOffSet);
		}
	}


}
