package com.company.makemytrip;


import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bob And Array Queries
 * Bob has an array A[] of N integers. Initially, all the elements of the array are zero. Bob asks you to perform Q operations on this array.
 * <p>
 * There are three types of operations that can be performed:
 * <p>
 * 1 X: Update the value of A[X] to  2 * A[X] + 1.
 * 2 X: Update the value A[X] to  f(A[x]/2), where f(x) is Greatest Integer Function.
 * 3 X Y: Take all the A[i] such that  X <= i <= Y and convert them into their corresponding binary strings. Now concatenate all the binary strings and find the total no. of '1' in the resulting string.
 * Note: It is guaranteed that there is at least 1 type-3 query in the every test case. All the array elements will fit into 64 bit integers.
 * <p>
 * Input Format:
 * First line consists of two space-separated integers N and Q.
 * Next, Q lines consist of Q operations of either of the 3 types as described above.
 * <p>
 * Output Format:
 * For each type-3 query print the answer that is the no. of '1' in the resulting string.
 **/
public class BobAndArrayQueries {

    public static void main(String[] args) throws IOException {
        //BufferedReader
        Reader s = new Reader();
        int n = s.nextInt();                // Reading input from STDIN

        int op = s.nextInt();
        BigInteger inputArr[] = new BigInteger[n];
        BobAndArrayQueries bobAndArrayQueries = new BobAndArrayQueries();
        for (int i = 0; i < op; i++) {
            String operation = s.readLine();
            inputArr = bobAndArrayQueries.performOperation(operation, inputArr);
        }
    }

    private BigInteger[] performOperation(String operation, BigInteger[] inputArray) {
            switch (operation.charAt(0)) {
                case '1':
                    int x = Integer.parseInt(operation.split(" ")[1]);
                    inputArray[x - 1] = inputArray[x - 1].multiply(BigInteger.valueOf(2L)).add(BigInteger.valueOf(1L));
                    return inputArray;
                case '2':
                    int x2 = Integer.parseInt(operation.split(" ")[1]);
                    inputArray[x2 - 1] = BigInteger.valueOf(BigDecimal.valueOf(inputArray[x2 - 1].floatValue()).divide(BigDecimal.valueOf(2L),new MathContext(Integer.MAX_VALUE,RoundingMode.FLOOR)).intValue());
                    return inputArray;
                case '3':
                    int x3 = Integer.parseInt(operation.split(" ")[1]);
                    int y3 = Integer.parseInt(operation.split(" ")[2]);
                    int count = 0;
                    for (int i = (x3 - 1); i <= (y3 - 1); i++) {
                        count += inputArray[i].bitCount();
                    }
                    System.out.println(count);
                    return inputArray;
            }
            return null;
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
