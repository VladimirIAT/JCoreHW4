package org.example;

import java.util.Arrays;
import java.util.Random;

/**
 * Главный класс программы.
 */
public class Main {
    private static Customer[] customers = new Customer[2];
    private static Product[] products = new Product[5];

    public static void main(String[] args) {

        //Создаем и инициализируем массив покупателей
        customers[0] = new Customer("Иванов", "Иван", 30, "1234567890", Gender.MALE);
        customers[1] = new Customer("Петрова", "Мария", 25, "0987654321", Gender.FEMALE);


        // Создаём массив товаров
        products[0] = new Product("Товар 1", 100.0, Category.STANDARD);
        products[1] = new Product("Товар 2", 200.0, Category.PREMIUM);
        products[2] = new Product("Товар 3", 300.0, Category.STANDARD);
        products[3] = new Product("Товар 4", 400.0, Category.PREMIUM);
        products[4] = new Product("Товар 5", 500.0, Category.STANDARD);


        System.out.println();
// Устанавливаем случайную скидку на товар
        products[3].setRandomDiscount();
        System.out.println("На " + products[3].getName() + " действует скидка, его прошлая цена за штуку 400");
        System.out.println();


        // Создаем массив заказов
        Random random = new Random();
        int orderCount = random.nextInt(10) + 1; // Генерация случайного числа от 1 до 10
        Order[] orders = new Order[orderCount];

        for (int i = 0; i < orders.length; i++) {
            Customer Customer = customers[random.nextInt(customers.length)];
            Product Product = products[random.nextInt(products.length)];



            int Quantity = random.nextInt(5) - 1;

            // Вызываем метод совершения покупки для заполнения массива заказов
            try {
                orders[i] = makePurchase(Customer.getLastName(), Product.getName(), Quantity);
                // Выводим информацию о заказах
                System.out.println("Заказ: " + orders[i].getProduct().getName() + ", количество: "
                        + orders[i].getQuantity() + ", стоимость: " + orders[i].getCost());
            } catch (CustomerException e) {
                System.out.println(e.getMessage() + " (" + Customer.getLastName() + ")");
            } catch (ProductException e) {
                System.out.println(e.getMessage() + " (" + Product.getName() + ")");
            } catch (AmountException e) {
                System.out.println(e.getMessage() + " (" + Quantity + ")");
            }
        }


        /**
         * Метод для подсчета общего количества совершенных покупок.
         *
         * @param orders массив заказов
         * @return общее количество покупок
         */
        int count = 0;
        for (Order order : orders) {
            if (order != null) {
                count++;
            }
        }


        // Выводим информацию о совершенных покупках
        System.out.println("Количество совершенных покупок: " + count);
    }

    /**
     * Метод для совершения покупки
     *
     * @param lastName    фамилия покупателя
     * @param productName название товара
     * @param quantity    количество товара
     * @return объект заказа
     * @throws CustomerException если передан несуществующий покупатель
     * @throws ProductException  если передан несуществующий товар
     * @throws AmountException   если передано неверное количество товара
     */
    public static <customer> Order makePurchase(String lastName, String productName, int quantity)
            throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getLastName().equals(lastName)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            throw new CustomerException("Несуществующий покупатель: " + lastName);
        }

        Product product = null;
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                product = p;
                break;
            }
        }

        if (product == null) {
            throw new ProductException("Несуществующий товар: " + productName);
        }

        if (quantity <= 0 || quantity > 99) {
            throw new AmountException("Неверное количество: " +  " " + lastName + " " + productName);
        }

        return new Order(customer, product, quantity);
    }
}