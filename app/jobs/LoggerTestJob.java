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
package jobs;

import mashup.fm.log4play.ExceptionUtil;
import play.Logger;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

// TODO: Auto-generated Javadoc
/**
 * The Class LoggerTestJob.
 */
@OnApplicationStart(async = true)
public class LoggerTestJob extends Job {

	/**
	 * Debug Messages for Testing
	 * 
	 * @see play.jobs.Job#doJob()
	 */
	@Override
	public void doJob() {
		if (Play.mode.equals(Play.Mode.PROD)) {
			return;
		}

		int i = 0;
		while (true) {
			i++;
			String msg = "";
			for (int x = 0; x < 20; x++) {
				msg = msg + "Debug Message " + i + " ";
			}
			Logger.debug(msg);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Logger.error(ExceptionUtil.getStackTrace(e));
			}
		}
	}
}
