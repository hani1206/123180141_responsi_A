package MVC;

import Controller.ControllerAddSimpanan;
import Model.ModelTampil;
import View.ViewAddSimpanan;

public class MVC_AddSimpanan {
    public MVC_AddSimpanan(){
        ViewAddSimpanan viewAddSimpanan = new ViewAddSimpanan();
        ModelTampil modelTampil = new ModelTampil();
        ControllerAddSimpanan controllerAddSimpanan = new ControllerAddSimpanan(viewAddSimpanan, modelTampil);
    }
}
