package com.cyq7on.sword2offer.array;


/**
 * @author cyq7on
 * @description 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/16
 **/
public class WordSearch {
    private int[][] visit;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        if (row * col < word.length()) {
            return false;
        }
        visit = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) {
            return true;
        }

        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1
                || visit[i][j] > 0 || board[i][j] != word.charAt(start)) {
            return false;
        }
        visit[i][j] = 1;
        start++;
        if (dfs(board, i - 1, j, word, start) || dfs(board, i + 1, j, word, start)
                || dfs(board, i, j - 1, word, start) || dfs(board, i, j + 1, word, start)) {
            return true;
        } else {
            //回溯
            visit[i][j] = 0;
            return false;
        }
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] chars = {{'a'}};
        System.out.println(wordSearch.exist(chars, "a"));
        chars = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(wordSearch.exist(chars, "ABCCED"));
        System.out.println(wordSearch.exist(chars, "SEE"));
        System.out.println(wordSearch.exist(chars, "ABCB"));
    }
}
