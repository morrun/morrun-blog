package com.morrun.blog.beans;

import java.util.Date;

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

@Entity
@Table(name = "morrun_profiles_degrees")
public class ProfilesDegrees {
	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id")
	private Profiles profiles;
	
	@Column(name = "`school`")
	private String school;
	
	@Column(name = "`degree`")
	private String degree;
	
	@Column(name = "`graduated_date`")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date graduatedDate;
	
	@Column(name = "`major`")
	private String major;

	public ProfilesDegrees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfilesDegrees(Long id, Profiles profiles, String school, String degree, Date graduatedDate, String major) {
		super();
		this.id = id;
		this.profiles = profiles;
		this.school = school;
		this.degree = degree;
		this.graduatedDate = graduatedDate;
		this.major = major;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profiles getProfiles() {
		return profiles;
	}

	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Date getGraduatedDate() {
		return graduatedDate;
	}

	public void setGraduatedDate(Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "ProfilesDegrees [id=" + id + ", profiles=" + profiles + ", school=" + school + ", degree=" + degree
				+ ", graduatedDate=" + graduatedDate + ", major=" + major + "]";
	}
	
}
