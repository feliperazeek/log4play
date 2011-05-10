package mashup.fm.log4play;

import play.PlayPlugin;
import play.mvc.Router;

public class Log4PlayPlugin extends PlayPlugin {

	/**
	 * On application start.
	 */
	@Override
	public void onApplicationStart() {
		Router.addRoute("GET", "/@logs", "Log4Play.index");
		Router.addRoute("WS", "/@logs/stream", "Log4Play.WebSocket.stream");
	}

}
