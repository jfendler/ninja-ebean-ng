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
package models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Guest book entry database model class.
 *
 */
@Entity
@Table(name = "guestbook_entry")
public class GuestBookEntry {

	@Id
	Integer id;

	String email;

	String content;

	@Version
	Timestamp lastUpdate;

	/**
	 * @param email
	 * @param content
	 */
	public GuestBookEntry(String email, String content) {
		this.email = email;
		this.content = content;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}