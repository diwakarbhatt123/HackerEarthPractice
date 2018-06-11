package com.company.makemytrip;

import java.io.*;
import java.util.Arrays;

/**
 * Poisonous gas
 * You are in a battle field and your enemy has an army of N soldiers. Each soldier has a strength denoted by an array A. Your enemy will select some soldiers such that total strength of selected soldiers is maximum. You have a poisonous gas and you can use it on the selected soldiers as many times as you want. If the total strength is even, the poisonous gas will decrease the total strength of the selected soldiers to half of the total strength, otherwise it will not affect them. Your task is to tell if its possible to reduce the total strength to 1 or not.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * First line contains an integer T, denoting the number of test cases.
 * <p>
 * First line of each test case contains an integer N, denoting the number of soldiers.
 * <p>
 * Second line of each test case contains N space-separated integers, denoting the strength of the soldiers.
 * <p>
 * <p>
 * <p>
 * Output Format:
 * <p>
 * For each test case, print Yes if its possible to reduce the total strength to 1, otherwise print No.
 */


public class PoisnousGas {

    public static void main(String[] args) throws IOException {
        //BufferedReader
        Reader s = new Reader();
        int testCases = s.nextInt();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < testCases; i++) {
            int numberOfSoldiers = s.nextInt();
            int totalPower = 0;
            for (int j = 0; j < numberOfSoldiers; j++) {
                int power = s.nextInt();
                if (power > 0) {
                    totalPower += power;
                }
            }
            System.out.println((canBeReducedToZero(totalPower)) ? "Yes" : "No");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time"+ (endTime - startTime));
    }

//    private static void canReduceSoldierPowerToOne(int[] powers) {
//        Arrays.stream(powers).reduce((power1, power2) -> {
//            if (power1 <= 0 && power2 <= 0) {
//                return 0;
//            } else {
//                if (power1 <= 0) {
//                    return power2;
//                } else if (power2 <= 0) {
//                    return power1;
//                } else {
//                    return (power1 + power2);
//                }
//            }
//        }).ifPresent(val -> );
//    }

    private static boolean canBeReducedToZero(int val) {
        String binary = Integer.toBinaryString(val);
        return (binary.matches("^10*"));
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
