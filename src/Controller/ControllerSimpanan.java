package Controller;

import MVC.MVC_Home;
import Model.ModelTampil;
import View.ViewSimpanan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerSimpanan {
    ViewSimpanan viewSimpanan;
    ModelTampil modelTampil;

    public ControllerSimpanan(ViewSimpanan viewSimpanan, ModelTampil modelTampil){
        this.viewSimpanan = viewSimpanan;
        this.modelTampil = modelTampil;
        if (modelTampil.getBanyakData() != 0) {
            String data[][] = modelTampil.readSimpan();
            viewSimpanan.tabel.setModel((new JTable(data, viewSimpanan.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        viewSimpanan.btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSimpanan.setVisible(false);
                MVC_Home mvc_home = new MVC_Home();
            }
        });
        viewSimpanan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewSimpanan.tabel.getSelectedRow();
                int kolom = viewSimpanan.tabel.getSelectedColumn();

                String dataterpilih = viewSimpanan.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    modelTampil.deleteSimpan(dataterpilih);
                    String newData[][] = modelTampil.readSimpan();
                    viewSimpanan.tabel.setModel(new JTable(newData,viewSimpanan.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

    }
}
