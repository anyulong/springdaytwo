package com.example.service;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class MathService {
	
	public Stream<Long> factorialStream() {
		return Stream.generate(new Supplier<Long>() {
			private long f = 1;
			private long n = 1;
			@Override
			public Long get() {
				f *= n;
				n++;
				return f;
			}});
		
		}
	public Stream<Long>  febonaci(){
		
		return Stream.generate(new Supplier<Long>() {
			private long f = 1;
			private long before1 = 0;
			private long before2 = 0;
			private long before3 = 0;
			@Override
			public Long get() {	
				before3 = before2;
				before2=before1;
				before1=f;
				f=before1+before2+before3;								
				return f;
			}});
	}

}