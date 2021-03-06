package com.yucitms.orm.bbs;

import java.util.Date;

/**
 * 帖子回复
 * @author qiangzi
 *
 */
public class Response implements java.io.Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -81119100823655360L;
	private Integer id;
    private Date responseTime;
    private Post post;
    private String userName;
    private String content;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
