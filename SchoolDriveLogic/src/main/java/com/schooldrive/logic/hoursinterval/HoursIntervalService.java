package com.schooldrive.logic.hoursinterval;

import com.schooldrive.logic.drivebooking.DriveBookingService;
import com.schooldrive.logic.instructorbreak.InstructorBreakService;
import com.schooldrive.persistence.hoursinterval.HoursInterval;
import com.schooldrive.persistence.hoursinterval.HoursIntervalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Filip on 16.12.2017.
 */
@Service
public class HoursIntervalService {

    HoursIntervalDAO hoursIntervalDAO;

    @Autowired
    public HoursIntervalService(HoursIntervalDAO hoursIntervalDAO) {
        this.hoursIntervalDAO = hoursIntervalDAO;
    }

    public List<HoursInterval> getAllHourIntervals() {
        return this.hoursIntervalDAO.getAllHourIntervals();
    }

    public HoursInterval getHoursIntervalById(Integer id) {
        return this.hoursIntervalDAO.getHoursIntervalById(id);
    }

}
