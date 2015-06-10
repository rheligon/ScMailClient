/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sconnectmail;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author pbcgjp
 */
class ShadedTableCellRenderer implements TableCellRenderer {
    JCheckBox checkBox = new JCheckBox();

    public Component getTableCellRendererComponent( JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column ) {
        checkBox.setEnabled(true);
     
        if ( value != null ) {
            checkBox.setSelected( ( (Boolean)value ).booleanValue() );

            checkBox.setHorizontalAlignment( JLabel.CENTER );
            checkBox.setBackground( Color.white );
        }
        else{
            return null;
        }      

        return checkBox;
    }
}
