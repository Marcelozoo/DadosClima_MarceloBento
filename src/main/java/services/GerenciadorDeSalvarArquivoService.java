package services;

import services.interfaces.IFormaDeSalvarArquivoLog;
import model.ArquivoXmlApi;
import model.ArquivoJsonApi;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GerenciadorDeSalvarArquivoService {

    ArrayList<IFormaDeSalvarArquivoLog> salvarArquivos;

    public GerenciadorDeSalvarArquivoService() {
        this.salvarArquivos = new ArrayList<>();
        this.salvarArquivos.add(new ArquivoJsonAdapter(new ArquivoJsonApi()));
        this.salvarArquivos.add(new ArquivoXmlAdapter(new ArquivoXmlApi()));
    }
    
    public void processarLog(String tipoArquivo, LocalDate data, LocalTime hora, String tipoOperacao){
        for(IFormaDeSalvarArquivoLog formaSalvar : salvarArquivos){
            if(formaSalvar.verificaTipoDeArquivo(tipoArquivo)){
                formaSalvar.salvarLog(data, hora, tipoOperacao);
                break;
            }
        }   
    }
    
    

}
