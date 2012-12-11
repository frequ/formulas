package com.formula.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
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
		BufferedReader reader = null;
		try{
			URL myUrl = new URL("http://users.metropolia.fi/~samisuov/android/search.php?formulas="+param);
			reader= new BufferedReader(new InputStreamReader(myUrl.openStream()));
			serverResp="";
			

			
			while((inStr = reader.readLine())  != null){
				serverResp = serverResp + inStr;
			}
			
			reader.close();
			msg = ui.obtainMessage();
			msg.obj = serverResp;
			msg.what = 0;
			ui.sendMessage(msg);
			
			

			
		}catch(IOException e){
			Log.e("TCP", "C: Error", e);
			
		}finally{
			System.err.println("Connection timed out");
		}
	}


}

	


