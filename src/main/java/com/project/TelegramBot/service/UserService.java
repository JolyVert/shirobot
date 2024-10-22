package com.project.TelegramBot.service;

import com.project.TelegramBot.model.User;
import com.project.TelegramBot.model.UserInfoResponse;
import com.project.TelegramBot.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.sql.Timestamp;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(Message message) {

        if (userRepository.findById(message.getChatId()).isEmpty()) {

            Long chatId = message.getChatId();
            Chat chat = message.getChat();

            User user = new User();

            user.setChatId(chatId);
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUsername(chat.getUserName());
            user.setLocation(chat.getBio());
            user.setRegisteredAt(new Timestamp(System.currentTimeMillis()));

            userRepository.save(user);

        }
    }

    public void deleteUser(Message message) {

        if(userRepository.findById(message.getChatId()).isPresent()) {
            Long chatId = message.getChatId();
            Chat chat = message.getChat();

            User user = userRepository.findById(message.getChatId()).orElseThrow();
            userRepository.delete(user);
        }
    }

    public UserInfoResponse getUserInfo(Message message) {
        if(userRepository.findById(message.getChatId()).isPresent()) {
            User user = userRepository.findById(message.getChatId()).orElseThrow();
            return new UserInfoResponse(user.getFirstName(), user.getLastName(), user.getUsername(), user.getRegisteredAt());
        } else {
            return null;
        }
    }
}
