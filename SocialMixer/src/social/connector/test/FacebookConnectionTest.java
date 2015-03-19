package social.connector.test;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import facebook4j.FacebookException;
import social.connector.FacebookConnector;

public class FacebookConnectionTest {

	private FacebookConnector connector;
	
	public FacebookConnectionTest() {
		this.connector = new FacebookConnector();
	}
	
	  @Test
	  public void FacebookConnect() {
		  Assert.assertTrue(connector.Connect());
	  }
	  
	  @Test
	  public void testGetPosts(){
		  try {
			System.out.println(connector.getPosts());
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
