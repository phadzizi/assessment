package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    AgentRepository agentRepository;

    @GetMapping("agent/{id}")
    public Agent findAgent(@PathVariable("id") Long id) {
        return agentRepository.findById(id).get();
    }
    @GetMapping("agents/")
    public List<Agent> findAgents() {
        return agentRepository.findAll();
    }
    @PostMapping("agent/")
    public Agent createAgent(@RequestBody Agent agent) {
        return agentRepository.saveAndFlush(agent);
    }
    ////////////////////////////////////
    @GetMapping("team/{id}")
    public Team findTeam(@PathVariable("id") Long id) {
        return teamRepository.findById(id).get();
    }
    @GetMapping("teams/")
    public List<Team> findTeams() {
        return teamRepository.findAll();
    }
    @PostMapping("team/")
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.saveAndFlush(team);
    }

//    GET /teams/ - Returns a list of teams in the database in JSON format
//    GET /team/{{id}}/ - Returns a detail view of the specified team in JSON format
//    GET /agents/ - Returns a list of all agents in the database in JSON format
//    GET /agent/{{id}}/ - Returns a detail view of the specified agent in JSON format. This should include team details.
//            POST /team/ - Creates a new team with the specified details - Expects a JSON body
//    POST /agent/ - Creates a new agent with the specified details - Expects a JSON body

}
