package com.rutar.jhintedtextfield;

import java.awt.*;

// ............................................................................

/**
 * Клас JHintedTextFieldEvent
 * @author Rutar_Andriy
 * 06.06.2024
 */

public class JHintedTextFieldEvent extends AWTEvent {

private final Object oldValue;
private final Object newValue;

/** Ідентифікатор події JHINTEDTEXTFIELD_EVENT */
public static int JHINTEDTEXTFIELD_EVENT = AWTEvent.RESERVED_ID_MAX + 333;

///////////////////////////////////////////////////////////////////////////////

public JHintedTextFieldEvent (Object source, Object oldValue, Object newValue) {

super(source, JHINTEDTEXTFIELD_EVENT);

this.oldValue = oldValue;
this.newValue = newValue;

}

///////////////////////////////////////////////////////////////////////////////

public Object getOldValue() { return oldValue; }
public Object getNewValue() { return newValue; }

///////////////////////////////////////////////////////////////////////////////

@Override
public String toString() {

    return getClass().getName() +
        "[" +
            "oldValue=" + oldValue + "; " +
            "newValue=" + newValue +
        "]";
}

// Кінець класу JHintedTextFieldEvent /////////////////////////////////////////

}
