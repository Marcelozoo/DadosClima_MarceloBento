package services;

import services.interfaces.IFormaDeSalvarArquivoLog;
import model.ArquivoJsonApi;
import java.time.LocalDate;
import java.time.LocalTime;


public class ArquivoJsonAdapter implements IFormaDeSalvarArquivoLog {
    
    final private ArquivoJsonApi arquivoJson;
    
    public ArquivoJsonAdapter (ArquivoJsonApi arqJsonApi){
        this.arquivoJson = arqJsonApi;
        
    }
    @Override
    public void salvarLog(LocalDate data, LocalTime hora, String tipoOperacao){
        this.arquivoJson.salvarLog(data, hora, tipoOperacao);     
    }
    
    @Override
    public boolean verificaTipoDeArquivo(String tipoArquivo){
        return tipoArquivo == "JSON";
    }
    
}
