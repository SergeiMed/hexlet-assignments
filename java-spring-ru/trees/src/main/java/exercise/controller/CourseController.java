package exercise.controller;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "")
    public Iterable<Course> getCorses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // BEGIN
    @GetMapping(path = "/{id}/previous")
    public Iterable<Course> getParentCourses(@PathVariable long id) {
        String parentPath = courseRepository.findById(id).getPath();
        if (parentPath != null && !parentPath.equals("")) {
            List<Long> parentIds = Arrays.stream(parentPath.split("\\."))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            return courseRepository.findAllById(parentIds);
        }
        return courseRepository.findAllById(new ArrayList<>());
    }
    // END

}
