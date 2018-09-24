package com.cyq7on.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalScheduling {

    public static class Job implements Comparable<Job> {
        private String name;
        private int startTime;
        private int finishTime;

        public Job(String name, int startTime, int finishTime) {
            this.name = name;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        public Job(int startTime, int finishTime) {
            this("", startTime, finishTime);
        }

        @Override
        public int compareTo(Job o) {
            return finishTime - o.finishTime;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "name='" + name + '\'' +
                    ", startTime=" + startTime +
                    ", finishTime=" + finishTime +
                    '}';
        }
    }

    public static List<Job> intervalScheduling(Job[] jobs) {
        List<Job> list = new ArrayList<>(jobs.length);
        Arrays.sort(jobs);
        list.add(jobs[0]);
        for (int i = 1; i < jobs.length; i++) {
            Job job = jobs[i];
            Job lastJob = list.get(list.size() - 1);
            if (job.startTime >= lastJob.finishTime) {
                list.add(job);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job("a", 0, 6),
                new Job("b", 1, 4),
                new Job("c", 3, 5),
                new Job("d", 3, 8),
                new Job("e", 4, 7),
                new Job("f", 5, 9),
                new Job("g", 6, 10),
                new Job("h", 8, 11),
        };
        System.out.println(intervalScheduling(jobs));
    }
}
