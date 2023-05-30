package presenter;

import javax.swing.JFrame;
import model.EstacaoClimatica;
import presenter.interfaces.IPainel;
import view.DadosClimaView;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class DadosClimaPresenter {

    final DadosClimaView telaPrincipal;
    final private DadosDoTempoPresenter dadosTempo;
    final private IPainel atualizaTempoObserver;
    final private IPainel dadosMediosObserver;
    final private IPainel registrosObserver;
    final private IPainel telaGrafico;
    final private IPainel configuraTela;
    final private EstacaoClimatica estacao;

    public DadosClimaPresenter() {

        this.telaPrincipal = new DadosClimaView();
        this.telaPrincipal.setLocationRelativeTo(null);
        this.telaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.estacao = new EstacaoClimatica();

        atualizaTempoObserver = new PainelAtualizacaoObserverPresenter();
        dadosMediosObserver = new DadosMediosObserverPresenter(this.telaPrincipal.getLabelQuantideRegistro());
        registrosObserver = new RegistrosObserverPresenter(this.estacao);
        telaGrafico = new MaximasEMinimasObserverPresenter();
        configuraTela = new ConfiguracaoObserverPresenter();

        
        this.estacao.registrarPainel(atualizaTempoObserver);
        this.estacao.registrarPainel(dadosMediosObserver);
        this.estacao.registrarPainel(registrosObserver);
        this.estacao.registrarPainel(telaGrafico);
        this.estacao.registrarPainel(configuraTela);

        this.dadosTempo = new DadosDoTempoPresenter(this.estacao);

        this.mostrarTodasTelas();
        this.gerenciaTelaDeConfiguracao();

    }

    private void mostrarTodasTelas() {

        JDesktopPane desktopPainel = telaPrincipal.getDesktopPanel();

        JInternalFrame dadosClima = dadosTempo.getView();
        JInternalFrame ultimaAtualizacao = atualizaTempoObserver.getView();
        JInternalFrame mediaDados = dadosMediosObserver.getView();
        JInternalFrame registros = registrosObserver.getView();
        JInternalFrame graficoTela = telaGrafico.getView();
        JInternalFrame configuracoesTela = configuraTela.getView();

        desktopPainel.add(dadosClima);
        desktopPainel.add(ultimaAtualizacao);
        desktopPainel.add(mediaDados);
        desktopPainel.add(registros);
        desktopPainel.add(graficoTela);
        desktopPainel.add(configuracoesTela);
    }

    private void gerenciaTelaDeConfiguracao() {
        JMenu menuItem = telaPrincipal.getItemMenuConfigura();

        menuItem.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                if(configuraTela.getvisibilidade() == false){
                    configuraTela.setVisible(true);
                }else{
                    configuraTela.setVisible(false);
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {
             
            }
        });
    }

}
