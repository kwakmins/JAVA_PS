import java.util.Stack;

/**
 * LV1 3진법 뒤집기 - https://school.programmers.co.kr/learn/courses/30/lessons/68935?language=java
 * 진수 계산 - 10진수를 3진수로 변환 후 거꾸로 뒤집고 다시 10진수로 바꾸는 간단한 진수 문제
 *
 * !!! N 진수 -> 10진수 = Integer.parseInt( n진수 문자, n )
 * !!! String reverse 하려면 StringBuilder로 변환해야함.
 */
class Solution {

    public static final int formationNum = 3;

    public int solution( int n ) {

        Stack< Integer > resultStack = convertFormation( formationNum, n, new Stack<>() );
        String resultConvertString = "";

        while ( !resultStack.isEmpty() ) {
            resultConvertString += resultStack.pop();
        }

        return convertNumber( formationNum, resultConvertString );
    }

    private Stack< Integer > convertFormation( int x, int n, Stack< Integer > stack ) {

        if ( n == 0 ) {
            return stack;
        }

        stack.push( n % x );
        return convertFormation( x, n / x, stack );
    }

    private int convertNumber( int x, String num ) {
        int resultNumber = 0;
        int countIndex = 0;
        for ( String s : num.split( "" ) ) {
            resultNumber += ( int ) (Integer.parseInt( s ) * Math.pow( x, countIndex++ ));
        }

        return resultNumber;
    }
}