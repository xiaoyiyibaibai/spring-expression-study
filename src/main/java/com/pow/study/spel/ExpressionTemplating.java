package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.Society;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author power
 * @date 2018/10/11 下午8:16
 */
public class ExpressionTemplating {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        String str = parser.parseExpression(
                "The result of '1 == 2' is #{1 == 2}",
                new TemplateParserContext()).getValue(String.class);

        System.out.println(str);//The result of '1 == 2' is false
    }
}
