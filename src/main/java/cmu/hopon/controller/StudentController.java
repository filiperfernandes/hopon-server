package cmu.hopon.controller;

import cmu.hopon.domain.Student;
import cmu.hopon.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Controller
@RequestMapping("/")
class StudentController {
    final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody Iterable<Student> list() {
        return studentService.getStudents();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String addStudent (@RequestParam Integer rollNo,
                                            @RequestParam String name,
                                            @RequestParam String dateOfBirth ) throws ParseException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Student student = new Student();
        student.setRollNo(rollNo);
        student.setName(name);
        student.setDateOfBirth(df.parse(dateOfBirth));
        studentService.addStudent(student);
        return "Saved";
    }

}
