package com.learn.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王亚华
 * @Description 逆波兰表达式实现计算器  中缀转后缀  包括 + - * /  小括号 ()
 * @Date 创建于 2020-04-16 14:11
 */
public class PolandNotation {

    private static final String ADD = "+";

    private static final String SUB = "-";

    private static final String MUL = "*";

    private static final String DIV = "/";


    public static void main(String[] args) {
        PolandNotation polandNotation = new PolandNotation();
        // 将表达式转换为一个List
        List<String> expressionList = polandNotation.expressionToList("1+((2+3)*4)-5");
        // 将中缀表达式转换为后缀表达式（逆波兰表达式）
        List<String> suffixExpressionList = polandNotation.parseSuffixExpressionList(expressionList);
        System.out.println(suffixExpressionList);
        System.out.println(polandNotation.calculate(suffixExpressionList));
    }

    /**
     * 根据后缀表达式进行运算
     * 主要实现就是将后缀表达式遍历，如果遇到数字，那么就进行入栈，遇到符号就进行pop出两个来进行运算,将运算的结果再压入栈
     *
     * @param suffixExpressionList
     * @return
     */
    public int calculate(List<String> suffixExpressionList) {
        LinkListStack<String> stack = new LinkListStack<>();
        for (String item : suffixExpressionList) {
            if (isNumber(item)) {
                stack.push(item);
            } else {
                String num2 = stack.pop();
                String num1 = stack.pop();
                int res = cal(Integer.parseInt(num1), Integer.parseInt(num2), item);
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }


    /**
     * 中缀转后缀表达式分析：
     * 1. 遍历字符串表达式。
     * 2. 遇到操作数时，将其压入S2
     * 3. 遇到运算符的时候，比较其与S1栈顶运算符的优先级
     * 3.1：如果运算符栈S1为空或栈顶运算符为左括号“(”时直接将此运算符入栈；
     * 3.2：如果此运算符比栈顶的运算符优先级高，也将运算符压入运算符S1栈中；
     * 3.3：如果此运算符比运算符栈顶的优先级底或相等，将S1栈顶的运算符弹出并压入到S2中，再次转到3.1与S1中新的栈顶运算符比较。
     * 4. 遇到括号时：
     * 4.1：如果是左括号“(”，则直接压入S1
     * 4.2：如果是有括号“)”，则依次弹出S1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃。
     * 5. 重复1~4的步骤，直到遍历完表达式。
     * 6. 将S1中剩余的运算符依次弹出并压入S2
     * 7. 依次弹出S2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */

    /**
     * 将中缀表达式转换为后缀表达式
     *
     * @param expressionList
     * @return
     */
    public List<String> parseSuffixExpressionList(List<String> expressionList) {
        LinkListStack<String> s1 = new LinkListStack<>();
        List<String> s2 = new ArrayList<>();
        for (String item : expressionList) {
            if (isNumber(item)) {
                s2.add(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else if (item.equals("(")) {
                s1.push(item);
            } else {
                while (!s1.isEmpty() && !isNumber(item) && getOperatorPriority(s1.peek()) >= getOperatorPriority(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;
    }


    /**
     * 将字符表达式转换为List
     *
     * @param expression
     * @return
     */
    private List<String> expressionToList(String expression) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (isNumber(expression.charAt(i))) { // 如果是数字
                StringBuilder numStr = new StringBuilder(String.valueOf(expression.charAt(i)));
                for (int j = i + 1; j < expression.length(); j++) {
                    if (isNumber(expression.charAt(j))) {
                        numStr.append(expression.charAt(j));
                        i = j;
                    } else {
                        break;
                    }
                }
                resultList.add(numStr.toString());
            } else {
                resultList.add(String.valueOf(expression.charAt(i)));
            }
        }
        return resultList;
    }


    /**
     * 获取运算符的优先级
     *
     * @param operator
     * @return
     */
    private int getOperatorPriority(String operator) {
        if (ADD.equals(operator) || SUB.equals(operator)) {
            return 1;
        } else if (MUL.equals(operator) || DIV.equals(operator)) {
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
    private int cal(int num1, int num2, String operator) {
        int result = 0;
        switch (operator) {
            case ADD:
                result = num1 + num2;
                break;
            case SUB:
                result = num1 - num2;
                break;
            case MUL:
                result = num1 * num2;
                break;
            case DIV:
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }


    private boolean isNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }


    private boolean isNumber(String str) {
        return str.matches("\\d+");
    }


}
