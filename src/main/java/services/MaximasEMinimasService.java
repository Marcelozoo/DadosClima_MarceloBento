package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.DadoClima;

public class MaximasEMinimasService {

    public Map<String, Float> calculaMaximas(ArrayList<DadoClima> dadosClima) {

        Map<String, Float> maximas = new HashMap<>();

        float zero = 0;
        maximas.put("TemperaturaMaxima", zero);
        maximas.put("PressaoMaxima", zero);
        maximas.put("UmidadeMaxima", zero);

        for (DadoClima dado : dadosClima) {
            if (dado.getTemperatura() > maximas.get("TemperaturaMaxima")) {
                maximas.put("TemperaturaMaxima", dado.getTemperatura());

            }
            if (dado.getPressao() > maximas.get("PressaoMaxima")) {
                maximas.put("PressaoMaxima", dado.getPressao());

            }
            if (dado.getUmidade() > maximas.get("UmidadeMaxima")) {
                maximas.put("UmidadeMaxima", dado.getUmidade());
            }

        }
        return maximas;
    }

    public Map<String, Float> calculaMinimas(ArrayList<DadoClima> dadosClima) {

        Map<String, Float> minimas = new HashMap<>();

        minimas.put("TemperaturaMinima", dadosClima.get(0).getTemperatura());
        minimas.put("PressaoMinima", dadosClima.get(0).getPressao());
        minimas.put("UmidadeMinima", dadosClima.get(0).getUmidade());

        for (DadoClima dado : dadosClima) {

            if (dado.getTemperatura() < minimas.get("TemperaturaMinima")) {
                minimas.put("TemperaturaMinima", dado.getTemperatura());
            }
            if (dado.getPressao() < minimas.get("PressaoMinima")) {
                minimas.put("PressaoMinima", dado.getPressao());
            }
            if (dado.getUmidade() < minimas.get("UmidadeMinima")) {
                minimas.put("UmidadeMinima", dado.getUmidade());

            }
        }
        return minimas;
    }
    
}
