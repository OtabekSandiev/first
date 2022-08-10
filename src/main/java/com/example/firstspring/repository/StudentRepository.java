package com.example.firstspring.repository;


import com.example.firstspring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByAge(Integer age);

    /**
     * Returns a list of all students between the start and end ages
     * Reminder :
     *      In order to avoid logical errors,
     *      startAge and endAge should work according
     *      to this principle -> (startAge < endAge)
     * @param startAge
     * @param endAge
     * @return
     */

    List<Student> findAllByAgeBetween(Integer startAge, Integer endAge);

    /**
     * return student list via (like course)
     * Reminder :
     *      To avoid logical errors,
     *      put (%) at the beginning, end, or both sides of the course
     * @param course
     * @return
     */
    List<Student> findAllByCourseLike(String course);

    /**
     * return list of students through course
     * Here it is checked that the incoming information
     * is exactly the same as the original
     *  -> this.course.equals(course)
     * @param course
     * @return
     */
    List<Student> findAllByCourse(String course);

    /**
     * return Student by id
     * @param id
     * @return
     */
    Student findAllById(Integer id);

    /**
     * Delete student by id
     * Returns ResponseDto
     * Reminder :
     *      ResponseDto class
     *      fields code, success, message.
     *
     * Success if the code returns 1
     * otherwise error
     * @param id
     * @return
     */
    void deleteAllById(Integer id);

}
