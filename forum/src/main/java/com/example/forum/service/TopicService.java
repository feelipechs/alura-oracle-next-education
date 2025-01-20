package com.example.forum.service;

import com.example.forum.model.Topic;
import com.example.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> listAll() {
        return topicRepository.findAll();
    }

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic create(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic update(Long id, Topic topic) {
        if (topicRepository.existsById(id)) {
            topic.setId(id);
            return topicRepository.save(topic);
        }
        return null;
    }

    public void delete(Long id) {
        topicRepository.deleteById(id);
    }
}