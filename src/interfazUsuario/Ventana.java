package interfazUsuario;

import logicaApp.Alumno;
import logicaApp.Alumnos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Ventana extends JFrame {
    ArrayList<Alumno> alumnos;
    public Ventana(Alumnos alumnos) {
        this.alumnos = alumnos.getAlumnos();
        setTitle("Ventana");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel = addAlumno();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panel, gbc);

        JScrollPane tabla = addTable();
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
        JTextField txtAlumno = new JTextField();
        txtAlumno.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtAlumno, gbc);
        //x=2,y=0 JCombobox Curso
        JComboBox cbAlumno = new JComboBox();
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
        JTextField txtApelido = new JTextField();
        txtApelido.setColumns(15);
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

    public JScrollPane addTable(){
        ArrayList<String[]> data = getData();
        String[] columnas = {"Nombre", "Apellido", "Curso"};
        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        for (String[] row: data){
            tableModel.addRow(row);
        }

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
}
