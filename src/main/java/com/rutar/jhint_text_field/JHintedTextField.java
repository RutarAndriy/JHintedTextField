package com.rutar.jhint_text_field;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// ............................................................................
// @author RutarAndriy
// 26.11.2021

public class JHintedTextField extends JTextField {

private boolean showHint;

private String hintText = "Заповніть поле";

private Color foreground = null;
private Color hintColor = new Color(153, 153, 153);

///////////////////////////////////////////////////////////////////////////////
// Головний конструктор

public JHintedTextField() {

    foreground = getForeground();
    addFocusListener(focusListener);
    
    showHint(true);
    
}

///////////////////////////////////////////////////////////////////////////////
// Задання тексту

@Override
public void setText (String text) {

    if (text.isEmpty()) { showHint(true); }
    else                { showHint(false);
                          super.setText(text); }

}

///////////////////////////////////////////////////////////////////////////////

public String getHintText() { return hintText;  }
public Color getHintColor() { return hintColor; }

///////////////////////////////////////////////////////////////////////////////
// Задання тексту підказки

public void setHintText (String hintText)
    { this.hintText = hintText;
      if (showHint) { super.setText(hintText); } }

///////////////////////////////////////////////////////////////////////////////
// Задання кольору підказки

public void setHintColor (Color hintColor)
    { this.hintColor = hintColor;
      if (showHint) { super.setForeground(hintColor); } }

///////////////////////////////////////////////////////////////////////////////
// Отримання введеного тексту

@Override
public String getText() { return showHint ? "" : super.getText(); }

///////////////////////////////////////////////////////////////////////////////
// Прослуховувач фокусу для jTextField'а

private final FocusListener focusListener = new FocusListener() {

@Override
// Одержання фокусу
public void focusGained (FocusEvent e)
    { String text = getText();
      showHint(false);
      if (!text.isEmpty()) { setText(text); } }

// ............................................................................

@Override
// Втрата фокусу
public void focusLost (FocusEvent e)
    { if (getText().isEmpty()) { showHint(true); } }

};

///////////////////////////////////////////////////////////////////////////////
// Метод відображає/приховує підказку

private void showHint (boolean show) {

if (show) { showHint = true;
            super.setText(hintText);
            super.setForeground(hintColor); }

else      { showHint = false;
            super.setText("");
            super.setForeground(foreground); }

}

///////////////////////////////////////////////////////////////////////////////

}