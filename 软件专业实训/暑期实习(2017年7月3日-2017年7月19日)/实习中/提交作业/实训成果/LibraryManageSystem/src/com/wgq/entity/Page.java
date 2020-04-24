package com.wgq.entity;

public class Page {
	
	private int offset;//查询起始位置：0[无限制]
	private int limit;//偏移量：0[无限制]
	private int count;//总条数
	private String search;//搜索
	private String sortOrder;//排序方式
	
	public Page(){}
	
	public Page(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return "Page [offset=" + offset + ", limit=" + limit + ", count=" + count + ", search=" + search
				+ ", sortOrder=" + sortOrder + "]";
	}

}
