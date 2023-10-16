package firebase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.firebase.database.FirebaseDatabase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


public class FireBaseService {
	FirebaseDatabase db;

	/*
	 * public FireBaseService() throws IOException { File file = new
	 * File(getClass().getClassLoader().getResource("key.json").getFile());
	 * FileInputStream serviceAccount = new FileInputStream(file);
	 * 
	 * FirebaseOptions options = new FirebaseOptions.Builder()
	 * .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	 * .setDatabaseUrl("https://strange-song-394808-default-rtdb.firebaseio.com").
	 * build();
	 * 
	 * FirebaseApp.initializeApp(options);
	 * 
	 * }
	 */
	// update java lên 8+ để dùng
	
}
