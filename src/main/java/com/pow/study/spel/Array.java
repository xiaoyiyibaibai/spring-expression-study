package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.PlaceOfBirth;
import com.pow.study.spel.inventor.Society;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.GregorianCalendar;

/**
 * @author power
 * @date 2018/10/11 下午2:39
 */
public class Array {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Inventor inventor = new Inventor();

        String[] inventions = {"telephone","cap","cellphone","desktop"};
        inventor.setInventions(inventions);

        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        String invention = parser.parseExpression("inventions[3]").getValue(simpleEvaluationContext, inventor, String.class);
        System.out.println(invention);
    }
}
