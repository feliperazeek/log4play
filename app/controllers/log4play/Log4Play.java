package controllers.log4play;

import play.Logger;
import play.libs.F.EventStream;
import play.libs.F.Promise;
import play.modules.log4play.LogStream;
import play.mvc.Controller;
import play.mvc.WebSocketController;

public class Log4Play extends Controller {

	public static void index() {
		render();
	}

	public static class WebSocket extends WebSocketController {

		public static void index() {
			EventStream loggingStream = LogStream.getStream();
			while (inbound.isOpen()) {
				try {
					Promise promise = loggingStream.nextEvent();
					play.modules.log4play.Log4PlayEvent event = await(promise);
					outbound.sendJson(event);

				} catch (Throwable t) {
					Logger.error(t, null);
				}
			}
		}

	}

}