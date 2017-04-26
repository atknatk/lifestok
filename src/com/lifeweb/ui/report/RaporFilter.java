package com.lifeweb.ui.report;

import com.jidesoft.converter.ConverterContext;
import com.jidesoft.grid.CellStyle;
import com.jidesoft.grid.EditorStyleTableModel;
import com.jidesoft.grid.Property;
import static com.jidesoft.grid.Property.PROPERTY_VALUE;
import com.jidesoft.grid.PropertyTableModel;
import com.jidesoft.grid.PropertyTableSearchable;
import com.jidesoft.grid.RowStripeTableStyleProvider;
import com.jidesoft.grid.StyleModel;
import com.jidesoft.swing.JideSwingUtilities;
import com.lifeweb.ui.helper.UIConfig;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.border.MatteBorder;

public class RaporFilter extends javax.swing.JFrame {

    private static int _editorStyle = EditorStyleTableModel.EDITOR_STYLE_NORMAL;
    private static final long serialVersionUID = 7477343900692892168L;
    PropertyTableModel model;
    ReportCreator reportCreator = new ReportCreator();
    private final static CellStyle CELL_STYLE_EXPERT = new CellStyle();

    static {
        CELL_STYLE_EXPERT.setBorder(new MatteBorder(0, 0, 0, 6, Color.BLUE));
    }

    public RaporFilter() {
        Locale.setDefault(new Locale("tr", "TR"));
        initComponents();
        setLocation(UIConfig.getLocation(RaporFilter.this));
        ArrayList<SampleProperty> list = new ArrayList<>();

        SampleProperty property;

        property = new SampleProperty("Başlangıç Tarihi", "Rapor için başlangıç tarihi seçiniz", Calendar.class);
        list.add(property);
        property = new SampleProperty("Bitiş Tarihi", "Rapor için bitiş tarihi seçiniz", Calendar.class);
        list.add(property);

        model = new EditorStylePropertyTableModel<>(list);
        propertyTable1.setModel(model);
        propertyTable1.setPreferredScrollableViewportSize(new Dimension(400, 600));
        propertyTable1.expandFirstLevel();

        PropertyTableSearchable searchable = new PropertyTableSearchable(propertyTable1);
        searchable.setRecursive(true);

        propertyTable1.setTableStyleProvider(new RowStripeTableStyleProvider());

        Locale.setDefault(Locale.ENGLISH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        propertyTable1 = new com.jidesoft.grid.PropertyTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtrele");
        setAlwaysOnTop(true);

        propertyTable1.setAutoCreateRowSorter(true);
        propertyTable1.setDoubleClickEnabled(false);
        jScrollPane1.setViewportView(propertyTable1);

        jButton1.setText("Tamam");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Kapat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        satisDokumu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void satisDokumu() {
        HashMap<String, Object> mapReport = new HashMap<>();
        mapReport.put("tarih_bas", ((Calendar) map.get("Başlangıç Tarihi")).getTime());
        mapReport.put("tarih_son", ((Calendar) map.get("Bitiş Tarihi")).getTime());
        reportCreator.getReport(ReportType.SATIS_DOKUMU, mapReport, null);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.jidesoft.grid.PropertyTable propertyTable1;
    // End of variables declaration//GEN-END:variables

    static HashMap<String, Object> map = new HashMap<>();

    static {
        map.put("Başlangıç Tarihi", Calendar.getInstance());
        map.put("Bitiş Tarihi", Calendar.getInstance());
    }

    static class SampleProperty extends Property {

        private static final long serialVersionUID = -3739511507958060504L;

        public SampleProperty(String name, String description, Class type, String category, ConverterContext context) {
            super(name, description, type, category, context);
        }

        public SampleProperty(String name, String description, Class type, String category) {
            super(name, description, type, category);
        }

        public SampleProperty(String name, String description, Class type) {
            super(name, description, type);
        }

        public SampleProperty(String name, String description) {
            super(name, description);
        }

        public SampleProperty(String name) {
            super(name);
        }

        public void setValue(Object value) {
            Object old = getValue();
            if (!JideSwingUtilities.equals(old, value)) {
                map.put(getFullName(), value);
                firePropertyChange(PROPERTY_VALUE, old, value);
            }
        }

        @Override
        public Object getValue() {
            return map.get(getFullName());
        }

        @Override
        public boolean hasValue() {
            return map.get(getFullName()) != null;
        }
    }

    static class EditorStylePropertyTableModel<T extends Property> extends PropertyTableModel<T> implements EditorStyleTableModel, StyleModel {

        private static final long serialVersionUID = -4435995349055070783L;

        public EditorStylePropertyTableModel(List<T> properties) {
            super(properties);
        }

        public int getEditorStyleAt(int rowIndex, int columnIndex) {
            return _editorStyle;
        }

        @Override
        public ConverterContext getConverterContextAt(int row, int column) {
            T valueProperty = getPropertyAt(row);
            if (valueProperty == null) {
                return null;
            }
            T priorityProperty = getProperty("Priority");
            if ("Multiple Values".equals(valueProperty.getName())) {
                Object[] possibleValues = new Object[]{"A", "B", "C", "D", "E"};
                Object priorityValue = priorityProperty.getValue();
                if (priorityValue instanceof Integer && (Integer) priorityValue == 0) {
                    possibleValues = new Object[]{"A", "B"};
                }
                return new ConverterContext("ABCDE", possibleValues);
            }
            return super.getConverterContextAt(row, column);
        }

        public CellStyle getCellStyleAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                T property = getPropertyAt(rowIndex);
                if (property.isExpert()) {
                    return CELL_STYLE_EXPERT;
                }
            }
            return null;
        }

        public boolean isCellStyleOn() {
            return true;
        }
    }

}
