package com.example.MovieRating;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumDepth {
	
	public static void main(String args[]) {
		
	
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(5);
		numList.add(10);
		numList.add(90);
		numList.add(100);
		
		int size=numList.size();
		
		int maxDiff= maxDifferenceJava8(numList,size);
		
		System.out.println("----Max Depth---"+maxDiff);
	}

	
	public static int maxDifference(Integer[] numLists, Integer length) {

		int diffVal = 0;
		int diff = 0;

		for (int i = 0; i < length; i++) {

			for (int j = 0; j < length && i != j; j++) {

				diff = numLists[i] - numLists[j];
				if (diff > diffVal) {
					diffVal = diff;
				}

			}
		}

		return diffVal;

	}

	public static int maxDifferenceJava8(List<Integer> numList, Integer length) {

		

		Set<Integer> diffList = new HashSet<Integer>();

		numList.stream().forEach(n -> numList.stream().map(x -> n - x).forEach(y -> diffList.add(y)));
		IntSummaryStatistics diffSummary = diffList.stream().collect(Collectors.summarizingInt(n -> n));

		return diffSummary.getMax();

	}
}
