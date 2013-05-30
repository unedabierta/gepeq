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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import es.uned.lsi.gepec.model.QuestionLevel;

/**
 * Question generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="question_id_seq", sequenceName="question_id_seq") 
@Table(name = "questions", schema = "public")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Question implements java.io.Serializable {
	protected long id;
	protected String version;
	protected Category category;
	protected Resource resource;
	protected Resource correctFeedbackResource;
	protected Resource incorrectFeedbackResource;
	protected Resource passFeedbackResource;
	protected Resource finalFeedbackResource;
	protected String name;
	protected String questionText;
	protected String type;
	protected User createdBy;
	protected User modifiedBy;
	protected Date timeCreated;
	protected Date timeModified;
	protected Date timeBuild;
	protected Date timeDeploy;
	protected Date timePublished;
	protected String correctFeedback;
	protected String incorrectFeedback;
	protected String stillFeedback;
	protected String passFeedback;
	protected String answerFeedback;
	protected QuestionLevel level;
	protected int resourceWidth;
	protected int resourceHeight;
	protected int correctFeedbackResourceWidth;
	protected int correctFeedbackResourceHeight;
	protected int incorrectFeedbackResourceWidth;
	protected int incorrectFeedbackResourceHeight;
	protected int passFeedbackResourceWidth;
	protected int passFeedbackResourceHeight;
	protected int finalFeedbackResourceWidth;
	protected int finalFeedbackResourceHeight;
	protected boolean displayEquations;
	protected List<Answer> answers = new ArrayList<Answer>(0);
	protected List<QuestionResource> questionResources = new ArrayList<QuestionResource>(0);
	protected List<Feedback> feedbacks = new ArrayList<Feedback>(0);
	protected List<QuestionOrder> questionOrders = new ArrayList<QuestionOrder>(0);

	public Question() {
		this.name = "";
		this.level = QuestionLevel.NORMAL;
		this.version = "";
		this.resource = null;
		this.correctFeedbackResource = null;
		this.incorrectFeedbackResource = null;
		this.passFeedbackResource = null;
		this.finalFeedbackResource = null;
		this.resourceWidth = -1;
		this.resourceHeight = -1;
		this.correctFeedbackResourceWidth = -1;
		this.correctFeedbackResourceHeight = -1;
		this.incorrectFeedbackResourceWidth = -1;
		this.incorrectFeedbackResourceHeight = -1;
		this.passFeedbackResourceWidth = -1;
		this.passFeedbackResourceHeight = -1;
		this.finalFeedbackResourceWidth = -1;
		this.finalFeedbackResourceHeight = -1;
	}

	public Question(long id, Category category, Resource resource, int resourceWidth, int resourceHeight,
			Resource correctFeedbackResource, int correctFeedbackResourceWidth, int correctFeedbackResourceHeight,
			Resource incorrectFeedbackResource, int incorrectFeedbackResourceWidth, int incorrectFeedbackResourceHeight,
			Resource passFeedbackResource, int passFeedbackResourceWidth, int passFeedbackResourceHeight,
			Resource finalFeedbackResource, int finalFeedbackResourceWidth, int finalFeedbackResourceHeight,
			String name, String questionText, User createdBy, Date timecreated, User modifiedBy,
			Date timemodified, Date timeBuild, Date timeDeploy, Date timePublished, String correctFeedback,
			String incorrectFeedback, String stillFeedback, String passFeedback, String answerFeedback, 
			boolean displayEquations, List<Answer> answers, List<Feedback> feedbacks) {
		this.id = id;
		this.category = category;
		this.resource = resource;
		this.resourceWidth = resourceWidth;
		this.resourceHeight = resourceHeight;
		this.correctFeedbackResource = correctFeedbackResource;
		this.correctFeedbackResourceWidth = correctFeedbackResourceWidth;
		this.correctFeedbackResourceHeight = correctFeedbackResourceHeight;
		this.incorrectFeedbackResource = incorrectFeedbackResource;
		this.incorrectFeedbackResourceWidth = incorrectFeedbackResourceWidth;
		this.incorrectFeedbackResourceHeight = incorrectFeedbackResourceHeight;
		this.passFeedbackResource = passFeedbackResource;
		this.passFeedbackResourceWidth = passFeedbackResourceWidth;
		this.passFeedbackResourceHeight = passFeedbackResourceHeight;
		this.finalFeedbackResource = finalFeedbackResource;
		this.finalFeedbackResourceWidth = finalFeedbackResourceWidth;
		this.finalFeedbackResourceHeight = finalFeedbackResourceHeight;
		this.questionText = questionText;
		this.createdBy = createdBy;
		this.timeCreated = timecreated;
		this.modifiedBy = modifiedBy;
		this.timeModified = timemodified;
		this.timeBuild = timeBuild;
		this.timeDeploy = timeDeploy;
		this.timePublished = timePublished;
		this.correctFeedback = correctFeedback;
		this.incorrectFeedback = incorrectFeedback;
		this.stillFeedback = stillFeedback;
		this.passFeedback = passFeedback;
		this.answerFeedback = answerFeedback;
		this.displayEquations = displayEquations;
		this.answers = answers;
		this.feedbacks = feedbacks;
	}

	@Id
	@GeneratedValue(generator="question_id_seq", strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "version", length = 50)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_resource")
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_correct_feedback_resource")
	public Resource getCorrectFeedbackResource() {
		return this.correctFeedbackResource;
	}

	public void setCorrectFeedbackResource(Resource correctFeedbackResource) {
		this.correctFeedbackResource = correctFeedbackResource;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_incorrect_feedback_resource")
	public Resource getIncorrectFeedbackResource() {
		return this.incorrectFeedbackResource;
	}

	public void setIncorrectFeedbackResource(Resource incorrectFeedbackResource) {
		this.incorrectFeedbackResource = incorrectFeedbackResource;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pass_feedback_resource")
	public Resource getPassFeedbackResource() {
		return this.passFeedbackResource;
	}

	public void setPassFeedbackResource(Resource passFeedbackResource) {
		this.passFeedbackResource = passFeedbackResource;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_final_feedback_resource")
	public Resource getFinalFeedbackResource() {
		return this.finalFeedbackResource;
	}

	public void setFinalFeedbackResource(Resource finalFeedbackResource) {
		this.finalFeedbackResource = finalFeedbackResource;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "question_text")
	public String getQuestionText() {
		return this.questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Column(name = "type", nullable = false, length = 25)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_createdby", nullable = false)
	public User getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timecreated", length = 35)
	public Date getTimecreated() {
		return this.timeCreated;
	}

	public void setTimecreated(Date timecreated) {
		this.timeCreated = timecreated;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modifiedby")
	public User getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timemodified", length = 35)
	public Date getTimemodified() {
		return this.timeModified;
	}

	public void setTimemodified(Date timemodified) {
		this.timeModified = timemodified;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timebuild", length = 35)
	public Date getTimebuild() {
		return this.timeBuild;
	}

	public void setTimebuild(Date timebuild) {
		this.timeBuild = timebuild;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timedeploy", length = 35)
	public Date getTimedeploy() {
		return this.timeDeploy;
	}

	public void setTimedeploy(Date timedeploy) {
		this.timeDeploy = timedeploy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timepublished", length = 35)
	public Date getTimepublished() {
		return this.timePublished;
	}

	public void setTimepublished(Date timepublished) {
		this.timePublished = timepublished;
	}

	@Column(name = "correct_feedback")
	public String getCorrectFeedback() {
		return this.correctFeedback;
	}

	public void setCorrectFeedback(String correctFeedback) {
		this.correctFeedback = correctFeedback;
	}

	@Column(name = "incorrect_feedback")
	public String getIncorrectFeedback() {
		return this.incorrectFeedback;
	}

	public void setIncorrectFeedback(String incorrectFeedback) {
		this.incorrectFeedback = incorrectFeedback;
	}
	
	@Column(name = "still_feedback")
	public String getStillFeedback() {
		return this.stillFeedback;
	}

	public void setStillFeedback(String stillFeedback) {
		this.stillFeedback = stillFeedback;
	}

	@Column(name = "pass_feedback")
	public String getPassFeedback() {
		return this.passFeedback;
	}

	public void setPassFeedback(String passFeedback) {
		this.passFeedback = passFeedback;
	}

	@Column(name = "answer_feedback")
	public String getAnswerFeedback() {
		return this.answerFeedback;
	}

	public void setAnswerFeedback(String answerFeedback) {
		this.answerFeedback = answerFeedback;
	}
	
	@Column(name = "level", nullable = false, length = 10)
	public String getLevelString() {
		return this.level.toString();
	}

	public void setLevelString(String level) {
		this.level = QuestionLevel.valueOf(level);
	}
	
	@Transient
	public QuestionLevel getLevel() {
		return this.level;
	}

	public void setLevel(QuestionLevel level) {
		this.level = level;
	}
	
	@Column(name = "resource_width", nullable = false)
	public int getResourceWidth() {
		return this.resourceWidth;
	}

	public void setResourceWidth(int resourceWidth) {
		this.resourceWidth = resourceWidth;
	}

	@Column(name = "resource_height", nullable = false)
	public int getResourceHeight() {
		return this.resourceHeight;
	}

	public void setResourceHeight(int resourceHeight) {
		this.resourceHeight = resourceHeight;
	}

	@Column(name = "correct_feedback_resource_width", nullable = false)
	public int getCorrectFeedbackResourceWidth() {
		return this.correctFeedbackResourceWidth;
	}

	public void setCorrectFeedbackResourceWidth(int correctFeedbackResourceWidth) {
		this.correctFeedbackResourceWidth = correctFeedbackResourceWidth;
	}

	@Column(name = "correct_feedback_resource_height", nullable = false)
	public int getCorrectFeedbackResourceHeight() {
		return this.correctFeedbackResourceHeight;
	}

	public void setCorrectFeedbackResourceHeight(int correctFeedbackResourceHeight) {
		this.correctFeedbackResourceHeight = correctFeedbackResourceHeight;
	}

	@Column(name = "incorrect_feedback_resource_width", nullable = false)
	public int getIncorrectFeedbackResourceWidth() {
		return this.incorrectFeedbackResourceWidth;
	}

	public void setIncorrectFeedbackResourceWidth(int incorrectFeedbackResourceWidth) {
		this.incorrectFeedbackResourceWidth = incorrectFeedbackResourceWidth;
	}

	@Column(name = "incorrect_feedback_resource_height", nullable = false)
	public int getIncorrectFeedbackResourceHeight() {
		return this.incorrectFeedbackResourceHeight;
	}

	public void setIncorrectFeedbackResourceHeight(int incorrectFeedbackResourceHeight) {
		this.incorrectFeedbackResourceHeight = incorrectFeedbackResourceHeight;
	}

	@Column(name = "pass_feedback_resource_width", nullable = false)
	public int getPassFeedbackResourceWidth() {
		return this.passFeedbackResourceWidth;
	}

	public void setPassFeedbackResourceWidth(int passFeedbackResourceWidth) {
		this.passFeedbackResourceWidth = passFeedbackResourceWidth;
	}

	@Column(name = "pass_feedback_resource_height", nullable = false)
	public int getPassFeedbackResourceHeight() {
		return this.passFeedbackResourceHeight;
	}

	public void setPassFeedbackResourceHeight(int passFeedbackResourceHeight) {
		this.passFeedbackResourceHeight = passFeedbackResourceHeight;
	}

	@Column(name = "final_feedback_resource_width", nullable = false)
	public int getFinalFeedbackResourceWidth() {
		return this.finalFeedbackResourceWidth;
	}

	public void setFinalFeedbackResourceWidth(int finalFeedbackResourceWidth) {
		this.finalFeedbackResourceWidth = finalFeedbackResourceWidth;
	}

	@Column(name = "final_feedback_resource_height", nullable = false)
	public int getFinalFeedbackResourceHeight() {
		return this.finalFeedbackResourceHeight;
	}

	public void setFinalFeedbackResourceHeight(int finalFeedbackResourceHeight) {
		this.finalFeedbackResourceHeight = finalFeedbackResourceHeight;
	}

	@Column(name = "display_equations", nullable = false)
	public boolean isDisplayEquations() {
		return this.displayEquations;
	}

	public void setDisplayEquations(boolean displayEquations) {
		this.displayEquations = displayEquations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	public List<QuestionOrder> getSection_questions() {
		return this.questionOrders;
	}

	public void setSection_questions(List<QuestionOrder> questionOrders) {
		this.questionOrders = questionOrders;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	@Transient
	public Answer getAnswer(int position)
	{
		Answer answer=null;
		for (Answer a:answers)
		{
			if (a.getPosition()==position)
			{
				answer=a;
				break;
			}
		}
		return answer;
	}
	
	public void addAnswer(Answer answer)
	{
		answers.add(answer);
		answer.setPosition(answers.size());
		answer.setQuestion(this);
	}
	
	public boolean removeAnswer(int position)
	{
		boolean ok=false;
		Answer toRemove=getAnswer(position);
		if (toRemove!=null)
		{
			ok=true;
			answers.remove(toRemove);
			
			// We renumber answers
			for (Answer answer:answers)
			{
				int answerPos=answer.getPosition();
				if (answerPos>position)
				{
					answer.setPosition(answerPos-1);
				}
			}
		}
		return ok;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
	public List<QuestionResource> getQuestionResources() {
		return this.questionResources;
	}
	
	public void setQuestionResources(List<QuestionResource> questionResources) {
		this.questionResources=questionResources;
	}
	
	@Transient
	public QuestionResource getQuestionResource(int position)
	{
		QuestionResource questionResource=null;
		for (QuestionResource qr:questionResources)
		{
			if (qr.getPosition()==position)
			{
				questionResource=qr;
				break;
			}
		}
		return questionResource;
	}
	
	public void addQuestionResource(QuestionResource questionResource)
	{
		questionResources.add(questionResource);
		questionResource.setPosition(questionResources.size());
		questionResource.setQuestion(this);
	}
	
	public boolean removeQuestionResource(int position)
	{
		boolean ok=false;
		QuestionResource toRemove=getQuestionResource(position);
		if (toRemove!=null)
		{
			ok=true;
			questionResources.remove(toRemove);
			
			// We renumber resources of question
			for (QuestionResource questionResource:questionResources)
			{
				int questionResourcePos=questionResource.getPosition();
				if (questionResourcePos>position)
				{
					questionResource.setPosition(questionResourcePos-1);
				}
			}
		}
		return ok;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
	public List<Feedback> getFeedbacks()
	{
		return feedbacks;
	}
	
	public void setFeedbacks(List<Feedback> feedbacks)
	{
		this.feedbacks=feedbacks;
	}
	
	@Transient
	public Feedback getFeedback(int position)
	{
		Feedback feedback=null;
		for (Feedback f:feedbacks)
		{
			if (f.getPosition()==position)
			{
				feedback=f;
				break;
			}
		}
		return feedback;
	}
	
	public void addFeedback(Feedback feedback)
	{
		feedbacks.add(feedback);
		feedback.setQuestion(this);
	}
	
	public boolean removeFeedback(int position)
	{
		boolean ok=false;
		Feedback toRemove=getFeedback(position);
		if (toRemove!=null)
		{
			ok=true;
			feedbacks.remove(toRemove);
			
			// Now we renumber feedbacks
			for (Feedback feedback:feedbacks)
			{
				int feedbackPos=feedback.getPosition();
				if (feedbackPos>position)
				{
					feedback.setPosition(feedbackPos-1);
				}
			}
		}
		return ok;
	}
	
	//TODO creo que no se usa... pensar si cambiar para que tenga en cuenta todos los recursos que dependen de la pregunta o si eliminar
	@Transient
	public List<String> getResourceNames()
	{
		ArrayList<String> resourceNames = new ArrayList<String>();
		if(resource != null)
		{
			resourceNames.add(resource.getFileName());
		}
		
		return resourceNames;
	}
	
	@Transient
	public String getPackage()
	{
		StringBuffer packageName=new StringBuffer();
		packageName.append('u');
		packageName.append(getCreatedBy().getId());
		packageName.append(".q");
		packageName.append(getId());
		return packageName.toString();
	}
	
	@Transient
	public List<Answer> getAnswersSortedByPosition()
	{
		List<Answer> sortedAnswers=new ArrayList<Answer>(answers.size());
		for (Answer answer:answers)
		{
			sortedAnswers.add(answer);
		}
		Collections.sort(sortedAnswers,new Comparator<Answer>()
		{
			@Override
			public int compare(Answer a1,Answer a2)
			{
				return a1.getPosition()==a2.getPosition()?0:a1.getPosition()>a2.getPosition()?1:-1;
			}
		});
		return sortedAnswers;
	}
	
	@Transient
	public List<QuestionResource> getQuestionResourcesSortedByPosition()
	{
		List<QuestionResource> sortedQuestionResources=new ArrayList<QuestionResource>(questionResources.size());
		for (QuestionResource questionResource:questionResources)
		{
			sortedQuestionResources.add(questionResource);
		}
		Collections.sort(sortedQuestionResources,new Comparator<QuestionResource>()
		{
			@Override
			public int compare(QuestionResource qr1,QuestionResource qr2)
			{
				return qr1.getPosition()==qr2.getPosition()?0:qr1.getPosition()>qr2.getPosition()?1:-1;
			}
		});
		return sortedQuestionResources;
	}
	
	@Transient
	public List<Feedback> getFeedbacksSortedByPosition()
	{
		List<Feedback> sortedFeedbacks=new ArrayList<Feedback>(feedbacks.size());
		for (Feedback feedback:feedbacks)
		{
			sortedFeedbacks.add(feedback);
		}
		Collections.sort(sortedFeedbacks,new Comparator<Feedback>()
		{
			@Override
			public int compare(Feedback f1,Feedback f2)
			{
				return f1.getPosition()==f2.getPosition()?0:f1.getPosition()>f2.getPosition()?1:-1;
			}
		});
		return sortedFeedbacks;
	}
	
	/**
	 * Set the fields of this question with the values from fields from other question.
	 * @param otherQuestion Other question
	 */
	@Transient
	public void setFromOtherQuestion(Question otherQuestion)
	{
		if (otherQuestion!=null)
		{
			setId(otherQuestion.getId());
			setVersion(otherQuestion.getVersion());
			setCategory(otherQuestion.getCategory());
			setResource(otherQuestion.getResource());
			setCorrectFeedbackResource(otherQuestion.getCorrectFeedbackResource());
			setIncorrectFeedbackResource(otherQuestion.getIncorrectFeedbackResource());
			setPassFeedbackResource(otherQuestion.getPassFeedbackResource());
			setFinalFeedbackResource(otherQuestion.getFinalFeedbackResource());
			setName(otherQuestion.getName());
			setQuestionText(otherQuestion.getQuestionText());
			setType(otherQuestion.getType());
			setCreatedBy(otherQuestion.getCreatedBy());
			setModifiedBy(otherQuestion.getModifiedBy());
			setTimecreated(otherQuestion.getTimecreated());
			setTimemodified(otherQuestion.getTimemodified());
			setTimebuild(otherQuestion.getTimebuild());
			setTimedeploy(otherQuestion.getTimedeploy());
			setTimepublished(otherQuestion.getTimepublished());
			setCorrectFeedback(otherQuestion.getCorrectFeedback());
			setIncorrectFeedback(otherQuestion.getIncorrectFeedback());
			setStillFeedback(otherQuestion.getStillFeedback());
			setPassFeedback(otherQuestion.getPassFeedback());
			setAnswerFeedback(otherQuestion.getAnswerFeedback());
			setLevelString(otherQuestion.getLevelString());
			setResourceWidth(otherQuestion.getResourceWidth());
			setResourceHeight(otherQuestion.getResourceHeight());
			setCorrectFeedbackResourceWidth(otherQuestion.getCorrectFeedbackResourceWidth());
			setCorrectFeedbackResourceHeight(otherQuestion.getCorrectFeedbackResourceHeight());
			setIncorrectFeedbackResourceWidth(otherQuestion.getIncorrectFeedbackResourceWidth());
			setIncorrectFeedbackResourceHeight(otherQuestion.getIncorrectFeedbackResourceHeight());
			setPassFeedbackResourceWidth(otherQuestion.getPassFeedbackResourceWidth());
			setPassFeedbackResourceHeight(otherQuestion.getPassFeedbackResourceHeight());
			setFinalFeedbackResourceWidth(otherQuestion.getFinalFeedbackResourceWidth());
			setFinalFeedbackResourceHeight(otherQuestion.getFinalFeedbackResourceHeight());
			setDisplayEquations(otherQuestion.isDisplayEquations());
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Question && getId()==((Question)obj).getId();
	}
}
