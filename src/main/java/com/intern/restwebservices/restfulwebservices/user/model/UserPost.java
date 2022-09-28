package com.intern.restwebservices.restfulwebservices.user.model;

public class UserPost {

	private Integer postId;
	private Integer userId;
	private String postTag;
	private String postDescription;
	
	public UserPost() {

	}

	public UserPost(int postId, int userId, String postTag, String postDescription) {
		this.postId = postId;
		this.userId = userId;
		this.postTag = postTag;
		this.postDescription = postDescription;
	}

	/**
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the postTag
	 */
	public String getPostTag() {
		return postTag;
	}

	/**
	 * @param postTag the postTag to set
	 */
	public void setPostTag(String postTag) {
		this.postTag = postTag;
	}

	/**
	 * @return the postDescription
	 */
	public String getPostDescription() {
		return postDescription;
	}

	/**
	 * @param postDescription the postDescription to set
	 */
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	@Override
	public String toString() {
		return "UserPost [postId=" + postId + ", userId=" + userId + ", postTag=" + postTag + ", postDescription="
				+ postDescription + "]";
	}
	
}
