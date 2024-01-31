package org.example;

/**
 * Исключение, выбрасываемое при неверном покупателе.
 */
public class CustomerException extends Exception {

    /**
     * Конструктор класса CustomerException.
     *
     * @param message сообщение об ошибке
     */
    public CustomerException(String message) {
        super(message);
    }

}