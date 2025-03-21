package gestorDeAlumnos.controllers;

import gestorDeAlumnos.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos") //Unificar de URLs
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Andrey Leguizamo", "andrew111@gmail.com", 19, "Ciencias de la Computación"),
            new Student(2, "Luisa Reyes", "lui222@hotmail.com", 17, "Ingeniería Mecánica"),
            new Student(3, "Carlos Leon", "leo333@gmail.com", 22, "Administración de Empresas"),
            new Student(4, "Martha Lopez", "lopez44@hotmail.com", 18, "Ingenieria Eléctrica")
    ));

    // Mostrar todos los Alumnos
    @GetMapping
    public List<Student> getStudents(){

        return students;
    }

    // Consultar un alumno por su email
    @GetMapping("/{email}")
    public Student getStudent (@PathVariable String email) {
        for (Student S : students) {
            if(S.getEmail().equalsIgnoreCase(email)){
                return S;
            }
        }
        return null;
    }

    //Crear un nuevo estudiante
    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    //Modificacion total de una alumno
    @PutMapping
    public Student putStudent(@RequestBody Student student) {
        for (Student S: students) {
            if (S.getID() == student.getID()) {
                S.setName(student.getName());
                S.setEmail(student.getEmail());
                S.setAge(student.getAge());
                S.setCourse(student.getCourse());

                return student;
            }
        }
        return null;
    }


    // Modificación parcial de un Alumno
    @PatchMapping
    public Student patchStudent(@RequestBody Student student) {
        for (Student S : students) {
            if(S.getID() == student.getID()){

                if(student.getName() != null){
                    S.setName(student.getName());
                }
                if(student.getEmail() != null) {
                    S.setEmail(student.getEmail());
                }
                if(student.getAge() != 0){
                    S.setAge(student.getAge());
                }
                if(student.getCourse() != null){
                    S.setCourse(student.getCourse());
                }

                return S;
            }
        }
        return null;
    }


    //Eliminar un Estudiante a través de su ID
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        for (Student S : students) {
            if (S.getID() == id) {
                students.remove(S);
                return S;
            }
        }
        return null;
    }

}
