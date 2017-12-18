package service;

import com.mathworks.toolbox.javabuilder.*;
import main.*;
import testMain.Circle;
//import testPrint.*;

import java.util.ArrayList;

/**
 * Created by yangchen on 17/12/17.
 */
public class ManualCalculate {

    public static void main(String[] args) {
        try {
            Class1 circle = new Class1();
            Object[] status;
            Object a = 2;
            Object b = 2;
//            status = circle.testPrint(2, a, b);
//            for(Object i:status)
//                System.out.println(i);
            circle.main();
        } catch (MWException e) {
            e.printStackTrace();
        }
    }

}
