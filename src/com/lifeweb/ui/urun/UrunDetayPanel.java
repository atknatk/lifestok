/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.urun;

import com.jidesoft.converter.ConverterContext;
import com.jidesoft.converter.DoubleConverter;
import com.jidesoft.grid.AbstractMultiTableModel;
import com.jidesoft.grid.AutoResizePopupMenuCustomizer;
import com.jidesoft.grid.CellStyle;
import com.jidesoft.grid.ColumnIdentifierTableModel;
import com.jidesoft.grid.CsvTableScrollPaneUtils;
import com.jidesoft.grid.HeaderStyleModel;
import com.jidesoft.grid.MultiTableModel;
import static com.jidesoft.grid.MultiTableModel.FOOTER_COLUMN;
import static com.jidesoft.grid.MultiTableModel.HEADER_COLUMN;
import static com.jidesoft.grid.MultiTableModel.REGULAR_COLUMN;
import com.jidesoft.grid.StyleModel;
import com.jidesoft.grid.TableColumnChooserPopupMenuCustomizer;
import com.jidesoft.grid.TableHeaderPopupMenuInstaller;
import com.jidesoft.grid.TableScrollPane;
import com.jidesoft.hssf.HssfTableScrollPaneUtils;
import com.jidesoft.hssf.HssfTableUtils;
import com.jidesoft.swing.PartialLineBorder;
import com.jidesoft.swing.PartialSide;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.enitity.helper.DaoHelper;
import com.lifeweb.ui.helper.UIConfig;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author Atakan
 */
public class UrunDetayPanel extends javax.swing.JFrame {

    protected MultiTableModel _totalModel;
    protected MultiTableModel _model;
    protected MultiTableModel _subHeaderModel;
    public TableScrollPane _pane;
    private static final long serialVersionUID = -5850105228695796397L;
    protected Color COLOR_MAIN = new Color(255, 254, 203);
    protected Color COLOR_HEADER = new Color(233, 254, 203);
    protected Color COLOR_CORNER = new Color(32, 32, 32);
    private static CellStyle SALES_STYLE = new CellStyle();
    private static CellStyle PROFITS_STYLE = new CellStyle();
    private static CellStyle BOLD_STYLE = new CellStyle();
    private static CellStyle FOOTER_STYLE = new CellStyle();
    private String _tablePref;
    private String _lastDirectory = ".";
    private int id;

    static {
        SALES_STYLE.setForeground(new Color(0, 128, 0));
        SALES_STYLE.setHorizontalAlignment(SwingConstants.CENTER);
        PROFITS_STYLE.setForeground(Color.blue);
        PROFITS_STYLE.setHorizontalAlignment(SwingConstants.CENTER);
        BOLD_STYLE.setFontStyle(Font.BOLD);
        BOLD_STYLE.setHorizontalAlignment(SwingConstants.CENTER);

        FOOTER_STYLE.setForeground(Color.YELLOW);
    }

    public UrunDetayPanel(Urunler urun) throws HeadlessException {
        this.id = urun.getUrunId();
        Locale.setDefault(new Locale("tr", "TR"));
        init();
        setLocation(UIConfig.getLocation(this));
        setTitle(urun.getUrunAdi());
        setAlwaysOnTop(true);

        Locale.setDefault(Locale.ENGLISH);
    }

    JPanel jPanel1;

    private void init() {

        add(getDemoPanel());
        pack();
    }

    public Component getDemoPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 400));
        panel.setLayout(new BorderLayout());
        panel.add(createTablePane(), BorderLayout.CENTER);
        return panel;
    }

    private TableScrollPane createTablePane() {
        _model = new DummyTableModel();
        _totalModel = new DummyFooterTableModel(_model);
        _subHeaderModel = new DummyHeaderTableModel(_model);
        _pane = new TableScrollPane(_model, _subHeaderModel, _totalModel, true);

        //    _pane.getRowHeaderTable().setBackground(COLOR_MAIN);
        _pane.getMainTable().setBackground(COLOR_MAIN);
        _pane.getRowFooterTable().setBackground(COLOR_MAIN);

        _pane.getColumnHeaderTable().setBackground(COLOR_HEADER);
        _pane.getRowHeaderColumnHeaderTable().setBackground(COLOR_HEADER);
        _pane.getRowFooterColumnHeaderTable().setBackground(COLOR_HEADER);

        _pane.getColumnFooterTable().setBackground(COLOR_CORNER);
        _pane.getRowHeaderColumnFooterTable().setBackground(COLOR_CORNER);
        _pane.getRowFooterColumnFooterTable().setBackground(COLOR_CORNER);

        Border border = new PartialLineBorder(Color.DARK_GRAY, 2, PartialSide.SOUTH);
        _pane.getRowHeaderColumnHeaderTable().setBorder(border);
        _pane.getColumnHeaderTable().setBorder(border);
        _pane.getRowFooterColumnHeaderTable().setBorder(border);

        TableHeaderPopupMenuInstaller installer = new TableHeaderPopupMenuInstaller(_pane.getMainTable()) {
            @Override
            protected void customizeMenuItems(final JTableHeader header, final JPopupMenu popup, final int clickingColumn) {
                super.customizeMenuItems(header, popup, clickingColumn);

                addSeparatorIfNecessary(popup);

                final JMenuItem export = new JMenuItem(new AbstractAction("Export to Excel 2003 format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        _pane.putClientProperty(HssfTableUtils.CLIENT_PROPERTY_EXCEL_OUTPUT_FORMAT, HssfTableUtils.EXCEL_OUTPUT_FORMAT_2003);
                        if (!HssfTableUtils.isHssfInstalled()) {
                            JOptionPane.showMessageDialog((Component) e.getSource(), "Export to Excel feature is disabled because POI-HSSF jar is missing in the classpath.");
                            return;
                        }
                        outputToExcel(e);
                    }
                });

                final JMenuItem export2007 = new JMenuItem(new AbstractAction("Export to Excel 2007 format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        _pane.putClientProperty(HssfTableUtils.CLIENT_PROPERTY_EXCEL_OUTPUT_FORMAT, HssfTableUtils.EXCEL_OUTPUT_FORMAT_2007);
                        if (!HssfTableUtils.isXssfInstalled()) {
                            JOptionPane.showMessageDialog((Component) e.getSource(), "Export to Excel 2007 feature is disabled because one or several POI-XSSF dependency jars are missing in the classpath. Please include all the jars from poi release in the classpath and try to run again.");
                            return;
                        }
                        outputToExcel(e);
                    }
                });

                final JMenuItem exportToCsv = new JMenuItem(new AbstractAction("Export to CSV format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        outputToCsv(e);
                    }
                });
                popup.add(export);
                popup.add(export2007);
                popup.add(exportToCsv);
            }
        };
        installer.addTableHeaderPopupMenuCustomizer(new AutoResizePopupMenuCustomizer());
        installer.addTableHeaderPopupMenuCustomizer(new TableColumnChooserPopupMenuCustomizer());

        TableHeaderPopupMenuInstaller installer2 = new TableHeaderPopupMenuInstaller(_pane.getRowFooterTable()) {
            @Override
            protected void customizeMenuItems(final JTableHeader header, final JPopupMenu popup, final int clickingColumn) {
                super.customizeMenuItems(header, popup, clickingColumn);

                addSeparatorIfNecessary(popup);

                final JMenuItem export = new JMenuItem(new AbstractAction("Export to Excel 2003 format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        _pane.putClientProperty(HssfTableUtils.CLIENT_PROPERTY_EXCEL_OUTPUT_FORMAT, HssfTableUtils.EXCEL_OUTPUT_FORMAT_2003);
                        if (!HssfTableUtils.isHssfInstalled()) {
                            JOptionPane.showMessageDialog((Component) e.getSource(), "Export to Excel feature is disabled because POI-HSSF jar is missing in the classpath.");
                            return;
                        }
                        outputToExcel(e);
                    }
                });

                final JMenuItem export2007 = new JMenuItem(new AbstractAction("Export to Excel 2007 format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        _pane.putClientProperty(HssfTableUtils.CLIENT_PROPERTY_EXCEL_OUTPUT_FORMAT, HssfTableUtils.EXCEL_OUTPUT_FORMAT_2007);
                        if (!HssfTableUtils.isXssfInstalled()) {
                            JOptionPane.showMessageDialog((Component) e.getSource(), "Export to Excel 2007 feature is disabled because one or several POI-XSSF dependency jars are missing in the classpath. Please include all the jars from poi release in the classpath and try to run again.");
                            return;
                        }
                        outputToExcel(e);
                    }
                });

                final JMenuItem exportToCsv = new JMenuItem(new AbstractAction("Export to CSV format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        outputToCsv(e);
                    }
                });
                popup.add(export);
                popup.add(export2007);
                popup.add(exportToCsv);
            }
        };
        installer2.addTableHeaderPopupMenuCustomizer(new AutoResizePopupMenuCustomizer());
        installer2.addTableHeaderPopupMenuCustomizer(new TableColumnChooserPopupMenuCustomizer());

        TableHeaderPopupMenuInstaller installer3 = new TableHeaderPopupMenuInstaller(_pane.getRowHeaderTable()) {
            @Override
            protected void customizeMenuItems(final JTableHeader header, final JPopupMenu popup, final int clickingColumn) {
                super.customizeMenuItems(header, popup, clickingColumn);

                addSeparatorIfNecessary(popup);

                final JMenuItem export = new JMenuItem(new AbstractAction("Export to Excel 2003 format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        _pane.putClientProperty(HssfTableUtils.CLIENT_PROPERTY_EXCEL_OUTPUT_FORMAT, HssfTableUtils.EXCEL_OUTPUT_FORMAT_2003);
                        if (!HssfTableUtils.isHssfInstalled()) {
                            JOptionPane.showMessageDialog((Component) e.getSource(), "Export to Excel feature is disabled because POI-HSSF jar is missing in the classpath.");
                            return;
                        }
                        outputToExcel(e);
                    }
                });

                final JMenuItem export2007 = new JMenuItem(new AbstractAction("Export to Excel 2007 format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        _pane.putClientProperty(HssfTableUtils.CLIENT_PROPERTY_EXCEL_OUTPUT_FORMAT, HssfTableUtils.EXCEL_OUTPUT_FORMAT_2007);
                        if (!HssfTableUtils.isXssfInstalled()) {
                            JOptionPane.showMessageDialog((Component) e.getSource(), "Export to Excel 2007 feature is disabled because one or several POI-XSSF dependency jars are missing in the classpath. Please include all the jars from poi release in the classpath and try to run again.");
                            return;
                        }
                        outputToExcel(e);
                    }
                });

                final JMenuItem exportToCsv = new JMenuItem(new AbstractAction("Export to CSV format") {
                    private static final long serialVersionUID = 2581042425782595535L;

                    public void actionPerformed(ActionEvent e) {
                        outputToCsv(e);
                    }
                });
                popup.add(export);
                popup.add(export2007);
                popup.add(exportToCsv);
            }
        };
        installer3.addTableHeaderPopupMenuCustomizer(new AutoResizePopupMenuCustomizer());
        installer3.addTableHeaderPopupMenuCustomizer(new TableColumnChooserPopupMenuCustomizer());

        return _pane;
    }

    private void outputToExcel(ActionEvent e) {
        JFileChooser chooser = new JFileChooser() {
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                JDialog dialog = super.createDialog(parent);
                dialog.setTitle("Export the content to an Excel file");
                return dialog;
            }
        };
        chooser.setCurrentDirectory(new File(_lastDirectory));
        int result = chooser.showDialog(((JComponent) e.getSource()).getTopLevelAncestor(), "Export");
        if (result == JFileChooser.APPROVE_OPTION) {
            _lastDirectory = chooser.getCurrentDirectory().getAbsolutePath();
            try {
                HssfTableScrollPaneUtils.export(_pane, chooser.getSelectedFile().getAbsolutePath(), "TreeTableScrollPane", false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void outputToCsv(ActionEvent e) {
        JFileChooser chooser = new JFileChooser() {
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                JDialog dialog = super.createDialog(parent);
                dialog.setTitle("Export the content to a CSV file");
                return dialog;
            }
        };
        chooser.setCurrentDirectory(new File(_lastDirectory));
        int result = chooser.showDialog(((JComponent) e.getSource()).getTopLevelAncestor(), "Export");
        if (result == JFileChooser.APPROVE_OPTION) {
            _lastDirectory = chooser.getCurrentDirectory().getAbsolutePath();
            try {
                CsvTableScrollPaneUtils.export(_pane, chooser.getSelectedFile().getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class DummyFooterTableModel extends AbstractMultiTableModel implements ColumnIdentifierTableModel, StyleModel {

        TableModel _model;
        private static final long serialVersionUID = -9132647394140127017L;

        public DummyFooterTableModel(TableModel model) {
            _model = model;
        }

        @Override
        public CellStyle getCellStyleAt(int rowIndex, int columnIndex) {
            return FOOTER_STYLE;
        }

        @Override
        public boolean isCellStyleOn() {
            return true;
        }

        @Override
        public String getColumnName(int column) {
            return _model.getColumnName(column);
        }

        @Override
        public Object getColumnIdentifier(int columnIndex) {
            return ((ColumnIdentifierTableModel) _model).getColumnIdentifier(columnIndex);
        }

        @Override
        public int getColumnCount() {
            return _model.getColumnCount();
        }

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return _model.getColumnClass(columnIndex);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return "Toplam";
            } else if (columnIndex == 5) {
                Double summary = 0d;
                for (int i = 0; i < _model.getRowCount(); i++) {
                    Object value = _model.getValueAt(i, columnIndex);
                    if (value instanceof Double) {
                        summary += (Double) value;
                    }
                }
                return summary / _model.getRowCount();
            } else {
                Double summary = 0d;
                for (int i = 0; i < _model.getRowCount(); i++) {
                    Object value = _model.getValueAt(i, columnIndex);
                    if (value instanceof Double) {
                        summary += (Double) value;
                    }
                }
                if (summary == 0) {
                    return null;
                }
                return summary;
            }

        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public int getColumnType(int column) {
            return ((MultiTableModel) _model).getColumnType(column);
        }

        @Override
        public int getTableIndex(int columnIndex) {
            return 0;
        }

        @Override
        public Class<?> getCellClassAt(int row, int column) {
            return getColumnClass(column);
        }

        @Override
        public ConverterContext getConverterContextAt(int row, int column) {
            return column >= 3 || column < 8 ? DoubleConverter.CONTEXT_FRACTION_NUMBER : null;
        }
    }

    class DummyTableModel extends AbstractMultiTableModel implements ColumnIdentifierTableModel, HeaderStyleModel, StyleModel {

        public DummyTableModel() {

        }

        private static final long serialVersionUID = 7142342324546147914L;
        private final String[] header = new String[]{"Ürün Adı", "Fiş Tarihi", "Fiş Saati", "Miktar", "Birim Fiyatı", "İndirim Oranı", "İndirim Miktarı", "Tutar", "Kasiyer"};
        private final Object[][] data = getUrunDetayData(id);

        @Override
        public CellStyle getHeaderStyleAt(int rowIndex, int columnIndex) {
            if (columnIndex >= 1 && columnIndex <= 4) {
                return SALES_STYLE;
            } else if (columnIndex >= 5 && columnIndex <= 8) {
                return PROFITS_STYLE;
            }
            return BOLD_STYLE;
        }

        @Override
        public boolean isHeaderStyleOn() {
            return true;
        }

        @Override
        public CellStyle getCellStyleAt(int rowIndex, int columnIndex) {
            if (columnIndex >= 1 && columnIndex <= 4) {
                return SALES_STYLE;
            } else if (columnIndex >= 5 && columnIndex <= 8) {
                return PROFITS_STYLE;
            }
            return null;
        }

        @Override
        public boolean isCellStyleOn() {
            return true;
        }

        @Override
        public String getColumnName(int column) {
            return header[column];
        }

        @Override
        public Object getColumnIdentifier(int column) {
            return header[column];
        }

        @Override
        public int getColumnCount() {
            return header.length;
        }

        @Override
        public int getRowCount() {
            if (data == null || data.length == 0) {
                return 0;
            }
            return data.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 3 || columnIndex == 4 || columnIndex == 5 || columnIndex == 6 || columnIndex == 7) {
                return Double.class;
            }
            return String.class;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (data == null || data.length == 0) {
                return null;
            }
            return data[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public int getTableIndex(int columnIndex) {
            return 0;
        }

        @Override
        public int getColumnType(int column) {
            if (column < 3) {
                return HEADER_COLUMN;
            } else if (column >= getColumnCount() - 1) {
                return FOOTER_COLUMN;
            } else {
                return REGULAR_COLUMN;
            }
        }

        @Override
        public Class<?> getCellClassAt(int row, int column) {
            return getColumnClass(column);
        }

        @Override
        public ConverterContext getConverterContextAt(int row, int column) {
            return column >= 3 || column < 8 ? DoubleConverter.CONTEXT_FRACTION_NUMBER : null;
        }
    }

    private Object[][] getUrunDetayData(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Object[][] data = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT count(satis_fisi_line_id) FROM satis_fisi_line where urun_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                pstmt = con.prepareStatement("SELECT ur.urun_adi,sf.fis_tarihi, sf.fis_saati,sfl.miktar,sfl.birim_fiyati, sfl.indirim_orani,sfl.birim_fiyati-sfl.tutar as indirim_miktari, sfl.tutar,concat(kul.adi,' ',kul.soyadi) as isim FROM satis_fisi_line  as sfl left join  satis_fisi as sf on sf.SATIS_FISI_ID=sfl.SATIS_FISI_ID left join urunler as ur on ur.urun_id=sfl.urun_id left join odeme_turleri_line as otl on otl.satis_fisi_id=sf.satis_fisi_id left join odeme_turleri as ot on ot.odeme_id=otl.odeme_id left join kullanici as kul on kul.KULLANICI_ID=sf.sys_ekleyen where ur.urun_id=?");
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();

                data = new Object[count][9];
                int i = 0;
                Format formatter = new SimpleDateFormat("dd MMMM yyyy, EEEE");
                Format saat = new SimpleDateFormat("hh:mm:ss");

                while (rs.next()) {
                    data[i][0] = rs.getString(1);
                    data[i][1] = formatter.format(new Date(rs.getDate(2).getTime()));
                    data[i][2] = rs.getTime(3);
                    data[i][3] = rs.getDouble(4);
                    data[i][4] = rs.getDouble(5);
                    data[i][5] = rs.getDouble(6);
                    data[i][6] = rs.getDouble(7);
                    data[i][7] = rs.getDouble(8);
                    data[i][8] = rs.getString(9);
                    i++;
                }
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
        }
        return data;
    }

    class DummyHeaderTableModel extends AbstractMultiTableModel implements ColumnIdentifierTableModel, StyleModel {

        TableModel _model;
        private static final long serialVersionUID = -9132647394140127017L;

        public DummyHeaderTableModel(TableModel model) {
            _model = model;
        }

        @Override
        public CellStyle getCellStyleAt(int rowIndex, int columnIndex) {
            return ((StyleModel) _model).getCellStyleAt(0, columnIndex);
        }

        @Override
        public boolean isCellStyleOn() {
            return true;
        }

        @Override
        public String getColumnName(int column) {
            return _model.getColumnName(column);
        }

        @Override
        public Object getColumnIdentifier(int columnIndex) {
            return ((ColumnIdentifierTableModel) _model).getColumnIdentifier(columnIndex);
        }

        @Override
        public int getColumnCount() {
            return _model.getColumnCount();
        }

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return _model.getColumnClass(columnIndex);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return "Ürün Detay Raporu";
            }
            return null;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public int getColumnType(int column) {
            return ((MultiTableModel) _model).getColumnType(column);
        }

        @Override
        public int getTableIndex(int columnIndex) {
            return 0;
        }

        @Override
        public Class<?> getCellClassAt(int row, int column) {
            return getColumnClass(column);
        }

        @Override
        public ConverterContext getConverterContextAt(int row, int column) {
            return column >= 1 ? DoubleConverter.CONTEXT_FRACTION_NUMBER : null;
        }
    }

}
