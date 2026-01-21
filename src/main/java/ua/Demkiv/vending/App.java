package ua.Demkiv.vending;


import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        Product apple = new Product(12, "apple", 2);
        Product orange = new Product(14, "orange", 4);
        Product pineapple = new Product(34, "pineapple", 8);
        Product pear = new Product(13, "pear", 2.5);

        Product[] fruits = {apple, orange, pineapple, pear};
        VendingMachine vm = new VendingMachine(fruits);

        System.out.println(Arrays.toString(vm.getProductsNames()));
        vm.insertMoney(7);
        vm.selectProduct(14);
        vm.getChange();

        vm.insertMoney(5);
        vm.selectProduct(34);
        vm.getChange();
    }
}
