package org.example;

/**
 * Исключение, выбрасываемое при неверном товаре.
 */
public class ProductException extends Exception {

    /**
     * Конструктор класса ProductException.
     *
     * @param message сообщение об ошибке
     */
    public ProductException(String message) {
        super(message);
    }
}
