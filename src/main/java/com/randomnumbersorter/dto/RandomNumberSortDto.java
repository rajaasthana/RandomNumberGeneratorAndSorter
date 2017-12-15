package com.randomnumbersorter.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RandomNumberData")
public class RandomNumberSortDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String unsortedNumbers;

	@Column
	private String sortedNumbers;

	@Column
	private int noOfPositionsChanged;

	@Column
	private long sortTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
