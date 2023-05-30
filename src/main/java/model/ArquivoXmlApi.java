package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoXmlApi {

    private BufferedWriter arquivoXml;

    public void salvarLog(LocalDate data, LocalTime hora, String tipoOperacao) {

        if (this.arquivoXml == null) {
            criaArquivo();
        } else {
            try {
                this.arquivoXml = new BufferedWriter(new FileWriter("log.xml", true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Log", Log.class);

        Log log = new Log(data, hora, tipoOperacao);

        String xml = xstream.toXML(log);

        try {
            arquivoXml.write(xml);
            arquivoXml.newLine();
            arquivoXml.flush();
            arquivoXml.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void criaArquivo() {
        try {
            this.arquivoXml = new BufferedWriter(new FileWriter("log.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
