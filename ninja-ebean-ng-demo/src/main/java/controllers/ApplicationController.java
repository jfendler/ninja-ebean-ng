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
package controllers;

import java.util.List;
import java.util.Map;

import models.GuestBookEntry;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.params.Param;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import dao.GuestbookDao;

/**
 * Controller for the demo web application.
 *
 */
@Singleton
public class ApplicationController {

	/**
	 * The injected EBean server component.
	 */
	@Inject
	protected GuestbookDao guestbookDao;

	/**
	 * Handle a request for the index page, listing all existing guestbook
	 * entries.
	 * 
	 * @return the index page {@link Result}
	 */
	public Result index() {
		// Get all guestbookentries now:
		List<GuestBookEntry> guestBookEntries = guestbookDao.getAllEntries();

		Map<String, Object> toRender = Maps.newHashMap();
		toRender.put("guestBookEntries", guestBookEntries);

		// Default rendering is simple by convention
		// This renders the page in views/ApplicationController/index.ftl.html
		return Results.html().render(toRender);

	}

	/**
	 * Handle a post request to store a new guest book entry in the database.
	 * 
	 * @param email
	 *            the email for the new entry
	 * @param content
	 *            the content for the new entry
	 * @return a redirect {@link Result}
	 */
	public Result post(@Param("email") String email, @Param("content") String content, Context context) {
		if (guestbookDao.createEntry(email, content) == null) {
			context.getFlashScope().error("Could not create new guestbook entry.");
		}
		return Results.redirect("/");
	}
}
