package com.company.Esko;

import java.io.*;
import java.util.stream.Stream;

/**
 * Write a program to sort a set of given units and output a single relationship equation among the units in descending order of size. The input given will be a series of comma separated units and a set of relationship equations between them. From these equations, you are expected to derive a single relationship equation in descending order of the units, with the largest unit on the left. Further, the following are given:
 *
 * The number of equations given will be 1 less than the number of units given
 *
 * To keep it simple, only units that can be expressed as integer multiples of each other should be considered. Meaning, the equations must not contain fractional multipliers
 *
 * Input
 * First line contains name of all the units separated by comma - no spaces
 * If there are  units in the above line then there will be  lines in the input that defines relation between the quanitites. The input format of the relationship between the units is -
 *  where  is the string that denotes unit on the left hand side of the eqquation , then followed by the space is the = symbol , then followed by space is an integer value  and then followed by space is the string  that denotes unit on the right hand side.
 *
 * Output
 *
 * In the output you need to print a single string that denotes relation between all the units in the descending order of their value as per  the sample output.
 *
 * Constraints
 *
 * Sample Input
 * day,hour,second,minute
 * day = 24 hour
 * hour = 60 minute
 * minute = 60 second
 * Sample Output
 * 1day = 24hour = 1440minute = 86400second
 */
public class UnitBalancer {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int noOfUnits = reader.readLine().split(",").length;
        System.out.println(getEquationString(new BufferedReader(new InputStreamReader(System.in)).lines()));
    }

    private static String getEquationString(Stream<String> lines) {
        StringBuilder equation = new StringBuilder();
//        lines.
        return "";
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
