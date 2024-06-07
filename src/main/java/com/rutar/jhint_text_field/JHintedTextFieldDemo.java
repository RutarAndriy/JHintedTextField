package com.rutar.jhint_text_field;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;

// ............................................................................

public class JHintedTextFieldDemo extends JFrame {

///////////////////////////////////////////////////////////////////////////////

public JHintedTextFieldDemo() {
    
initComponents();

button_info.setText(getHTML("Отримати інформацію"));
button_info.setActionCommand("info");

button_reset.setText(getHTML("Очистити всі поля"));
button_reset.setActionCommand("reset");

getContentPane().requestFocusInWindow();
setLocationRelativeTo(null);

}

///////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jHintTextField_1 = new JHintedTextField();
        jHintTextField_2 = new JHintedTextField();
        jHintTextField_3 = new JHintedTextField();
        button_info = new JButton();
        button_reset = new JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JHintTextField Demo");
        setResizable(false);

        jHintTextField_1.setHintText("Заповніть дане поле");

        jHintTextField_2.setHintColor(new Color(255, 0, 0));
        jHintTextField_2.setHintText("Дане поле є обов'язковим !!!");

        jHintTextField_3.setHintColor(new Color(0, 255, 0));
        jHintTextField_3.setHintText("Додаткова інформація");

        button_info.setText("info");
        button_info.addActionListener(formListener);

        button_reset.setText("reset");
        button_reset.addActionListener(formListener);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jHintTextField_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jHintTextField_2, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jHintTextField_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_info, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_reset, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button_info, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jHintTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHintTextField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHintTextField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(button_reset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements ActionListener {
        FormListener() {}
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == button_info) {
                JHintedTextFieldDemo.this.buttonPressed(evt);
            }
            else if (evt.getSource() == button_reset) {
                JHintedTextFieldDemo.this.buttonPressed(evt);
            }
        }
    }//GEN-END:initComponents

///////////////////////////////////////////////////////////////////////////////

    private void buttonPressed(ActionEvent evt) {//GEN-FIRST:event_buttonPressed
        
        switch (evt.getActionCommand()) {
            
            // Отримання введеної інформації
            case "info":
                
                String template = "Перше поле: %s" + "\n" +
                                  "Друге поле: %s" + "\n" +
                                  "Третє поле: %s";
                
                String info = String.format(template,
                                            jHintTextField_1.getText(),
                                            jHintTextField_2.getText(),
                                            jHintTextField_3.getText());
                
                JOptionPane.showMessageDialog(this, info, "Повідомлення",
                                              INFORMATION_MESSAGE);
                break;
            
            // Очищення полів
            case "reset":
                
                jHintTextField_1.setText("");
                jHintTextField_2.setText("");
                jHintTextField_3.setText("");
                break;
            
        }
        
    }//GEN-LAST:event_buttonPressed

///////////////////////////////////////////////////////////////////////////////

public static void main (String args[]) {

try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
catch (Exception ex) {}

// ............................................................................

EventQueue.invokeLater(() -> { new JHintedTextFieldDemo().setVisible(true); });

}

///////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton button_info;
    private JButton button_reset;
    private JHintedTextField jHintTextField_1;
    private JHintedTextField jHintTextField_2;
    private JHintedTextField jHintTextField_3;
    // End of variables declaration//GEN-END:variables

///////////////////////////////////////////////////////////////////////////////

private String getHTML (String text) {
  
    String template = "<html><p align=\"center\">%s</p></html>";    
    return String.format(template, text);

}

///////////////////////////////////////////////////////////////////////////////

}
