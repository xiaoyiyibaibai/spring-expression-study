package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.PlaceOfBirth;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.GregorianCalendar;

/**
 * @author power
 * @date 2018/10/11 下午5:26
 */
public class Assignment {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        int num = 8;
        simpleEvaluationContext.setVariable("num", num);

        // num = 9
        num = (Integer) parser.parseExpression("#num = 9").getValue(simpleEvaluationContext);
        System.out.println(num);
    }
}
