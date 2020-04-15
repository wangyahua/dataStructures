package com.learn.stack;

/**
 * @author 王亚华
 * @Description 使用栈实现普通计算器 该类只包含+ - * /的符号运算
 * @Date 创建于 2020-04-15 21:36
 */
public class Calculator {

    private static final char ADD = '+';

    private static final char SUB = '-';

    private static final char MUL = '*';

    private static final char DIV = '/';

    /**
     * 数栈
     */
    private LinkListStack<Integer> numStack = new LinkListStack<>();

    /**
     * 符号栈（运算符）
     */
    private LinkListStack<Character> operatorStack = new LinkListStack<>();


    /**
     * 例如：3+2*6-2
     * -> 2              -> -
     *    12                *
     *    3                 +
     * numStack            operatorStack
     * <p>
     * 需要有两个栈：一个是数栈（存放数的）；一个是符号栈（存放运算符的）
     * 1. 需要进行遍历表达式，相当于遍历字符串
     * 2. 如果遍历发现是一个数字的时候，那么就进行入数栈
     * 3. 如果是一个运算符号的时候，分以下几种情况：
     * 3.1：如果符号栈为空，那么就进行入栈。
     * 3.2：如果符号栈已经有运算符，那么就进行比较运算符，如果当前运算符小于等于栈顶的运算符的时候，将数栈中的pop出两个数并将符号栈pop出一个运算符进行运算，运算的结果再次压入数栈
     * 3.3：如果当前运算符大于栈顶的运算符，那么就直接入符号栈
     * 4. 当表达式遍历完毕，就顺序的将数栈与符号栈中pop出相应的数和运算符来进行运算。
     * 5. 最后在数栈中的最后一个数字就是结果值。
     */
    public int startCalculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new RuntimeException("表达式有误");
        }
        int res = 0;
        for (int i = 0; i < expression.length(); i++) {
            char charAt = expression.charAt(i);
            if (isOperator(charAt)) { // 如果是运算符号
                if (operatorStack.isEmpty()) {
                    operatorStack.push(charAt);
                } else {
                    if (getOperatorPriority(charAt) <= getOperatorPriority(operatorStack.peek())) {
                        res = cal(numStack.pop(), numStack.pop(), operatorStack.pop());
                        numStack.push(res);
                        operatorStack.push(charAt);
                    } else {
                        operatorStack.push(charAt);
                    }
                }
            } else { // 如果不是运算符号，那么就是数字
                numStack.push(Integer.parseInt(String.valueOf(charAt)));
            }
        }
        while (!operatorStack.isEmpty()) {
            res = cal(numStack.pop(), numStack.pop(), operatorStack.pop());
            numStack.push(res);
        }
        return numStack.pop();
    }


    /**
     * 判断是否是一个符号
     *
     * @param val
     * @return
     */
    private boolean isOperator(char val) {
        return ADD == val || SUB == val || MUL == val || DIV == val;
    }


    /**
     * 获取符号的优先级
     *
     * @param operator
     * @return
     */
    private int getOperatorPriority(char operator) {
        if (ADD == operator || SUB == operator) {
            return 1;
        } else if (MUL == operator || DIV == operator) {
            return 2;
        } else {
            return -1;
        }
    }


    /**
     * 计算结果值的方法
     *
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    private int cal(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case ADD:
                result = num1 + num2;
                break;
            case SUB:
                result = num2 - num1;
                break;
            case MUL:
                result = num1 * num2;
                break;
            case DIV:
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.startCalculator("3+2*6-2");
        System.out.printf("3+2*6-2=%d", result);
    }

}
