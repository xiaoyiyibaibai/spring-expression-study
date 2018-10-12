package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author power
 * @date 2018/10/11 下午7:41
 */
public class TernaryOperator {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        //falseExp
        String string = parser.parseExpression("false ? 'trueExp' : 'falseExp'").getValue(simpleEvaluationContext, String.class);
        System.out.println(string);
    }
}
