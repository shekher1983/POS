package com.chandra.pos;

import com.chandra.pos.model.PaymentType;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/25/12
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    enum PAYMENT_TYPE {CASH, CHECK, BANK_TRANSFER, FALL}

    enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    ;

    public static void main(String args[]) {
        POSConfig config = new POSConfig();


//         for (Day d : EnumSet.range(Day.TUESDAY, Day.FRIDAY))
//        System.out.println(d);
        //Season[] test=  Season.values();
        // Season.
      //  System.out.println(PaymentType.CASH.getType(2).getName()); //config.test();

NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        System.out.println(Currency.getInstance(new Locale("hi", "IN")).getSymbol());

      //  System.out.println(numberFormat.format(45)); //config.test();


    }
}
