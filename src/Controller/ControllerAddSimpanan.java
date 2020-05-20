package Controller;

import MVC.MVC_Home;
import Model.ModelTampil;
import View.ViewAddSimpanan;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

public class ControllerAddSimpanan implements ActionListener{
    ViewAddSimpanan viewAddSimpanan;
    ModelTampil modelTampil;

    public ControllerAddSimpanan(ViewAddSimpanan viewAddSimpanan,  ModelTampil modelTampil){
        this.viewAddSimpanan = viewAddSimpanan;
        this.modelTampil = modelTampil;
        if (modelTampil.getBanyakData() != 0){
            String data[][]  = modelTampil.readSimpan();
            viewAddSimpanan.table.setModel((TableModel) new JTable(data, viewAddSimpanan.namaKolom).getModel());
            updateDataCombo2(modelTampil.readAnggota());
        } else {
            JOptionPane.showMessageDialog(null, "Data Masih Kosong");
        }
        viewAddSimpanan.btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAddSimpanan.setVisible(false);
                MVC_Home mvc_home = new MVC_Home();
            }
        });
        viewAddSimpanan.btnInsert.addActionListener(this);
        viewAddSimpanan.btnReset1.addActionListener(this);
        viewAddSimpanan.btnUpdate.addActionListener(this);
        viewAddSimpanan.btnReset2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAddSimpanan.btnInsert) {
            String id_anggota = viewAddSimpanan.getId_anggota();
            String nama = viewAddSimpanan.getNama();
            String id_buku = viewAddSimpanan.getId_buku();
            String judul = viewAddSimpanan.getJudul();

            if (id_anggota.equals("")){
                JOptionPane.showMessageDialog(null, "Nim Tidak Boleh Kosong");
            } else if (id_anggota.length() != 9){
                JOptionPane.showMessageDialog(null, "Nim Harus 9 Digit");
            } else {
                modelTampil.insertSimpanan(id_anggota, nama, id_buku, judul);
                String newData[][] = modelTampil.readSimpan();
                viewAddSimpanan.table.setModel(new JTable(newData, viewAddSimpanan.namaKolom).getModel());
                updateDataCombo2(modelTampil.readAnggota());
            }
        } else if (e.getSource() == viewAddSimpanan.btnReset1){
            viewAddSimpanan.tfId_anggota.setText("");
            viewAddSimpanan.tfNama.setText("");
            viewAddSimpanan.tfId_buku.setText("");
            viewAddSimpanan.tfJudul.setText("");

        } else if (e.getSource() == viewAddSimpanan.btnUpdate){
            String id_anggota = viewAddSimpanan.getId_anggota2();
            String nama = viewAddSimpanan.getNama2();
            String id_buku = viewAddSimpanan.getId_buku2();
            String judul = viewAddSimpanan.getJudul2();

            if (nama.equals("") || id_buku.equals("") || judul.equals("")){
                JOptionPane.showMessageDialog(null, "Form Tidak Boleh Kosong");
            } else {
                modelTampil.updateSimpan(id_anggota, nama, id_buku, judul);
                String newData[][] = modelTampil.readSimpan();
                viewAddSimpanan.table.setModel(new JTable(newData, viewAddSimpanan.namaKolom).getModel());
                updateDataCombo2(modelTampil.readAnggota());
            }
        } else if (e.getSource() == viewAddSimpanan.btnReset2){
            viewAddSimpanan.tfNama2.setText("");
            viewAddSimpanan.tfId_buku2.setText("");
            viewAddSimpanan.tfJudul2.setText("");
        }
    }
    private void updateDataCombo2(ArrayList<String> data) {
        viewAddSimpanan.cbId_anggota.removeAllItems();
        for (String item : data) {
            viewAddSimpanan.cbId_anggota.addItem(item);
        }
    }
}
