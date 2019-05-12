/*
	Transform pseudo-code to Java code for merging two sorted lists
	*/

import java.util.ArrayList;

public class Merger  {

	public static ArrayList<String> sortedA;
	public static ArrayList<String> sortedB;
	public static ArrayList<String> unsorted;

	public static void main(String[] args) {
		//sortedA = new ArrayList<String>();
		//sortedB = new ArrayList<String>();
		unsorted = new ArrayList<String>();

		//sortedA.add("A");
		//sortedA.add("C");
		//sortedA.add("D");
		//sortedA.add("D");
		//sortedA.add("Z");

		//sortedB.add("B");
		//sortedB.add("D");

		//System.out.println(sortedA);
		//System.out.println(sortedB);

		//System.out.println("Merging...");
		//System.out.println(merge(sortedA, sortedB));

		unsorted.add("B");
		unsorted.add("A");
		unsorted.add("Z");
		unsorted.add("F");
		unsorted.add("B");
		unsorted.add("L");

		System.out.println(mergeSort(unsorted));
	}

	public static ArrayList<String> merge (ArrayList<String> listA, ArrayList<String> listB) {
		ArrayList<String> merged = new ArrayList<String>();
		while (listA.size() != 0 || listB.size() != 0 ) {
			if (listA.size() != 0 && listB.size() != 0) {
				if ((listA.get(0)).compareTo(listB.get(0)) < 0){
					merged.add(listA.get(0));
					listA.remove(0);
				} else {
					merged.add(listB.get(0));
					listB.remove(0);
				}
			} else if (listA.size() != 0 && listB.size() == 0) {
				while (listA.size() != 0) {
					merged.add(listA.get(0));
					listA.remove(0);
				}
			} else if (listA.size() == 0 && listB.size() != 0) {
				while (listB.size() != 0) {
					merged.add(listB.get(0));
					listB.remove(0);
				}
			}
		}
		return merged;
	}

	public static ArrayList<String> mergeSort (ArrayList<String> arbitraryList) {
		ArrayList<String> returnList = arbitraryList;
		if (arbitraryList.size() <= 1) {
			return returnList;
		} else {
			int halfIndex = arbitraryList.size() / 2;
			returnList = merge(mergeSort(listRange(arbitraryList, 0, halfIndex)), 
							   mergeSort(listRange(arbitraryList, halfIndex, arbitraryList.size())));
			return returnList;
		}
	}

	public static ArrayList<String> listRange (ArrayList<String> toBeRanged, int start, int end) {
		ArrayList<String> returnList = new ArrayList<String>();
		for (int i = start; i < end; i++) {
			returnList.add(toBeRanged.get(i));
		}
		return returnList;
	}
}