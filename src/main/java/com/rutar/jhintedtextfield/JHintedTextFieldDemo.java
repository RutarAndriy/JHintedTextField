package com.rutar.jhintedtextfield;

import java.awt.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;

// ............................................................................

/**
 * Клас JHintedTextFieldDemo
 * @author Rutar_Andriy
 * 06.06.2024
 */

public class JHintedTextFieldDemo extends JFrame {

///////////////////////////////////////////////////////////////////////////////

public JHintedTextFieldDemo() {
    
initComponents();
initAppIcons();

}

///////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jHintedTextField_1 = new JHintedTextField();
        jHintedTextField_2 = new JHintedTextField();
        jHintedTextField_3 = new JHintedTextField();
        btn_info = new JButton();
        btn_reset = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JHintTextField Demo");
        setResizable(false);

        jHintedTextField_1.setHorizontalAlignment(JTextField.CENTER);

        jHintedTextField_2.setHintColor(new Color(255, 0, 51));
        jHintedTextField_2.setHorizontalAlignment(JTextField.CENTER);

        jHintedTextField_3.setHintColor(new Color(51, 255, 0));
        jHintedTextField_3.setHorizontalAlignment(JTextField.CENTER);

        btn_info.setText("<html><p align=\"center\">Отримати інформацію</p></html>");
        btn_info.setActionCommand("btn_info");
        btn_info.addActionListener(this::buttonPressed);

        btn_reset.setText("<html><p align=\"center\">Очистити всі поля</p></html>");
        btn_reset.setActionCommand("btn_reset");
        btn_reset.setToolTipText("");
        btn_reset.addActionListener(this::buttonPressed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jHintedTextField_3, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHintedTextField_1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHintedTextField_2, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(btn_info, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btn_reset, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_info, btn_reset});

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jHintedTextField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jHintedTextField_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jHintedTextField_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_info, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btn_reset))
                .addGap(5, 5, 5))
        );

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {btn_info, btn_reset});

        pack();
        setLocationRelativeTo(null);
        btn_info.requestFocus();
    }//GEN-END:initComponents

///////////////////////////////////////////////////////////////////////////////

    private void buttonPressed(ActionEvent evt) {//GEN-FIRST:event_buttonPressed
        
    switch (evt.getActionCommand()) {
        
        case "btn_info" -> {                   // Отримання введеної інформації
            
            String template = """
                              Перше поле: %s
                              Друге поле: %s
                              Третє поле: %s
                              """;

            String info = String.format(template,
                                        jHintedTextField_1.getText(),
                                        jHintedTextField_2.getText(),
                                        jHintedTextField_3.getText());

            JOptionPane.showMessageDialog(this, info, "Повідомлення",
                                          INFORMATION_MESSAGE); }
        
        // ....................................................................
        
        case "btn_reset" -> {                                 // Очищення полів
            jHintedTextField_1.setText("");
            jHintedTextField_2.setText("");
            jHintedTextField_3.setText(""); }

    }        
    }//GEN-LAST:event_buttonPressed

///////////////////////////////////////////////////////////////////////////////

public static void main (String args[]) {

    EventQueue.invokeLater(() -> {
        new JHintedTextFieldDemo().setVisible(true);
    });
}

///////////////////////////////////////////////////////////////////////////////

private void initAppIcons() {

JHintedTextFieldBeanInfo beanInfo = new JHintedTextFieldBeanInfo();
ArrayList<Image> icons = new ArrayList<>();

icons.add(beanInfo.getIcon(BeanInfo.ICON_COLOR_16x16));
icons.add(beanInfo.getIcon(BeanInfo.ICON_COLOR_32x32));

setIconImages(icons);

}

///////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btn_info;
    private JButton btn_reset;
    private JHintedTextField jHintedTextField_1;
    private JHintedTextField jHintedTextField_2;
    private JHintedTextField jHintedTextField_3;
    // End of variables declaration//GEN-END:variables

// Кінець класу JHintedTextFieldDemo //////////////////////////////////////////

}
