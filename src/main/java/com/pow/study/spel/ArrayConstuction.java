package com.pow.study.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author power
 * @date 2018/10/11 下午3:57
 */
public class ArrayConstuction {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(simpleEvaluationContext);
        numbers1[3] = 2;
        for (int num : numbers1) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();

        // Array with initializer
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(simpleEvaluationContext);
        for (int num : numbers2) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();

        // Multi dimensional array
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(simpleEvaluationContext);
        numbers3[3][2] = 32;
        for (int[] num_x:numbers3) {
            for (int num : num_x) {
                System.out.print(num);
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
