package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {

    // Автоматически заполняем значение поля
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return this.personRepository.findById(id);
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }

    // BEGIN
    @PostMapping(path = "")
    public void createPerson(@RequestBody Person person) {
        this.personRepository.save(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable Long id) {
        this.personRepository.deleteById(id);
    }

    @PatchMapping(path = "{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        this.personRepository.save(person);
    }
    // END
}
