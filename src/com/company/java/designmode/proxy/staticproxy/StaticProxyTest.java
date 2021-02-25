package com.company.java.designmode.proxy.staticproxy;

public class StaticProxyTest {
    public void fuck() {
        Guy guy = new Guy();
        SexProxy sexProxy = new SexProxy(guy);
        FoodProxy foodProxy = new FoodProxy(guy);
        BeerProxy beerProxy = new BeerProxy(guy);
        sexProxy.fuck();
        foodProxy.eat();
        beerProxy.drink();
    }

    public static void test() {
        StaticProxyTest test = new StaticProxyTest();
        test.fuck();
    }
}
