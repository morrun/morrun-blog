package com.morrun.blog.beans;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "morrun_blog")
public class Blog {
	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Blog(Long id, List<Comment> comments, String title, String content, int userId, Date createDate,
			Date updateDate, int like, int unlike, BlogType type) {
		super();
		this.id = id;
		this.comments = comments;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.like = like;
		this.unlike = unlike;
		this.type = type;
	}
	public BlogType getType() {
		return type;
	}
	public void setType(BlogType type) {
		this.type = type;
	}
	@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("blog")
	private List<Comment> comments;
	
	@Column(name = "`title`")
	private String title;
	@Column(name = "`content`")
	private String content;
	@Column(name = "`user_id`")
	private int userId;
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "`type_id`")
	private BlogType type;
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public Blog(Long id, List<Comment> comments, String title, int userId, Date createDate, Date updateDate, int like,
			int unlike) {
		super();
		this.id = id;
		this.comments = comments;
		this.title = title;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.like = like;
		this.unlike = unlike;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Blog(Long id, List<Comment> comments, String title, String content, int userId, Date createDate,
			Date updateDate, int like, int unlike) {
		super();
		this.id = id;
		this.comments = comments;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.like = like;
		this.unlike = unlike;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", comments=" + comments + ", title=" + title + ", content=" + content + ", userId="
				+ userId + ", createDate=" + createDate + ", updateDate=" + updateDate + ", like=" + like + ", unlike="
				+ unlike + ", type=" + type + "]";
	}
	
	
	
}
