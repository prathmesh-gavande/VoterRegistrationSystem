package com.votingSystem.service;

import java.util.List;


import com.votingSystem.entity.Voter;

public interface VoterService {
	
	public Voter saveVoter(Voter voter);
	public List<Voter> voterlist();
	public void deleteById(int id);
	public Voter findById(int id);
	public Voter updateVoter(Voter voter,int id);
	Voter findByUsernameAndPassword(String username, String password);
}
