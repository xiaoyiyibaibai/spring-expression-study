package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.PlaceOfBirth;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.GregorianCalendar;

/**
 * @author power
 * @date 2018/10/11 下午5:36
 */
public class Types {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        EvaluationContext standardEvaluationContext = new StandardEvaluationContext();

        //result : java.lang.Math
        Class mathClass = parser.parseExpression("T(java.lang.Math)").getValue(standardEvaluationContext, Class.class);
        System.out.println(mathClass.getName());

        //Exception in thread "main" org.springframework.expression.spel.SpelEvaluationException: EL1005E: Type cannot be found 'java.util.Date'
        Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(simpleEvaluationContext, Class.class);
        System.out.println(dateClass.getName());
    }
}
