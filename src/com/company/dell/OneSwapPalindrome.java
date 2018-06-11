package com.company.dell;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * One Swap to Palindrome
 * You are given T tasks to perform. In each task, you are given a string S of length N. You are allowed to select any two indices i and j (i!=j) of the given string and perform exactly one swap between the characters at these indices.
 *
 * If it is possible to make the new string a palindrome then print "Yes", else print "No".
 *
 * Note:
 *
 * A string is said to be palindrome if it reads same as its reverse form. For example: "madam" , "dad" etc.
 *
 *
 *
 * INPUT
 *
 * First line contain an integer T denoting total number of tasks to perform.
 *
 * Each of the following T lines contains a string S.
 *
 *
 *
 * OUTPUT
 *
 * For each task, print a single line with "Yes" if it is possible to make palindrome otherwise print "No" without any quotes.
 *
 *
 */
public class OneSwapPalindrome {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        for (int i = 0; i < testCases; i++) {
            StringBuilder str = new StringBuilder(reader.readLine());
            System.out.println(singleSwapPalindromePossible(str));
        }

    }

    private static boolean singleSwapPalindromePossible(StringBuilder str) {
        int startPointer = 0;
        int endPointer = str.length()-1;
        while (startPointer<endPointer){
            if(str.charAt(startPointer) != str.charAt(endPointer)){
                for (int i = startPointer+1; i <=endPointer; i++) {
                    StringBuilder tempString = new StringBuilder(str);
                    tempString.setCharAt(startPointer,str.charAt(i));
                    tempString.setCharAt(i,str.charAt(startPointer));
                    String originalString = tempString.toString();
                    String reversedString = tempString.reverse().toString();
                    if(originalString.equals(reversedString)){
                        return true;
                    }
                }
            }
            startPointer++;
            endPointer--;
        }
        return false;
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
