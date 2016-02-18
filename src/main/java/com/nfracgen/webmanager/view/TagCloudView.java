package com.nfracgen.webmanager.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;
 
@ManagedBean
public class TagCloudView {
     
    private TagCloudModel model;
     
    @PostConstruct
    public void init() {
        model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Scanline","#", 2));
        model.addTag(new DefaultTagCloudItem("Darwin01", "#", 3));
        model.addTag(new DefaultTagCloudItem("Falhas", "#", 5));
        model.addTag(new DefaultTagCloudItem("NfracGen", 4));
        model.addTag(new DefaultTagCloudItem("Fraturas", "#", 2));
        model.addTag(new DefaultTagCloudItem("WEB", 5));
        model.addTag(new DefaultTagCloudItem("Mobile",  3));
        model.addTag(new DefaultTagCloudItem("Afloramento", "#", 4));
        model.addTag(new DefaultTagCloudItem("Rochas", "#", 1));
    }
 
    public TagCloudModel getModel() {
        return model;
    }
     
    public void onSelect(SelectEvent event) {
        TagCloudItem item = (TagCloudItem) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
