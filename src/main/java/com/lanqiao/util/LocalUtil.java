package com.lanqiao.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class LocalUtil {
	 private  final  String LOCAL_LIST_PATH=this.getClass().getClassLoader().getResource("LocList.xml").getPath();
      
	 
	    //所有国家地区名称List
	    private static final List<String> COUNTRY_REGION = new ArrayList<String>();
	    //本类是地址
	    private static LocalUtil  localutil;
	    private SAXReader reader;
	    private Document document;
	    private Element rootElement;
		//初始化
	    private LocalUtil(){
	        //1.读取
	        reader = new SAXReader();
	        try {
	            document = reader.read(LOCAL_LIST_PATH);
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }
	        //2.获得根元素
	        rootElement =  document.getRootElement();
	        //3.初始化所有国家名称列表
	        Iterator it =  rootElement.elementIterator();
	        Element ele = null;
	        while(it.hasNext()){
	            ele = (Element)it.next();
	            COUNTRY_REGION.add(ele.attributeValue("Name"));
	        }
	 
	 
	 
	    }
	 
	 
	    //01获取所有国家名称
	    public List<String> getCOUNTRY_REGIONs(){
	        List<String> list = new ArrayList<>();
	        //1.读取
	        reader = new SAXReader();
	        //2.获得根元素
	        rootElement =  document.getRootElement();
	        //3.初始化所有国家名称列表
	        Iterator it =  rootElement.elementIterator();
	        Element ele = null;
	        while (it.hasNext()){
	            ele = (Element)it.next();
	            list.add(ele.attributeValue("Name"));
	        }
	       return list;
	    }
	 
	 
	 
	    public List<String> getCountry(){
	        return COUNTRY_REGION;
	    }
	    /**
	     *
	     * @author		LiuJinan
	     * @TODO		功能：	根据国家名获取该国所有省份
	     * @time		2016-8-26 上午9:07:21
	     * @param countryName	国家名，从getCountry()从取出
	     * @return		List<Element>
	     */
	    private List<Element> getprovinces(String countryName){
	        Iterator it =  rootElement.elementIterator();
	        List<Element> provinces = new ArrayList<Element>();
	 
	        Element ele = null;
	        while(it.hasNext()){
	            ele = (Element)it.next();
	 
	            if(ele.attributeValue("Name").equals(countryName)){
	                provinces = ele.elements();
	                break;
	            }
	        }
	        return provinces;
	    }
	      //01
	    public List<Element> provinces(String countryName){
	        Iterator it =  rootElement.elementIterator();
	        List<Element> provinces = new ArrayList<Element>();
	        Element ele = null;
	        while(it.hasNext()){
	            ele = (Element)it.next();
	            COUNTRY_REGION.add(ele.attributeValue("Name"));
	            if(ele.attributeValue("Name").equals(countryName)){
	                provinces = ele.elements();
	                break;
	            }
	        }
	        return provinces;
	    }
	 
	    /**
	     *
	     * @author		LiuJinan
	     * @TODO		功能：	根据国家名获取该国所有省份
	     * @time		2016-8-26 上午9:07:21
	     * @param countryName	国家名，从getCountry()从取出
	     * @return		List<String>
	     */
	    //02获取国家内的省份有哪些
	    public List<String> getProvinces(String countryName){
	        List<Element> tmp = this.provinces(countryName);
	        List<String> list = new ArrayList<String>();
	        for(int i=0; i<tmp.size(); i++){
	            list.add(tmp.get(i).attributeValue("Name"));
	        }
	        return list;
	    }
	 
	    /**
	     *
	     * @author		LiuJinan
	     * @TODO		功能：根据国家名和省份名，获取该省城市名列表
	     * @time		2016-8-26 上午9:15:24
	     * @param
	     * @param provinceName
	     * @return
	     */
	    private List<Element> cities(String countryName, String provinceName){
	        List<Element> provinces =  this.provinces(countryName);
	        List<Element> cities = new ArrayList<Element>();
	        if(provinces==null || provinces.size()==0){		//没有这个城市
	            return cities;
	        }
	        for(int i=0; i<provinces.size(); i++){
	            if(provinces.get(i).attributeValue("Name").equals(provinceName)){
	                cities = provinces.get(i).elements();
	                break;
	            }
	        }
	        return cities;
	    }
	    //获取对应省份的所有市区
	    public List<Element> citie(String provinceName ){
	        //所有的省
	        List<Element> provinces =    this.provinces("中国");
	        List<Element> cities = new ArrayList<Element>();
	        if(provinces==null || provinces.size()==0){		//没有这个城市
	 
	        }
	        for (int i = 0;i<provinces.size();i++){
	 
	            if(provinces.get(i).attributeValue("Name").equals(provinceName)){
	                //这里是所有的省
	                cities = provinces.get(i).elements();
	                break;
	            }
	        }
	            return cities;
	    }
	     //获取对应市区的所有市
	    public List<Element> xian(String citie,String ar){
	        //获取到市名称
	        List<Element>  cit  =this.citie(citie);
	        List<Element> xian = new ArrayList<Element>();
	        if(cit ==null ||cit.size() ==0){
	            //没有这个城市
	        }
	        for (int i =0;i<cit.size();i++){
	            if(cit.get(i).attributeValue("Name").equals(ar))
	           xian =cit.get(i).elements();
	        }
	        return  xian;
	    }
	 
	 
	 
	 
	    //县
	 
	    public List<String> getxian(String xian,String ar){
	        List<Element> tmp = this.xian( xian, ar);
	        List<String> xianming = new ArrayList<String>();
	        for(int i=0; i<tmp.size(); i++){
	            xianming.add(tmp.get(i).attributeValue("Name"));
	        }
	        return xianming;
	    }
	 
	 
	    //市
	     public List<String> getCitie(String provinceName){
	        List<Element> tmp =  this.citie(provinceName);
	        List<String> cities = new ArrayList<String>();
	        for(int i=0; i<tmp.size(); i++){
	            cities.add(tmp.get(i).attributeValue("Name"));
	        }
	        return cities;
	    }
	 
	 
	 
	    /**
	     *
	     * @author		LiuJinan
	     * @TODO		功能：根据国家名和省份名获取城市列表
	     * @time		2016-8-26 下午4:55:55
	     * @param countryName
	     * @param provinceName
	     * @return		List<String>
	     */
	    public List<String> getCities(String countryName, String provinceName){
	        List<Element> tmp =  this.cities(countryName, provinceName);
	        List<String> cities = new ArrayList<String>();
	        for(int i=0; i<tmp.size(); i++){
	            cities.add(tmp.get(i).attributeValue("Name"));
	        }
	        return cities;
	    }
	 
	 
	 
	 
	 
	 
	    public static LocalUtil getInstance(){
	        if(localutil==null){
	            localutil = new LocalUtil();
	        }
	        return localutil;
	    }
}
