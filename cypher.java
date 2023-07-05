/*Mr.jamesbond is a spy, he has to send a text to headquarters, as a security measure he is sending the text in cypher mode,the conversion of plain text to cypher text is as folows.
The string "PAYPALISHIRING" is converted to  cypher on a given number of rows like this
P   A   H   N
A P L S I I G
Y   I   R
To make his work simple write a program which converts plain text cipher text. You may want to display this pattern in a fixed font for better legibility example the above cipher may display like "PAHNAPLSIIGYIR".
input format : string
               number
output format : string
Example 1:
input = PAYPALISHIRING
3
output = PAHNAPLSIIGYIR
Example 2:
input = PAYPALISHIRING
4
output = PINALSIGYAHRPI*/

import java.util.Scanner;
public class Main {
    public static String convertToCipher(String text, int numRows) {
        if (numRows == 1 || text.length() <= numRows) {
            return text;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        int direction = -1;
        for (char ch : text.toCharArray()) {
            rows[currentRow].append(ch);
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction *= -1;
            }
            currentRow += direction;
        }
        StringBuilder cipherText = new StringBuilder();
        for (StringBuilder row : rows) {
            cipherText.append(row);
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int numRows = scanner.nextInt();
        String cipherText = convertToCipher(text, numRows);
        System.out.println(cipherText);
    }
}



    