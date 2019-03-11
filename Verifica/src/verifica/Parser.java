/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author proserpio_giacomo
 */
public class Parser {
     private List link;

    public Parser() {
        link = new ArrayList();
    }

    public List parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Vino vino;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("row");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                vino= getVino(element);
                link.add(vino);
            }
        }
        return link;
    }

    private Vino getVino(Element element) {
        Vino vino;
        NodeList nodelist;

        String anno="",regione="",codice="";
        int docDocg=0,igt=0, daTavola=0,totale=0;
        Element el;

        nodelist = element.getElementsByTagName("anno");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        el = (Element) nodelist.item(i);
        anno=getTextValue(el);
        }
        }
        
        nodelist = element.getElementsByTagName("regione");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        el = (Element) nodelist.item(i);
        regione=getTextValue(el);
        }
        }
        
        nodelist = element.getElementsByTagName("codice");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        el = (Element) nodelist.item(i);
        codice=getTextValue(el);
        }
        }
        
         nodelist = element.getElementsByTagName("d_o_c__e_d_o_c_g_");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        el = (Element) nodelist.item(i);
        docDocg=Integer.parseInt(getTextValue(el));
        }
        }
        
        nodelist = element.getElementsByTagName("i_g_t_");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        el = (Element) nodelist.item(i);
        if(getTextValue(el)!=null){
         igt=Integer.parseInt(getTextValue(el));
        }else{
            igt=0;
        }
        }
        }
        
        nodelist = element.getElementsByTagName("da_tavola");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        el = (Element) nodelist.item(i);
        if(getTextValue(el)!=null){
         daTavola=Integer.parseInt(getTextValue(el));
        }else{
            daTavola=0;
        }
        }
        }
        
         nodelist = element.getElementsByTagName("totale");
        if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        el = (Element) nodelist.item(i);
        totale=Integer.parseInt(getTextValue(el));
        }
        }
        
        
        vino = new Vino(anno,regione,codice, docDocg, igt, daTavola, totale);
        return vino;
    }
     
    
    // restituisce il valore testuale dell’elemento figlio specificato
 private String getTextValue(Element element) {
        String value = null;
        if (element != null ) {
        Node el = element.getFirstChild();
        if(el!=null){
           value = el.getNodeValue();
        }
        }       
        return value;
         }
    
}