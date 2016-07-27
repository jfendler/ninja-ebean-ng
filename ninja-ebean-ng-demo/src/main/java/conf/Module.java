/**
 * Copyright (C) 2012 by the original ninja-ebean module authors.
 * 
 * Copyright (C) 2016 by Jens Fendler.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package conf;

import com.google.inject.AbstractModule;
import com.jensfendler.ebeanng.NinjaEbeanNGModule;

/**
 * Configuration of Ninja application modules.
 *
 */
public class Module extends AbstractModule {

	/**
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		// This installs the NinjaEbeanNGModule and handles the lifecycle
		install(new NinjaEbeanNGModule());
	}

}
