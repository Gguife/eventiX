package com.eventiX.api.controller;


import com.eventiX.api.domain.event.Event;
import com.eventiX.api.domain.event.EventDetailsDTO;
import com.eventiX.api.domain.event.EventRequestDTO;
import com.eventiX.api.domain.event.EventResponseDTO;
import com.eventiX.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Event> create(@RequestParam("title")String title,
                                        @RequestParam(value = "description", required = false) String description,
                                        @RequestParam("date") Long date,
                                        @RequestParam("city") String city,
                                        @RequestParam("state") String state,
                                        @RequestParam("remote") Boolean remote,
                                        @RequestParam("eventUrl") String eventUrl,
                                        @RequestParam(value = "image", required = false)MultipartFile image){
        EventRequestDTO eventRequestDTO = new EventRequestDTO(title, description, date, city, state, remote, eventUrl, image);
        Event newEvent = this.eventService.createEvent(eventRequestDTO);
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDTO> allEvents = this.eventService.getUpcomingEvents(page, size);
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDetailsDTO> getEventDetails(@PathVariable UUID eventId){
        EventDetailsDTO eventDatails = eventService.getEventDetails(eventId);
        return ResponseEntity.ok(eventDatails);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<EventResponseDTO>> getFilterEvents(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "10") int size,
                                                                  @RequestParam(required = false)String title,
                                                                  @RequestParam(required = false) String city,
                                                                  @RequestParam(required = false) String state,
                                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
                                                                  ){
        List<EventResponseDTO> events = eventService.getFilteredEvents(page, size, title, city, state, startDate, endDate);
        return ResponseEntity.ok(events);
    }
}
