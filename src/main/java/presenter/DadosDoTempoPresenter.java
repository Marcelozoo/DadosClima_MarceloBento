package presenter;

import view.DadosTempoView;
import javax.swing.JInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import model.EstacaoClimatica;

public class DadosDoTempoPresenter {

    final private DadosTempoView media;
    final private EstacaoClimatica estacao;


    public DadosDoTempoPresenter(EstacaoClimatica estacao) {

        this.media = new DadosTempoView();
        this.estacao = estacao;

        inserirDados();

    }

    private void inserirDados() {
        media.getBtn().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField data = media.getTextFieldData();
                JTextField temperatura = media.getTextFieldTemperatura();
                JTextField umidade = media.getTextFieldUmidade();
                JTextField pressao = media.getTextFieldPressao();

                try {
                    if (data.getText().isEmpty()) {
                        throw new RuntimeException("Campo Vazio!");
                    }
                } catch (RuntimeException excecao) {
                    JOptionPane.showMessageDialog(null, excecao.getMessage());
                    return;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    LocalDate valorData = LocalDate.parse(data.getText(), formatter);
                    float valorTemp = Float.parseFloat(temperatura.getText());
                    float valorUmidade = Float.parseFloat(umidade.getText());
                    float valorPressao = Float.parseFloat(pressao.getText());

                    estacao.atualizarMedicoes(valorTemp, valorUmidade, valorPressao, valorData);

                    limpaCamposDeTexto(temperatura, umidade, pressao, data);
                    JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso!");
                } catch (DateTimeParseException excecao) {
                    JOptionPane.showMessageDialog(null, "Data está no formato errado!");
                    return;
                }

            }
        });
    }

    public void limpaCamposDeTexto(JTextField temp, JTextField umidade, JTextField pressao, JTextField data) {
        temp.setText("");
        umidade.setText("");
        pressao.setText("");
        data.setText("");

    }

    public JInternalFrame getView() {
        return this.media;
    }
}
