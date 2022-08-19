package com.spring.spring.controller;

import com.spring.spring.model.VideoGame;
import com.spring.spring.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RequestMapping(value = "/VideoGame")
@RestController
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping
    public List<VideoGame> findAll(){
        return videoGameService.findAll();
    }

    @PostMapping
    public VideoGame save(@RequestBody VideoGame videoGame){
        return videoGameService.save(videoGame);
    }

    @PutMapping(value = "/{id}")
    public VideoGame update(@RequestBody VideoGame videoGame, @PathVariable Long id){

        Optional<VideoGame> videoGameOptional = videoGameService.findById(id);
        if (!videoGameOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Video Game não encontrado!");
        }else{
            videoGame.setId(id);
            return videoGameService.save(videoGame);
        }
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {

        Optional<VideoGame> videoGameOptional = videoGameService.findById(id);

        if (!videoGameOptional.isPresent()) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Video Game não encontrado!");
        }else{
            videoGameService.delete(id);
            return "Video Game deletado";
        }
    }

}
