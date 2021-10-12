package com.floydweb.demo;

import junit.framework.TestCase;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;



public class Base32hTest extends TestCase{
	private ArrayList<String> list;

	
	@Before
	public void setUp(){
		list = new ArrayList<String>();
	}
	
	@Test
	public void encodeTest() {
		list = new ArrayList<String>();

		list.add(0,"H");
		list.add(1,"0");
		list.add(2,"W");
		list.add(3,"D");
		list.add(4,"Y");

		assertEquals(Base32h.encode(17854910),list);
	}
	
	@Test
	public void decodeTest() {
		assertEquals(Base32h.decode("88pzd"), 8675309);
	}
	

}
