package com.zyc.dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import sun.applet.Main;

public class Dijkstra {
	private Integer juzhen[][];// 邻接矩阵
	private static final Integer max = Integer.MAX_VALUE;// 无法到达权值
	private Integer nEdgnum;// 路径数量
	private Integer numVexs;// 顶点数量
	private Set<Integer> vexs;
	private List<Integer> old;//是否极端过顶点的集合
	private List<Integer> value;//顶点到剩余点之间权值的集合
	private List<Integer> result;
	private Integer dingdian;

	public Dijkstra(Integer nEdgnum, Integer numVexs, Integer dingdian) {
		Scanner reader = new Scanner(System.in);
		this.nEdgnum = nEdgnum;
		this.numVexs = numVexs;
		this.juzhen = new Integer[this.numVexs][this.numVexs];
		old = new ArrayList<Integer>(numVexs);
		value = new ArrayList<Integer>(numVexs);
		result = new ArrayList<Integer>(numVexs);
		vexs = new HashSet<Integer>();
		for (int i = 0; i < numVexs; i++) {
			for (int j = 0; j < numVexs; j++) {
				if (i == j) {
					juzhen[i][j] = 0;
				}
				juzhen[j][i] = max;
				juzhen[i][j] = max;
			}
		}
		System.out.println("输入值");
		for (int i = 0; i < nEdgnum; i++) {
			int x = reader.nextInt();
			vexs.add(x);
			int y = reader.nextInt();
			vexs.add(y);
			int value = reader.nextInt();
			juzhen[x - 1][y - 1] = value;
			juzhen[y - 1][x - 1] = value;
		}
		reader.close();
		for (int i = 0; i < numVexs; i++) {
			old.add(i, 0);
			result.add(i, 0);
			value.add(i, juzhen[i][dingdian]);
		}
		//初始化顶点所在权值以及是否计算过
		old.set(dingdian, 0);
		value.set(dingdian, 0);
		this.dingdian = dingdian;
		System.out.println("初始化完成");
	}

	public void show() {
		for (int i = 0; i < numVexs; i++) {
			for (int j = 0; j < numVexs; j++) {
				if (juzhen[i][j] == max) {
					System.out.print("∞\t");
				} else {
					System.out.print(juzhen[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}

	public void getShort() {
		int k = 0;// 最短顶点
		for (int i = 1; i < numVexs; i++) {
			Integer min = max;
			for (int w = 0; w < numVexs; w++) {
				if (old.get(w) == 0 && value.get(w) < min) {
					min = value.get(w);
					k = w;
				}
			}
			old.add(k, 1);

			for (int j = 0; j < numVexs; j++) {
				Integer temp = juzhen[k][j] == max ? max : (min + juzhen[k][j]);
				if (old.get(j) == 0 && (temp < value.get(j))) {
					value.set(j, temp);
					result.set(j, k);
				}
			}
		}
		System.out.printf("顶点%d的最短路径\n", this.dingdian);
		for (int i = 0; i < numVexs; i++) {
			System.out.println("顶点" + this.dingdian + "到顶点" + i + "的权值为" + value.get(i));
		}
	}
}
