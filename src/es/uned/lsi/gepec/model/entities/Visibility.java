/* OpenMark Authoring Tool (GEPEQ)
 * Copyright (C) 2013 UNED
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package es.uned.lsi.gepec.model.entities;

//Generated 16-may-2012 16:24:00 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
* Visibilities generated by hbm2java
*/
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="visibilities_id_seq", sequenceName="visibilities_id_seq") 
@Table(name = "visibilities", schema = "public")
public class Visibility implements java.io.Serializable {

	private long id;
	private String visibility;
	private boolean global;
	private int level;
	private Set<Category> categories = new HashSet<Category>(0);

	public Visibility() {
	}

	public Visibility(long id, boolean global, int level) {
		this.id = id;
		this.global = global;
		this.level = level;
	}

	public Visibility(long id, String visibility, boolean global, int level,Set<Category> categories) {
		this.id = id;
		this.visibility = visibility;
		this.global = global;
		this.level = level;
		this.categories = categories;
	}

	@Id
	@GeneratedValue(generator="visibilities_id_seq", strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "visibility", length = 30)
	public String getVisibility() {
		return this.visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	@Column(name = "global", nullable = false)
	public boolean isGlobal() {
		return this.global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	@Column(name = "level", nullable = false)
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "visibility")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	/**
	 * Set the fields of this visibility with the values from fields from other visibility.
	 * @param otherVisibility Other visibility
	 */
	@Transient
	public void setFromOtherVisibility(Visibility otherVisibility)
	{
		if (otherVisibility!=null)
		{
			setId(otherVisibility.getId());
			setVisibility(otherVisibility.getVisibility());
			setGlobal(otherVisibility.isGlobal());
			setLevel(otherVisibility.getLevel());
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Visibility && getId()==((Visibility)obj).getId();
	}
}