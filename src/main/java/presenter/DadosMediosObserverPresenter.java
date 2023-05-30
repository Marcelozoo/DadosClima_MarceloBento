package presenter;

import model.DadoClima;
import presenter.interfaces.IPainel;
import view.DadosMediosView;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import services.MediaService;

public class DadosMediosObserverPresenter implements IPainel {

    final private DadosMediosView dadosMedios;
    final private ArrayList<DadoClima> dadosClima;
    final private MediaService calculaMedia;
    final private JLabel labelQtdRegistros;
    private boolean visible;
    private int numeroRegistros;

    public DadosMediosObserverPresenter(JLabel quantidadeRegistros) {

        this.numeroRegistros = 0;

        this.visible = false;

        this.labelQtdRegistros = quantidadeRegistros;

        this.dadosClima = new ArrayList<>();

        this.dadosMedios = new DadosMediosView();
        this.dadosMedios.setLocation(420, 0);

        this.calculaMedia = new MediaService();

    }

    @Override
    public void atualizar(DadoClima dadoClima) {

        for (int i = 0; i < this.dadosClima.size(); i++) {
            if (dadoClima.equals(this.dadosClima.get(i))) {
                this.dadosClima.remove(dadoClima);
                this.numeroRegistros--;
                this.labelQtdRegistros.setText(Integer.toString(this.numeroRegistros));
                exibirMedia();
                return;
            }
        }
        this.dadosClima.add(dadoClima);
        this.numeroRegistros++;
        this.labelQtdRegistros.setText(Integer.toString(this.numeroRegistros));
        exibirMedia();
    }

    private void exibirMedia() {

        JLabel temp = dadosMedios.getLabelTemp();
        JLabel pressao = dadosMedios.getLabelPressao();
        JLabel umidade = dadosMedios.getLabelUmidade();
        JLabel nRegistros = dadosMedios.getLabelNumeroRegistros();

        if (!dadosClima.isEmpty()) {
            ArrayList<Float> medias = calculaMedia.calculaMediaDadosClimaticos(dadosClima);
            
            temp.setText(medias.get(0).toString());
            umidade.setText(medias.get(1).toString());
            pressao.setText(medias.get(2).toString());
            nRegistros.setText(Integer.toString(this.numeroRegistros));
            
        } else {
            temp.setText("0");
            pressao.setText("0");
            umidade.setText("0");
            nRegistros.setText(Integer.toString(this.numeroRegistros));

        }
    }

    @Override
    public JInternalFrame getView() {
        return this.dadosMedios;
    }

    public int getNumeroRegistros() {
        return this.numeroRegistros;
    }

    @Override
    public void setVisible(boolean visiblidade) {
        this.dadosMedios.setVisible(visiblidade);
        this.visible = visiblidade;
    }

    @Override
    public boolean getvisibilidade() {
        return this.visible;
    }

}
