package com.nt.beans;

import java.util.Date;

public class Utility {

	public Date getSysDate() {
		return new Date();
	}

	public void m1() {
		System.out.println("Utility.m1():abc");
	}

	public static void main(String[] args) {
		Utility util = new Utility();

		System.out.println(util.getSysDate());
	}
}
