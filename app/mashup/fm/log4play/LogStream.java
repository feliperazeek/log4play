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
package mashup.fm.log4play;

import play.libs.F.ArchivedEventStream;
import play.libs.F.EventStream;

// TODO: Auto-generated Javadoc
/**
 * The Class LogStream.
 */
public abstract class LogStream {

	/** The stream. */
	public static final ArchivedEventStream<Log4PlayEvent> stream = new ArchivedEventStream<Log4PlayEvent>(50);

	/**
	 * Gets the stream.
	 * 
	 * @return the stream
	 */
	public static EventStream<Log4PlayEvent> getStream() {
		return stream.eventStream();
	}

	/**
	 * Publish.
	 * 
	 * @param event
	 *            the event
	 */
	public static void publish(Log4PlayEvent event) {
		stream.publish(event);
	}

}
