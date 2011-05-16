/**
 * Copyright (c) 2011 - 2011, Verizon , All rights reserved.
 * 
 * @author Deepthi
 */
package controllers;

import play.Logger;
import play.libs.F.EventStream;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.WebSocketController;

// TODO: Auto-generated Javadoc
/**
 * The Class Log4Play.
 */
public class Log4Play extends Controller {

	/**
	 * Index.
	 */
	public static void index() {
		render();
	}

	/**
	 * The Class WebSocket.
	 */
	public static class WebSocket extends WebSocketController {

		/**
		 * Index.
		 */
		public static void index() {
			EventStream<play.modules.log4play.Log4PlayEvent> loggingStream = play.modules.log4play.LogStream.getStream();
			while (inbound.isOpen()) {
				try {
					Promise<play.modules.log4play.Log4PlayEvent> promise = loggingStream.nextEvent();
					play.modules.log4play.Log4PlayEvent event = await(promise);
					outbound.sendJson(event);

				} catch (Throwable t) {
					Logger.error(play.modules.log4play.ExceptionUtil.getStackTrace(t));
				}
			}
		}

	}

}