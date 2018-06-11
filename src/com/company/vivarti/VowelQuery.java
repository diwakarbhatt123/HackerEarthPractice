package com.company.vivarti;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * You are given a string S consisting of lowercase alphabets and an integer array val consisting of N integers. Using the given string S and array val, you need to create another string X according to the code snippet below:
 * Initially string X is empty
 * Let len be the length of string S
 * <p>
 * for i := 0 to N-1
 * pos := absolute value of val[i]
 * if(val[i] >= 0)
 * X := X + S[0,pos] // append substring of string S from index 0 to pos (both including) into X
 * else
 * X := X + S[pos,len-1] // append substring of string S from index pos to len-1 (both including) into X
 * You have to answer Q tasks. For each task, you are given an integer K and you have to print the Kth vowel in the string X. If the Kth vowel doesn't exist print -1.
 */
public class VowelQuery {

    private static List<Character> vowelList = new ArrayList<Character>();

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        String inputString = reader.readLine();
        StringBuilder outputString = new StringBuilder();
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            int pos = reader.nextInt();
            if (pos >= 0) {
                String subString = inputString.substring(0, pos + 1);
                for (char c : subString.toCharArray()) {
                    if (isVowel(c)) {
                        vowelList.add(c);
                    }
                }
                outputString.append(subString);
            } else {
                String subString = inputString.substring(Math.abs(pos), inputString.length());
                for (char c : subString.toCharArray()) {
                    if (isVowel(c)) {
                        vowelList.add(c);
                    }
                }
                outputString.append(inputString, Math.abs(pos), inputString.length());
            }
        }
        int tasks = reader.nextInt();
        for (int i = 0; i < tasks; i++) {
            int pos = reader.nextInt();
            try{
                System.out.println(vowelList.get(pos-1));
            }catch (IndexOutOfBoundsException ex){
                System.out.println(-1);
            }
        }
    }

    private static boolean isVowel(Character o1) {
        return (o1 == 'a' || o1 == 'e' || o1 == 'i' || o1 == 'o' || o1 == 'u');
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
            byte[] buf = new byte[(int)Math.pow(10,5)]; // line length
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
