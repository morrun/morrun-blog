package com.morrun.blog.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "morrun_profiles")
public class Profiles {
	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "`image`")
	private String imageUrl;
	
	@Column(name = "`email`")
	private String email;
	
	@OneToMany(mappedBy = "profiles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("profiles")
	private Set<ProfilesSkills> profilesSkills;
	
	@OneToMany(mappedBy = "profiles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("profiles")
	private Set<ProfilesDegrees> profilesDegrees;

	public Profiles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Profiles(Long id, String imageUrl, String email, Set<ProfilesSkills> profilesSkills,
			Set<ProfilesDegrees> profilesDegrees) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.email = email;
		this.profilesSkills = profilesSkills;
		this.profilesDegrees = profilesDegrees;
	}



	public Set<ProfilesSkills> getProfilesSkills() {
		return profilesSkills;
	}



	public void setProfilesSkills(Set<ProfilesSkills> profilesSkills) {
		this.profilesSkills = profilesSkills;
	}



	public Set<ProfilesDegrees> getProfilesDegrees() {
		return profilesDegrees;
	}



	public void setProfilesDegrees(Set<ProfilesDegrees> profilesDegrees) {
		this.profilesDegrees = profilesDegrees;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Profiles [id=" + id + ", imageUrl=" + imageUrl + ", email=" + email + ", profilesSkills="
				+ profilesSkills + ", profilesDegrees=" + profilesDegrees + "]";
	}
	
	
}
