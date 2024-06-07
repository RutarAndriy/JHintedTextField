package com.rutar.jhintedtextfield;

import java.io.*;
import java.awt.*;
import java.util.*;
import java.beans.*;
import javax.imageio.*;

import static java.beans.BeanInfo.*;

// ............................................................................

/**
 * Клас JHintedTextFieldBeanInfo
 * @author Rutar_Andriy
 * 06.06.2024
 */

public class JHintedTextFieldBeanInfo extends SimpleBeanInfo {

private final Class parentClass = JHintedTextField.class.getSuperclass();

///////////////////////////////////////////////////////////////////////////////

/**
 * Метод повертає список доступних властивостей
 * @return список доступних властивостей
 */
@Override
public PropertyDescriptor[] getPropertyDescriptors() {

PropertyDescriptor property;
ArrayList <PropertyDescriptor> properties = new ArrayList<>();

try {

// ............................................................................
// Отримуємо властивості суперкласу та робимо їх непріоритетними

PropertyDescriptor[] descriptors = Introspector.getBeanInfo(parentClass)
                                               .getPropertyDescriptors();

for (var descriptor : descriptors) {
    descriptor.setPreferred(false);
    properties.add(descriptor);
}

// ............................................................................
// Додаємо нові властивості та робимо їх пріоритетними

/**
 * new PropertyDescriptor(String a, Class b, String c, String d)
 * 
 * a - назва, яка відображається у IDE та описує властивість
 * b - клас, який містить дану властивість
 * c - назва getter-метода
 * d - назва setter-метода
 */

// Hint
property = new PropertyDescriptor("hint", JHintedTextField.class,
                                  "isHint", "setHint");
property.setPreferred(true);
properties.add(property);

// HintText
property = new PropertyDescriptor("hintText", JHintedTextField.class,
                                  "getHintText", "setHintText");
property.setPreferred(true);
properties.add(property);

// HintColor
property = new PropertyDescriptor("hintColor", JHintedTextField.class,
                                  "getHintColor", "setHintColor");
property.setPreferred(true);
properties.add(property);

property.setPreferred(true);
properties.add(property);

}

catch (IntrospectionException e) { }

return properties.toArray(PropertyDescriptor[]::new);

}

///////////////////////////////////////////////////////////////////////////////

/**
 * Метод повертає список доступних прослуховувачів
 * @return список доступних прослуховувачів
 */
@Override
public EventSetDescriptor[] getEventSetDescriptors() {

String[] methods;
EventSetDescriptor eventSet;
ArrayList <EventSetDescriptor> eventSets = new ArrayList<>();

try {

// ............................................................................
// Отримуємо набори подій суперкласу та робимо їх непріоритетними

EventSetDescriptor[] descriptors = Introspector.getBeanInfo(parentClass)
                                               .getEventSetDescriptors();

for (var descriptor : descriptors) {
    descriptor.setPreferred(false);
    eventSets.add(descriptor);
}

// ............................................................................
// Додаємо нові набори подій та робимо їх пріоритетними

/**
 * new EventSetDescriptor(Class a, String b, Class c, String[] d,
                          String e, String f)
 * 
 * a - клас, який відправляє події
 * b - програмна назва дескриптора подій
 * c - клас, який містить методи для прослуховування. Бажано використовувати
       адаптери, а не інтерфейси
 * d - масив строк, який містить назви методів для відобреження в IDE
 * e - назва метода, який додає прослуховувач
 * f - назва setter, який видаляє прослуховувач
 */

// ............................................................................
// JHintedTextFieldListener

methods = new String[] { "hintChange",
                         "textChange",
                         "hintTextChange",
                         "hintColorChange" };

eventSet = new EventSetDescriptor(JHintedTextField.class,
                                  "JHintedTextFieldListener",
                                  JHintedTextFieldListener.class, methods,
                                  "addJHintedTextFieldListener",
                                  "removeJHintedTextFieldListener");
eventSet.setPreferred(true);
eventSets.add(eventSet);
  
}

catch (IntrospectionException e) { }

return eventSets.toArray(EventSetDescriptor[]::new);

}

///////////////////////////////////////////////////////////////////////////////

/**
 * Метод повертає об'єкт зображення типу Image
 * @param iconType Тип іконки - константа класу BeanInfo
 * @return об'єкт типу Image
 */
@Override
public Image getIcon (int iconType) {

return switch (iconType) {

    case ICON_MONO_16x16, ICON_COLOR_16x16 -> loadIcon(false);
    case ICON_MONO_32x32, ICON_COLOR_32x32 -> loadIcon(true);

    default -> null;

};
}

///////////////////////////////////////////////////////////////////////////////

/**
 * Метод завантажує зображення різного розміру
 * @param large Розмір іконки (true - великий, false - малий)
 * @return об'єкт типу Image
 */
private Image loadIcon (boolean large) {

    Image image;
    String res = "/com/rutar/jhintedtextfield/icons/"
               + "icon_" + (large ? "32" : "16") + ".png";
    
    try (InputStream stream = JHintedTextFieldBeanInfo.class
                             .getResourceAsStream(res)) {
            
        image = ImageIO.read(stream);
        return image;
    
    }
    
    catch (IOException ex) { return null; }

}

// Кінець класу JHintedTextFieldBeanInfo //////////////////////////////////////

}
