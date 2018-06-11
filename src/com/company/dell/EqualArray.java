package com.company.dell;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
You are given an array  of size

    Find the minimum non negative number  such that there exist an index  and when you can replace  by , the sum of elements of array from index  to   and  to   becomes equal, where . Assume array to be 1-indexed.

    If there is no possible  print  in separate line.

    Input Format

    The first line contains , the number of test cases.
    For each Test case :
    The first line contains an integer , size of the array.
    The second line contains  space-separated integers, the  of which is .
**/

public class EqualArray {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        for (int i = 0; i < testCases; i++) {
            int arraySize = reader.nextInt();
            int inputArray[] = new int[arraySize];
            int arrSum = 0;
            for (int j = 0; j < arraySize ; j++) {
                int val = reader.nextInt();
                inputArray[j] = val;
                arrSum += val;
            }
            System.out.println(findMinIntegerToMakeEqual(inputArray, arrSum));
        }
        reader.close();
    }

    private static int findMinIntegerToMakeEqual(int array[], int arraySum) {
        int leastDiff = Integer.MAX_VALUE;
        int sumTillNow = 0;
        for (int i = 0; i < array.length; i++) {
            sumTillNow += array[i];
            int sumLeft = arraySum - sumTillNow;
            int diff = sumLeft - sumTillNow;
            leastDiff = ((diff >= 0) && (diff < leastDiff)) ? diff : leastDiff;
        }
        return (leastDiff == Integer.MAX_VALUE) ? -1 : leastDiff;
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
