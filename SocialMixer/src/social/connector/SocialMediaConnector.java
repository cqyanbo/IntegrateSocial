package social.connector;

import java.io.IOException;
import java.util.Hashtable;

import social.constant.CredentialIterm;
import social.tools.PropertiesReader;

/**
 * This is an abstract class to define the framework of all specific connections
 * @author cqyanbo
 *
 */

public abstract class SocialMediaConnector{
	// TODO: Get the log
	
	public abstract boolean Connect();
	
	public String getValue(CredentialIterm key) throws IOException{
		return PropertiesReader.getProperty(key.toString());
	}
}
