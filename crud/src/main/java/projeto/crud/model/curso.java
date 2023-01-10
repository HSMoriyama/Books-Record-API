package projeto.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/*
 * GETS AND SETS, CONSTRUCTOR C/ ARGS, ToString e EqualsAndHashCode
*/
@Data 

/* 
 * DETERMINA QUE ESTA CLASSE SERA ENTIDADE NO BANCO  
*/
@Entity

/*
 * CASO A TEBELA JA EXISTA NO BD, BASTA DIZER O NOME DELA ATRAVES DE @Table(name = "X")
 */
@Table(name = "curso")
public class curso {
    
    /* 
     * DETERMINA COLUNA COMO CHAVE PRIMARIA
    */
    @Id
    /*
     * DETERMINA COLUNA COMO AUTO-INCREMENTO
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 10, max = 200)
    /*
     * CASO A COLUNA JA EXISTA NO BD, BASTA DIZER O NOME DELA ATRAVES DE @Column(name = "X")
    */
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(name = "categoria", length = 10, nullable = false)
    private String categoria;

}
