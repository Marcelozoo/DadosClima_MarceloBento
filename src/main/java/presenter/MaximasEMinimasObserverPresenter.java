package presenter;

import model.DadoClima;
import presenter.interfaces.IPainel;
import view.MaximasEMinimasView;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Map;
import services.MaximasEMinimasService;


public class MaximasEMinimasObserverPresenter implements IPainel {

    final private MaximasEMinimasView graficoTela;
    final private ArrayList<DadoClima> dadosClima;
    final private MaximasEMinimasService calculaMaximasEMinimas;
    private boolean visible;

    public MaximasEMinimasObserverPresenter() {
        
        this.graficoTela = new MaximasEMinimasView();
        this.dadosClima = new ArrayList<>();
        
        this.calculaMaximasEMinimas = new MaximasEMinimasService();
        
        this.visible = false;

        this.graficoTela.setLocation(850, 170);
    }

    @Override
    public void atualizar(DadoClima dadoClima) {

        for (int i = 0; i < this.dadosClima.size(); i++) {
            if (dadoClima.equals(this.dadosClima.get(i))) {
                this.dadosClima.remove(dadoClima);
                getMaximasEMinimas();
                return;
            }
        }
        this.dadosClima.add(dadoClima);
        getMaximasEMinimas();
    }

    private void getMaximasEMinimas() {
        
        if (this.dadosClima.isEmpty()) {
            exibeGrafico(0, 0, 0, 0, 0, 0, false);
        }else{
            Map<String, Float> maximas = calculaMaximasEMinimas.calculaMaximas(dadosClima);
            Map<String, Float> minimas = calculaMaximasEMinimas.calculaMinimas(dadosClima);
            
            exibeGrafico(maximas.get("TemperaturaMaxima"), 
                    maximas.get("UmidadeMaxima"), 
                    maximas.get("PressaoMaxima"), 
                    minimas.get("TemperaturaMinima"), 
                    minimas.get("UmidadeMinima"),
                    minimas.get("PressaoMinima"),
                    true);
        }
       
    }

    private void exibeGrafico(float maxTemp, float maxUmidade, float maxPressao, float minTemp, float minUmidade, float minPressao, boolean possuiMedias) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(maxTemp, "Máxima", "Temperatura");
        dataset.addValue(minTemp, "Mínima", "Temperatura");

        dataset.addValue(maxUmidade, "Máxima", "Umidade");
        dataset.addValue(minUmidade, "Mínima", "Umidade");

        dataset.addValue(maxPressao, "Máxima", "Pressão");
        dataset.addValue(minPressao, "Mínima", "Pressão");

        JFreeChart chart = ChartFactory.createBarChart(
                "Máximas e Mínimas",
                "Atributos Climáticos",
                "Valores",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);

        JInternalFrame frameInterno = getView();
        frameInterno.setContentPane(chartPanel);

        if (possuiMedias == false) {
            frameInterno.remove(chartPanel);
        }

    }

    @Override
    public JInternalFrame getView() {
        return this.graficoTela;
    }
    
    @Override
    public void setVisible(boolean visiblidade) {
        this.graficoTela.setVisible(visiblidade);
        this.visible = visiblidade;
    }
    
    @Override
    public boolean getvisibilidade() {
        return this.visible;
    }

}
