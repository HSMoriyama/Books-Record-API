package projeto.crud.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import projeto.crud.DTO.cursoDTO;
import projeto.crud.model.curso;
import projeto.crud.service.cursoService;

/*
 * PERMITE QUE TODAS AS ANOTATIONS DE VALIDAÇÃO
 * FUNCIONEM
*/
@Validated

/*
* INFORMA AO SPRING QUE ESTE SERA O ENDPOINT
* ISSO É UM JAVA SERVLET 
*/
@RestController 

/*
 * DETERMINANDO ENDPOINT
 */
@RequestMapping("/api/cursos")
@AllArgsConstructor
@CrossOrigin("*")
public class cursoController{

    private final cursoService service;

    //METODO CREATE
    @PostMapping
    public ResponseEntity<curso> create(@RequestBody @Valid cursoDTO curso){
        return service.create(curso);
    }

    //METODO READ ALL
    @GetMapping
    public List<curso> list(){
        return service.list();
    }

    //METODO READ BY ID 2 PASSAGEM PELA URL
    @GetMapping("/{id}")
    public ResponseEntity<curso> listById2(@PathVariable("id") @NotNull @Positive Long id){
        return service.listById2(id);
    }

    //METODO UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<curso> update(@PathVariable("id") @NotNull @Positive Long id, @RequestBody @Valid cursoDTO curso){
        
        return service.update(id, curso);
    }  

    //METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") @NotNull @Positive Long id){
        return service.delete(id);
    }
}