package presentation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Tweet;

public interface IOHandler {

	public String readFromConsoleInput();
	public void writeToConsoleOutput(List<Tweet> tweets);
	
}
