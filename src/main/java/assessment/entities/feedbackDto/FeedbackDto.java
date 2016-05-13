package assessment.entities.feedbackDto;

import assessment.entities.review.Review;

import java.util.Date;

/**
 * Created by jtucker on 5/11/2016.
 */
public class FeedbackDto {

	private String avatar;

	private String firstName;

	private String lastName;

	private Date submittedDate;

	private String teamName;

	private String templateName;

	private Double summaryscore;

	private Review review;

	public FeedbackDto() {}

	public FeedbackDto(String avatar, String firstName, String lastName, Date submittedDate, String teamName, String templateName, Double summaryscore, Review review) {
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.submittedDate = submittedDate;
		this.teamName = teamName;
		this.templateName = templateName;
		this.summaryscore = summaryscore;
		this.review = review;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Double getSummaryscore() {
		return summaryscore;
	}

	public void setSummaryscore(Double summaryscore) {
		this.summaryscore = summaryscore;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
}
