/**
 * Copyright (c) 2011 - 2011, Verizon , All rights reserved.
 * 
 * @author Deepthi
 */
package play.modules.log4play;

import play.Logger;
import play.PlayPlugin;
import play.mvc.Router;

// TODO: Auto-generated Javadoc
/**
 * The Class Log4PlayPlugin.
 */
public class Log4PlayPlugin extends PlayPlugin {

	/**
	 * On application start.
	 */
	@Override
	public void onApplicationStart() {
		// Check Disabled Flag
		boolean disabled = "true".equals(play.Play.configuration.getProperty("log4play.disabled"));
		if ( disabled ) {
			Logger.warn("Log4Play is currently disabled, if you would like to enable it just change configuration property 'log4play.disabled'.");
			return;
		}
		
		// Add appender that will stream log messages as Log4PlayEvent instances
		// through WebSocket (Log4Play.WebSocket.stream)
		PlayWebSocketLogAppender appender = new PlayWebSocketLogAppender();
		Logger.log4j.addAppender(appender);

		// Add routes for the UI
		Router.addRoute("WS", "/logstream", "log4play.Log4Play.WebSocket.index");
		Router.addRoute("GET", "/@logs", "log4play.Log4Play.index");
		Router.addRoute("GET", "/public_log4play/", "staticDir:public_log4play");
	}

}
