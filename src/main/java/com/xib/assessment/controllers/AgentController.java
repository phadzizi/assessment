package com.xib.assessment.controllers;

import com.xib.assessment.models.Agent;
import com.xib.assessment.repositories.AgentRepository;
import com.xib.assessment.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AgentController {

    @Autowired
    AgentRepository agentRepository;

    @GetMapping("agent/{id}")
    public Agent findAgent(@PathVariable("id") Long id) {
        return agentRepository.findById(id).get();
    }

    @GetMapping("agents")
    public List<Agent> findAgents(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize) {
        List<Agent> ret = agentRepository.findAll(new Page(pageNumber, pageSize)).getContent();
        for (Agent a : ret) {
            a.setIdNumber(null);
        }
        return ret;
    }

    @GetMapping("agents/free")
    public List<Agent> freeAgents() {
        List<Agent> all = agentRepository.findAll();
        List<Agent> ret = new ArrayList<>();
        for (Agent a : all) {
            if (a.getTeam() == null) {
                ret.add(a);
            }
        }
        return ret;
    }

    @PostMapping("agent")
    public Agent createAgent(@RequestBody Agent agent) {
        return agentRepository.saveAndFlush(agent);
    }

    @PutMapping("team/{id}/agent")
    public Agent teamAgent(@PathVariable("id") Long id, @RequestBody Agent agent) {
        return agentRepository.saveAndFlush(agent);
    }

}
