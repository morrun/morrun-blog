package com.morrun.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morrun.blog.beans.Profiles;
import com.morrun.blog.dao.ProfilesDao;
import com.morrun.blog.http.Response;

@Service
public class ProfilesService {

	@Autowired
	private ProfilesDao pd;
	
	public List<Profiles> getAllProfiles(){
		return pd.findAll();
	}
	
	public Response updateProfiles(Profiles profiles) {
		try {
			pd.save(profiles);
			return new Response(true);
		}catch (Exception e) {
			return new Response(false, e.getStackTrace().toString());
		}
	}
}
