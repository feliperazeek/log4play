/** 
 * Copyright 2011 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author Felipe Oliveira (http://mashup.fm)
 * 
 */
package play.modules.log4play;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

/**
 * The Class Log4PlayEvent.
 */
public class Log4PlayEvent {

	/** The level. */
	public String level;

	/** The category. */
	public String category;

	/** The thread. */
	public String thread;

	/** The message. */
	public String message;

	/** The date. */
	public String date;

	/**
	 * Instantiates a new log4 play event.
	 * 
	 * @param event
	 *            the event
	 */
	public Log4PlayEvent(LoggingEvent event) {
		// Define Date Format
		DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();

		// Set Data Fields
		this.category = event.categoryName;
		this.thread = event.getThreadName();
		this.date = dateFormat.format(new Date(event.getTimeStamp()));
		this.message = event.getRenderedMessage();

		// Set Log Level
		if (event.getLevel().toInt() == Level.TRACE_INT) {
			this.level = "TRACE";
		}
		if (event.getLevel().toInt() == Level.DEBUG_INT) {
			this.level = "DEBUG";
		}
		if (event.getLevel().toInt() == Level.INFO_INT) {
			this.level = "INFO";
		}
		if (event.getLevel().toInt() == Level.WARN_INT) {
			this.level = "WARN";
		}
		if (event.getLevel().toInt() == Level.ERROR_INT) {
			this.level = "ERROR";
		}
	}
}
