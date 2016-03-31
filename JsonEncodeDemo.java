package com.atul.json;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;


class JsonEncodeDemo {
	
	public void parse(String json,String fieldname,String value) throws JsonProcessingException, IOException  {
	       JsonFactory factory = new JsonFactory();

	       ObjectMapper mapper = new ObjectMapper(factory);
	       JsonNode rootNode = mapper.readTree(json);  

	       int count=0;
	       Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
	       while (fieldsIterator.hasNext()) {
	    	  
	           Map.Entry<String,JsonNode> field = fieldsIterator.next();
	          
	           JsonNode node=field.getValue();
	           if(node.isArray()){
	        	   for(JsonNode nd:field.getValue()){
	        		   if(nd.has(fieldname)){
		        		   if(nd.get(fieldname).asText().equals(value)){
		        			   System.out.println(nd.get(fieldname));
		        		   }
	        		   }
	        		   else{
	        			   continue;
	        		   }
	        	      	//System.out.println(nd.get("dataSalary"));
	        	   }
	           }
	       }
	     
	       
	       
	}

   public static void main(String[] args) throws IOException{
	
	   ObjectMapper mapper=new ObjectMapper();
	   List<Data> dataList=new ArrayList<>();
	   dataList.add(new Data("hello1", "1200","sapient"));
	   dataList.add(new Data("hello2", "1200","sent"));
	   dataList.add(new Data("hello3", "1200","snt"));
	   dataList.add(new Data("hello4", "1500","sernt"));
	   dataList.add(new Data("hello5", "1600","sjaient"));
	   dataList.add(new Data("hello6", "16900","111pient"));
	  
	   Employee e=new Employee("1","atul",1000,dataList);
	   
	   JsonEncodeDemo demo=new JsonEncodeDemo();
	   demo.parse(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(e),"dataSalary","1200");
	  
	   
	       
   }
}

 class Employee{
	
	String id;
	String name;
	int salary;
	List<Data> dataList;
	public Employee(String id, String name, int salary,List<Data> data) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dataList=data;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public List<Data> getDataList() {
		return dataList;
	}
	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}
	
}

class Data{
	
	String dataName;
	String dataSalary;
	String brand;
	
	
	
	public Data(String dataName, String dataSalary, String brand) {
		
		this.dataName = dataName;
		this.dataSalary = dataSalary;
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDataName() {
		return dataName;
	}
	public String getDataSalary() {
		return dataSalary;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public void setDataSalary(String dataSalary) {
		this.dataSalary = dataSalary;
	}
}

