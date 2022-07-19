package src;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 */
public class ReverseBits {

    private static final int M8 = 0x00ff00ff;  // 0b00000000111111110000000011111111
    private static final int M4 = 0x0f0f0f0f;  // 0b00001111000011110000111100001111
    private static final int M2 = 0x33333333;  // 0b00110011001100110011001100110011
    private static final int M1 = 0x55555555;  // 0b01010101010101010101010101010101

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = n >>> 16 | n << 16;
        n = n >>> 8 & M8 | (n & M8) << 8;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 1 & M1 | (n & M1) << 1;
        return n;
    }

}
