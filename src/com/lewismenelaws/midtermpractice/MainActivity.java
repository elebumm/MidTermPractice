package com.lewismenelaws.midtermpractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private EditText inputEditText;
	private TextView rotTextView;
	private SeekBar rotSeekBar;
	private EditText outputEditText;
	private Button outputButton1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inputEditText = (EditText) findViewById(R.id.inputEditText);
		rotTextView = (TextView) findViewById(R.id.rotTextView);
		rotSeekBar = (SeekBar) findViewById(R.id.rotSeekBar);
		outputEditText = (EditText) findViewById(R.id.outputEditText);
		outputButton1 = (Button) findViewById(R.id.outputButton1);

		rotSeekBar.setOnSeekBarChangeListener(rotSeekBarListener);

		outputButton1.setOnClickListener(outputButton1Listener);
	}

	private OnSeekBarChangeListener rotSeekBarListener = new OnSeekBarChangeListener() {
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			rotTextView.setText(String.valueOf(progress));
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {

		}
	};
	
	private OnClickListener outputButton1Listener = new OnClickListener() {
		  @Override
		  public void onClick(View v) {
			  rotate();
		  }
	   };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	public void rotate() {
		char[] input = inputEditText.getText().toString().toCharArray();
		int rotValue = rotSeekBar.getProgress();
		String output = "";
		for (char c : input) {
			if (Character.isLetter(c)) {
				c = (char) (c + rotValue);
				if (!Character.isLetter(c))
					c -= 26;
			}
			output += c;
		}
		outputEditText.setText(output);
	}

}
