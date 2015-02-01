package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<String> tweets;
	private ArrayAdapter<String> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				
				tweets.add(text);
				adapter.notifyDataSetChanged();
				saveInFile(text, new Date(System.currentTimeMillis()));
				//throw new RuntimeException("Testing");
				//finish();
				
			}
		});
	}

	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		/*User u = new Reader();
		
		try{
		u.setUsername("joe");
		}
		catch(IOException e){
			
		}
		*/
		
		super.onStart();
		tweets = loadFromFile();
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
		
		
		
	}

	private ArrayList<String> loadFromFile() {
		
		Gson gson = new Gson();
		
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			
			Type listType = new TypeToken<ArrayList<String>>() {}.getType();
			
		
						
			tweets = gson.fromJson(isr, listType);
			
			
			
			isr.close();
			fis.close();
						
						
			
		//	FileInputStream fis = openFileInput(FILENAME);
			//BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			//String line = in.readLine();
		//	while (line != null) {
			//	tweets.add(line);
			//	line = in.readLine();
			//}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (tweets == null){
		tweets = new ArrayList<String>();
		}
		
		
		return tweets;
	}
	
	private void saveInFile(String text, Date date) {
		Gson gson = new Gson();
		
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			
			//fos.write(new String(date.toString() + " | " + text)
			//		.getBytes());
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			gson.toJson(tweets, osw);
			
			osw.flush();
			osw.close();
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}