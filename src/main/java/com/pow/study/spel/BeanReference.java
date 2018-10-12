package com.pow.study.spel;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author power
 * @date 2018/10/10 上午10:39
 */
public class BeanReference {
    public void test() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new MyBeanResolver());

        Object bean = parser.parseExpression("&foo").getValue(context);
        System.out.println(bean);
    }

    public static void main(String[] args) {
        BeanReference demo = new BeanReference();
        demo.test();
    }

    /**
     * @author power
     * @date 2018/10/9 下午9:09
     */
    public static class MyBeanResolver implements BeanResolver {
        @Override
        public Object resolve(EvaluationContext context, String beanName) throws AccessException {
            if (beanName.equals("foo") || beanName.equals("bar")) {
                return "MyBeanResolver";
            }
            if (beanName.equals("&foo")) {
                return "MyBeanResolver-&foo";
            }
            throw new AccessException("not heard of " + beanName);
        }
    }
}
