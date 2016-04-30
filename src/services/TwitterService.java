package services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.TwitterDao;
import entities.Tweet;

public class TwitterService {

	private TwitterDao dao;

	public TwitterService(TwitterDao dao) {
		super();
		this.dao=dao;

	}

	public void writeTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		dao.save(tweet);

	}

	public List<Tweet> readTweets() {
		// TODO Auto-generated method stub
		return dao.read();
	}

}
