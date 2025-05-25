package example.educacion.requests;
import jakarta.validation.constraints.NotBlank;
import org.hiperate.validator.constraints.URL;
import lombok.Data;

@Data
public class ContenidoCrear {
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    @URL
    private String urlVideo;
    
    @NotBlank
    private int idCurso;
}