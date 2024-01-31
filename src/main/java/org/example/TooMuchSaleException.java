package org.example;

/**
 * Исключение, выбрасываемое при назначении слишком большой скидки на товар премиум-категории.
 */
public class TooMuchSaleException extends RuntimeException {
    /**
     * Конструктор класса TooMuchSaleException.
     *
     * @param message сообщение об ошибке
     */
    public TooMuchSaleException(String message) {
        super(message);
    }
}
