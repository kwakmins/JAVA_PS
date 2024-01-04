import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G5 이진 검색 트리 - https://www.acmicpc.net/problem/5639
 * 이진 트리 구현 - 후위 순회 구현하기.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(bf.readLine()));
        while (true) {
            String line = bf.readLine();
            if (line == null || line.equals("")) {
                break;
            }

            root.insert(Integer.parseInt(line));
        }
        postOrder(root);
    }

    static class Node {

        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }

        void insert(int n) {
            if (n < this.value) {
                if (this.left != null) {
                    this.left.insert(n);
                } else {
                    this.left = new Node(n);
                }
            } else {
                if (this.right != null) {
                    this.right.insert(n);
                } else {
                    this.right = new Node(n);
                }
            }
        }
    }

    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
