package com.xib.assessment.controllers;

import com.xib.assessment.models.Team;
import com.xib.assessment.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("team/{id}")
    public Team findTeam(@PathVariable("id") Long id) {
        return teamRepository.findById(id).get();
    }

    @GetMapping("teams")
    public List<Team> findTeams() {
        return teamRepository.findAll();
    }

    @PostMapping("team")
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.saveAndFlush(team);
    }

}
