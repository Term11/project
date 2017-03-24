package bwf.teaching.book.web.tool;

public class Paging {
	
	private int curr = 1;
	private int prev;
	private int next;
	private int total;
	private int count;
	private int size;

	public Paging(String pageNO, int pageSize, long totalCount) {
		if(totalCount < 0 ) {
			throw new RuntimeException("【Paging异常】无法理解数量为负数！totalCount: " + totalCount);
		}
		if(pageSize < 1) {
			throw new RuntimeException("【Paging异常】无法理解每页显示条数为非正数！pageSize: " + pageSize);
		}
		
		count = (int)totalCount;
		
		size = pageSize;
		
		total = count % size == 0 ? count / size : count/size + 1;
		if(total == 0) {
			total = 1; //当没有任何一条信息，则计算出的总页数count为0，不符合习惯（我们不说第0页上没有数据）
		}
		
		// 当pageNO（请求参数）为null时，或者参数格式无效时，curr为1；否则，以转换为int类型的pageNO为curr的暂时值
		if(pageNO != null) { 
			try {
				curr = Integer.parseInt(pageNO);
			} catch(Exception ex) {	}
		}
		
		if(curr <= 0) {
			curr = 1;
		}
		
		if(curr > total) {
			curr = total;
		}
		
		prev = curr == 1 ? 1 : curr - 1;
		
		next = curr == total ? total : curr+1;
	}

	public int getCurr() {
		return curr;
	}

	public int getPrev() {
		return prev;
	}

	public int getNext() {
		return next;
	}

	public int getTotal() {
		return total;
	}

	public int getCount() {
		return count;
	}

	public int getSize() {
		return size;
	}
	
	

}
