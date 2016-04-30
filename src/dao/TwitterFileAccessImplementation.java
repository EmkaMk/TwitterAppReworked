package dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entities.Tweet;

public class TwitterFileAccessImplementation implements TwitterDao {

	private ArrayList<Tweet> tweets;

	public TwitterFileAccessImplementation() {
		super();
		tweets = new ArrayList<>();
	}

	@Override
	public ArrayList<Tweet> read() {
		// TODO Auto-generated method stub
		try (FileReader filereader = new FileReader("tweet.txt")) {

			try (BufferedReader reader = new BufferedReader(filereader)) {

				String line = "";
				while ((line = reader.readLine()) != null) {
					Tweet t=new Tweet();
					t.setContent(line);
					tweets.add(t);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return tweets;
	}

	@Override
	public void save(Tweet tweet) {
		// TODO Auto-generated method stub
		File f = new File("tweet.txt");

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (FileWriter writer = new FileWriter(f, true)) {

			writer.write(tweet.getContent() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
