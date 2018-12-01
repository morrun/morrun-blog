package com.morrun.blog.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "morrun_comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "`content`")
	private String content;
	@Column(name = "`commenter_email`")
	private String commenterEmail;
	@Column(name = "`create_date`")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@Column(name = "`updata_date`")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	@Column(name = "`like`")
	private int like;
	@Column(name = "`unlike`")
	private int unlike;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "blog_id")
	@JsonIgnoreProperties("comments")
	private Blog blog;
//	@Column(name = "`blog_id`")
//	private Long blogId;
	public Comment() {
		super();
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommenterEmail() {
		return commenterEmail;
	}
	public void setCommenterEmail(String commenterEmail) {
		this.commenterEmail = commenterEmail;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getUnlike() {
		return unlike;
	}
	public void setUnlike(int unlike) {
		this.unlike = unlike;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", commenterEmail=" + commenterEmail + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", like=" + like + ", unlike=" + unlike + ", blog=" + blog.getId()
				+ "]";
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Comment(Long id, String content, String commenterEmail, Date createDate, Date updateDate, int like,
			int unlike, Blog blog) {
		super();
		this.id = id;
		this.content = content;
		this.commenterEmail = commenterEmail;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.like = like;
		this.unlike = unlike;
		this.blog = blog;
	}
}
