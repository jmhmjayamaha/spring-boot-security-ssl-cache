package lk.harshana.app.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebContainerConfig {

	private static final String USER_CONSTRAINT = "CONFIDENTIAL";
	private static final String CONNECTOR_NAME = "org.apache.coyote.http11.Http11NioProtocol";
	
	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint constraint = new SecurityConstraint();
//				constraint.setUserConstraint(USER_CONSTRAINT);
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				constraint.addCollection(collection);
//				context.addConstraint(constraint);				
//			}			
//		};
		CustomTomcatServletWebServverFactory tomcat = new CustomTomcatServletWebServverFactory();
		tomcat.addAdditionalTomcatConnectors(createSSLConnector());
		return tomcat;
	}
	
	static final class CustomTomcatServletWebServverFactory extends TomcatServletWebServerFactory {
		
		@Override
		protected void postProcessContext(Context context) {
			SecurityConstraint constraint = new SecurityConstraint();
			constraint.setUserConstraint(USER_CONSTRAINT);
			SecurityCollection collection = new SecurityCollection();
			collection.addPattern("/*");
			constraint.addCollection(collection);
			context.addConstraint(constraint);				
		}
	}
	
	private Connector createSSLConnector() {
		Connector connector = new Connector(CONNECTOR_NAME);
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setRedirectPort(8443);
		connector.setSecure(false);
		
		return connector;
	}
}
