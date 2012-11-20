package com.formula.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class SClient implements Runnable {
	
	private Handler ui;
	private String param;
	private String serverResp;
	
	public SClient(Handler uiHandler, String searchText) {
		ui = uiHandler;
		param = searchText;
	}
	
	public void run() {
		
		Message msg;
		try{
			URL myUrl = new URL("http://users.metropolia.fi/~villevsa/android/hurrr.php?formulas="+param);
			BufferedReader in = new BufferedReader(new InputStreamReader(myUrl.openStream()));
			serverResp="";
			String inStr;
			
			while ((inStr = in.readLine()) != null)
			{
				serverResp = serverResp + inStr;
				
			}

			in.close();
			msg = ui.obtainMessage();
			msg.obj = serverResp;
			msg.what = 0;
			ui.sendMessage(msg);
		}
		catch(Exception e){
			Log.e("TCP", "C: Error", e);

		}
	}
}

	


