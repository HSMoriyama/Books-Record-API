package projeto.crud.mapper;

import lombok.Data;
import projeto.crud.DTO.cursoDTO;
import projeto.crud.model.curso;

@Data
public class cursoMapper {

    public static curso toCurso(cursoDTO cursoDTO){
        curso cursoPersistencia = new curso();
        cursoPersistencia.setNome(cursoDTO.getNome());
        cursoPersistencia.setCategoria(cursoDTO.getCategoria());
        return cursoPersistencia;
    }

}
