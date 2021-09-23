package com.project.conferencedemo.controllers;

import com.project.conferencedemo.models.Session;
import com.project.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    // *** GET *** //
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getById(id);
    }

    // *** POST *** //
    @PostMapping
    public Session create(@RequestBody final Session session){  // SpringMVC is taking all the Session attrib in JSON payload and marshalling them into a session object
        return sessionRepository.saveAndFlush(session);     // saveAndFlush saves the entities and commits to the DB as well
    }

    // *** DELETE *** //
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        // Also need to check children records before deleting
        sessionRepository.deleteById(id);
    }

    // *** PUT *** //
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
