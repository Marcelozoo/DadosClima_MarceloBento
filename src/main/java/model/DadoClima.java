package model;

import java.time.LocalDate;
import java.util.Objects;

public class DadoClima {

    final private float temperatura;
    final private float umidade;
    final private float pressao;
    final private LocalDate data;

    public DadoClima(float temperatura, float umidade, float pressao, LocalDate data) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DadoClima other = (DadoClima) obj;
        return Float.compare(other.temperatura, temperatura) == 0
                && Float.compare(other.umidade, umidade) == 0
                && Float.compare(other.pressao, pressao) == 0
                && Objects.equals(other.data, data);
    }

    public float getTemperatura() {
        return this.temperatura;
    }

    public float getUmidade() {
        return this.umidade;
    }

    public float getPressao() {
        return this.pressao;
    }

    public LocalDate getData() {
        return this.data;
    }

}
