package dao;
import java.util.ArrayList;
import java.util.List;

import entities.Tweet;

public interface TwitterDao {

	public List<Tweet> read();

	public void save(Tweet tweet);
}
