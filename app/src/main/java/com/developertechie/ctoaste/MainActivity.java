package com.developertechie.ctoaste;

import android.graphics.Color;
import android.os.Bundle;

import com.developertechie.ctoast.CToast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		findViewById(R.id.btnShowError).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				CToast cToast = new CToast.Builder(getApplicationContext())
						.setToastBgColor(R.color.ct_error)
						.setMsg(R.string.error)
						.setLeftDrawable(R.drawable.ic_error_red_24dp)
						.setDuration(Toast.LENGTH_SHORT)
						.setTextColor(R.color.white)
						.build();
				cToast.show();

			}
		});


		findViewById(R.id.btnShowSuccess).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				CToast cToast = new CToast.Builder(getApplicationContext())
						.setToastBgColor(R.color.ct_success)
						.setMsg(R.string.success)
						.setLeftDrawable(R.drawable.ic_done_green_24dp)
						.setDuration(Toast.LENGTH_SHORT)
						.setTextColor(R.color.white)
						.build();
				cToast.show();

			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
