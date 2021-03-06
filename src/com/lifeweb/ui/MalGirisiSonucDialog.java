package com.lifeweb.ui;

import com.jidesoft.dialog.ButtonPanel;
import com.jidesoft.dialog.StandardDialog;
import com.jidesoft.dialog.StandardDialogPane;
import com.jidesoft.swing.JideBoxLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.HeadlessException;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
public class MalGirisiSonucDialog extends StandardDialog {
    public JComponent _detailsPanel;
    TableModel model;
    TableModel eskiModel;
    List<Integer> sira;
    public MalGirisiSonucDialog(TableModel model,TableModel eskiModel,List<Integer> sira) throws HeadlessException {
        super((Frame) null, "Mal Girişi Değişiklikler");
        this.model=model;
        this.eskiModel=eskiModel;
        this.sira=sira;
    }

    @Override
    public JComponent createBannerPanel() {
        return null;
    }

    public JComponent createDetailsPanel() {
     
        JTextArea textArea = new JTextArea("Yakında \n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        textArea.setRows(10);

        JLabel label = new JLabel("Detaylar:");

        JPanel panel = new JPanel(new BorderLayout(6, 6));
        panel.add(new JScrollPane(textArea));
        panel.add(label, BorderLayout.BEFORE_FIRST_LINE);
        label.setLabelFor(textArea);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        return panel;
    }

    @Override
    protected StandardDialogPane createStandardDialogPane() {
        DefaultStandardDialogPane dialogPane = new DefaultStandardDialogPane() {
            @Override
            protected void layoutComponents(Component bannerPanel, Component contentPanel, ButtonPanel buttonPanel) {
                setLayout(new JideBoxLayout(this, BoxLayout.Y_AXIS));
                if (bannerPanel != null) {
                    add(bannerPanel);
                }
                if (contentPanel != null) {
                    add(contentPanel);
                }
                add(buttonPanel, JideBoxLayout.FIX);
                _detailsPanel = createDetailsPanel();
                add(_detailsPanel, JideBoxLayout.VARY);
                _detailsPanel.setVisible(false);
            }
        };
        return dialogPane;
    }

    @Override
    public JComponent createContentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));

        JLabel label = new JLabel("Başarıyla giriş yapıldı. Detaylar için detay seçeniğini seçiniz");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public ButtonPanel createButtonPanel() {
        ButtonPanel buttonPanel = new ButtonPanel();
        JButton closeButton = new JButton();
        JButton detailButton = new JButton();
        detailButton.setMnemonic('D');
        closeButton.setName(OK);
        buttonPanel.addButton(closeButton, ButtonPanel.AFFIRMATIVE_BUTTON);
        buttonPanel.addButton(detailButton, ButtonPanel.OTHER_BUTTON);

        closeButton.setAction(new AbstractAction("Kapat") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDialogResult(RESULT_AFFIRMED);
                setVisible(false);
                dispose();
            }
        });

        detailButton.setAction(new AbstractAction("Detaylar >>") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (_detailsPanel.isVisible()) {
                    _detailsPanel.setVisible(false);
                    putValue(Action.NAME, "Detaylar <<");
                    pack();
                }
                else {
                    _detailsPanel.setVisible(true);
                    putValue(Action.NAME, "<< Detaylar");
                    pack();
                }
            }
        });

        setDefaultCancelAction(closeButton.getAction());
        setDefaultAction(closeButton.getAction());
        getRootPane().setDefaultButton(closeButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setSizeConstraint(ButtonPanel.NO_LESS_THAN); 
        return buttonPanel;
    }
}
