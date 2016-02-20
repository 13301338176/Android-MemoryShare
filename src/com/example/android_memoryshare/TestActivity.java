package com.example.android_memoryshare;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import com.alibaba.laiwang.android.MemoryShare;

public class TestActivity extends Activity {

	private MemoryShare mMemoryShare;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMemoryShare = new MemoryShare();
		mMemoryShare.mFD = getIntent().getIntExtra("fdValue", 0);
		ParcelFileDescriptor fdc = getIntent().getParcelableExtra("fdName");
		mMemoryShare.mFD = fdc.getFd();

		try {
			mMemoryShare.mFD = ParcelFileDescriptor.fromFd(mMemoryShare.mFD).getFd();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Log.e("libTest", "onCreate:" + mMemoryShare.mFD);

		mMemoryShare.init();
		// mMemoryShare.open();
		mMemoryShare.mmap(mMemoryShare.mFD);
		Log.e("libTest", "onCreate2:" + mMemoryShare.mFD);
		// mMemoryShare.write();
		mMemoryShare.read();

		Intent intent = new Intent();
		intent.putExtra("fdValue", mMemoryShare.mFD);
		intent.setClassName("com.example.android_memoryshare", "com.alibaba.laiwang.android.MemoryService");
		this.startService(intent);
	}

	@Override
	protected void onDestroy() {
		// mMemoryShare.close();
		super.onDestroy();
	}

}
