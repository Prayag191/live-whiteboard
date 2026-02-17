package com.prayag.whiteboard.controller;

import com.prayag.whiteboard.entity.DrawingEvent;
import com.prayag.whiteboard.service.DrawingService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.prayag.whiteboard.model.DrawMessage;

@Controller
public class WhiteboardSocketController {

    private final DrawingService drawingService;

    public WhiteboardSocketController(DrawingService drawingService) {
        this.drawingService = drawingService;
    }

    @MessageMapping("/draw")
    @SendTo("/topic/board")
    public DrawMessage draw(DrawMessage message) {
        return message;
    }
}