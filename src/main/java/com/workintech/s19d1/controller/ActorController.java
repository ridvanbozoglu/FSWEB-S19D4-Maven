package com.workintech.s19d1.controller;


import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAll(){
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Long id){
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@RequestBody Actor actor){
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody Actor actor){
        return actorService.update(id,actor);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable Long id){
        return actorService.delete(id);
    }
}
