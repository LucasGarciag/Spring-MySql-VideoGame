package com.spring.spring.service;

import com.spring.spring.model.VideoGame;
import com.spring.spring.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    public List<VideoGame> findAll(){
        return videoGameRepository.findAll();
    }

    public VideoGame save(VideoGame videoGame){
        return videoGameRepository.save(videoGame);
    }

    public Optional<VideoGame> findById(Long id){
        return videoGameRepository.findById(id);
    }

    public void delete(Long id) {
        videoGameRepository.deleteById(id);
    }
}
