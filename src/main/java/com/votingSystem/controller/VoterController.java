package com.votingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.votingSystem.entity.Voter;
import com.votingSystem.service.VoterService;

@Controller
public class VoterController {
    
    @Autowired
    private VoterService voterService;

    @GetMapping("/adminDashboard")
    public String showAdminDashboard(Model model) {
        model.addAttribute("voters", voterService.voterlist());
        return "adminDashboard";
    }

    @GetMapping("/voters/edit/{id}")
    public String editVoter(@PathVariable int id, Model model) {
        Voter voter = voterService.findById(id);
        model.addAttribute("voter", voter);
        return "voterEdit";
    }

    @PostMapping("/voters/update")
    public String updateVoter(@ModelAttribute Voter voter) {
        voterService.updateVoter(voter, voter.getId());
        return "redirect:/adminDashboard";
    }

    @GetMapping("/voters/delete/{id}")
    public String deleteVoter(@PathVariable("id") int id) {
        voterService.deleteById(id);
        return "redirect:/adminDashboard";
    }

    @GetMapping("/voters/add")
    public String addVoter(Model model) {
        model.addAttribute("voter", new Voter());
        return "voterAdd";
    }

    @PostMapping("/voters/save")
    public String saveVoter(@ModelAttribute Voter voter) {
        voterService.saveVoter(voter);
        return "redirect:/adminDashboard";
    }
}
