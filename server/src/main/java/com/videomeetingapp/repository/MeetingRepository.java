package com.videomeetingapp.repository;

import java.util.List;
import com.videomeetingapp.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByCreatorUsername(String username);

    Meeting findByMeetingId(String meetingId);
}
