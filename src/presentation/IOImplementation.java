package presentation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Tweet;

public class IOImplementation implements IOHandler {

	private Scanner in = new Scanner(System.in);

	@Override
	public String readFromConsoleInput() {
		String option = in.nextLine();

		return option;
	}

	@Override
	public void writeToConsoleOutput(List<Tweet> tweets) {
		// TODO Auto-generated method stub
		Collections.reverse(tweets);
		for(Tweet t: tweets)
		{
			System.out.println(t.getContent());
		}

	}

}
