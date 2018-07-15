package com.stek.ca_ltd.webviewdeluxe;

/**
 * Created by CA_LTD on 2018-07-02.
 */

public class Probe {

    public boolean checkIfDividibleBy2(int number) {
        if ((number & 2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfDividibleBy3and5(int number) {
        if ((number & 3) == 0 && (number & 5) == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int powerThatNumber (int number) {
        int result = number^3;
        return result;
    }
    //7
  /*  public boolean checkIfSquareTriangle(int number1, int number2, int number3) {
        if(number1^2 + number2^2 == number3^2 ) {
            return true;
        }
    }*/

}
