package com.zyc.floyd;

import java.util.Scanner;

public class JuZhen {
	private Integer max;
	private Integer[][] t;
	private Integer bianshu;

	public JuZhen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JuZhen(Integer max, Integer bianshu) {
		this.max = max;
		this.bianshu=bianshu;
		System.out.println("生成" + max + "*" + max + "邻接矩阵");
		System.out.println("含有"+bianshu+"条边");
		t = new Integer[max][max];
	}

	public void init() {
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<max;i++){
			for(int j=0;j<max;j++){
				if(i==j){
					t[i][j]=0;
				}else{
					t[i][j]=999999999;
				}
			}
		}
		System.out.println("空邻接矩阵初始化完成，读入数据");
		this.show();
		for(int a=0;a<bianshu;a++){
			int i = scanner.nextInt()-1;
			int j = scanner.nextInt()-1;
			int value = scanner.nextInt();
			t[i][j] = value;
			t[j][i] =value; 
		}
		scanner.close();
		System.out.println("邻接矩阵初始化完成");
		this.show();
	}

	public void show() {
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (t[i][j] < 999999999) {
					System.out.print(t[i][j] + "\t");
				} else {
					System.out.print("∞" + "\t");
				}
			}
			System.out.println();
		}
	}

	public void Floyd() {
		for (int a = 0; a < max; a++) {
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < max; j++) {
					if (t[i][j] > (t[i][a] + t[a][j])) {
						t[i][j] = t[i][a] + t[a][j];
					}
				}
			}
			System.out.println("经过点"+a+"矩阵更新完成");
			this.show();
		}
	}
}
