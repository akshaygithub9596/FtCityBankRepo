package com.nt.beans;

import java.util.Date;

public class Utility {

	public Date getSysDate() {
		return new Date();
	}

	public static void main(String[] args) {
		Utility util = new Utility();
		
		System.out.println(util.getSysDate());
	}
}
