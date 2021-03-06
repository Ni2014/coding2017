package cn.cs.week2.basic;

import java.util.ArrayList;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public void reverseArray(int[] origin){
		int tmp = 0;
		for(int i=0;i<origin.length / 2;i++){
			tmp = origin[i];
			origin[i] = origin[origin.length - i - 1];
			origin[origin.length - i -1] = tmp;
		}
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	public int[] removeZero(int[] oldArray){
		ArrayList resultList = new ArrayList();
		int[] resultArray;
		for(int i=0;i<oldArray.length;i++){
			if(oldArray[i] != 0){
				resultList.add(oldArray[i]);
			}
		}
		resultArray = new int[resultList.size()];
		for(int i=0;i<resultList.size();i++){
			resultArray[i] = (int)resultList.get(i);
		}
		return resultArray;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){
		ArrayList resultList = new ArrayList();
		int[] resultArray;
		int i = 0;
		int j = 0;
		while(i<array1.length && j<array2.length){
			if(array1[i] < array2[j]){
				resultList.add(array1[i]);
				i++;
			}else if(array1[i] == array2[j]){
				resultList.add(array1[i]);
				i++;
				j++;
			}else {
				resultList.add(array2[j]);
				j++;
			}
		}
		if(i<=array1.length - 1){
			for(;i<array1.length;i++){
				resultList.add(array1[i]);
			}
		}
		if(j<=array2.length - 1){
			for(;j<array2.length;j++){
				resultList.add(array2[j]);
			}
		}
		resultArray = new int[resultList.size()];
		for(int index = 0;index <resultList.size();index++){
			resultArray[index] = (int)resultList.get(index);
		}
		return  resultArray;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		int[] result = new int[oldArray.length+size];
		for(int i=0;i<result.length;i++){
			if(i<oldArray.length)
				result[i] = oldArray[i];
			else result[i] = 0;
		}
		return result;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		if(max < 2){
			return new int[]{1,1};
		}else{
			int[] tmp = fibonacci(max - 1);
			if((tmp[tmp.length-1] + tmp[tmp.length-2] >= max)){
				return tmp;
			}
			int[] result = grow(tmp,1);
			result[result.length-1] = tmp[tmp.length - 2] + tmp[tmp.length - 1];
			return result;
		}
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public int[] getPrimes(int max){
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=2;i<max;i++){
			boolean flag = true;
			for(int j=2;j<i;j++){
				if((i % j) == 0){
					flag = false;
					break;
				}
			}
			if(flag){
				array.add(i);
			}
		}
		int[] result = new int[array.size()];
		for(int i=0;i<result.length;i++){
			result[i] = array.get(i);
		}
		return result;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=5;i<max;i++){
			ArrayList<Integer> yinzi = new ArrayList<>();
			int total = 0;
			for(int j=1;j<=(i/2);j++){
				if((i % j) == 0){
					yinzi.add(j);
				}
			}
			for(int ii=0;ii<yinzi.size();ii++){
				total += yinzi.get(ii);
			}
			if(i == total){
				array.add(i);
			}
		}
		int[] result = new int[array.size()];
		for(int i=0;i<result.length;i++){
			result[i] = array.get(i);
		}
		return result;
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param seperator
	 * @return
	 */
	public String join(int[] array, String seperator){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<array.length - 1;i++){
			sb.append(array[i] + seperator);
		}
		sb.append(array[array.length-1]);
		return sb.toString();
	}
}
