package leetcode;

/**
 * Created by linhjiang on 8/25/18.
 */
public class SolveTheEquation {

  public String solveEquation(String equation) {
    int numOfx = 0;
    int m = 1; // positive or negative
    int l = 1; // left or right
    int sum = 0;
    String num = "";
    for(char c : equation.toCharArray()) {
      if('x' == c) {
        if("".equals(num)) {
          numOfx += m * l;
        } else {
          numOfx += m * l * getNum(num);
        }
        num = "";
      } else if('-' == c) {
        sum += getNum(num) * m * l;
        num = "";
        m = -1;
      } else if('+' == c) {
        sum += getNum(num) * m * l;
        num = "";
        m = 1;
      } else if('=' == c) {
        sum += getNum(num) * m * l;
        num = "";
        l = -1;
        m = 1;
      } else {
        num += c;
      }
    }

    sum += getNum(num) * m * l;

    if(numOfx == 0) {
      if(sum == 0) {
        return "Infinite solutions";
      } else {
        return "No solution";
      }
    } else {
      return "x=" + sum / numOfx * -1;
    }
  }

  private int getNum(String num) {
    char[] chars = num.toCharArray();
    int result = 0;
    for(int i = chars.length - 1, j = 1; i >= 0; i --, j *= 10) {
     result += (chars[i] - 48) * j;
    }
    return result;
  }

  public static void main(String[] args) {
    String e = "3x=33+22+11";
    System.out.println(new SolveTheEquation().solveEquation(e));
  }
}
