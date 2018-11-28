package com.morrun.blog.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name = "morrun_profiles_skills")
public class ProfilesSkills {
	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "`profile_id`")
	private Profiles profiles;
	
	@Column(name = "`skills`")
	private String skills;
	
	@Column(name = "`rank`")
	private int rank;

	public ProfilesSkills() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfilesSkills(Long id, Profiles profiles, String skills, int rank) {
		super();
		this.id = id;
		this.profiles = profiles;
		this.skills = skills;
		this.rank = rank;
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "ProfilesSkills [id=" + id + ", profiles=" + profiles + ", skills=" + skills + ", rank=" + rank + "]";
	}
	
	
	
}
