/**
 * Created by linhjiang on 7/15/18.
 */
public class NumToHex {

  public String toHex(int num) {
    if(num >= 0) {
      return positiveToHex(num);
    } else {
      return negativeToHex(num);
    }
  }

  private String negativeToHex(int num) {
    String result = "";
    String value = positiveToHex( num * -1);
    int extra = 1;
    for(int i = value.length() - 1 ; i >= value.length() - 8; i --) {
      char c = '0';
      if(i >= 0) {
        c = value.charAt(i);
      }

      char f = (char) ('f' + extra);
      extra = 0;
      if(c >= 'a') {
        c = toHexChar(f - c);
      } else {
        int temp = f - 'a' + 10 - (c - '0');
        if(temp >= 16) {
          extra = 1;
          c = toHexChar(temp - 16);
        } else {
          c = toHexChar(temp);
        }
      }

      result = c + result;
    }
    return result;
  }

  private String positiveToHex(int num) {
    String result = "";
    do {
      result = toHexChar(num % 16) + result;
      num /=16;
    } while(num != 0);

    return result;
  }

  private char toHexChar(int n) {
    if (n < 10) {
      return (char) (n + 48);
    } else {
      return (char) (n - 10 + 'a');
    }
  }

  public static void main(String[] args) {
    System.out.println(new NumToHex().toHex(999));
    System.out.println(new NumToHex().toHex(-1));
    System.out.println(new NumToHex().toHex(-10));
    System.out.println(new NumToHex().toHex(-100000));
  }
}
