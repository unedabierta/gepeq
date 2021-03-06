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
package es.uned.lsi.gepec.web.services;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.uned.lsi.gepec.model.dao.DaoException;
import es.uned.lsi.gepec.model.dao.FeedbacksDao;
import es.uned.lsi.gepec.model.entities.Feedback;
import es.uned.lsi.gepec.model.entities.Question;
import es.uned.lsi.gepec.util.HibernateUtil.Operation;

/**
 * Manages question feedbacks.
 */
@SuppressWarnings("serial")
@ManagedBean(eager=true)
@ApplicationScoped
public class FeedbacksService implements Serializable
{
	private final static FeedbacksDao FEEDBACKS_DAO=new FeedbacksDao();
	
	public FeedbacksService()
	{
	}
	
	/**
	 * @param id Question feedback identifier
	 * @return Question feedback
	 * @throws ServiceException
	 */
	public Feedback getFeedback(long id) throws ServiceException
	{
		return getFeedback(null,id);
	}
	
	/**
	 * @param operation Operation
	 * @param id Question feedback identifier
	 * @return Question feedback
	 * @throws ServiceException
	 */
	public Feedback getFeedback(Operation operation,long id) throws ServiceException
	{
		Feedback feedback=null;
		try
		{
			FEEDBACKS_DAO.setOperation(operation);
			feedback=FEEDBACKS_DAO.getFeedback(id);
		}
		catch (DaoException de)
		{
			throw new ServiceException(de.getMessage(),de);
		}
		return feedback;
	}
	
	/**
	 * Updates a question feedback.
	 * @param feedback Question feedback to update
	 * @throws ServiceException
	 */
	public void updateFeedback(Feedback feedback) throws ServiceException
	{
		updateFeedback(null,feedback);
	}
	
	/**
	 * Updates a question feedback.
	 * @param operation Operation
	 * @param feedback Question feedback to update
	 * @throws ServiceException
	 */
	public void updateFeedback(Operation operation,Feedback feedback) throws ServiceException
	{
		try
		{
			FEEDBACKS_DAO.setOperation(operation);
			FEEDBACKS_DAO.updateFeedback(feedback);
		}
		catch (DaoException de)
		{
			throw new ServiceException(de.getMessage(),de);
		}
	}
	
	/**
	 * Adds a new question feedback.
	 * @param feedback Question feedback to add
	 * @throws ServiceException
	 */
	public void addFeedback(Feedback feedback) throws ServiceException
	{
		addFeedback(null,feedback);
	}
	
	/**
	 * Adds a new question feedback.
	 * @param operation Operation
	 * @param feedback Question feedback to add
	 * @throws ServiceException
	 */
	public void addFeedback(Operation operation,Feedback feedback) throws ServiceException
	{
		try
		{
			FEEDBACKS_DAO.setOperation(operation);
			FEEDBACKS_DAO.saveFeedback(feedback);
		}
		catch (DaoException de)
		{
			throw new ServiceException(de.getMessage(),de);
		}
	}
	
	/**
	 * Deletes a question feedback.
	 * @param feedback Question feedback to delete
	 * @throws ServiceException
	 */
	public void deleteFeedback(Feedback feedback) throws ServiceException
	{
		deleteFeedback(null,feedback);
	}
	
	/**
	 * Deletes a question feedback.
	 * @param operation Operation
	 * @param feedback Question feedback to delete
	 * @throws ServiceException
	 */
	public void deleteFeedback(Operation operation,Feedback feedback) throws ServiceException
	{
		try
		{
			FEEDBACKS_DAO.setOperation(operation);
			FEEDBACKS_DAO.deleteFeedback(feedback);
		}
		catch (DaoException de)
		{
			throw new ServiceException(de.getMessage(),de);
		}
	}
	
	/**
	 * @param question Question
	 * @return List of feedbacks of a question
	 * @throws ServiceException
	 */
	public List<Feedback> getFeedbacks(Question question) throws ServiceException
	{
		return getFeedbacks(null,question==null?0L:question.getId());
	}
	
	/**
	 * @param questionId Question identifier
	 * @return List of feedbacks of a question
	 * @throws ServiceException
	 */
	public List<Feedback> getFeedbacks(long questionId) throws ServiceException
	{
		return getFeedbacks(null,questionId);
	}
	
	/**
	 * @param operation Operation
	 * @param question Question
	 * @return List of feedbacks of a question
	 * @throws ServiceException
	 */
	public List<Feedback> getFeedbacks(Operation operation,Question question) throws ServiceException
	{
		return getFeedbacks(operation,question==null?0L:question.getId());
	}
	
	/**
	 * @param operation Operation
	 * @param questionId Question identifier
	 * @return List of feedbacks of a question
	 * @throws ServiceException
	 */
	public List<Feedback> getFeedbacks(Operation operation,long questionId) throws ServiceException
	{
		List<Feedback> feedbacks=null;
		try
		{
			FEEDBACKS_DAO.setOperation(operation);
			feedbacks=FEEDBACKS_DAO.getFeedbacks(questionId);
		}
		catch (DaoException de)
		{
			throw new ServiceException(de.getMessage(),de);
		}
		return feedbacks;
	}
}
