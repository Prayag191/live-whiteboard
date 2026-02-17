package com.prayag.whiteboard.repository;

import com.prayag.whiteboard.entity.DrawingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DrawingEventRepository extends JpaRepository<DrawingEvent, UUID> {
}