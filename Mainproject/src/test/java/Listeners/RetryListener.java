package Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

//RetryListener is used to call retry
public class RetryListener implements IAnnotationTransformer { //transform is method in ITestAnnotation
 	@Override 
 	public void transform(final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor, 
 			final Method testMethod) { 
 		annotation.setRetryAnalyzer(retry.Retry.class); //packagename.classname
 	} 
 
}
