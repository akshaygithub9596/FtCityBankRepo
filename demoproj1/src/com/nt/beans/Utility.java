package com.nt.beans;

import java.util.Date;

public class Utility {

	public Date getSysDate() {
		return new Date();
	}

	public void m1() {
		System.out.println("Utility.m1():abc");
		System.out.println("Utility.m1()");
		System.out.println("Utility.m1()");
	}

	public void m4() {
		System.out.println("Utility.m4()");
	}

	public void m2() {
		System.out.println("Utility.m2()");

	}

	public void m3() {
		System.out.println("Utility.m3()");

	}

	public static void main(String[] args) {
		Utility util = new Utility();

		System.out.println(util.getSysDate());
	}
}