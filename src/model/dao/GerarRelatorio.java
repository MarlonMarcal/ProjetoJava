/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conection.ConnectionFactory;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlon
 */
public class GerarRelatorio {/*
  
    public static void gerarRelatorioProd(Date dataInicio, Date dataFim, String grupo, String marca) throws Exception {

        try {

            Map params = new HashMap();
            params.put("data_inicio", dataInicio);
            params.put("data_fim", dataFim);
            params.put("marca", marca);
            params.put("grupo", grupo);
            
            System.out.println("Parametros DI:"+dataInicio+" DF:"+ dataFim +" M:"+ marca +" G:"+ grupo );

            JasperReport jas = (JasperReport) JRLoader.loadObjectFromFile("C:/Reports/produtos.jasper");

            JasperPrint jasprint = JasperFillManager.fillReport(jas, params, ConnectionFactory.getConnection());

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:/Reports/emitidos/produtos.pdf");
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasprint);
            exporter.exportReport();

            JasperViewer viewer = new JasperViewer(jasprint, false);
            viewer.show();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("ERRO METODO:"+ ex);
            throw ex;
        }

    }

*/}
