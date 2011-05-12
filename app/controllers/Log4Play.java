/**
 * Copyright (c) 2011 - 2011, Verizon , All rights reserved.
 * 
 * @author Deepthi
 */
package controllers;

import mashup.fm.log4play.ExceptionUtil;
import mashup.fm.log4play.Log4PlayEvent;
import mashup.fm.log4play.LogStream;
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
			EventStream<Log4PlayEvent> loggingStream = LogStream.getStream();
			while (inbound.isOpen()) {
				try {
					Promise<Log4PlayEvent> promise = loggingStream.nextEvent();
					Log4PlayEvent event = await(promise);
					outbound.sendJson(event);

				} catch (Throwable t) {
					Logger.error(ExceptionUtil.getStackTrace(t));
				}
			}
		}

	}

}