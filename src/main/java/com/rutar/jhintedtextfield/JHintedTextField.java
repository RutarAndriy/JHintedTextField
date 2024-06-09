package com.rutar.jhintedtextfield;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

// ............................................................................

/**
 * Клас JHintedTextField
 * @author Rutar_Andriy
 * 26.11.2021
 */

public class JHintedTextField extends JTextField {

///////////////////////////////////////////////////////////////////////////////
// Змінні, які реалізують основний функціонал компонента //////////////////////

private String text = "";                                              // Текст
private String hintText = "Заповніть поле";                   // Текст підказки

private boolean hint = true;               // Якщо true - відображаємо підказку
private Color hintColor = new Color(153, 153, 153);    // Колір тексту підказки
private Color normalColor = null;                    // Початковий колір тексту

///////////////////////////////////////////////////////////////////////////////
// Допоміжні змінні /////////////////////////////////////////// ///////////////

private boolean focused = false;       // Якщо true - поле знаходиться у фокусі
private static ArrayList <JHintedTextFieldListener> listeners = null;

///////////////////////////////////////////////////////////////////////////////
// Головний конструктор компонента ////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

public JHintedTextField() { normalColor = getForeground();
                            addFocusListener(focusListener);
                            getDocument().addDocumentListener(docListener);
                            updateText(false); }

///////////////////////////////////////////////////////////////////////////////
// Getter'и та Setter'и - повертають та задають властивості компонента ////////
///////////////////////////////////////////////////////////////////////////////

/**
 * Отримання можливості відображення підказки
 * @return true - відображається, false - не відображається
 */
public boolean isHint() { return hint; }

/**
 * Задання можливості відображення підказки
 * @param hint true - відображається, false - не відображається
 */
public void setHint (boolean hint) {
    
    boolean oldValue = this.hint;
    this.hint = hint;    
    updateText(false);
    fireAll("hint", oldValue, hint); }

///////////////////////////////////////////////////////////////////////////////

/**
 * Отримання тексту поля введення
 * @return текст поля введення
 */
@Override
public String getText() { String getText = super.getText();
                          return getText.equals(hintText) ? "" : getText; }

/**
 * Задання тексту поля введення
 * @param text новий текст поля введення
 */
@Override
public void setText (String text) {

    String oldValue = this.text;
    this.text = text;  
    super.setText(text);
    updateText(false);
    fireAll("text", oldValue, text); }

///////////////////////////////////////////////////////////////////////////////

/**
 * Отримання тексту підказки
 * @return текст підказки
 */
public String getHintText() { return hintText;  }

/**
 * Задання тексту підказки
 * @param hintText новий текст підказки
 */
public void setHintText (String hintText) {
    
    String oldValue = this.hintText;
    this.hintText = hintText;
    updateText(true);
    fireAll("hintText", oldValue, hintText); }

///////////////////////////////////////////////////////////////////////////////

/**
 * Отримання кольору підказки
 * @return колір підказки
 */
public Color getHintColor() { return hintColor; }

/**
 * Задання кольору підказки
 * @param hintColor новий колір підказки
 */
public void setHintColor (Color hintColor) {
    
    Color oldValue = this.hintColor;
    this.hintColor = hintColor;
    updateText(false);
    fireAll("hintColor", oldValue, hintColor); }

///////////////////////////////////////////////////////////////////////////////
// Додавання та видалення прослуховувачів подій ///////////////////////////////
///////////////////////////////////////////////////////////////////////////////

public void addJHintedTextFieldListener (JHintedTextFieldListener listener)
    { getListeners().add(listener); }

///////////////////////////////////////////////////////////////////////////////

public void removeJHintedTextFieldListener (JHintedTextFieldListener listener)
    { getListeners().remove(listener); }

///////////////////////////////////////////////////////////////////////////////

private ArrayList <JHintedTextFieldListener> getListeners()
    { if (listeners == null) { listeners = new ArrayList<>(); }
      return listeners; }

///////////////////////////////////////////////////////////////////////////////

private void fireAll (String name, Object oldValue, Object newValue) {
    
    fireEvent          (name, oldValue, newValue);
    firePropertyChange (name, oldValue, newValue);
    
}

///////////////////////////////////////////////////////////////////////////////

private void fireEvent (String name, Object oldValue, Object newValue) {

JHintedTextFieldEvent event = new JHintedTextFieldEvent(this, oldValue, newValue);

for (JHintedTextFieldListener listener : getListeners()) {

    switch (name) {
        case "hint"
              -> listener.hintChange(event);
        case "text"
              -> listener.textChange(event);
        case "hintText"
              -> listener.hintTextChange(event);
        case "hintColor"
              -> listener.hintColorChange(event);
    }
}
}

///////////////////////////////////////////////////////////////////////////////
// Допоміжні методи ///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

private void updateText (boolean forceHint) {

boolean showHint = getText().isEmpty() && !focused;

if (hint && (showHint || forceHint)) { super.setForeground(hintColor);
                                       super.setText(hintText); }
else                                 { super.setForeground(normalColor);
                                       super.setText(text); }

}

///////////////////////////////////////////////////////////////////////////////
// Прослуховування та обробка подій ///////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

private final FocusListener focusListener = new FocusListener() {

@Override
public void focusGained (FocusEvent e)                      // Одержання фокусу
    { focused = true;
      updateText(false); }

@Override
public void focusLost (FocusEvent e)                           // Втрата фокусу
    { focused = false;
      updateText(false); }

};

///////////////////////////////////////////////////////////////////////////////

private final DocumentListener docListener = new DocumentListener() {

@Override
public void insertUpdate (DocumentEvent e) { text = getText(); }

@Override
public void removeUpdate (DocumentEvent e) { text = getText(); }

@Override
public void changedUpdate (DocumentEvent e) {}

};

// Кінець класу JHintedTextField //////////////////////////////////////////////

}
