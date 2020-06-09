package ru.geekbrains.lesson8;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MyWindow extends JFrame {

    public MyWindow(){
        setSize(500,500);
        setLocation(650,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        MyTableModel tableModel = new MyTableModel();
        JTable table1 = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table1);


        JPanel insertPanel = new JPanel(new GridLayout(2,1));
        JPanel textFieldPanel = new JPanel(new GridLayout(1,table1.getColumnCount()));

        JButton buttonAdd = new JButton("Add");

        JTextField[] insertTextField = new JTextField[table1.getColumnCount()];
        for(int i =0 ; i< table1.getColumnCount(); i++){
            insertTextField[i] = new JTextField();
            textFieldPanel.add(insertTextField[i]);
        }

        insertPanel.add(textFieldPanel);
        insertPanel.add(buttonAdd);


        add(insertPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        String[] strings = {"Петров", "Иван", "Иваныч", "315-58-44"};
        tableModel.addValue(strings);


        ActionListener addButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] str = new String[table1.getColumnCount()];
                for (int i=0; i<table1.getColumnCount(); i++){
                    str[i] = insertTextField[i].getText();
                }
                tableModel.addValue(str);
                tableModel.fireTableDataChanged();
                //System.out.println(Arrays.toString(str));
            }
        };

        buttonAdd.addActionListener(addButtonListener);


        setVisible(true);


    }

}
