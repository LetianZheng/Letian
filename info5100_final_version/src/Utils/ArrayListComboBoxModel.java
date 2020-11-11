/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author llm
 */
public class ArrayListComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
    private Object selectedItem; 
 
    private ArrayList anArrayList;


    @Override
    public int getSize() {
        return anArrayList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return anArrayList.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem; 
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
    public ArrayListComboBoxModel(ArrayList arrayList) { 
        anArrayList = arrayList; 
    }
    
    
    
}
