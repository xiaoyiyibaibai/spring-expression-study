package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

/**
 * @author power
 * @date 2018/10/11 下午6:24
 */
public class Functions {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().withInstanceMethods().build();
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();

        try {
            Method random = java.lang.Math.class.getDeclaredMethod("random");
            Method getRuntime = java.lang.Runtime.class.getDeclaredMethod("getRuntime");

            standardEvaluationContext.setVariable("random", random);
            standardEvaluationContext.registerFunction("getRuntime", getRuntime);

            simpleEvaluationContext.setVariable("random",random);
            simpleEvaluationContext.setVariable("getRuntime", getRuntime);

            //get a random
            Object o = parser.parseExpression("#random()").getValue(standardEvaluationContext);
            System.out.println(o);

            //open a calculator
            Object o1 = parser.parseExpression("#getRuntime().exec('open /Applications/Calculator.app')").getValue(standardEvaluationContext);
            System.out.println(o1);

            //get a random
            Object o2 = parser.parseExpression("#random()").getValue(simpleEvaluationContext);
            System.out.println(o2);

            //open a calculator
            Object o3 = parser.parseExpression("#getRuntime().exec('open /Applications/Calculator.app')").getValue(simpleEvaluationContext);
            System.out.println(o3);
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }

    }
}
