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
package es.uned.lsi.gepec.web.backbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.context.FacesContext;

import es.uned.lsi.gepec.model.entities.Evaluator;
import es.uned.lsi.gepec.model.entities.Test;
import es.uned.lsi.gepec.model.entities.User;
import es.uned.lsi.gepec.util.HibernateUtil.Operation;
import es.uned.lsi.gepec.web.TestBean;
import es.uned.lsi.gepec.web.services.LocalizationService;
import es.uned.lsi.gepec.web.services.UserSessionService;
import es.uned.lsi.gepec.web.services.UsersService;

/**
 * Backbean for an evaluator.
 */
@SuppressWarnings("serial")
public class EvaluatorBean implements Serializable
{
	private final static int MAXIMUM_NICKS_DISPLAYED_WITHIN_FILTERING_STRING=10;
	
	private TestBean testBean;
	private long id;
	private String evaluator;
	private String filterType;
	private String filterSubtype;
	private String filterValue;
	
	public EvaluatorBean(String evaluator,String filterType,String filterSubtype,String filterValue)
	{
		this(null,evaluator,filterType,filterSubtype,filterValue);
	}
	
	public EvaluatorBean(TestBean testBean,String evaluator,String filterType,String filterSubtype,
		String filterValue)
	{
		this.testBean=testBean;
		this.id=0L;
		this.evaluator=evaluator;
		this.filterType=filterType;
		this.filterSubtype=filterSubtype;
		this.filterValue=filterValue;
	}
	
	public EvaluatorBean(Evaluator evaluator)
	{
		this(null,evaluator);
	}
	
	public EvaluatorBean(TestBean testBean,Evaluator evaluator)
	{
		this.testBean=testBean;
		setFromEvaluator(evaluator);
	}
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id=id;
	}
	
	public String getEvaluator()
	{
		return evaluator;
	}
	
	public void setEvaluator(String evaluator)
	{
		this.evaluator=evaluator;
	}
	
	public String getFilterType()
	{
		return filterType;
	}
	
	public void setFilterType(String filterType)
	{
		this.filterType=filterType;
	}
	
	public String getFilterSubtype()
	{
		return filterSubtype;
	}
	
	public void setFilterSubtype(String filterSubtype)
	{
		this.filterSubtype=filterSubtype;
	}
	
	public String getFilterValue()
	{
		return filterValue;
	}
	
	public void setFilterValue(String filterValue)
	{
		this.filterValue=filterValue;
	}
	
	public String getFilteringString()
	{
		String filteringString=null;
		FacesContext context=FacesContext.getCurrentInstance();
        ELContext elContext=context.getELContext();
        ELResolver resolver=context.getApplication().getELResolver();
        LocalizationService localizationService=
        	(LocalizationService)resolver.getValue(elContext,null,"localizationService");
        if ("USER_FILTER".equals(getFilterType()))
        {
        	if ("USERS_SELECTION".equals(getFilterSubtype()))
        	{
        		StringBuffer usersNicks=new StringBuffer();
   				if (getFilterValue()!=null && !"".equals(getFilterValue()))
   				{
   					UserSessionService userSessionService=
   						(UserSessionService)resolver.getValue(elContext,null,"userSessionService");
   	        		UsersService usersService=(UsersService)resolver.getValue(elContext,null,"usersService");
   	        		
   	        		// Get current user session Hibernate operation
   	        		Operation operation=userSessionService.getCurrentUserOperation();
   	        		
   	        		String[] sOUCUs=getFilterValue().split(",");
   	        		List<String> checkedOUCUs=new ArrayList<String>();
   	        		int displayedNicks=0;
   	        		for (int i=0;i<sOUCUs.length && displayedNicks<=MAXIMUM_NICKS_DISPLAYED_WITHIN_FILTERING_STRING;i++)
  	       			{
   	       				String sOUCU=sOUCUs[i];
   	       				if (!checkedOUCUs.contains(sOUCU))
   	       				{
   	   	           			User user=usersService.getUserFromOucu(operation,sOUCUs[i]);
   	   	           			if (user!=null)
   	   	           			{
	   	           				if (usersNicks.length()>0)
   	   	           				{
   	   	           					usersNicks.append(", ");
   	   	           				}
   	   	           				if (displayedNicks<MAXIMUM_NICKS_DISPLAYED_WITHIN_FILTERING_STRING)
   	   	           				{
   	   	           					usersNicks.append(user.getNick());
   	   	           				}
   	   	           				else
   	   	           				{
   	   	           					usersNicks.append("...");
   	   	           				}
   	   	           				displayedNicks++;
   	   	           			}
   	   	           			checkedOUCUs.add(sOUCU);
   	       				}
   	       			}
   				}
        		filteringString=localizationService.getLocalizedMessage(
        			"USER_SELECTION_FILTERING").replace("?",usersNicks.toString());
        	}
        	else if ("RANGE_NAME".equals(getFilterSubtype()))
        	{
        		filteringString=localizationService.getLocalizedMessage(
        			"RANGE_NAME_FILTERING").replace("?",getFilterValue().replace("-",".."));
        	}
        	else if ("RANGE_SURNAME".equals(getFilterSubtype()))
        	{
        		filteringString=localizationService.getLocalizedMessage(
        			"RANGE_SURNAME_FILTERING").replace("?",getFilterValue().replace("-",".."));
        	}
        }
        if (filteringString==null)
		{
			filteringString=localizationService.getLocalizedMessage("NO_FILTERING");
		}
        return filteringString;
	}
	
	/**
	 * Set evaluator bean fields from a Evaluator object.
	 * @param evaluator Evaluator object
	 */
	public void setFromEvaluator(Evaluator evaluator)
	{
		setId(evaluator.getId());
		setEvaluator(evaluator.getEvaluator());
		setFilterType(evaluator.getAddressType().getType());
		setFilterSubtype(evaluator.getAddressType().getSubtype());
		setFilterValue(evaluator.getFilterValue());
	}
	
	/**
	 * @param test Test object
	 * @return Evaluator object with data from this evaluator bean
	 */
	public Evaluator getAsEvaluator(Test test)
	{
		return getAsEvaluator(null,test);
	}
	
	/**
	 * @param operation Operation
	 * @param test Test object
	 * @return Evaluator object with data from this evaluator bean
	 */
	public Evaluator getAsEvaluator(Operation operation,Test test)
	{
		return testBean==null?null:new Evaluator(getId(),test,
			testBean.getAddressType(testBean.getCurrentUserOperation(operation),getFilterType(),getFilterSubtype()),
			getFilterValue(),getEvaluator());
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean ok=false;
		if (obj instanceof EvaluatorBean)
		{
			if (getId()==0L)
			{
				ok=((EvaluatorBean)obj).getId()==0L && 
					getFilterType().equals(((EvaluatorBean)obj).getFilterType()) &&
					getFilterSubtype()==null?
					((EvaluatorBean)obj).getFilterSubtype()==null:
					getFilterSubtype().equals(((EvaluatorBean)obj).getFilterSubtype());
				if (ok)
				{
					if (getEvaluator()==null || getEvaluator().equals(""))
					{
						ok=((EvaluatorBean)obj).getEvaluator()==null || 
							((EvaluatorBean)obj).getEvaluator().equals("");
					}
					else
					{
						ok=getEvaluator().equals(((EvaluatorBean)obj).getEvaluator());
					}
				}
			}
			else
			{
				ok=getId()==((EvaluatorBean)obj).getId();
			}
		}
		return ok;
	}
}
