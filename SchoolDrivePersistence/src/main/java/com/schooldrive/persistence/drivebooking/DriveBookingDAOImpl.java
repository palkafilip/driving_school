package com.schooldrive.persistence.drivebooking;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.hoursinterval.HoursInterval;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by Filip on 04.10.2017.
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class DriveBookingDAOImpl implements DriveBookingDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public DriveBooking addDriveBooking(DriveBooking driveBooking) {
        return em.merge(driveBooking);
    }

    @Override
    public List<DriveBooking> getAllDrivesByUserId(Integer userId) {
        String jpqlQuery = "SELECT db from DriveBooking db where db.user.id = :uid";
        TypedQuery<DriveBooking> query = em.createQuery(jpqlQuery, DriveBooking.class);
        query.setParameter("uid", userId);
        return query.getResultList();
    }

    @Override
    public List<DriveBooking> getTakenHoursInDayByInstructorCarDay(Integer instructorId, Integer carId, Date inputDay) {
        String jpqlQuery = "SELECT db from DriveBooking db where db.day = :iday and db.instructor.id = :iid or db.day = :iday and db.car.id = :cid";
        TypedQuery<DriveBooking> query = em.createQuery(jpqlQuery, DriveBooking.class);
        query.setParameter("iid", instructorId);
        query.setParameter("cid", carId);
        query.setParameter("iday", inputDay);
        return query.getResultList();
    }

    @Override
    public Long getBookCountByUserDayHours(Integer userId, Integer hourIntervalId, Date day) {
        String jpqlQuery = "SELECT COUNT(db) from DriveBooking db where db.user.id = :uid and db.hoursInterval.id = :hid and db.day = :day";
        TypedQuery<Long> query = em.createQuery(jpqlQuery, Long.class);
        query.setParameter("uid", userId);
        query.setParameter("hid", hourIntervalId);
        query.setParameter("day", day);
        return query.getSingleResult();
    }

    @Override
    public DriveBooking getDriveById(Integer id) {
        return em.find(DriveBooking.class, id);
    }

    @Override
    public void deleteBook(DriveBooking drive) {
        drive.setCar(null);
        drive.setUser(null);
        drive.setInstructor(null);
        drive.setHoursInterval(null);
        em.remove(drive);
    }
}
