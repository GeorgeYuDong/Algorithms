/**
 * 
 */
package com.ucas.algorithms.sort;

import java.util.Collections;

import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

import com.ucas.algorithms.sort.utils.ArrayPrint;
import com.ucas.algorithms.sort.utils.IntegerArrayGenerator;
import com.ucas.algorithms.sort.utils.TimeElapse;

/**
 * @author wjg
 * @version 0.0.1
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] arr = IntegerArrayGenerator.fixedArray();
		int[] arr = IntegerArrayGenerator.randomArray(10000, 10000);
		ArrayPrint.print(arr);
		
		MergeSort sort = new MergeSort();
		TimeElapse timeElapse = new TimeElapse();
		timeElapse.start();
		
		sort.mergeSort(arr);
		timeElapse.stop();
		timeElapse.showElapsedTime();
		
		ArrayPrint.print(arr);
	}
	
	/**
	 * �鲢�����������Ա�����arr�����С�
	 * @param arr ��Ҫ���������
	 */
	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	/**
	 * �鲢��������arr������[p..r]�������飬�������Ա�����arr�����С�
	 * @param arr ��Ҫ���������
	 * @param p �������������ʼ�±�
	 * @param r �������������ֹ�±�
	 */
	public void mergeSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}

	/**
	 * �鲢����������������С�
	 * @param arr ���鲢������
	 * @param p ��һ�������е���ʼ�±�
	 * @param q ��һ�������еĽ����±�
	 * @param r �ڶ��������еĽ����±�
	 */
	public void merge(int[] arr, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] arrL = new int[n1 + 1];
		int[] arrR = new int[n2 + 1];
		for (int i=0; i<n1; i++) {
			arrL[i] = arr[p + i];
		}
		for (int i=0; i<n2; i++) {
			arrR[i] = arr[q + 1 + i];
		}
		arrL[n1] = Integer.MAX_VALUE;
		arrR[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (arrL[i] <= arrR[j]) {
				arr[k] = arrL[i];
				i++;
			}
			else {
				arr[k] = arrR[j];
				j++;
			}
		}
	}

}
