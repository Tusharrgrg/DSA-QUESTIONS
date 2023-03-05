import java.util.*;

public class jumpGame4 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        return bfs(arr, n);
    }

    private int bfs(int[] arr, int n) {
        boolean[] vis = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        queue.offer(0);
        vis[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                int curr = queue.peek();
                queue.poll();

                if (curr == n - 1) {
                    return steps;
                }
                int pos2 = curr + 1;
                int pos1 = curr - 1;

                if (pos1 >= 0 && !vis[pos1]) {
                    queue.offer(pos1);
                    vis[pos1] = true;
                }

                if (pos2 < n && !vis[pos2]) {
                    queue.offer(pos2);
                    vis[pos2] = true;
                }

                for (int idx : map.getOrDefault(arr[curr], new ArrayList<>())) {
                    if (!vis[idx]) {
                        queue.offer(idx);
                        vis[idx] = true;
                    }
                }

                map.remove(arr[curr]);
            }
            steps++;
        }
        return steps;
    }
}
