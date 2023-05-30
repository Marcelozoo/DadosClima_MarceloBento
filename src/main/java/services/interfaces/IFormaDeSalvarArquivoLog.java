package services.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IFormaDeSalvarArquivoLog {

    public void salvarLog(LocalDate data, LocalTime hora, String tipoOperacao);
    public boolean verificaTipoDeArquivo(String tipoArquivo);
}
