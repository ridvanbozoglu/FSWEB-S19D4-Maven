package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new ApiException("actor is not found with id: " + id,HttpStatus.NOT_FOUND));

    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor update(Long id, Actor actor) {
        Actor actor1 = actorRepository.findById(id).orElseThrow(()-> new ApiException("Kullanıcı bulunamadı!",HttpStatus.NOT_FOUND));
        actor1.setBirthDate(actor.getBirthDate());
        actor1.setMovies(actor.getMovies());
        actor1.setGender(actor.getGender());
        actor1.setFirstName(actor.getFirstName());
        actor1.setLastName(actor.getLastName());
        return actorRepository.save(actor1);
    }

    public Actor delete(Long id) {
        Actor actor = findById(id);
        actorRepository.delete(actor);
        return actor;
    }

    @Override
    public Actor delete(Actor actor) {
        return actor;
    }

}
