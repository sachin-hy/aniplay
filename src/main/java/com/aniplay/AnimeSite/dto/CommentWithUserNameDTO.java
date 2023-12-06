package com.aniplay.AnimeSite.dto;

import java.sql.Date;
public class CommentWithUserNameDTO {

	
	private Long commentId;
    private String videoId;
    private String commentText;
    private Date commentDate;
    private String userName;
    
    
    
	public CommentWithUserNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentWithUserNameDTO(Long commentId, String videoId, String commentText, Date commentDate,
			String userName) {
		super();
		this.commentId = commentId;
		this.videoId = videoId;
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.userName = userName;
	}


	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
    
}
