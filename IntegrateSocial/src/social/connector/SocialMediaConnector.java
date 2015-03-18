package social.connector;

import java.util.Hashtable;

import social.constant.CredentialIterm;

/**
 * This is an abstract class to define the framework of all specific connections
 * @author cqyanbo
 *
 */

public abstract class SocialMediaConnector{
	// TODO: Get the log
	
	Hashtable<CredentialIterm, String> infoPairs = new Hashtable<CredentialIterm, String>();
	public abstract boolean Connect();
	public void addInfoPair(CredentialIterm key, String value){
		infoPairs.put(key, value);
	}
	
	public boolean containsKey(CredentialIterm key){
		if(infoPairs == null || infoPairs.isEmpty() || !infoPairs.containsKey(key)){
			return false;
		}
		return true;
	}
	
	public String getValue(CredentialIterm key){
		if(infoPairs == null || infoPairs.isEmpty() || !infoPairs.containsKey(key)){
			return null;
		}
		return infoPairs.get(key);
	}
}
