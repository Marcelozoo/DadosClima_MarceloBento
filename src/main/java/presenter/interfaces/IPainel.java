
package presenter.interfaces;

import javax.swing.JInternalFrame;
import model.DadoClima;

public interface IPainel {
    
    void atualizar(DadoClima dadoClima);
    JInternalFrame getView();
    public void setVisible(boolean visiblidade);
    public boolean getvisibilidade();
    
}
