package presenter;

import model.DadoClima;
import presenter.interfaces.IPainel;
import view.ConfiguracaoSistemaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import model.ArquivoJsonApi;
import model.ArquivoXmlApi;
import services.GerenciadorDeSalvarArquivoService;

public class ConfiguracaoObserverPresenter implements IPainel {

    final private ConfiguracaoSistemaView configuraTela;
    final private ArrayList<DadoClima> dadosClima;
    final private ArquivoJsonApi salvarJson;
    final private ArquivoXmlApi salvarXml;
    final private GerenciadorDeSalvarArquivoService gerenciadorArquivo;
    private boolean visible;
    private String tipoArquivo;

    public ConfiguracaoObserverPresenter() {
        this.configuraTela = new ConfiguracaoSistemaView();
        this.configuraTela.setLocation(840, 0);
        this.visible = false;

        gerenciadorArquivo = new GerenciadorDeSalvarArquivoService();
        this.dadosClima = new ArrayList<>();
        this.salvarJson = new ArquivoJsonApi();
        this.salvarXml = new ArquivoXmlApi();

        salvarTipoArquivo();
    }

    private void salvarTipoArquivo() {
        configuraTela.getBtnSalvar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selecionaItemComboBox();

            }
        });
    }

    private void selecionaItemComboBox() {

        JComboBox comboBox = configuraTela.getComboBox();
        String tipoArquivoSelecionado = (String) comboBox.getSelectedItem();

        this.tipoArquivo = tipoArquivoSelecionado;
    }

    @Override
    public void atualizar(DadoClima dadoClima) {

        for (int i = 0; i < this.dadosClima.size(); i++) {
            if (dadoClima.equals(this.dadosClima.get(i))) {
                this.dadosClima.remove(dadoClima);
                gerenciadorArquivo.processarLog(this.tipoArquivo, LocalDate.now(), LocalTime.now(), "remoção");
                return;
            }
        }
        this.dadosClima.add(dadoClima);
        gerenciadorArquivo.processarLog(this.tipoArquivo, LocalDate.now(), LocalTime.now(), "inclusão");
    }

    @Override
    public JInternalFrame getView() {
        return this.configuraTela;
    }

    @Override
    public void setVisible(boolean visiblidade) {
        this.configuraTela.setVisible(visiblidade);
        this.visible = visiblidade;
    }

    @Override
    public boolean getvisibilidade() {
        return this.visible;
    }

}
