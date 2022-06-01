package com.sdet34L1.genericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

//IAnnotationTransformer : - It is a TestNG listener which allows to override or modify the default
//behaviour of TestNG annotation at runtime.

public class RetryAnalyserListenerimplementation implements IAnnotationTransformer {
	
	

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.sdet34L1.genericUtility.RetryAnalyserImplementation.class);
		
		
		
		
	}
}

