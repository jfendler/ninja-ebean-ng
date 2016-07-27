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

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class ReflectionsHelper {

	static public Set<String> findAllClassesInPackage(String packageName) {
		try {
			ClassPath cp = ClassPath.from(ReflectionsHelper.class.getClassLoader());
			ImmutableSet<ClassPath.ClassInfo> classes = cp.getTopLevelClasses(packageName);

			Set<String> classNames = new LinkedHashSet<>();

			for (ClassPath.ClassInfo ci : classes) {
				classNames.add(ci.getName());
			}

			return classNames;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
