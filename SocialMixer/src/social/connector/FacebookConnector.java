package social.connector;

import social.constant.CredentialIterm;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookConnector extends SocialMediaConnector {

	Facebook facebookConnector;
	
	public FacebookConnector() {
		Connect();
	}
	
	@Override
	public boolean Connect() {
		try{
			String appId = getValue(CredentialIterm.FACEBOOK_APP_ID);
			String appSecret = getValue(CredentialIterm.FACEBOOK_APP_SECRET);
			String accessToken = getValue(CredentialIterm.FACEBOOK_ACCESS_TOKEN);
			String permission = getValue(CredentialIterm.FACEBOOK_PERMISSIONS);
			
			if(appId == null || appId.isEmpty()){
				return false;
			}
			if(appSecret == null || appSecret.isEmpty()){
				return false;
			}
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthAppId(appId)
			  .setOAuthAppSecret(appSecret)
			  .setOAuthAccessToken(accessToken);
			FacebookFactory ff = new FacebookFactory(cb.build());
			this.facebookConnector = ff.getInstance();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public ResponseList<Post> getPosts() throws FacebookException{
		return facebookConnector.getPosts();
	}
}
