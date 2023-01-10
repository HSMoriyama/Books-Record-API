package projeto.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.crud.model.curso;

@Repository
public interface cursoRepository extends JpaRepository<curso, Long> {
 
    /*
     * CRIANDO UM METODO FIND BY ATRIBUTO
     * O SPRING ENTENDE O QUE VC QUER 
     * E AUTOMATICAMENTE CRIA UM METODO QUE FAZ
     * UM SELECT NO BD
    */

}