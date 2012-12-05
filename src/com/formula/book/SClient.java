package com.formula.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class SClient implements Runnable {
	
	private Handler ui;
	private String param;
	private String serverResp;
	private String inStr;
	
	public SClient(Handler uiHandler, String searchText) {
		ui = uiHandler;
		param = searchText;
	}
	
	public void run() {
		
		Message msg;
		try{
			URL myUrl = new URL("http://users.metropolia.fi/~samisuov/android/search.php?formulas="+param);
			BufferedReader in = new BufferedReader(new InputStreamReader(myUrl.openStream()));
			serverResp="";
			
			while ((inStr = in.readLine())  != null)
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
			//Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			inStr = null;

		}
	}


	
}

	


