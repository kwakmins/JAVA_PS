import java.util.*;

class Solution {

  public int[][] solution(int[][] arr) {
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      List<Integer> li = new ArrayList<>();
      for (int j = 0; j < arr[0].length; j++) {
        li.add(arr[i][j]);
      }
      list.add(li);
    }
    int sub = arr.length - arr[0].length;
    if (sub > 0) {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < sub; j++) {
          list.get(i).add(0);
        }
      }
    } else {
      for (int i = 0; i < Math.abs(sub); i++) {
        List<Integer> li = new ArrayList<>();
        for (int j = 0; j < arr[0].length; j++) {
          li.add(0);
        }
        list.add(li);
      }
    }
    int rows = list.size();
    int[][] result = new int[rows][];

    for (int i = 0; i < rows; i++) {
      List<Integer> innerList = list.get(i);
      int cols = innerList.size();
      result[i] = new int[cols];

      for (int j = 0; j < cols; j++) {
        result[i][j] = innerList.get(j);
      }
    }

    return result;
  }
}

class Solution2 {

  public int[][] solution(int[][] arr) {
    int max = Math.max(arr.length, arr[0].length);
    int[][] array = new int[max][max];

    for (int i = 0; i < arr.length; i++) {
      System.arraycopy(arr[i], 0, array[i], 0, arr[0].length);
    }
    return array;
  }
}
