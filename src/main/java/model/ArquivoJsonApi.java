package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ArquivoJsonApi {

    final private ObjectMapper objetoMapper;
    private FileWriter arquivoJson;

    public ArquivoJsonApi() {

        objetoMapper = new ObjectMapper();
    }

    public void salvarLog(LocalDate data, LocalTime hora, String tipoOperacao) {

        if (arquivoJson == null) {
            criaArquivo();
        } else {
            try {
                this.arquivoJson = new FileWriter("log.json", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log log = new Log(data, hora, tipoOperacao);

        String json;
        try {

            json = objetoMapper.writeValueAsString(log);
            arquivoJson.write(json);
            arquivoJson.write(System.lineSeparator());
            arquivoJson.flush();
            arquivoJson.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void criaArquivo() {
        try {
            this.arquivoJson = new FileWriter("log.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
