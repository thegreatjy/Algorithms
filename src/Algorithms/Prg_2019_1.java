package Algorithms;

import java.util.Stack;

public class Prg_2019_1 {

	public static int solution(int[][] board, int[]moves) {
		int answer=0;
		//바구니
		Stack<Integer> stk=new Stack<>();
		
		//board에서 처음 인형이 있는 칸(맨 윗칸)을 기억한다. exist 배열에 저장
		int[] exist= new int[board.length];
		for(int i=0;i<board.length;i++) {//board의 c
			exist[i]=-1;	//exist 배열을 -1로 초기화
			for(int j=0;j<board.length;j++) {//board의 r
				if(board[j][i]==0) {//board i열을 위에서 아래까지 탐색
					continue;		//인형이 없으면(0) 계속 탐색
				}else {				//인형이 있으면 위치(높이)를 저장하고 끝
					exist[i]=j;
					break;
				}
			}
		}
		
		//moves만큼 인형을 뽑는다.
		for(int i=0;i<moves.length;i++) {
			int c=moves[i]-1;
			int r=exist[c];
			int pick=-1;
			int prev=-1;
			//해당 열의 board에 인형이 있을 경우에만 인형을 뽑아 바구니에 넣는다.
			if(r>=0 && r<=board.length-1) {
				pick=board[r][c];
				if(!stk.isEmpty() && stk.peek()==pick) {//중복 인형일 경우
					stk.pop();
					answer=answer+2;
				}else {
					stk.push(pick);
				}
				board[r][c]=0;
				exist[c]=exist[c]+1;
			}
		}
		return answer;
		
	}
	
	public static void main(String[] args) {
		int [][] board={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int [] moves={1,5,3,5,1,2,1,4};
		int result=solution(board, moves);
		System.out.println(result);
	}

}
