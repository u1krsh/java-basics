package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazePrblm1 {
    public static void main(String[] args) {
//        System.out.println(count(3,3));
//        pathFind("",3,3);
//        System.out.println(pathFindArr("",3,3));
//        System.out.println(pathFindArrDiag("",3,3));
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}

        };
        int[][] path = new int[board.length][board[0].length];
        pathObsFind("",board,0,0);
        pathFindPrint("", board, 0,0, path,1);
    }


    static int count(int r, int c) {
        if (r == 1 || c == 1) return 1;

        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return right + left;
    }


    static void pathFind(String pro, int r, int c){
        if(r==1 && c == 1){
            System.out.println(pro);
            return;
        }

        if(r>1){
            pathFind(pro +'D',r-1,c);
        }

        if(c>1){
            pathFind(pro+'R', r, c-1);
        }
    }


    static List<String> pathFindArr(String pro, int r, int c){
        if(r==1 && c ==1){
            List<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        List<String> list = new ArrayList<>();
        if(r > 1){
            list.addAll(pathFindArr(pro + 'D', r-1,c));
        }
        if(c>1) {
            list.addAll(pathFindArr(pro+'R',r,c-1));
        }
        return list;
    }



    static List<String> pathFindArrDiag(String pro, int r, int c){
        if(r==1 && c ==1){
            List<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        List<String> list = new ArrayList<>();
        if(r > 1 && c > 1){
            list.addAll(pathFindArrDiag(pro + 'D', r-1,c-1));
        }
        if(r > 1){
            list.addAll(pathFindArrDiag(pro + 'V', r-1,c));
        }
        if(c>1) {
            list.addAll(pathFindArrDiag(pro+'H',r,c-1));
        }
        return list;
    }


    static void pathObsFind(String pro, boolean[][] maze, int r, int c){
        if(r==maze.length -1 && c == maze[0].length-1){
            System.out.println(pro);
            return;
        }

        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        if(r < maze.length -1){
            pathObsFind(pro +'D', maze,r+1,c);
        }

        if(c < maze[0].length -1){
            pathObsFind(pro+'R', maze, r, c+1);
        }

        if (r > 0) {
            pathObsFind(pro + 'U', maze, r - 1, c);
        }
        if (c > 0) {
            pathObsFind(pro + 'L', maze, r, c - 1);
        }
        maze[r][c] = true;
    }


    static void pathFindPrint(String pro, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r==maze.length -1 && c == maze[0].length-1){
            path[r][c] = step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(pro);
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if(r < maze.length -1){
            pathFindPrint(pro +'D', maze,r+1,c,path,step+1);
        }

        if(c < maze[0].length -1){
            pathFindPrint(pro+'R', maze, r, c+1,path,step+1);
        }

        if (r > 0) {
            pathFindPrint(pro + 'U', maze, r - 1, c,path,step+1);
        }
        if (c > 0) {
            pathFindPrint(pro + 'L', maze, r, c - 1,path,step+1);
        }
        maze[r][c] = true;
        path[r][c]  = 0;
    }

}
