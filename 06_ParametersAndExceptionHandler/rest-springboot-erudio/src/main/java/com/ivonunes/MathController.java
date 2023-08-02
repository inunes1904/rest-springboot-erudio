package com.ivonunes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivonunes.exceptions.UnsupportedMathOperationException;

import jakarta.websocket.server.PathParam;

@RestController
public class MathController {

	
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{n1}/{n2}", method= RequestMethod.GET)
	public Double sum(@PathVariable String n1, @PathVariable String n2) 
			throws Exception	
	{
		if(!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2) ) {
			throw new UnsupportedMathOperationException("Please set both numeric values.");
		}
		return NumberConverter.convertToDouble(n1) + NumberConverter.convertToDouble(n2);
	}
	
    @RequestMapping(value="sub/{n1}/{n2}", method=RequestMethod.GET)
    public Double sub(@PathVariable String n1, @PathVariable String n2) {
    	if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
    		throw new UnsupportedMathOperationException("Please set both numeric values.");
    	}
    	
    	return NumberConverter.convertToDouble(n1)-NumberConverter.convertToDouble(n2);
    }
	
    @RequestMapping(value="mul/{n1}/{n2}", method=RequestMethod.GET)
    public Double mul(@PathVariable String n1, @PathVariable String n2) {
    	if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
    		throw new UnsupportedMathOperationException("Please set both numeric values.");
    	}
    	
    	return NumberConverter.convertToDouble(n1)*NumberConverter.convertToDouble(n2);
    }
    
    @RequestMapping(value="div/{n1}/{n2}", method=RequestMethod.GET)
    public Double div(@PathVariable String n1, @PathVariable String n2) {
    	if(!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
    		throw new UnsupportedMathOperationException("Please set both numeric values.");
    	}else if ( Double.parseDouble(n2) == 0){
    		throw new UnsupportedMathOperationException("Division by 0 is not possible");
    	}
    	return NumberConverter.convertToDouble(n1)/NumberConverter.convertToDouble(n2);
    }
    
    
    @RequestMapping(value="avg/{n1}/{n2}")
    public Double avg(@PathVariable String n1, @PathVariable String n2) {
    	if(!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
    		throw new UnsupportedMathOperationException("Please set both numeric values.");
    	}
    	return (NumberConverter.convertToDouble(n1)+NumberConverter.convertToDouble(n2)) / 2;
    }
    
    
    @RequestMapping(value="square/{n1}")
    public Double square(@PathVariable String n1) {
    	if(!NumberConverter.isNumeric(n1)){
    		throw new UnsupportedMathOperationException("Please set both numeric values.");
    	}
    	return Math.sqrt(NumberConverter.convertToDouble(n1));
    }

	
}
