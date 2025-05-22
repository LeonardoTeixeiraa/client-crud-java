/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.ctr;

import java.sql.*;
import br.com.projeto_3.dao.ConexaoDAO;
import java.io.InputStream;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author leonardo-teixeira
 */
public class RelatorioCTR {

    public RelatorioCTR() {
    }

    public JFrame abrirRelatorio(String relatorio, String titulo, Map parametros) {
        try {
            //Cria um stream com os dados do relatorio
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("br/com/projeto3/rel/" + relatorio);
            
            //Gerando a impressão  do relatorio
            JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, getConexao());
            
            //Fechando  o banco de dados  que foi aberto  para gerar o relatorio
            CloseDB();
            
            //Monatando  a vizualizacao do relatorio
            JRViewer viewer = new JRViewer(print);
            
            //Criando um frame para exibir o relatorio
            JFrame frameRelatorio = new JFrame(titulo);
            
            //adiciona o JRViewer  no Frame 
            frameRelatorio.add(viewer);
            
            //maximiza o JFrame para ocupar a tela toda
            frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            //configura a operaçao  padrao  quando o JFrame  for fechado
            frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            //retorna o JFrame  com o relatorio para ser mostrado na VIEW 
            return frameRelatorio;
            
        } catch (Exception e) {
            System.out.println("Entrou erro no metodo abrirRelatorio");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Connection getConexao(){
           return ConexaoDAO.ConnectDBRels();
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
