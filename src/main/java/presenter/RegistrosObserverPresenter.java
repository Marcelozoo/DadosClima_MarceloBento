package presenter;

import model.DadoClima;
import model.EstacaoClimatica;
import presenter.interfaces.IPainel;
import view.RegistrosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistrosObserverPresenter implements IPainel {

    final private RegistrosView registros;
    final private ArrayList<DadoClima> dadosClima;
    final private JTable tabela;
    final private EstacaoClimatica estacao;
    private boolean visible;

    public RegistrosObserverPresenter(EstacaoClimatica estacao) {

        this.dadosClima = new ArrayList<>();
        this.registros = new RegistrosView();
        this.estacao = estacao;
        this.visible = false;

        this.registros.setLocation(420, 320);

        this.tabela = this.registros.getTabela();

        removerLinhaSelecionada();
    }

    @Override
    public void atualizar(DadoClima dadoClima) {

        for (int i = 0; i < this.dadosClima.size(); i++) {
            if (dadoClima.equals(this.dadosClima.get(i))) {
                this.dadosClima.remove(dadoClima);
                atualizaTabela();
                return;
            }
        }
        this.dadosClima.add(dadoClima);
        atualizaTabela();

    }

    private void atualizaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < this.dadosClima.size(); i++) {
            DadoClima dado = this.dadosClima.get(i);
            Object[] valores = {dado.getData().format(formatter), dado.getTemperatura(), dado.getUmidade(), dado.getPressao()};
            modelo.addRow(valores);
        }

    }

    private void removerLinhaSelecionada() {

        registros.getBtnRemover().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada != -1) {

                    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

                    pegaDadosParaRemover(modelo, linhaSelecionada);
                    atualizaTabela();
                }

            }
        });
    }

    public void pegaDadosParaRemover(DefaultTableModel modelo, int linhaSelecionada) {
        Object[] valoresLinha = new Object[modelo.getColumnCount()];
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            valoresLinha[i] = modelo.getValueAt(linhaSelecionada, i);
        }
        String dataString = valoresLinha[0].toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);
        
        
        LocalDate dataSemFormatacao = LocalDate.of(data.getYear(), data.getMonth(), data.getDayOfMonth());

        float temperatura = Float.parseFloat(valoresLinha[1].toString());
        float umidade = Float.parseFloat(valoresLinha[2].toString());
        float pressao = Float.parseFloat(valoresLinha[3].toString());

        this.estacao.atualizarMedicoes(temperatura, umidade, pressao, dataSemFormatacao);

    }

    @Override
    public JInternalFrame getView() {
        return this.registros;
    }
    
    @Override
    public void setVisible(boolean visiblidade) {
        this.registros.setVisible(visiblidade);
        this.visible = visiblidade;
    }
    
    @Override
    public boolean getvisibilidade() {
        return this.visible;
    }

}
