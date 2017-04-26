package com.lifeweb.ui.satis;

import com.jidesoft.swing.DefaultOverlayable;
import com.jidesoft.swing.StyledLabelBuilder;
import com.lifeweb.enitity.helper.DaoHelper;
import com.lifeweb.ui.MainUI;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SatisUrunUI {

    private static JTable table;

    protected static JPanel createTable(TableModel model) {
        table = new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(290, 200);
            }
        };
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);

        final DefaultOverlayable overlayTable = new DefaultOverlayable(new JScrollPane(table));
     
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    satisUI.getBarkodField().setText(table.getValueAt(table.getSelectedRow(), 0).toString());
                    satisUI.barkodRead();
                }
            }
        });
        table.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                        satisUI.getBarkodField().setText(table.getValueAt(table.getSelectedRow(), 0).toString());
                    satisUI.barkodRead();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        String text = "";
        int row = model.getRowCount();
        if (row == 0) {
            overlayTable.addOverlayComponent(StyledLabelBuilder.createStyledLabel(text));
        }else{
            table.requestFocus();
        }

        return overlayTable;
    }

    static class QuoteTableModel extends DefaultTableModel {

        public QuoteTableModel() {
            super(new String[]{"Barkod", "Ürün Adı"}, 0);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            return String.class;
        }
    }
static SatisUI satisUI;
    public static JPanel tableList(String value,SatisUI ui) {
        satisUI=ui;
        DefaultTableModel model = new QuoteTableModel();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            value = "%" + value + "%";
            Connection con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT BARKOD_ID,URUN_ADI FROM urunler where URUN_ADI like ? or BARKOD_ID like ? limit 10");

            pstmt.setObject(1, value);
            pstmt.setObject(2, value);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2)});
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createTable(model);
    }

    public static JTable getTable() {
        return table;
    }

}
