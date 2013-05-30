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

//Generated 22-may-2013 11:28:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
* QuestionResource generated by hbm2java
*/
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="questionresources_id_seq", sequenceName="questionresources_id_seq") 
@Table(name = "questionresources", schema = "public")
public class QuestionResource implements java.io.Serializable {

	private long id;
	private Question question;
	private Resource resource;
	private int position;
	private String name;
	private int width;
	private int height;

	public QuestionResource() {
	}

	public QuestionResource(long id, Question question, Resource resource, 
			int position) {
		this.id = id;
		this.question = question;
		this.resource = resource;
		this.position = position;
		this.name = "";
		this.width = -1;
		this.height = -1;
	}

	public QuestionResource(long id, Question question, Resource resource,
			int position, String name, int width, int height) {
		this.id = id;
		this.question = question;
		this.resource = resource;
		this.position = position;
		this.name = name;
		this.width = width;
		this.height = height;
	}

	@Id
	@GeneratedValue(generator="questionresources_id_seq", strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question", nullable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_resource", nullable = false)
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Column(name = "position", nullable = false)
	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Column(name = "name", length = 15)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "width", nullable = false)
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Column(name = "height", nullable = false)
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Set the fields of this resource of a question with the values from fields from other question of a resource.
	 * @param otherQuestionResource Other question of a resource
	 */
	@Transient
	public void setFromOtherQuestionResource(QuestionResource otherQuestionResource)
	{
		if (otherQuestionResource!=null)
		{
			setId(otherQuestionResource.getId());
			setQuestion(otherQuestionResource.getQuestion());
			setResource(otherQuestionResource.getResource());
			setPosition(otherQuestionResource.getPosition());
			setName(otherQuestionResource.getName());
			setWidth(otherQuestionResource.getWidth());
			setHeight(otherQuestionResource.getHeight());
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean ok=false;
		if (obj instanceof QuestionResource)
		{
			if (getId()==0L)
			{
				if (getQuestion()==null)
				{
					ok=((QuestionResource)obj).getId()==0L && ((QuestionResource)obj).getQuestion()==null &&
						getPosition()==((QuestionResource)obj).getPosition();
				}
				else
				{
					ok=((QuestionResource)obj).getId()==0L && 
						getQuestion().equals(((QuestionResource)obj).getQuestion()) && 
						getPosition()==((QuestionResource)obj).getPosition();
				}
			}
			else
			{
				ok=getId()==((QuestionResource)obj).getId();
			}
		}
		return ok;
	}
}
