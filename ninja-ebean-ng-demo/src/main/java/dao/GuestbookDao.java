/**
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
package dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.EbeanServer;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import models.GuestBookEntry;

/**
 * Guestbook DAO to handle ORM access.
 * 
 * @author Jens Fendler
 *
 */
@Singleton
public class GuestbookDao {

	private static final Logger LOG = LoggerFactory.getLogger(GuestbookDao.class);

	@Inject
	protected EbeanServer ebeanServer;

	/**
	 * Create a new {@link GuestBookEntry} and persist it to the DB via EBean
	 * 
	 * @param email
	 *            the email of the entry
	 * @param content
	 *            the content of the entry
	 * @return the persisted {@link GuestBookEntry}, or null on error
	 */
	public GuestBookEntry createEntry(String email, String content) {
		GuestBookEntry entry = new GuestBookEntry(email, content);
		try {
			ebeanServer.save(entry);
			return entry;
		} catch (Exception e) {
			LOG.error("Failed to save guestbook entry", e);
			return null;
		}
	}

	/**
	 * Return a list of all {@link GuestBookEntry}s from the database
	 * 
	 * @return a {@link List} of all {@link GuestBookEntry}s from the database
	 */
	public List<GuestBookEntry> getAllEntries() {
		return ebeanServer.find(GuestBookEntry.class).findList();
	}

}
