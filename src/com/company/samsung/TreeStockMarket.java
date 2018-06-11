package com.company.samsung;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Tree-Stock Market
 * Mr X is very curious to know about the frequency of stocks. But unfortunately for him, the stocks are represented as nodes of a tree with prices of the stocks as their value. Mr X hates trees as much as he loves to learn about stocks. So he asks for your help:
 *
 *  Given a tree with N nodes (each node represents a stock) numbered from 1 to N (rooted at 1).
 *  Each stock has a price/value which is denoted by Pi.
 *  He is very curious so he asks a lot of questions of the form: U L R .
 *  For each of his question he wants to know how many different stock prices/values are present in the subtree of U for which frequency is between L and R(Both inclusive).
 *
 *  INPUT:
 *
 * The first line contains 2 space seperated integers N and Q, the number of nodes in the tree and the number of queries
 *
 * Following N-1 lines contains 2 integers a and b denoting an edge between a and b
 *
 * Next line contains N space seperated integers denoting the value of each node
 *
 * Following Q lines contains 3 space seperated integers U,L,R
 *
 * OUTPUT:
 *
 * Output Q lines containing the answer of each query.
 */
public class TreeStockMarket {
    private static Map<Integer,Node> nodeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int nodes = reader.nextInt();
        int query = reader.nextInt();
        for (int i = 0; i < nodes-1; i++) {
            int firstNode = reader.nextInt();
            int secondNode = reader.nextInt();
            Node nodeOne = nodeMap.get(firstNode);
            if(nodeOne == null){
                nodeOne = new Node();
            }
            Node nodeTwo = new Node();
            if(nodeOne.getLeft() == null){
                nodeOne.setLeft(nodeTwo);
            } else if(nodeOne.getRight() == null){
                nodeOne.setRight(nodeTwo);
            }
            nodeMap.put(firstNode,nodeOne);
            nodeMap.put(secondNode,nodeTwo);
        }
        for (int i = 0; i < nodes; i++) {
            Node node = nodeMap.get(i+1);
            if(node != null){
                node.setData(reader.nextInt());
            }
        }
        for (int i = 0; i < query; i++) {
            int u = reader.nextInt();
            int l = reader.nextInt();
            int r = reader.nextInt();
//            System.out.println(findStockFrequency(u,l,r));
        }
    }

    private static int findStockFrequency(int u, int l, int r) throws Exception {
        Node root = nodeMap.get(u);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int frequency = 0;
        while (!queue.isEmpty())
        {
            Node tempNode = queue.poll();
            int data = tempNode.getData();
            if(data >= l && data <= r){
                frequency++;
            }
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
            Optional<Integer> integerOptional = Optional.of(1);
            integerOptional.orElseThrow(Exception::new);
        }
        return frequency;
    }

    static class Node{
        Node left;
        Node right;
        int data;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
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
