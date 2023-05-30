package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Log {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    final private String data;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    final private String hora;
    
    @JsonProperty("tipoOperacao")
    final private String tipoOperacao;

    public Log(LocalDate data, LocalTime hora, String tipoOperacao) {

        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        this.data = data.format(formatterData);
        this.hora = hora.format(formatterHora);
        this.tipoOperacao = tipoOperacao;
    }

}
