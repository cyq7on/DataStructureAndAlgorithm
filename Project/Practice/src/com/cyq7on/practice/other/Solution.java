package com.cyq7on.practice.other;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.compileSeq("\"1,2,-1,1\"");
    }

    static class Bean{
        public int index;
        public List<Integer> list;

        public Bean(int index, List<Integer> list) {
            this.index = index;
            this.list = list;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 编译顺序
     * @param input string字符串
     * @return string字符串
     */
    public String compileSeq (String input) {
        // write code here
        String[] split = input.substring(1, input.length() - 1).split(",");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            map.put(i, Integer.valueOf(split[i]));
        }
        List<Bean> lists = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            List<Integer> list = new ArrayList<>();
            Integer task;
            int j = i;
            while ((task = map.get(j)) != -1) {
                list.add(task);
                j = task;
            }
            lists.add(new Bean(i,list));
        }
        StringBuilder sb = new StringBuilder("\"");
        lists.sort(new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                return o1.list.size() - o2.list.size();
            }
        });
        for (int i = 0; i < lists.size(); i++) {
            sb.append(lists.get(i).index).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\"");
        System.out.println(sb);
        return sb.toString();
    }

    static class Item {
        int id;

        int inputCnt;

        List<Integer> nextItems = new ArrayList<>();

        Item(int id) {
            this.id = id;
        }
    }

    static class Group {
        int id;

        int inputCnt;

        List<Integer> items = new ArrayList<>();

        List<Group> nextGroups = new ArrayList<>();

        Group(int id) {
            this.id = id;
        }
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Item[] items = new Item[n];
        Group[] itemToGroup = new Group[n];
        List<Group> oriGroups = new ArrayList<>();

        for (int j = 0; j < m; j++) {
            oriGroups.add(new Group(j));
        }

        for (int i = 0; i < n; i++) {
            items[i] = new Item(i);
        }

        for (int i = 0; i < group.length; i++) {
            int groupId = group[i];
            if (groupId == -1) {// 项目不属于任何组
                Group temp = new Group(oriGroups.size());
                oriGroups.add(temp);
                temp.items.add(i);
                itemToGroup[i] = temp;
            } else {
                oriGroups.get(groupId).items.add(i);
                itemToGroup[i] = oriGroups.get(groupId);
            }
        }

        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> array = beforeItems.get(i);
            items[i].inputCnt = array.size();
            for (Integer itemId : array) {
                items[itemId].nextItems.add(i);
                Group beforeGroup = itemToGroup[itemId];
                Group curGroup = itemToGroup[i];
                if (beforeGroup != curGroup) {
                    beforeGroup.nextGroups.add(curGroup);
                    curGroup.inputCnt++;
                }
            }
        }

        Queue<Group> groupQueue = new LinkedList<>();

        for (Group ele : oriGroups) {
            if (ele.inputCnt == 0) {
                groupQueue.offer(ele);
            }
        }

        if (groupQueue.isEmpty()) {
            return new int[0];
        }

        int[] result = new int[n];
        int resultIndex = 0;
        while (!groupQueue.isEmpty()) {
            int size = groupQueue.size();
            for (int i = 0; i < size; i++) {
                Group curGroup = groupQueue.poll();
                Queue<Integer> itemQueue = new LinkedList<>();
                if (curGroup.items.isEmpty()) {
                    continue;
                }

                for (int temp : curGroup.items) {
                    if (items[temp].inputCnt == 0) {
                        itemQueue.offer(temp);
                    }
                }

                if (itemQueue.isEmpty()) {
                    return new int[0];
                }

                while (!itemQueue.isEmpty()) {
                    int itemQueueSize = itemQueue.size();
                    for (int j = 0; j < itemQueueSize; j++) {
                        Integer itemId = itemQueue.poll();
                        result[resultIndex++] = itemId;
                        for (int nextItemId : items[itemId].nextItems) {
                            items[nextItemId].inputCnt--;
                            if (items[nextItemId].inputCnt == 0 && curGroup.items.contains(nextItemId)) {
                                itemQueue.offer(nextItemId);
                            }
                        }
                    }
                }

                for (int itemId : curGroup.items) {
                    if (items[itemId].inputCnt > 0) {
                        return new int[0];
                    }
                }

                for (Group nextGroup : curGroup.nextGroups) {
                    nextGroup.inputCnt--;
                    if (nextGroup.inputCnt == 0) {
                        groupQueue.offer(nextGroup);
                    }
                }
            }
        }

        for (Group ele : oriGroups) {
            if (ele.inputCnt > 0) {
                return new int[0];
            }
        }

        for (int k = 0; k < items.length; k++) {
            if (items[k].inputCnt > 0) {
                return new int[0];
            }
        }

        return result;
    }
}

