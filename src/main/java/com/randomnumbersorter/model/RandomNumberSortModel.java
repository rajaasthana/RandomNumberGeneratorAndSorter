package com.randomnumbersorter.model;

/**
 * Model class to bind the data to view/controller
 * 
 * @author Raja Asthana
 * @since Dec-2017
 */
public class RandomNumberSortModel {

	/**
	 * Holds comma separated unsorted number
	 */
	private String unsortedNumbers;

	/**
	 * Holds comma separated sorted number
	 */
	private String sortedNumbers;

	/**
	 * Holds the position changed count to sort the random numbers
	 */
	private int noOfPositionsChanged;

	/**
	 * Holds the time taken to sort the random numbers in milliseconds
	 */
	private long sortTime;

	/**
	 * @return the unsortedNumbers
	 */
	public String getUnsortedNumbers() {
		return unsortedNumbers;
	}

	/**
	 * @param unsortedNumbers the unsortedNumbers to set
	 */
	public void setUnsortedNumbers(String unsortedNumbers) {
		this.unsortedNumbers = unsortedNumbers;
	}

	/**
	 * @return the sortedNumbers
	 */
	public String getSortedNumbers() {
		return sortedNumbers;
	}

	/**
	 * @param sortedNumbers the sortedNumbers to set
	 */
	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

	/**
	 * @return the noOfPositionsChanged
	 */
	public int getNoOfPositionsChanged() {
		return noOfPositionsChanged;
	}

	/**
	 * @param noOfPositionsChanged the noOfPositionsChanged to set
	 */
	public void setNoOfPositionsChanged(int noOfPositionsChanged) {
		this.noOfPositionsChanged = noOfPositionsChanged;
	}

	/**
	 * @return the sortTime
	 */
	public long getSortTime() {
		return sortTime;
	}

	/**
	 * @param sortTime the sortTime to set
	 */
	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}

}
