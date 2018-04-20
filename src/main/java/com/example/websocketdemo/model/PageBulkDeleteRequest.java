/*
 * Copyright 2014 Tagbangers, Inc.
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
 */

package com.example.websocketdemo.model;

import java.io.Serializable;
import java.util.List;

public class PageBulkDeleteRequest implements Serializable {

	private List<Long> ids;
	private String language;

	public List<Long> getIds() {
		return ids;
	}

	public String getLanguage() {
		return language;
	}

	public static class Builder  {

		private List<Long> ids;
		private String language;

		public Builder() {
		}

		public Builder ids(List<Long> ids) {
			this.ids = ids;
			return this;
		}

		public Builder language(String language) {
			this.language = language;
			return this;
		}

		public PageBulkDeleteRequest build() {
			PageBulkDeleteRequest request = new PageBulkDeleteRequest();
			request.ids = ids;
			request.language = language;
			return request;
		}
	}
}
