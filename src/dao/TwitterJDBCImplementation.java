package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Tweet;

public class TwitterJDBCImplementation implements TwitterDao {
	Connection con = null;

	@Override
	public List<Tweet> read() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/twitter", "postgres", "Password1");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from tweets");
			while (result.next()) {
				String content = result.getString("content");
				Tweet t = new Tweet();
				t.setContent(content);
				tweets.add(t);
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return tweets;
	}

	@Override
	public void save(Tweet tweet) {
		PreparedStatement statement = null;
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/twitter", "postgres", "Password1");
			statement = (PreparedStatement) con.prepareStatement("insert into tweets (content) values(?)");
			statement.setString(1, tweet.getContent());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
