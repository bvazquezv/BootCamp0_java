import java.time.LocalDateTime;


//Metodos de la interface sin implementacion
public interface Auditable {
    String getCreadoPor();
    LocalDateTime getCreadoEn();
    String getModificadoPor();
    LocalDateTime getModificadoEn();
}
