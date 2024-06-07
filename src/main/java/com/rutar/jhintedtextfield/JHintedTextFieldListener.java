package com.rutar.jhintedtextfield;

import java.util.*;

// ............................................................................

/**
 * Клас JHintedTextFieldListener
 * @author Rutar_Andriy
 * 06.06.2024
 */

public interface JHintedTextFieldListener extends EventListener {
    
/**
 * Зміна можливості відображення підказки
 * @param evt Подія типу JHintedTextFieldEvent
 */
public void hintChange (JHintedTextFieldEvent evt);
    
/**
 * Зміна тексту поля введення
 * @param evt Подія типу JHintedTextFieldEvent
 */
public void textChange (JHintedTextFieldEvent evt);

/**
 * Зміна тексту підказки
 * @param evt Подія типу JHintedTextFieldEvent
 */
public void hintTextChange (JHintedTextFieldEvent evt);

/**
 * Зміна кольору підказки
 * @param evt Подія типу JHintedTextFieldEvent
 */
public void hintColorChange (JHintedTextFieldEvent evt);

// Кінець класу JHintedTextFieldListener //////////////////////////////////////

}
