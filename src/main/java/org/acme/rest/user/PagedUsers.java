package org.acme.rest.user;

public class PagedUsers {

  private Long page;
  private Long per_page;
  private Long total;
  private Long total_pages;
  private User[] data;

  public Long getPage() {
    return this.page;
  }

  public void setPage(Long page) {
    this.page = page;
  }

  public Long getPer_page() {
    return this.per_page;
  }

  public void setPer_page(Long per_page) {
    this.per_page = per_page;
  }

  public Long getTotal() {
    return this.total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public Long getTotal_pages() {
    return this.total_pages;
  }

  public void setTotal_pages(Long total_pages) {
    this.total_pages = total_pages;
  }

  public User[] getData() {
    return this.data;
  }

  public void setData(User[] data) {
    this.data = data;
  }

}
