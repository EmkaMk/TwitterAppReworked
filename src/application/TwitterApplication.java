package application;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.TwitterDao;
import dao.TwitterHibernateImplementation;
import entities.Tweet;
import presentation.IOHandler;
import presentation.IOImplementation;
import presentation.TwitterInputReader;
import services.TwitterService;

/**
 * 
 */

/**
 * @author Emilija
 *
 */
public class TwitterApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Tweet.class)
				.buildSessionFactory();

		System.out.println("------------");
		System.out.println("Choose one of the following options:");
		System.out.println("1:Read tweets");
		System.out.println("2:Write tweet");
		System.out.println("3:Terminate the application!");
		System.out.println("------------");

		IOHandler ioHandler = new IOImplementation();
		TwitterDao dataHandler = new TwitterHibernateImplementation(sessionFactory);
		TwitterService twitter = new TwitterService(dataHandler);
		TwitterInputReader tinput = new TwitterInputReader(ioHandler, twitter);
		tinput.readUserInput();

	}
}
