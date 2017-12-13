package cn.yzl.mvvmdemo.http.been;

import java.util.ArrayList;
import java.util.List;

import cn.yzl.library.util.EmptyUtil;

/**
 * 双层List返回
 * Created by YZL on 2017/11/24.
 */
public class DoubleListHttpResponseWrapper<T> extends BaseHttpBean {
    private List<ListHttpResponseWrapper<T>> datas;
    
    @Override
    public boolean isDataSucess() {
        return EmptyUtil.isNoEmpty(datas) && datas.get(0).isDataSucess();
    }

    public List<T> getWrapperData() {
        if (isDataSucess()) {
            return datas.get(0).getWapperData();
        } else {
            return new ArrayList<T>();
        }
    }

    public void setDatas(List<ListHttpResponseWrapper<T>> datas) {
        this.datas = datas;
    }

    public boolean isDataNotNull() {
        return EmptyUtil.isNoEmpty(datas) && datas.get(0) != null;
    }
}
