package pd.example.demo.major.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.example.demo.major.project.repository.CourseRepository;
import pd.example.demo.major.project.utility.Course;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void save(Course course) {
        courseRepository.save(course);

    }

    public Object findAll() {
        return courseRepository.findAll();
    }

    public List<Course> getDropdown() {
//        List<Course> courses=new ArrayList<>();
//        courseRepository.save(new Course("Java"));
//        courseRepository.save(new Course("Python"));
//        courseRepository.save(new Course("HTML/CSS"));
//       courseRepository.save(new Course("J2EE"));
//        courseRepository.save(new Course("SQL"));
        List<Course> courseList = courseRepository.findAll();
        //System.out.printf(courseList.get(1).getCourseRegistered());
        return courseList;
    }
}
