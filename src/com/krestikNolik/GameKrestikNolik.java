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
    static int a;
    static int b;
    static int c;
    static int d;


    public static void main(String[] args) throws IOException {
        go();
    }

    public static void go() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя первого игрока");
        name1 = in.nextLine();
        System.out.println("Введите имя второго игрока");
        name2 = in.nextLine();
        field = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        flag = true;
        go1();
    }

    public static void go1() throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            if (flag == true) {
                System.out.println(name1 + "   Enter x (0..2):");
                a = in.nextInt();
                System.out.println(name1 + "   Enter y (0..2):");
                b = in.nextInt();
                if (a >= 0 && a <= 2 && b >= 0 && b <= 2) {
                    perviyProverka();
                } else {
                    System.out.println("Координаты введены неправильно, введите координаты заново от 0 до 2");
                    go1();
                }
            } else {
                System.out.println(name2 + "   Enter y (0..2):");
                c = in.nextInt();
                System.out.println(name2 + "   Enter x (0..2):");
                d = in.nextInt();
                if (c >= 0 && c <= 2 && d >= 0 && d <= 2) {
                    vtoroyProverka();
                } else {
                    System.out.println("Координаты введены неправильно, введите координаты заново от 0 до 2");
                    go1();
                }
            }
        }
    }

    public static void perviyProverka() throws IOException {
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
            System.out.println("Ячейка уже занята! Введите другие координаты");
        }
    }

    public static void vtoroyProverka() throws IOException {
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
            System.out.println("Ячейка уже занята! Введите другие координаты");
        }
    }

    public static void proverka() throws IOException {

        // Проверка по горизонтали 1 столбец
        if ((field[0][0] == field[0][1] && field[0][1] == field[0][2] && field[0][2] == 'x') || (field[0][0] == field[0][1] && field[0][1] == field[0][2] && field[0][2] == '0')) {
            s = field[0][0];
            save(s);
            // Проверка по горизонтали 2 столбец
        } else if ((field[1][0] == field[1][1] && field[1][1] == field[1][2] && field[1][2] == 'x') || (field[1][0] == field[1][1] && field[1][1] == field[1][2] && field[1][2] == '0')) {
            s = field[1][0];
            save(s);
            // Проверка по горизонтали 3 столбец
        } else if ((field[2][0] == field[2][1] && field[2][1] == field[2][2] && field[2][2] == 'x') || (field[2][0] == field[2][1] && field[2][1] == field[2][2] && field[2][2] == '0')) {
            char s = field[2][0];
            save(s);
            // Проверка по вертикали 1 строка
        } else if ((field[0][0] == field[1][0] && field[1][0] == field[2][0] && field[2][0] == 'x') || (field[0][0] == field[1][0] && field[1][0] == field[2][0] && field[2][0] == '0')) {
            char s = field[0][0];
            save(s);
            // Проверка  по вертикали 2 строка
        } else if ((field[0][1] == field[1][1] && field[1][1] == field[2][1] && field[2][1] == 'x') || (field[0][1] == field[1][1] && field[1][1] == field[2][1] && field[2][1] == '0')) {
            char s = field[0][1];
            save(s);
            // Проверка по вертикали 3 строка
        } else if ((field[0][2] == field[1][2] && field[1][2] == field[2][2] && field[2][2] == 'x') || (field[0][2] == field[1][2] && field[1][2] == field[2][2] && field[2][2] == '0')) {
            char s = field[0][2];
            save(s);
            // Проверка по диоганали
        } else if ((field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] == 'x') || (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] == '0')) {
            char s = field[0][0];
            save(s);
            // Проверка по диоганали
        } else if ((field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[2][0] == 'x') || (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[2][0] == '0')) {
            char s = field[0][2];
            save(s);
        }
    }

    public static void save(char s) throws IOException {
        OutputStream out = null;
        String pobeditel = null;
        if (s == 'x') {
            pobeditel = "Победил " + name1 + "\n";
        } else if (s == '0') {
            pobeditel = "Победил " + name2 + "\n";
        }
        try {
            out = new FileOutputStream("C:\\IdeaProjects\\KresikNolik\\src\\com\\krestikNolik\\save.txt", true);
            System.out.println("\n" + pobeditel);
            byte[] bytes = pobeditel.getBytes("cp1251");
            out.write(bytes);
            System.out.println("Если хочешь сыграть ещё раз введи? \"да\" или \"нет\"");
            Scanner in = new Scanner(System.in);
            String xotelka = in.nextLine();
            if (xotelka.equals("да")) {
                go();
            } else {
                System.out.println("Игра закончена");
                System.exit(1);
            }
        } finally {
            if (out != null) out.close();
        }
    }
}

