package Controller;

import MVC.*;
import View.ViewHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerHome {
    ViewHome viewHome;
    public ControllerHome(ViewHome viewHome) {
        this.viewHome = viewHome;

        viewHome.btnSee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHome.setVisible(false);
                MVC_Simpanan mvc_simpanan = new MVC_Simpanan();
            }
        });
        viewHome.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHome.setVisible(false);
                MVC_AddSimpanan mvc_addSimpanan = new MVC_AddSimpanan();
            }
        });
        viewHome.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHome.setVisible(false);
                MVC_AddSimpanan mvc_editSimpanan = new MVC_AddSimpanan();
            }
        });
        viewHome.btnOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHome.setVisible(false);
                MVC_Logout mvc_logout = new MVC_Logout();
            }
        });
    }
}
