package com.videomeetingapp.service;

import com.videomeetingapp.model.Meeting;

import java.util.List;

public interface MeetingService {

    Meeting createMeeting(Meeting meeting);
    Meeting getMeetingById(Long id);
    Meeting getMeetingByMeetingId(String meetingId);
    List<Meeting> getMeetingsByCreatorUsername(String username);
    void addUserToMeeting(Long meetingId, Long userId);
    void removeUserFromMeeting(Long meetingId, Long userId);

}
