package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewEditSimpanan extends JFrame {
    JLabel title = new JLabel("EDIT SIMPANAN");
    JLabel title2 = new JLabel("EDIT SIMPANAN");

    JLabel lId_anggota = new JLabel("ID ANGGOTA: ");
    public JComboBox cbId_anggota = new JComboBox();
    JLabel lNama2 = new JLabel("NAMA: ");
    public JTextField tfNama2 = new JTextField();
    JLabel lId_buku2 = new JLabel("ID BUKU: ");
    public JTextField tfId_buku2 = new JTextField();
    JLabel lJudul2 = new JLabel("JUDUL BUKU: ");
    public JTextField tfJudul2 = new JTextField();

    public JButton btnHome = new JButton("Home");
    public JButton btnUpdate = new JButton("Edit");
    public JButton btnReset2 = new JButton("Reset");

    Color salem  = new Color(249, 239, 234);
    Color red2 = new Color(150, 54, 54);
    Color red = new Color(212, 76, 76);
    Color green2 = new Color(61, 99, 65);
    Color green = new Color(85, 138, 90);
    Color yellow = new Color(255, 196, 33);
    Color pink = new Color(255, 148, 177);
    Color blue2 = new Color(51, 56, 173);
    Color blue = new Color(176, 208, 211);
    Color puce = new Color(192, 132, 151);
    Color orange  = new Color(247, 175, 157);
    Color peach = new Color(247, 227, 175);
    Color yellow2 = new Color(243, 238, 195);

    ImageIcon img = new ImageIcon("src\\Assets\\add.jpg");
    JLabel logo = new JLabel(img);

    Font font = new Font("Garamond",Font.ITALIC,20);
    Font font2 = new Font("Garamond",Font.PLAIN,20);

    public JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;
    public Object[] namaKolom= {"id_simpanan", "pengguna", "nama_barang", "jumlah"};
    public ViewEditSimpanan(){
        tableModel = new DefaultTableModel(getNamaKolom(), 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        getContentPane().setBackground(salem);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(400,50,1200,700);

        add(title);
        title.setBounds(315,50,800,50);
        title.setFont(new Font("Garamond",Font.BOLD,50));
        title.setForeground(blue2);
        add(title2);
        title2.setBounds(330,100,800,50);
        title2.setFont(new Font("Garamond",Font.BOLD,45));
        title2.setForeground(blue);

        add(logo);
        logo.setBounds(700,10,422,634);

        add(lId_anggota);
        lId_anggota.setBounds(150,180,200,35);
        lId_anggota.setFont(font2);
        add(cbId_anggota);
        cbId_anggota.setBounds(330,180,300,35);

        add(lNama2);
        lNama2.setBounds(150,230,200,35);
        lNama2.setFont(font2);
        add(tfNama2);
        tfNama2.setBounds(330,230,300,35);

        add(lId_buku2);
        lId_buku2.setBounds(150,280,200,35);
        lId_buku2.setFont(font2);
        add(tfId_buku2);
        tfId_buku2.setBounds(330,280,300,35);

        add(lJudul2);
        lJudul2.setBounds(150,330,200,35);
        lJudul2.setFont(font2);
        add(tfJudul2);
        tfJudul2.setBounds(330,330,300,35);

        add(btnUpdate);
        btnUpdate.setBounds(530, 430, 100, 50);
        btnUpdate.setFont(font);
        btnUpdate.setBackground(green2);
        btnUpdate.setForeground(salem);
        add(btnReset2);
        btnReset2.setBounds(530, 480, 100, 50);
        btnReset2.setFont(font);
        btnReset2.setBackground(red2);
        btnReset2.setForeground(salem);

        add(btnHome);
        btnHome.setBounds(30, 55, 75, 50);
        btnHome.setFont(font);
        btnHome.setBackground(blue);
        btnHome.setForeground(blue2);
    }

    public String getNama2(){
        return tfNama2.getText();
    }
    public String getId_buku2(){
        return tfId_buku2.getText();
    }
    public String getJudul2(){
        return tfJudul2.getText();
    }

    public Object[] getNamaKolom() {
        return namaKolom;
    }
    public void setNamaKolom(Object[] namaKolom) {
        this.namaKolom = namaKolom;
    }

    public String getId_anggota2() {return cbId_anggota.getSelectedItem().toString();
    }
}
