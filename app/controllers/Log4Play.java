package controllers;

import play.mvc.Controller;
import play.mvc.WebSocketController;

public class Log4Play extends Controller {

	public static void index() {
		render();
	}

	public static class WebSocket extends WebSocketController {

		/**
		 * Index.
		 */
		public static void index() {
			while (inbound.isOpen()) {
				// try {
				// Logger.info("Waiting for next event to be published...");
				// Promise<StatisticsEvent> promise =
				// StatisticsStream.liveStream.nextEvent();
				// /StatisticsEvent event = await(promise);
				// Logger.info("Publishing Event %s to Outbound Subscribers",
				// event);
				// outbound.send(event.toString());

				// } catch (Throwable t) {
				// Logger.error(ExceptionUtil.getStackTrace(t));
				// }
			}
		}

	}

}