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

//Generated 27-nov-2012 10:44:54 by Hibernate Tools 3.4.0.CR1

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
* Evaluator generated by hbm2java
*/
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="evaluators_id_seq", sequenceName="evaluators_id_seq") 
@Table(name = "evaluators", schema = "public")
public class Evaluator implements java.io.Serializable {

	private long id;
	private Test test;
	private AddressType addressType;
	private String filterValue;
	private String evaluator;

	public Evaluator() {
	}

	public Evaluator(long id, Test test) {
		this.id = id;
		this.test = test;
	}

	public Evaluator(long id, Test test, AddressType addressType, String filterValue, String evaluator) {
		this.id = id;
		this.test = test;
		this.addressType = addressType;
		this.filterValue = filterValue;
		this.evaluator = evaluator;
	}

	@Id
	@GeneratedValue(generator="evaluators_id_seq", strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_test", nullable = false)
	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_addresstype", nullable = false)
	public AddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@Column(name = "filtervalue")
	public String getFilterValue() {
		return this.filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	@Column(name = "evaluator")
	public String getEvaluator() {
		return this.evaluator;
	}

	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}
	
	/**
	 * Set the fields of this evaluator with the values from fields from other evaluator.
	 * @param otherEvaluator Other evaluator
	 */
	@Transient
	public void setFromOtherEvaluator(Evaluator otherEvaluator)
	{
		if (otherEvaluator!=null)
		{
			setId(otherEvaluator.getId());
			setTest(otherEvaluator.getTest());
			setAddressType(otherEvaluator.getAddressType());
			setFilterValue(otherEvaluator.getFilterValue());
			setEvaluator(otherEvaluator.getEvaluator());
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean ok=false;
		if (obj instanceof Evaluator)
		{
			if (getId()==0L)
			{
				ok=getTest().equals(((Evaluator)obj).getTest()) && 
					getAddressType().equals(((Evaluator)obj).getAddressType());
				if (ok)
				{
					if (getFilterValue()==null)
					{
						ok=((Evaluator)obj).getFilterValue()==null;
					}
					else
					{
						ok=getFilterValue().equals(((Evaluator)obj).getFilterValue());
					}
					if (ok)
					{
						if (getEvaluator()==null || getEvaluator().equals(""))
						{
							ok=((Evaluator)obj).getEvaluator()==null || ((Evaluator)obj).getEvaluator().equals("");
						}
						else
						{
							ok=getEvaluator().equals(((Evaluator)obj).getEvaluator());
						}
					}
				}
			}
			else
			{
				ok=getId()==((Evaluator)obj).getId();
			}
		}
		return ok;
	}
}
