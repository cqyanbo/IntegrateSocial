package social.connector;

import social.constant.CredentialIterm;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookConnector extends SocialMediaConnector {

	Facebook facebookConnector;
	
	@Override
	public boolean Connect() {
		try{
			String appId = getValue(CredentialIterm.APP_ID);
			String appSecret = getValue(CredentialIterm.APP_SECRET);
			String accessToken = getValue(CredentialIterm.ACCESS_TOKEN);
			String permission = getValue(CredentialIterm.PERMISSIONS);
			
			if(appId == null || appId.isEmpty()){
				return false;
			}
			if(appSecret == null || appSecret.isEmpty()){
				return false;
			}
			if(accessToken == null || accessToken.isEmpty()){
				return false;
			}
			if(permission == null || permission.isEmpty()){
				return false;
			}
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthAppId(appId)
			  .setOAuthAppSecret(appSecret)
			  .setOAuthAccessToken(accessToken)
			  .setOAuthPermissions(permission);
			FacebookFactory ff = new FacebookFactory(cb.build());
			this.facebookConnector = ff.getInstance();
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
