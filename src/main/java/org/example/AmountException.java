package org.example;

/**
 * Исключение, выбрасываемое при неверном количестве товара.
 */
public class AmountException extends Exception {

    /**
     * Конструктор класса AmountException.
     *
     * @param message сообщение об ошибке
     */
    public AmountException(String message) {
        super(message);
    }
}