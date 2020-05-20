package MVC;

import Controller.ControllerSimpanan;
import Model.ModelTampil;
import View.ViewSimpanan;


public class MVC_Simpanan {
    ViewSimpanan viewSimpanan = new ViewSimpanan();
    ModelTampil modelTampil = new ModelTampil();
    ControllerSimpanan controllerSimpanan = new ControllerSimpanan(viewSimpanan, modelTampil);
}
