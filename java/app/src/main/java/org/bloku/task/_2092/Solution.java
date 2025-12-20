package org.bloku.task._2092;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@LeetCodeName("Find All People With Secret")
@Topics({GRAPH, SORTING, UNION_FIND})
class Solution {

    private final Set<Integer> knows = new HashSet<>();

    public List<Integer> findAllPeople(int persons, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(persons);
        knows.add(0);
        knows.add(firstPerson);
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        int n = meetings.length;
        int pos = 0;
        while (pos < n) {
            int time = meetings[pos][2];
            while (pos < n && meetings[pos][2] == time) {
                uf.union(meetings[pos][0], meetings[pos][1]);
                pos++;
            }
            uf.clear();
        }
        uf.shareSecret();
        return new ArrayList<>(knows);
    }

    private final class UnionFind {
        private final int[] parents;
        private final Set<Integer> touched;
        private final Set<Integer> groups;

        UnionFind(int n) {
            this.parents = new int[n];
            this.touched = new HashSet<>();
            this.groups = new HashSet<>();
            for (int i = 0; i < n; i++) this.parents[i] = i;
        }

        int find(int i) {
            int root = parents[i];
            if (parents[root] != root) {
                return parents[i] = find(root);
            }
            return root;
        }

        void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);
            parents[parB] = parA;
            if (knows.contains(a)
                    || knows.contains(b)
                    || groups.contains(parA)
                    || groups.contains(parB)) groups.add(parA);
            else {
                touched.add(a);
                touched.add(b);
            }
        }

        void clear() {
            for (int person : touched) if (!groups.contains(find(person))) parents[person] = person;
            touched.clear();
        }

        void shareSecret() {
            for (int i = 0; i < parents.length; i++) if (groups.contains(find(i))) knows.add(i);
        }
    }
}
