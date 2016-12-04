package leetcode;

public class MSpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int dir = 0;//1: left to right; 2: up to down; 3: right to left; 4: down to up
        int num = 1, x = 0, y = 0;
        while(num <= n*n){
        	System.out.println(num);
            result[x][y] = num;
            num++;
            dir = newDir(x, y, result, dir);
            x = newX(dir, x, result);
            y = newY(dir, y, result);
        }
        return result;
    }
    
    public static void main(String[] args){
    	MSpiralMatrixII m = new MSpiralMatrixII();
    	int[][] result = m.generateMatrix(6);
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			System.out.print(result[i][j]+",");
    		}
    		System.out.println();
    	}
    }
    
    private int newDir(int x, int y, int[][] result, int dir){
        switch(dir){
        case 0:
        	y++;
        	break;
        case 1:
        	x++;
        	break;
        case 2:
        	y--;
        	break;
        case 3:
        	x--;
        	break;
        }
        if(x < 0 || y < 0 || x >= result.length || y >= result.length || result[x][y] > 0) dir = (dir + 1) % 4;
        return dir;
    }
    
    private int newX(int dir, int x, int[][] result){
        switch(dir){
        case 1:
        	x++;
        	break;
        case 3:
        	x--;
        	break;
        default:
        	break;
        }
        return x;
    }
    
    private int newY(int dir, int y, int[][] result){
        switch(dir){
        case 0:
        	y++;
        	break;
        case 2:
        	y--;
        	break;
        default:
        	break;
        }
        return y;
    }
}
