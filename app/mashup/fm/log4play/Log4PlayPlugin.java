/**
 * Copyright (c) 2011 - 2011, Verizon , All rights reserved.
 * 
 * @author Deepthi
 */
package mashup.fm.log4play;

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
	PlayWebSocketLogAppender appender = new PlayWebSocketLogAppender();
	// setting the PlayWebSocketLogAppender on the play logger

	Logger.log4j.addAppender(appender);
	Logger.info("appender is "
		+ Logger.log4j.getAppender("PlayWebSocketLogAppender"));

	// using HTMLLayout for displaying on UI
	Router.addRoute("GET", "/@logs", "Log4Play.index");
	Router.addRoute("WS", "/@logs/stream", "Log4Play.WebSocket.stream");
    }

}
