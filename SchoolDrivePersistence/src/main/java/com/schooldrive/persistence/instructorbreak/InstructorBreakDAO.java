package com.schooldrive.persistence.instructorbreak;

import java.util.Date;
import java.util.List;

/**
 * Created by Filip on 16.12.2017.
 */
public interface InstructorBreakDAO {

    InstructorBreak getInstructorBreakById(Integer id);
    List<InstructorBreak> getAllInstructorBreaksByInstructorId(Integer instructorId);
    List<InstructorBreak> getInstruktorBreakByIntructorAndDay(Integer instructorId, Date day);
}
