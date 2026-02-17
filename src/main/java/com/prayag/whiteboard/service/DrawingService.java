package com.prayag.whiteboard.service;

import com.prayag.whiteboard.entity.DrawingEvent;
import com.prayag.whiteboard.repository.DrawingEventRepository;
import org.springframework.stereotype.Service;

@Service
public class DrawingService {

    private final DrawingEventRepository repository;

    public DrawingService(DrawingEventRepository repository) {
        this.repository = repository;
    }

    public DrawingEvent save(DrawingEvent event) {
        return repository.save(event);
    }
}