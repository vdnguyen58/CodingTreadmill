package com.vonguyen.leetcode.weeklycontest82;

public class FriendsOfAppropriateAges {

    private boolean canFriend(int A, int B) {
        if (B <= 0.5 * A + 7) {
            return false;
        }
        if (B > A) {
            return false;
        }
        if (B > 100 && A < 100) {
            return false;
        }
        return true;
    }

    public int numFriendRequests(int[] ages) {

        int[] distribution = new int[151];
        int count = 0;

        for (int age : ages) {
            distribution[age]++;
        }

        for (int i=1; i<=150; i++) {
            if (distribution[i] != 0) {
                for (int j = 1; j <= 150; j++) {
                    if (distribution[j] != 0 && canFriend(i, j)) {
                        if (i != j) {
                            count += distribution[i] * distribution[j];
                        } else {
                            count += distribution[i] * (distribution[i] - 1);
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FriendsOfAppropriateAges app = new FriendsOfAppropriateAges();
        int[] ages = {16, 16, 16, 17, 17};
        System.out.println(app.numFriendRequests(ages));
    }
}
