package ru.geekbrains.lesson8;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Stack;

public class MyTableModel extends AbstractTableModel {

    private int rowCount;
    private ArrayList<String []> dataArray;



    public MyTableModel(){
        dataArray = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return dataArray.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dataArray.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0 : return "Фамилия";
            case 1 : return "Имя";
            case 2 : return "Отчество";
            case 3 : return "Телефон";
        }
        return "";
    }

    public void addValue(String [] row){
        String [] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArray.add(rowCount, row);
    }
}
