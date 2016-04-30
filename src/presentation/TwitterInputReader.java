package presentation;
import entities.Tweet;
import services.TwitterService;

public class TwitterInputReader {

	private IOHandler handler;
	private TwitterService service;

	public TwitterInputReader(IOHandler handler, TwitterService service) {
		super();
		this.handler = handler;
		this.service = service;
	}

	public void readUserInput() {

		while (true) {
			String input = handler.readFromConsoleInput();
			if (input.equals("3")) {
				System.out.println("Thank you for using our service! Come back soon");
				break;
			} else if (input.equals("1")) {
				handler.writeToConsoleOutput(service.readTweets());

			} else if (input.equals("2")) {
				String tweet = handler.readFromConsoleInput();
				Tweet t = new Tweet();
				t.setContent(tweet);
				service.writeTweet(t);
			}
		}
	}

}