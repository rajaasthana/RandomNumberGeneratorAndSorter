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
	private String unsortedNumber;

	/**
	 * Holds comma separated sorted number
	 */
	private String sortedNumber;

	/**
	 * Holds the position changed count to sort the random numbers
	 */
	private int noOfPositionChanged;

	/**
	 * Holds the time taken to sort the random numbers in milliseconds
	 */
	private long sortTime;

	/**
	 * @return the unsortedNumber
	 */
	public String getUnsortedNumber() {
		return unsortedNumber;
	}

	/**
	 * @param unsortedNumber
	 *            the unsortedNumber to set
	 */
	public void setUnsortedNumber(String unsortedNumber) {
		this.unsortedNumber = unsortedNumber;
	}

	/**
	 * @return the sortedNumber
	 */
	public String getSortedNumber() {
		return sortedNumber;
	}

	/**
	 * @param sortedNumber
	 *            the sortedNumber to set
	 */
	public void setSortedNumber(String sortedNumber) {
		this.sortedNumber = sortedNumber;
	}

	/**
	 * @return the noOfPositionChanged
	 */
	public int getNoOfPositionChanged() {
		return noOfPositionChanged;
	}

	/**
	 * @param noOfPositionChanged
	 *            the noOfPositionChanged to set
	 */
	public void setNoOfPositionChanged(int noOfPositionChanged) {
		this.noOfPositionChanged = noOfPositionChanged;
	}

	/**
	 * @return the sortTime
	 */
	public long getSortTime() {
		return sortTime;
	}

	/**
	 * @param sortTime
	 *            the sortTime to set
	 */
	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}
}
