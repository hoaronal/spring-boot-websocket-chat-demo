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

package com.example.websocketdemo.domain;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table(name = "tag", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "language"}))
@DynamicInsert
@DynamicUpdate
@SuppressWarnings("serial")
public class Tag extends DomainObject<Long> implements Comparable<Tag> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 200, nullable = false)
	private String name;

	@Column(length = 3, nullable = false)
	private String language;

	@ManyToMany
	@JoinTable(
			name = "post_tag",
			joinColumns = {@JoinColumn(name = "tag_id")},
			inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
	@SortNatural
	private SortedSet<Post> posts = new TreeSet<>();

	@Override
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public SortedSet<Post> getPosts() {
		return posts;
	}

	public void setPosts(SortedSet<Post> posts) {
		this.posts = posts;
	}

//	public int getArticleCount() {
//		return articleCount;
//	}

	@Override
	public String print() {
		return getName();
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int compareTo(Tag tag) {
		return new CompareToBuilder()
				.append(getName(), tag.getName())
				.append(getId(), tag.getId())
				.toComparison();
	}
}
