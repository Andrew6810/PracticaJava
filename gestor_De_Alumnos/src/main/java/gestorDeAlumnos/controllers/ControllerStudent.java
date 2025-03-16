package gestorDeAlumnos.controllers;

import gestorDeAlumnos.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ControllerStudent {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Andrey Leguizamo", "andrew111@gmail.com", 19, "ONCE-A"),
            new Student(2, "Luisa Reyes", "lui222@hotmail.com", 17, "SEXTO-B"),
            new Student(3, "Carlos Leon", "leo333@gmail.com", 22, "DOCE-A"),
            new Student(4, "Martha Lopez", "lopez44@hotmail.com", 18, "SEPTIMO-C")
    ));

    @GetMapping("/Alumnos")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/Alumnos/{email}")
    public Student getAlumno (@PathVariable String email) {
        for (Student S : students) {
            if(S.getEmail().equalsIgnoreCase(email)){
                return S;
            }
        }
        return null;
    }

}
