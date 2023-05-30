package services;

import java.util.ArrayList;
import model.DadoClima;

public class MediaService {

    public ArrayList<Float> calculaMediaDadosClimaticos(ArrayList<DadoClima> dadosClima) {
        float somaTemperaturas = 0;
        float somaUmidades = 0;
        float somaPressoes = 0;
        
        ArrayList<Float> medias = new ArrayList<>();
        
        for (DadoClima dadoClima : dadosClima) {
            somaTemperaturas += dadoClima.getTemperatura();
            somaUmidades += dadoClima.getUmidade();
            somaPressoes += dadoClima.getPressao();
        }
        
        medias.add(somaTemperaturas/dadosClima.size());
        medias.add(somaUmidades/dadosClima.size());
        medias.add(somaPressoes/dadosClima.size());
        
        return medias;  
    }

}
