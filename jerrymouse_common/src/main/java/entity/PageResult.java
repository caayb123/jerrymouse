package entity;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
     private Long total;
     private List<T> data;

    public PageResult(Long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
