package bryan.pruebaspring.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nombre;
    String descripcion;
    String estado;
    LocalDate fecha_creacion;

    public Tarea(String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.estado="activo";
        this.fecha_creacion=LocalDate.now();
    }

    public Tarea(Integer id , String nombre , String descripcion){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.estado="activo";
        this.fecha_creacion=LocalDate.now();
    }
}
