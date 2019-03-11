/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author proserpio_giacomo
 */
public class Verifica {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        List<Vino> vino = null;
        Parser dom = new Parser();
        try {
            vino = dom.parseDocument("circolareVerifica.xml");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        // iterazione della lista e visualizzazione degli oggetti
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1,2,3,4:");
        String risposta=br.readLine();
        if(risposta.equals("1")){
            System.out.println("inserisci anno:");
            String r=br.readLine();
            System.out.println("inserisci regione:");
            String r2=br.readLine();
            for(Vino doc:vino){
                if(r.equals(doc.getAnno())&& r2.equals(doc.getRegione())){
                    System.out.println(doc.toString());
                }
            }
        }
        if(risposta.equals("2")){
            int h=0;
            System.out.println("inserisci anno:");
            String r3=br.readLine();
            for(Vino doc:vino){
                if(r3.equals(doc.getAnno())){
                    h=h+doc.getDaTavola();
                    
                }
            }
            System.out.println(h);
        }
         
        }
        

    }

