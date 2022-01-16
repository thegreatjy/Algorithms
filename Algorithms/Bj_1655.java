package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Bj_1655 {
	//���޹��� �迭 �߿��� ��� �ε����� ����
	public static int sub(short[] arr, int last) {
		//���޹��� �迭�� �����Ѵ�.
		Arrays.sort(arr,0,last+1);
		int result=0;
		//�迭�� ���� ������ ¦�����̸�
		if((last+1)%2==0) {
			result=(last+1)/2-1;
		}else {//���� ������ Ȧ�����̸�
			result=(last+1)/2;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//�־����� ������ ����
		int n=scan.nextInt();
		
		short[] arr= new short[n];
		//arr�� n���� ���ڸ� �Է¹���
		//�Է¹��� �� ����, �߰� ���� ����Ʈ
		for(int i=0;i<n;i++) {
			arr[i]=scan.nextShort();
			System.out.println(arr[sub(arr, i)]);
		}
	}

}
