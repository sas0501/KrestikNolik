package com.krestikNolik;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class GameKrestikNolik {

    static char[][] field = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static boolean flag = true;
    static String name1;
    static String name2;
    static char s;

    public static void main(String[] args) throws IOException {
        go();
    }

    public static void go() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("������� ��� ������� ������");
        name1 = in.nextLine();
        System.out.println("������� ��� ������� ������");
        name2 = in.nextLine();
        field = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        flag=true;
        while (true) {
            if (flag == true) {
                System.out.println(name1 + "   Enter x (0..2):");
                int a = in.nextInt();
                System.out.println(name1 + "   Enter y (0..2):");
                int b = in.nextInt();
                if (field[a][b] == ' ') {
                    flag = false;
                    field[a][b] = 'x';
                    for (int i = 0; i < 3; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < 3; j++) {
                            System.out.print(field[i][j] + " | ");
                        }
                        System.out.println();
                    }
                    proverka();
                } else {
                    System.out.println("������ ��� ������! ������� ������ ����������");
                }
            } else {
                System.out.println(name2 + "   Enter y (0..2):");
                int c = in.nextInt();
                System.out.println(name2 + "   Enter x (0..2):");
                int d = in.nextInt();
                if (field[c][d] == ' ') {
                    flag = true;
                    field[c][d] = '0';
                    for (int i = 0; i < 3; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < 3; j++) {
                            System.out.print(field[i][j] + " | ");
                        }
                        System.out.println();
                    }
                    proverka();
                } else {
                    System.out.println("������ ��� ������! ������� ������ ����������");
                }
            }
        }
    }

    public static void proverka() throws IOException {

        // �������� �� ����������� 1 �������
        if ((field[0][0] == field[0][1] && field[0][1] == field[0][2] && field[0][2] == 'x') || (field[0][0] == field[0][1] && field[0][1] == field[0][2] && field[0][2] == '0')) {
            s = field[0][0];
            save(s);
            // �������� �� ����������� 2 �������
        } else if ((field[1][0] == field[1][1] && field[1][1] == field[1][2] && field[1][2] == 'x') || (field[1][0] == field[1][1] && field[1][1] == field[1][2] && field[1][2] == '0')) {
            s = field[1][0];
            save(s);
            // �������� �� ����������� 3 �������
        } else if ((field[2][0] == field[2][1] && field[2][1] == field[2][2] && field[2][2] == 'x') || (field[2][0] == field[2][1] && field[2][1] == field[2][2] && field[2][2] == '0')) {
            char s = field[2][0];
            save(s);
            // �������� �� ��������� 1 ������
        } else if ((field[0][0] == field[1][0] && field[1][0] == field[2][0] && field[2][0] == 'x') || (field[0][0] == field[1][0] && field[1][0] == field[2][0] && field[2][0] == '0')) {
            char s = field[0][0];
            save(s);
            // ��������  �� ��������� 2 ������
        } else if ((field[0][1] == field[1][1] && field[1][1] == field[2][1] && field[2][1] == 'x') || (field[0][1] == field[1][1] && field[1][1] == field[2][1] && field[2][1] == '0')) {
            char s = field[0][1];
            save(s);
            // �������� �� ��������� 3 ������
        } else if ((field[0][2] == field[1][2] && field[1][2] == field[2][2] && field[2][2] == 'x') || (field[0][2] == field[1][2] && field[1][2] == field[2][2] && field[2][2] == '0')) {
            char s = field[0][2];
            save(s);
            // �������� �� ���������
        } else if ((field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] == 'x') || (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] == '0')) {
            char s = field[0][0];
            save(s);
            // �������� �� ���������
        } else if ((field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[2][0] == 'x') || (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[2][0] == '0')) {
            char s = field[0][2];
            save(s);
        }
    }

    public static void save(char s) throws IOException {
        OutputStream out = null;
        String pobeditel = null;
        if (s == 'x') {
            pobeditel = "������� " + name1 + "\n";
        } else if (s == '0') {
            pobeditel = "������� " + name2 + "\n";
        }
        try {
            out = new FileOutputStream("C:\\IdeaProjects\\KresikNolik\\src\\com\\krestikNolik\\save.txt", true);
            System.out.println("\n" + pobeditel);
            byte[] bytes = pobeditel.getBytes("cp1251");
            out.write(bytes);
            System.out.println("���� ������ ������� ��� ��� �����? \"��\" ��� \"���\"");
            Scanner in = new Scanner(System.in);
            String xotelka = in.nextLine();
            if (xotelka.equals("��")) {
                go();
            } else {
                System.out.println("���� ���������");
                System.exit(1);
            }
        } finally {
            if (out != null) out.close();
        }
    }
}

