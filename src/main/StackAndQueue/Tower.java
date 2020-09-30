package main.StackAndQueue;

public class Tower {

    public void move(int n, char origin, char buffer, char dest) {
        if (n > 0) {
            move(n-1, origin, dest, buffer);
            System.out.println(
                    String.format("Move disk %s from %s to %s",n, origin, dest));
            move(n-1, buffer, origin, dest);
        }

    }
}
