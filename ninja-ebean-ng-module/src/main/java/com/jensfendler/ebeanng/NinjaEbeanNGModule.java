/**
 * Copyright (C) 2012 by the original ninja-ebean module authors. Copyright (C)
 * 2016 by Jens Fendler.
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
package com.jensfendler.ebeanng;

import com.avaje.ebean.EbeanServer;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Use this module if you want to enable Ebeans support in your application.
 * 
 * In conf.Module you can simply call <code>
 *    install(new NinjaEbeanNGModule());
 * </code>
 *
 */
public class NinjaEbeanNGModule extends AbstractModule {

	@Override
	protected void configure() {
		// nothing to bind...
	}

	@Provides
	@Singleton
	EbeanServer provideEbeanServer(NinjaEbeanNGServerLifecycle ninjaEbeanServerLifecycle) {
		return ninjaEbeanServerLifecycle.getEbeanServer();
	}

}
