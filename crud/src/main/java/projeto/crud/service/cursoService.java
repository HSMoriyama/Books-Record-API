package projeto.crud.service;

import org.springframework.stereotype.Service;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import projeto.crud.DTO.cursoDTO;
import projeto.crud.mapper.cursoMapper;
import projeto.crud.model.curso;
import projeto.crud.repository.cursoRepository;


@AllArgsConstructor
@Service
public class cursoService {
    
    private final cursoRepository repository;

    //METODO CREATE
    public ResponseEntity<curso> create(cursoDTO curso){
        curso dtoToCurso = cursoMapper.toCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(dtoToCurso));
    }

    //METODO READ ALL
    public List<curso> list(){
        return repository.findAll();
    }

    //METODO READ BY ID 2 PASSAGEM PELA URL
    public ResponseEntity<curso> listById2(@NotNull @Positive Long id){
        return repository.findById(id)
            .map(cursoFound -> ResponseEntity.ok().body(cursoFound))
            .orElse(ResponseEntity.notFound().build());
    }

    //METODO UPDATE
    public ResponseEntity<curso> update(@NotNull @Positive Long id, @RequestBody @Valid cursoDTO curso){
        curso dtoToCurso = cursoMapper.toCurso(curso);
        
        return repository.findById(id)
            .map(cursoFound -> {
                    cursoFound.setNome(dtoToCurso.getNome());
                    cursoFound.setCategoria(dtoToCurso.getCategoria());
                    curso cursoUpdated = repository.save(cursoFound);
                    return ResponseEntity.ok().body(cursoUpdated);
                
                    /*
                     * OUTRA FORMA return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
                    */
                })
            .orElse(ResponseEntity.notFound().build());
    }  

    //METODO DELETE
    public ResponseEntity<Void> delete(@NotNull @Positive Long id){
        return repository.findById(id)
            .map(cursoFound -> {
                repository.deleteById(id);
                return ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

}
