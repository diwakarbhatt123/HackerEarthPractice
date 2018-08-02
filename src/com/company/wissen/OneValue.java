package com.company.wissen;

import java.io.*;
import java.util.*;

public class OneValue {

    private static Map<Integer, Integer> frequencyMap = new HashMap<>();
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(tk.nextToken());
            if (type == 1) {
                int val = Integer.parseInt(tk.nextToken());
                add_to_list(val);
            }
            else if (type == 2) {
                int val = Integer.parseInt(tk.nextToken());
                remove_from_list(val);
            }
            else if (type == 3) {
                find_least_frequency();
            }
            else if (type == 4){
                find_highest_frequency();
            }
        }
    }
    public static void add_to_list(int val){
        Integer freq = frequencyMap.get(val);
        if (Objects.isNull(freq)) {
            freq = 1;
        } else {
            freq++;
        }
        frequencyMap.put(val, freq);
    }

    public static void remove_from_list(int val){
        Integer freq = frequencyMap.get(val);
        if (Objects.nonNull(freq)) {
            freq--;
        }
        frequencyMap.put(val, freq);
    }

    public static void find_least_frequency(){
        Optional<Map.Entry<Integer, Integer>> maxFreqEntry = frequencyMap.entrySet().parallelStream().min((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return (Objects.equals(o1.getKey(), o2.getKey())) ? 0 : ((o1.getKey() < o2.getKey()) ? 1 : -1);
            } else {
                return (o1.getValue() > o2.getValue()) ? 1 : -1;
            }
        });
        System.out.println(maxFreqEntry.map(Map.Entry::getKey).orElse(-1));
    }

    public static void find_highest_frequency() throws Exception{
        try {
            Optional<Map.Entry<Integer,Integer>> minFreqEntry = frequencyMap.entrySet().parallelStream().max((o1, o2) -> {
                if (Objects.equals(o1.getValue(), o2.getValue())) {
                    return (Objects.equals(o1.getKey(), o2.getKey())) ? 0 : ((o1.getKey() > o2.getKey()) ? 1 : -1);
                } else {
                    return (o1.getValue() > o2.getValue()) ? 1 : -1;
                }
            });
            System.out.println(minFreqEntry.map(Map.Entry::getKey).orElse(-1));
        }catch (NullPointerException npe){
            System.err.println(npe.getMessage()+"\n"+frequencyMap.toString());
            throw new Exception(npe.getMessage()+"\n"+frequencyMap.toString());
        }
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
            byte[] buf = new byte[(int) Math.pow(10, 5)]; // line length
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
