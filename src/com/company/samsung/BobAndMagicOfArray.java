package com.company.samsung;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Bob and Beauty of the Array
 * Bob is having a array A  of N elements . Bob wants to determine the beauty of the array and the beauty of the array is defned as :-
 * <p>
 * Determine Bitwise OR of maximum and minimum elements  of every subset of size greater than or equal to  2 and add them.
 * <p>
 * As the answer can be quite large , you have to report it by taking modulo with 1000000007 .
 * <p>
 * Input
 * <p>
 * First line of the input will contain N , denoting the number of elements of the array.
 * <p>
 * Second line will contain N spaced integers denoting elements of the array .
 */
public class BobAndMagicOfArray {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int size = reader.nextInt();
        int inputArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            inputArray[i] = reader.nextInt();
        }
        System.out.println(getBeautyOfArray(inputArray));
    }

    private static long getBeautyOfArray(int[] inputArray) {
        long n = inputArray.length;
        long sum = 0;
        for (long i = 0; i < (1L << n); i++) {
            long count = 0;
            long minElement = Integer.MAX_VALUE;
            long maxElement = Integer.MIN_VALUE;
            for (long j = 0; j < n; j++) {
                if ((i & (1L << j)) > 0) {
                    count ++;
                    minElement = (inputArray[(int) j] < minElement)?inputArray[(int) j]:minElement;
                    maxElement = (inputArray[(int) j] > maxElement)?inputArray[(int) j]:maxElement;
                }
            }
            if(count > 1){
                sum += minElement | maxElement;
            }
        }
        return (sum % 1000000007);
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
