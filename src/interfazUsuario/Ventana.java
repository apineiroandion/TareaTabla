package interfazUsuario;

import logicaApp.Alumno;
import logicaApp.Alumnos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana extends JFrame {
    ArrayList<Alumno> alumnos = new ArrayList<>();
    JComboBox cbAlumno;
    JPanel panel;
    JScrollPane tabla;
    ArrayList<String[]> data = getData();
    String[] columnas = {"Nombre", "Apellido", "Curso"};
    DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

    JTextField txtAlumno;
    JTextField txtApelido;

    public Ventana(Alumnos alumnos) {
        this.alumnos = alumnos.getAlumnos();
        setTitle("Ventana");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panel = addAlumno();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panel, gbc);

        tabla = addTable();
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(tabla, gbc);

        setVisible(true);
    }
    public JPanel addAlumno (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Insets padding = new Insets(10, 10, 10, 10);

        //x=0,y=0 LabelName
        JLabel lblAlumno = new JLabel("Name");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = padding;
        panel.add(lblAlumno, gbc);
        //x=1,y=0 JTextName
        txtAlumno = new JTextField();
        txtAlumno.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtAlumno, gbc);
        //x=2,y=0 JCombobox Curso
        String[] opciones = {"DAM 1", "DAM 2"};
        cbAlumno = new JComboBox(opciones);
        cbAlumno.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(cbAlumno, gbc);
        //x=0,y=1 LabelApelido
        JLabel lblApelido = new JLabel("Apelido");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblApelido, gbc);
        //x=1,y=1 JTextApelido
        txtApelido = new JTextField();
        txtApelido.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtApelido, gbc);
        //x=1,y=1 JButton AddTable
        JButton addTable = new JButton("Add Table");
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(addTable, gbc);

        addTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newAlumno();
                data = getData();
                addRowTable();
                tabla.repaint();
            }
        });

        panel.setVisible(true);
        return panel;
    }

    public JScrollPane addTable(){
        for (String[] row: data){
            tableModel.addRow(row);
        }
        JTable table= new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }
    public JScrollPane addRowTable(){
        tableModel.addRow(new String[]{
                txtAlumno.getText(),
                txtApelido.getText(),
                cbAlumno.getSelectedItem().toString()
        });
        JTable table= new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }
    public ArrayList<String[]> getData() {
        ArrayList<String[]> data = new ArrayList<>();
        for (int i = 0; i < alumnos.size(); i++){
            data.add(new String[]{alumnos.get(i).getName(),
                    alumnos.get(i).getSurnume(), alumnos.get(i).getCurso()});
        }
        return data;
    }
    public void newAlumno(){
        alumnos.add(new Alumno(
               txtAlumno.getText(),
               txtApelido.getText(),
                cbAlumno.getSelectedItem().toString()
        ));
    }

}
