public class PlusOne {
    // 根据题意加一，没错就是加一这很重要，因为它是只加一的所以有可能的情况就只有两种：
    // 1.除9之外的数字加一，
    // 2.数字9加一得十进一位个位数为0
    // 加法运算如不出现进位就运算结束了且进位只会是一，
    // 所以只需要判断有没有进位并模拟出它的进位方式，
    // 如十位数加1个位数置为0，如此循环直到判断没有再进位就退出循环返回结果。
    // 然后还有一些特殊情况就是当出现99、999之类的数字时，循环到最后也需要进位，
    // 出现这种情况时需要手动将它进一位。
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
