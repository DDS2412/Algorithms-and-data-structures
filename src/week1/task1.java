package week1;

import mooc.*;

public class task1 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            io.println(io.nextInt() + io.nextInt());
        }
    }
}