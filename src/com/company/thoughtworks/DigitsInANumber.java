package com.company.thoughtworks;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Digits in a Number
 * Let's say  are the only digits which exists in a unique number system, so the numbers will be  in ascending order .
 * <p>
 * number is 1 and number of digits is 1
 * <p>
 * will be 11  and number of digits is 2
 * <p>
 * will be 112 and number of digits will be 3
 * <p>
 * will be 1111  and number of digits will be 4
 * <p>
 * You have to find number of digits of  term in unique number system .
 * <p>
 * Input :
 * <p>
 * First line T contains number of testcases
 * <p>
 * Next T lines contains N
 * <p>
 * Output :
 * <p>
 * Number of digits in  number
 */

public class DigitsInANumber {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(printNthElement(reader.nextLong()));
        }
    }

    // Return n-th number in series made of 4 and 7
    static long printNthElement(long n)
    {
       long digitsInLevel = 0;
       BigInteger nodesInLevel = BigInteger.ZERO;
       BigInteger three = BigInteger.valueOf(3);
       long level = 2;
       while (nodesInLevel.compareTo(BigInteger.valueOf(n)) < 0){
           nodesInLevel = three.pow((int) (level - 1));
           digitsInLevel++;
           level++;
       }
        return digitsInLevel;
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
