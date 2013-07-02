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

// Generated 17-jul-2011 1:27:48 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Cuestionario generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="tests_id_seq", sequenceName="tests_id_seq") 
@Table(name = "tests", schema = "public")
public class Test implements java.io.Serializable {
	private long id;
	private String name;
	private Category category;
	private String description;
	private String title;
	private Assessement assessement;
	private ScoreType scoreType;
	private boolean allUsersAllowed;
	private boolean allowAdminReports;
	private User createdBy;
	private User modifiedBy;
	private Date timecreated;
	private Date timemodified;
	private Date timetestdeploy;
	private Date timedeploydeploy;
	private Date startDate;
	private Date closeDate;
	private Date warningDate;
	private Date feedbackDate;
	private boolean freesummary;
	private boolean freestop;
	private boolean summaryquestions;
	private boolean summaryscores;
	private boolean summaryattempts;
	private boolean navigation;
	private NavLocation navLocation;
	private RedoQuestionValue redoQuestion;
	private boolean redotest;
	private String presentationTitle;
	private String presentation;
	private String preliminarysummaryTitle;
	private String preliminarysummaryButton;
	private String preliminarysummary;
	private boolean feedbackDisplaysummary;
	private boolean feedbackDisplaysummarymarks;
	private boolean feedbackDisplaysummaryattempts;
	private String feedbackSummaryprevious;
	private boolean feedbackDisplayscores;
	private boolean feedbackDisplayscoresmarks;
	private boolean feedbackDisplayscorespercentages;
	private String feedbackScoresprevious;
	private String feedbackAdvancedprevious;
	private String feedbackAdvancednext;
	private List<Section> sections = new ArrayList<Section>(0);
	private List<TestFeedback> testFeedbacks = new ArrayList<TestFeedback>(0);
	private List<SupportContact> supportContacts = new ArrayList<SupportContact>(0);
	private List<Evaluator> evaluators = new ArrayList<Evaluator>(0);
	private List<TestUser> testUsers = new ArrayList<TestUser>(0);
	private String userGroups;
	private String adminGroups;
	
	public Test() {
		addSection(new Section());
	}

	public Test(long id, String name, Category category, User createdBy, Date timecreated) {
		this.id=id;
		this.name=name;
		this.category=category;
		this.createdBy=createdBy;
		this.timecreated=timecreated;
	}

	@Id
	@GeneratedValue(generator="tests_id_seq", strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "title", length = 25)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_assessement")
	public Assessement getAssessement() {
		return this.assessement;
	}

	public void setAssessement(Assessement assessement) {
		this.assessement = assessement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_scoretype")
	public ScoreType getScoreType() {
		return this.scoreType;
	}

	public void setScoreType(ScoreType scoreType) {
		this.scoreType = scoreType;
	}

	@Column(name = "all_users_allowed", nullable = false)
	public boolean isAllUsersAllowed() {
		return this.allUsersAllowed;
	}

	public void setAllUsersAllowed(boolean allUsersAllowed) {
		this.allUsersAllowed = allUsersAllowed;
	}

	@Column(name = "allow_admin_reports", nullable = false)
	public boolean isAllowAdminReports() {
		return this.allowAdminReports;
	}

	public void setAllowAdminReports(boolean allowAdminReports) {
		this.allowAdminReports = allowAdminReports;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_createdby", nullable = false)
	public User getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modifiedby", nullable = false)
	public User getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timecreated", length = 35)
	public Date getTimeCreated() {
		return this.timecreated;
	}

	public void setTimeCreated(Date timecreated) {
		this.timecreated = timecreated;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timemodified", length = 35)
	public Date getTimeModified() {
		return this.timemodified;
	}

	public void setTimeModified(Date timemodified) {
		this.timemodified = timemodified;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timetestdeploy", length = 35)
	public Date getTimeTestDeploy() {
		return this.timetestdeploy;
	}

	public void setTimeTestDeploy(Date timetestdeploy) {
		this.timetestdeploy = timetestdeploy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timedeploydeploy", length = 35)
	public Date getTimeDeployDeploy() {
		return this.timedeploydeploy;
	}

	public void setTimeDeployDeploy(Date timedeploydeploy) {
		this.timedeploydeploy = timedeploydeploy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", length = 35)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "close_date", length = 35)
	public Date getCloseDate() {
		return this.closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "warning_date", length = 35)
	public Date getWarningDate() {
		return this.warningDate;
	}

	public void setWarningDate(Date warningDate) {
		this.warningDate = warningDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "feedback_date", length = 35)
	public Date getFeedbackDate() {
		return this.feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	@Column(name = "freesummary", nullable = false)
	public boolean isFreeSummary() {
		return this.freesummary;
	}

	public void setFreeSummary(boolean freesummary) {
		this.freesummary = freesummary;
	}

	@Column(name = "freestop", nullable = false)
	public boolean isFreeStop() {
		return this.freestop;
	}

	public void setFreeStop(boolean freestop) {
		this.freestop = freestop;
	}

	@Column(name = "summaryquestions", nullable = false)
	public boolean isSummaryQuestions() {
		return this.summaryquestions;
	}

	public void setSummaryQuestions(boolean summaryquestions) {
		this.summaryquestions = summaryquestions;
	}

	@Column(name = "summaryscores", nullable = false)
	public boolean isSummaryScores() {
		return this.summaryscores;
	}

	public void setSummaryScores(boolean summaryscores) {
		this.summaryscores = summaryscores;
	}

	@Column(name = "summaryattempts", nullable = false)
	public boolean isSummaryAttempts() {
		return this.summaryattempts;
	}

	public void setSummaryAttempts(boolean summaryattempts) {
		this.summaryattempts = summaryattempts;
	}

	@Column(name = "navigation", nullable = false)
	public boolean isNavigation() {
		return this.navigation;
	}

	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_navlocation")
	public NavLocation getNavLocation() {
		return this.navLocation;
	}

	public void setNavLocation(NavLocation navLocation) {
		this.navLocation = navLocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_redoquestion")
	public RedoQuestionValue getRedoQuestion() {
		return this.redoQuestion;
	}

	public void setRedoQuestion(RedoQuestionValue redoQuestion) {
		this.redoQuestion = redoQuestion;
	}

	@Column(name = "redotest", nullable = false)
	public boolean isRedoTest() {
		return this.redotest;
	}

	public void setRedoTest(boolean redotest) {
		this.redotest = redotest;
	}

	@Column(name = "presentation_title", length = 25)
	public String getPresentationTitle() {
		return this.presentationTitle;
	}

	public void setPresentationTitle(String presentationTitle) {
		this.presentationTitle = presentationTitle;
	}

	@Column(name = "presentation")
	public String getPresentation() {
		return this.presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	@Column(name = "preliminarysummary_title", length = 25)
	public String getPreliminarySummaryTitle() {
		return this.preliminarysummaryTitle;
	}

	public void setPreliminarySummaryTitle(String preliminarysummaryTitle) {
		this.preliminarysummaryTitle = preliminarysummaryTitle;
	}

	@Column(name = "preliminarysummary_button", length = 50)
	public String getPreliminarySummaryButton() {
		return this.preliminarysummaryButton;
	}

	public void setPreliminarySummaryButton(String preliminarysummaryButton) {
		this.preliminarysummaryButton = preliminarysummaryButton;
	}

	@Column(name = "preliminarysummary")
	public String getPreliminarySummary() {
		return this.preliminarysummary;
	}

	public void setPreliminarySummary(String preliminarysummary) {
		this.preliminarysummary = preliminarysummary;
	}

	@Column(name = "feedback_displaysummary", nullable = false)
	public boolean isFeedbackDisplaySummary() {
		return this.feedbackDisplaysummary;
	}

	public void setFeedbackDisplaySummary(boolean feedbackDisplaysummary) {
		this.feedbackDisplaysummary = feedbackDisplaysummary;
	}

	@Column(name = "feedback_displaysummarymarks", nullable = false)
	public boolean isFeedbackDisplaySummaryMarks() {
		return this.feedbackDisplaysummarymarks;
	}

	public void setFeedbackDisplaySummaryMarks(boolean feedbackDisplaysummarymarks) {
		this.feedbackDisplaysummarymarks = feedbackDisplaysummarymarks;
	}

	@Column(name = "feedback_displaysummaryattempts", nullable = false)
	public boolean isFeedbackDisplaySummaryAttempts() {
		return this.feedbackDisplaysummaryattempts;
	}

	public void setFeedbackDisplaySummaryAttempts(boolean feedbackDisplaysummaryattempts) {
		this.feedbackDisplaysummaryattempts = feedbackDisplaysummaryattempts;
	}

	@Column(name = "feedback_summaryprevious")
	public String getFeedbackSummaryPrevious() {
		return this.feedbackSummaryprevious;
	}

	public void setFeedbackSummaryPrevious(String feedbackSummaryprevious) {
		this.feedbackSummaryprevious = feedbackSummaryprevious;
	}

	@Column(name = "feedback_displayscores", nullable = false)
	public boolean isFeedbackDisplayScores() {
		return this.feedbackDisplayscores;
	}

	public void setFeedbackDisplayScores(boolean feedbackDisplayscores) {
		this.feedbackDisplayscores = feedbackDisplayscores;
	}

	@Column(name = "feedback_displayscoresmarks", nullable = false)
	public boolean isFeedbackDisplayScoresMarks() {
		return this.feedbackDisplayscoresmarks;
	}

	public void setFeedbackDisplayScoresMarks(boolean feedbackDisplayscoresmarks) {
		this.feedbackDisplayscoresmarks = feedbackDisplayscoresmarks;
	}

	@Column(name = "feedback_displayscorespercentages", nullable = false)
	public boolean isFeedbackDisplayScoresPercentages() {
		return this.feedbackDisplayscorespercentages;
	}

	public void setFeedbackDisplayScoresPercentages(
			boolean feedbackDisplayscorespercentages) {
		this.feedbackDisplayscorespercentages = feedbackDisplayscorespercentages;
	}

	@Column(name = "feedback_scoresprevious")
	public String getFeedbackScoresPrevious() {
		return this.feedbackScoresprevious;
	}

	public void setFeedbackScoresPrevious(String feedbackScoresprevious) {
		this.feedbackScoresprevious = feedbackScoresprevious;
	}

	@Column(name = "feedback_advancedprevious")
	public String getFeedbackAdvancedPrevious() {
		return this.feedbackAdvancedprevious;
	}

	public void setFeedbackAdvancedPrevious(String feedbackAdvancedprevious) {
		this.feedbackAdvancedprevious = feedbackAdvancedprevious;
	}

	@Column(name = "feedback_advancednext")
	public String getFeedbackAdvancedNext() {
		return this.feedbackAdvancednext;
	}

	public void setFeedbackAdvancedNext(String feedbackAdvancednext) {
		this.feedbackAdvancednext = feedbackAdvancednext;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = CascadeType.ALL)
	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public void addSection(Section section) {
		sections.add(section);
		section.setOrder(sections.size());
		section.setTest(this);
	}
	
	public boolean removeSection(int sectionNumber) {
		if(sections.size() < 2) {
			return false;
		}
		
		sections.remove(sectionNumber - 1);
		
		// Renumeramos resto de secciones
		for(int i = 0; i < sections.size(); i++) {
			sections.get(i).setOrder(i + 1);
		}
		
		return true;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = CascadeType.ALL)
	public List<TestFeedback> getTestFeedbacks() {
		return this.testFeedbacks;
	}

	public void setTestFeedbacks(List<TestFeedback> testFeedbacks) {
		this.testFeedbacks = testFeedbacks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = CascadeType.ALL)
	public List<SupportContact> getSupportContacts() {
		return this.supportContacts;
	}

	public void setSupportContacts(List<SupportContact> supportContacts) {
		this.supportContacts = supportContacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = CascadeType.ALL)
	public List<Evaluator> getEvaluators() {
		return this.evaluators;
	}

	public void setEvaluators(List<Evaluator> evaluators) {
		this.evaluators = evaluators;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = CascadeType.ALL)
	public List<TestUser> getTestUsers() {
		return this.testUsers;
	}

	public void setTestUsers(List<TestUser> testUsers) {
		this.testUsers = testUsers;
	}

	@Column(name = "usergroups")
	public String getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(String userGroups) {
		this.userGroups = userGroups;
	}

	@Column(name = "admingroups")
	public String getAdminGroups() {
		return this.adminGroups;
	}

	public void setAdminGroups(String adminGroups) {
		this.adminGroups = adminGroups;
	}

	@Transient
	public String getSignature()
	{
		StringBuffer signature=new StringBuffer();
		signature.append('u');
		signature.append(getCreatedBy().getId());
		signature.append(".t");
		signature.append(getId());
		return signature.toString();
	}
	
	/**
	 * Set the fields of this test with the values from fields from other test.
	 * @param otherTest Other test
	 */
	@Transient
	public void setFromOtherTest(Test otherTest)
	{
		if (otherTest!=null)
		{
			setId(otherTest.getId());
			setName(otherTest.getName());
			setCategory(otherTest.getCategory());
			setDescription(otherTest.getDescription());
			setTitle(otherTest.getTitle());
			setAssessement(otherTest.getAssessement());
			setScoreType(otherTest.getScoreType());
			setAllUsersAllowed(otherTest.isAllUsersAllowed());
			setAllowAdminReports(otherTest.isAllowAdminReports());
			setCreatedBy(otherTest.getCreatedBy());
			setModifiedBy(otherTest.getModifiedBy());
			setTimeCreated(otherTest.getTimeCreated());
			setTimeModified(otherTest.getTimeModified());
			setTimeTestDeploy(otherTest.getTimeTestDeploy());
			setTimeDeployDeploy(otherTest.getTimeDeployDeploy());
			setStartDate(otherTest.getStartDate());
			setCloseDate(otherTest.getCloseDate());
			setWarningDate(otherTest.getWarningDate());
			setFeedbackDate(otherTest.getFeedbackDate());
			setFreeSummary(otherTest.isFreeSummary());
			setFreeStop(otherTest.isFreeStop());
			setSummaryQuestions(otherTest.isSummaryQuestions());
			setSummaryScores(otherTest.isSummaryScores());
			setSummaryAttempts(otherTest.isSummaryAttempts());
			setNavigation(otherTest.isNavigation());
			setNavLocation(otherTest.getNavLocation());
			setRedoQuestion(otherTest.getRedoQuestion());
			setRedoTest(otherTest.isRedoTest());
			setPresentationTitle(otherTest.getPresentationTitle());
			setPresentation(otherTest.getPresentation());
			setPreliminarySummaryTitle(otherTest.getPreliminarySummaryTitle());
			setPreliminarySummaryButton(otherTest.getPreliminarySummaryButton());
			setPreliminarySummary(otherTest.getPreliminarySummary());
			setFeedbackDisplaySummary(otherTest.isFeedbackDisplaySummary());
			setFeedbackDisplaySummaryMarks(otherTest.isFeedbackDisplaySummaryMarks());
			setFeedbackDisplaySummaryAttempts(otherTest.isFeedbackDisplaySummaryAttempts());
			setFeedbackSummaryPrevious(otherTest.getFeedbackSummaryPrevious());
			setFeedbackDisplayScores(otherTest.isFeedbackDisplayScores());
			setFeedbackDisplayScoresMarks(otherTest.isFeedbackDisplayScoresMarks());
			setFeedbackDisplayScoresPercentages(otherTest.isFeedbackDisplayScoresPercentages());
			setFeedbackScoresPrevious(otherTest.getFeedbackScoresPrevious());
			setFeedbackAdvancedPrevious(otherTest.getFeedbackAdvancedPrevious());
			setFeedbackAdvancedNext(otherTest.getFeedbackAdvancedNext());
			setUserGroups(otherTest.getUserGroups());
			setAdminGroups(otherTest.getAdminGroups());
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Test && getId()==((Test)obj).getId();
	}
}
