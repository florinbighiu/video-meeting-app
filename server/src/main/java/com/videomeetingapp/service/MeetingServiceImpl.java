package com.videomeetingapp.service;

import com.videomeetingapp.model.Meeting;
import com.videomeetingapp.model.User;
import com.videomeetingapp.repository.MeetingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;

    private final UserService userService;

    @Override
    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting getMeetingById(Long id) {
        return meetingRepository.findById(id).orElse(null);
    }

    @Override
    public Meeting getMeetingByMeetingId(String meetingId) {
        return meetingRepository.findByMeetingId(meetingId);
    }

    @Override
    public List<Meeting> getMeetingsByCreatorUsername(String username) {
        return meetingRepository.findByCreatorUsername(username);
    }

    @Override
    public void addUserToMeeting(Long meetingId, Long userId) {
        Meeting meeting = getMeetingById(meetingId);
        User user = userService.getUserById(userId);

        if (meeting != null && user != null) {
            meeting.getParticipants().add(user);
            meetingRepository.save(meeting);
   }
    }


    @Override
    public void removeUserFromMeeting(Long meetingId, Long userId) {
        Meeting meeting = getMeetingById(meetingId);
        User user = userService.getUserById(userId);
        if (meeting != null && user != null) {
            meeting.getParticipants().remove(user);
            meetingRepository.save(meeting);
        }
    }

}