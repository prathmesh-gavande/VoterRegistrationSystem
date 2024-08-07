package com.votingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingSystem.entity.Voter;
import com.votingSystem.repository.VoterRepository;

@Service
public class VoterserviceImpl implements VoterService {
	@Autowired
	VoterRepository voterRepo;
	
	 @Override
	    public Voter saveVoter(Voter voter) {
	        return voterRepo.save(voter);
	    }

	    @Override
	    public List<Voter> voterlist() {
	        return voterRepo.findAll();
	    }

	    @Override
	    public void deleteById(int id) {
	        voterRepo.deleteById(id);
	    }

	    @Override
	    public Voter findById(int id) {
	        Optional<Voter> findById = voterRepo.findById(id);
	        return findById.orElse(null);
	    }

	    @Override
	    public Voter updateVoter(Voter voter, int id) {
	        if (voterRepo.existsById(id)) {
	            voter.setId(id);
	            return voterRepo.save(voter);
	        }
	        return null;
	    }

	    @Override
	    public Voter findByUsernameAndPassword(String username, String password) {
	        return voterRepo.findByUsernameAndPassword(username, password);
	    }

}
