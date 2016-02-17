package com.nfracgen.webmanager.view;

import java.io.Serializable;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;
 
@ManagedBean
@ViewScoped
public class MindmapView implements Serializable {
     
    
	private static final long serialVersionUID = 1L;

	private MindmapNode root;
     
    private MindmapNode selectedNode;
     
    public MindmapView() {
        root = new DefaultMindmapNode("NFracGen.com", "NfracGen WebSite", "FFCC00", false);
        
        //root2 = new DefaultMindmapNode("CODE-BRIGHT", "NfracGen WebSite", "FFCC00", false);
         
        MindmapNode equip = new DefaultMindmapNode("EQUIPAMENT", "Darwin01 medidor", "6e9ebf", true);
        MindmapNode mobile = new DefaultMindmapNode("MOBILE", "Prog Android", "6e9ebf", true);
        MindmapNode web = new DefaultMindmapNode("WEB", "Webservices", "6e9ebf", true);
        MindmapNode desk = new DefaultMindmapNode("DESKTOP", "Gerador de fraturas", "6e9ebf", true);
         
        root.addNode(desk);
        root.addNode(web);
        root.addNode(mobile);
        root.addNode(equip);
        
        
    }
 
    public MindmapNode getRoot() {
        return root;
    }
 
    public MindmapNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }
 
    public void onNodeSelect(SelectEvent event) {
        MindmapNode node = (MindmapNode) event.getObject();
         
        //populate if not already loaded
        if(node.getChildren().isEmpty()) {
            Object label = node.getLabel();
 
            if(label.equals("WEB")) {
               
                   node.addNode(new DefaultMindmapNode("Análise", "Namespace of Google", "82c542", false));
                   node.addNode(new DefaultMindmapNode("Simulação", "Namespace of Google", "82c542", false));
                   node.addNode(new DefaultMindmapNode("Aramazenamento", "Namespace of Google", "82c542", false));
                   node.addNode(new DefaultMindmapNode("Filtro", "Namespace of Google", "82c542", false));
                
            }
            
            else if(label.equals("DESKTOP")) {
                   
            	node.addNode(new DefaultMindmapNode("GUI", "IP Number: 1.1.1.", "fce24f", false));
            	node.addNode(new DefaultMindmapNode("CODE-BRIGHT", "IP Number: 1.1.1.", "fce24f", false));
                 
            }
            
            else if(label.equals("EQUIPAMENT")) {
                
            	node.addNode(new DefaultMindmapNode("Darwin01", "-", "fce24f", false));
            	node.addNode(new DefaultMindmapNode("Android App", "-", "fce24f", false));
                 
            }
            
            else if(label.equals("MOBILE")) {
                for(int i = 0; i < 8; i++) {
                    String random = UUID.randomUUID().toString();
                    node.addNode(new DefaultMindmapNode("Malware-"  + random, "Malicious Software: " + random, "3399ff", false));
                }
            }
        }   
    }
     
    public void onNodeDblselect(SelectEvent event) {
        this.selectedNode = (MindmapNode) event.getObject();        
    }
}
