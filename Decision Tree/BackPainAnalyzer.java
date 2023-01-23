/**
 * BackPainAnalyzer.java
 *
 * Kenichi Shihota 
 *
 * Asking questions to the user, and if user input N, it moves to the left side of the question.
 * If user input other than N, it moves to the right side of the question
 */

import java.io.*;
import jsjf.*;

public class BackPainAnalyzer
{
    /**
     * Asks questions of the user to diagnose a medical problem.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("So, you’re having back pain.");

        //when you use input.txt
        DecisionTree expert = new DecisionTree("input.txt");

        expert.evaluate();
    }
}