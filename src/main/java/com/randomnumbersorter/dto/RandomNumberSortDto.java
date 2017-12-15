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
	private String unsortedNumber;

	@Column
	private String sortedNumber;

	@Column
	private int noOfPositionChanged;

	@Column
	private long sortTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnsortedNumber() {
		return unsortedNumber;
	}

	public void setUnsortedNumber(String unsortedNumber) {
		this.unsortedNumber = unsortedNumber;
	}

	public String getSortedNumber() {
		return sortedNumber;
	}

	public void setSortedNumber(String sortedNumber) {
		this.sortedNumber = sortedNumber;
	}

	public int getNoOfPositionChanged() {
		return noOfPositionChanged;
	}

	public void setNoOfPositionChanged(int noOfPositionChanged) {
		this.noOfPositionChanged = noOfPositionChanged;
	}

	public long getSortTime() {
		return sortTime;
	}

	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}

}
