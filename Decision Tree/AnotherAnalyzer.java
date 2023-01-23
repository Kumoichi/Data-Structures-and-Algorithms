/**
 * AnotherAnalyzer.java
 *
 * Kenichi Shihota 
 *
 * Asking questions to the user, and if user input N, it moves to the left side of the question.
 * If user input other than N, it moves to the right side of the question
 */

import java.io.*;
import jsjf.*;

public class AnotherAnalyzer
{
    /**
     * Asks questions of the user.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("I'll ask you some questions");

        //when you use Another.txt
        DecisionTree expert = new DecisionTree("Another.txt");
        expert.evaluate();
    }
}