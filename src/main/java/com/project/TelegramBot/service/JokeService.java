package com.project.TelegramBot.service;

import com.project.TelegramBot.model.Joke;
import com.project.TelegramBot.model.JokeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class JokeService {

    @Autowired
    private JokeRepository jokeRepository;

    public String getJoke() {

        Random random = new Random();
        long joke_id = (long)random.nextInt((int)jokeRepository.count());
        System.out.println(joke_id);


        return jokeRepository.findById(joke_id).orElseThrow().getJoke();
    }
}
