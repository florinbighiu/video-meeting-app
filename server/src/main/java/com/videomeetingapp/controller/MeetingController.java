package com.videomeetingapp.controller;

import com.videomeetingapp.model.Meeting;
import com.videomeetingapp.service.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
        Meeting createdMeeting = meetingService.createMeeting(meeting);
        return ResponseEntity.ok(createdMeeting);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable Long id) {
        Meeting meeting = meetingService.getMeetingById(id);
        if (meeting == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meeting);
    }

    @GetMapping("/meetingId/{meetingId}")
    public ResponseEntity<Meeting> getMeetingByMeetingId(@PathVariable String meetingId) {
        Meeting meeting = meetingService.getMeetingByMeetingId(meetingId);
        if (meeting == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meeting);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Meeting>> getMeetingsByCreatorUsername(@PathVariable String username) {
        List<Meeting> meetings = meetingService.getMeetingsByCreatorUsername(username);
        return ResponseEntity.ok(meetings);
    }

    @PostMapping("/{meetingId}/users/{userId}")
    public ResponseEntity<Void> addUserToMeeting(@PathVariable Long meetingId, @PathVariable Long userId) {
        meetingService.addUserToMeeting(meetingId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{meetingId}/users/{userId}")
    public ResponseEntity<Void> removeUserFromMeeting(@PathVariable Long meetingId, @PathVariable Long userId) {
        meetingService.removeUserFromMeeting(meetingId, userId);
        return ResponseEntity.ok().build();
    }

}
