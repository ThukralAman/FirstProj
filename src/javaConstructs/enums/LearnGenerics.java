package javaConstructs.enums;

import java.util.ArrayList;
import java.util.List;

public class LearnGenerics {

    public static void main(String[] args) {
        BasicMathsOperations mathsObj = new BasicMathsOperations(2, 4);
        System.out.println(mathsObj.add(2, 4));
        System.out.println(mathsObj.subtract());

    }

}

 class BasicMathsOperations <T> {
    T num1;
    T num2;

     BasicMathsOperations(T num1, T num2) {
         List<Integer> p = new ArrayList<>();
         this.num1 = num1;
         this.num2 = num2;
     }


    public T add(T num1, T num2) {
        return num1;
        //return num1 > num2;
    }

    public T subtract() {
        return num1;
        //return num1 - num2;
    }
}
