package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelTampil {
    Statement statement;

   public int getBanyakData(){
        try {
            int jmlData = 0;
            String query = "SELECT * FROM `simpan`";
            statement = DataBase.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public void insertSimpanan(String id_anggota, String nama, String id_buku, String judul){
        try{
            String query = "INSERT INTO `simpan` (`id_simpan`, `id_anggota`, `nama`, `id_buku`, `judul` ) VALUES ('0','"+id_anggota+"','"+nama+"','"+id_buku+"','"+judul+"')";
            statement = DataBase.getConnection().createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public String[][] readSimpan(){
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][5];
            String query = "SELECT * FROM `simpan`";
            ResultSet resultSet = statement.executeQuery(query);
            int i = 1;
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_simpan");
                data[jmlData][1] = resultSet.getString("id_anggota");
                data[jmlData][2] = resultSet.getString("nama");
                data[jmlData][3] = resultSet.getString("id_buku");
                data[jmlData][4] = resultSet.getString("judul");
                jmlData++;
                i++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public ArrayList<String> readAnggota(){
        try {
            ArrayList<String> data = new ArrayList<>();
            String query = "SELECT * FROM `simpan`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data.add(resultSet.getString("id_anggota"));
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public void updateSimpan(String id_anggota, String nama, String id_buku, String judul){
        try {
            String query = "UPDATE `simpan` SET `id_anggota` = '"+id_anggota+"',`nama`='" + nama + "',`id_buku`='" +id_buku +"', `judul`='" +judul +"'WHERE `id_anggota` = '" + id_anggota + "'";
            statement = DataBase.getConnection().createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteSimpan(String id_simpan){
        try {
            String query = "DELETE FROM `simpan` WHERE `id_simpan` = '" + id_simpan + "'";
            statement = DataBase.getConnection().createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

