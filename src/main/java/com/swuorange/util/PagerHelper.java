package com.swuorange.util;

import java.util.List;
//T 这个泛型 是通过在这个分页类添加一个方法获取到数据list这种方式才需要，现在没有实现，可以不实现
public class PagerHelper<T> {
	 
	
    private List<T> list; //对象记录结果集，没有使用
    private int total = 0; // 保存总记录数
    private int startrownumber = 1; //取记录的开始位置
    private int limit = 10; // 每页显示记录数
    private int pages = 1; // 保存总页数
    private int pageNumber = 1; // 当前页码
    //公司id
    private int companyinfoId;
    //请求人id
    private int requesterId;
    
    
    
    

	public int getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}
	public int getCompanyinfoId() {
		return companyinfoId;
	}
	public void setCompanyinfoId(int companyinfoId) {
		this.companyinfoId = companyinfoId;
	}
	
	private boolean isFirstPage=false;        //是否为第一页
    private boolean isLastPage=false;         //是否为最后一页
    private boolean hasPreviousPage=false;   //是否有前一页
    private boolean hasNextPage=false;       //是否有下一页
     
    private int navigatePages=8; //页码导航条显示的页码数
    private int[] navigatePageNumbers;  //保存页码的编号
     
    public PagerHelper(int total, int pageNumber) {
        init(total, pageNumber, limit);
    }
    //当  new 对象的时候会调用init 进行必要的计算 
    public PagerHelper(int total, int pageNumber, int limit) {
        init(total, pageNumber, limit);
    }
    //计算了启始记录位置，总页数 ，生成了导航条页面的数组，生成了导航条页面有没有前一页后一页等标志
    private void init(int total, int pageNumber, int limit){
        
        this.total=total;
        this.limit=limit;
        this.pageNumber = pageNumber;
        //计算了启始记录位置，总页数
        this.startrownumber = (this.pageNumber - 1) * limit;
        this.pages=(this.total-1)/this.limit+1;
         
        //设置当前页，如果当前页小于1就设为1，大于最大页面就设为最大页码，否则就不变
        if(pageNumber<1){
            this.pageNumber=1;
        }else if(pageNumber>this.pages){
            this.pageNumber=this.pages;
        }else{
            this.pageNumber=pageNumber;
        }
         
        //计算导航条页码的数组
        calcNavigatePageNumbers();
         
        //前一页下一页标志的设定
        judgePageBoudary();
    }
     

    private void calcNavigatePageNumbers(){
        //当总页数小于8时候就建一个总页数大小的数组，并初始化数组为1到总页数
        if(pages<=navigatePages){
            navigatePageNumbers=new int[pages];
            for(int i=0;i<pages;i++){
                navigatePageNumbers[i]=i+1;
            }
        //否则建一个8大小的数组，假设当前页pageNumber 是5
        // 将    startNum 设置为 pageNumber-navigatePages/2 等于 1
        // 将    endNum  设置为    pageNumber+navigatePages/2 等于9
        // 
        }else{ 
            navigatePageNumbers=new int[navigatePages];
            int startNum=pageNumber-navigatePages/2;
            int endNum=pageNumber+navigatePages/2;
            //如果startNum 小于1 就赋值为1 然后就生成1到8的数组
            if(startNum<1){
                startNum=1;
                //(最前navPageCount页
                for(int i=0;i<navigatePages;i++){
                    navigatePageNumbers[i]=startNum++;
                }
             //如果   endNum 大于总页数 endNum设置为总页数
             //将数组设置为从endnum开始递减7次后的8个元素的数组
            }else if(endNum>pages){
                endNum=pages;

                for(int i=navigatePages-1;i>=0;i--){
                    navigatePageNumbers[i]=endNum--;
                }
            //否则将数组设置为startNum 开始递增7次的8个元素的数组
            }else{
  
                for(int i=0;i<navigatePages;i++){
                    navigatePageNumbers[i]=startNum++;
                }
            }
        }
    }
 
    
    
    public String getNavigateBar(){
    	
    	String result = "<div class = ''>";
    	//如果不是第一页就加一个到第一页的链接 符号用<<
    	if (!isFirstPage)
    	{	
    		result += "["  + "<a  href ='?pageNumber=1' ><<</a>" + "]";
    	}
        //如果有前一页就加一个到前一页的链接 符号用 <  链接的参数就是当前页减一
    	if (hasPreviousPage)
    	{	
    		result +=  "["  + "<a  href ='?pageNumber=" + ( pageNumber - 1) +"' ><</a>" + "]";
    	}
    	
        for(int i=0;i<navigatePageNumbers.length;i++){
        	if (pageNumber == navigatePageNumbers[i])
        	{
                result +=  "["   + navigatePageNumbers[i]  + "]";

        	}
        	else
        	{
                result +=  "["  + "<a  href ='?pageNumber=" + (navigatePageNumbers[i] ) +"' >" + navigatePageNumbers[i] + "</a>" + "]";
        	}
        }
        
    	if (hasNextPage)
    	{	
    		result += "["  + "<a  href ='?pageNumber=" + ( pageNumber + 1) +"' >></a>" + "]";;
    	}
    	
    	if (!isLastPage)
    	{	
    		result +=  "["  + "<a  href ='?pageNumber=" + pages +"' >>></a>" + "]";
    	}        
        
        result += "</div>";
        return result;
    }    
    
    /**
     * 判定页面边界
     */
    private void judgePageBoudary(){
        isFirstPage = pageNumber == 1;
        isLastPage = pageNumber == pages && pageNumber!=1;
        hasPreviousPage = pageNumber!=1;
        hasNextPage = pageNumber!=pages;
    }
     
     
    public void setList(List<T> list) {
        this.list = list;
    }
 
    /**
     * 得到当前页的内容
     * @return {List}
     */
    public List<T> getList() {
        return list;
    }
 
    /**
     * 得到记录总数
     * @return {int}
     */
    public int getTotal() {
        return total;
    }
 
    /**
     * 得到每页显示多少条记录
     * @return {int}
     */
    public int getLimit() {
        return limit;
    }
 
    /**
     * 得到页面总数
     * @return {int}
     */
    public int getPages() {
        return pages;
    }
 
    /**
     * 得到当前页号
     * @return {int}
     */
    public int getPageNumber() {
        return pageNumber;
    }
 
 
    /**
     * 得到所有导航页号 
     * @return {int[]}
     */
    public int[] getNavigatePageNumbers() {
        return navigatePageNumbers;
    }
 
    public boolean isFirstPage() {
        return isFirstPage;
    }
 
    public boolean isLastPage() {
        return isLastPage;
    }
 
    public boolean hasPreviousPage() {
        return hasPreviousPage;
    }
 
    public boolean hasNextPage() {
        return hasNextPage;
    }
    
    
    
 
    public int getStartrownumber() {
		return startrownumber;
	}

	public void setStartrownumber(int startrownumber) {
		this.startrownumber = startrownumber;
	}

	public String toString(){
        String str=new String();
        str= "[" +
            "total="+total+
            ",pages="+pages+
            ",pageNumber="+pageNumber+
            ",limit="+limit+
            //",navigatePages="+navigatePages+
            ",isFirstPage="+isFirstPage+
            ",isLastPage="+isLastPage+
            ",hasPreviousPage="+hasPreviousPage+
            ",hasNextPage="+hasNextPage+
            ",navigatePageNumbers=";
        int len=navigatePageNumbers.length;
        if(len>0)str+=(navigatePageNumbers[0]);
        for(int i=1;i<len;i++){
            str+=(" "+navigatePageNumbers[i]);
        }
        //sb+=",list="+list;
        str+="]";
        return str;
    }
    
}