package com.company.capillary;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Old and Cold Numbers
 * Let's define Old number as a number , such that it is divisible by count of odd integers in the range  to . If number does not hold this property, then such number is defined as Cold number.
 * You are given an array  and  tasks of the form  , you have to find what is the minimum numbers of steps needed to make subarray from  to  balanced.
 * Any subarray is said to be balanced if count of Old number(s) is not less than count of Cold number(s) in that subarray. In every step, you can either increase the value of some array element by 1 or you can decrease an array element by 1.
 * <p>
 * Note: All tasks are independent of each other.
 * <p>
 * Input Format:
 * First line contains an integer , denoting the number of testcases.
 * <p>
 * In each test case:
 * Firstl line contains , the number of elements in array .
 * Next line contains  space separated integers denoting array elements.
 * Next line contains , the number of queries.
 * Each of the next  lines contains two space separated integers  and .
 * <p>
 * Output Fomat:
 * For each task, print total number of steps needed to change the subarray such that subarray from  to  is balanced.
 * Answer for each task should be printed in a new line.
 */
public class OldAndColdNumbers {


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < testCases; i++) {
            int arrSize = reader.nextInt();
            int inputArr[] = new int[arrSize];
            for (int j = 0; j < arrSize; j++) {
                inputArr[j] = reader.nextInt();
            }
            int noOfQuery = reader.nextInt();
            map.put("Array"+i,inputArr);
            List<String> queries = new ArrayList<>();
            for (int j = 0; j < noOfQuery; j++) {
                queries.add(reader.nextInt()+"/"+reader.nextInt());
//                System.out.println(noOfStepsRequiredToBalanace(inputArr, reader.nextInt(), reader.nextInt()));
            }
            map.put("query"+i,queries);
        }
        throw new IOException("Queries " +
                map.toString()
        );
    }

    private static long noOfStepsRequiredToBalanace(int[] inputArray, int l, int r) {
        long evenInRange = Arrays.stream(inputArray,l-1,r).filter(integer -> integer % 2 == 0).count();
        return Math.abs((IntStream.rangeClosed(l, r).count() - evenInRange) - evenInRange);
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
