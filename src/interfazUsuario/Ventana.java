package interfazUsuario;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Ventana");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panel, gbc);

        setVisible(true);
    }
    public JPanel addAlumno (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //x=0,y=0 LabelName
        JLabel lblAlumno = new JLabel("Name");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblAlumno, gbc);
        //x=1,y=0 JTextName
        JTextField txtAlumno = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtAlumno, gbc);
        //x=2,y=0 JCombobox Curso
        JComboBox cbAlumno = new JComboBox();
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(cbAlumno, gbc);
        //x=0,y=1 LabelApelido
        JLabel lblApelido = new JLabel("Apelido");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblApelido, gbc);
        //x=1,y=1 JTextApelido
        JTextField txtApelido = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtApelido, gbc);
        //x=1,y=1 JButton AddTable
        JButton addTable = new JButton("Add Table");
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(addTable, gbc);

        panel.setVisible(true);
        return panel;
    }
}
