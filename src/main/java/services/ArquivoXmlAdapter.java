package services;

import services.interfaces.IFormaDeSalvarArquivoLog;
import model.ArquivoXmlApi;
import java.time.LocalDate;
import java.time.LocalTime;


public class ArquivoXmlAdapter implements IFormaDeSalvarArquivoLog {
    
    final private ArquivoXmlApi arquivoXml;
    
    public ArquivoXmlAdapter (ArquivoXmlApi arqXmlApi){
        this.arquivoXml = arqXmlApi;
        
    }
    @Override
    public void salvarLog(LocalDate data, LocalTime hora, String tipoOperacao){
        this.arquivoXml.salvarLog(data, hora, tipoOperacao);     
    }
    @Override
    public boolean verificaTipoDeArquivo(String tipoArquivo){
        return tipoArquivo == "XML";
    }
    
}
