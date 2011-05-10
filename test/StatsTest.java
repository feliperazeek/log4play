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
import mashup.fm.log4play.Stats;

import org.junit.Test;

import play.test.UnitTest;

/**
 * The Class StatsTest.
 */
public class StatsTest extends UnitTest {

	/**
	 * A test.
	 */
	@Test
	public void testStats() {
		Stats<String> stats = new Stats<String>();

		long time = 10l;
		String key = "methodA";
		assertEquals(0, stats.executions(key));

		stats.record(key, time);

		try {
			Thread.sleep(500);
		} catch (Throwable t) {
		}

		assertEquals(1, stats.executions(key));
		assertEquals(time, stats.executionTimes(key));
		assertEquals(time, stats.averageTime(key));

		long time2 = 20;
		stats.record(key, time2);

		try {
			Thread.sleep(500);
		} catch (Throwable t) {
		}

		assertEquals(2, stats.executions(key));
		assertEquals(time + time2, stats.executionTimes(key));
		assertEquals((time + time2) / 2, stats.averageTime(key));

	}

}