package com.shiro.common.dto;

import java.io.Serializable;
import java.util.jar.Attributes;

/**
 * Created by HuaYu on 2018/2/18.
 */
public class EasyUITreeResponse implements Serializable {
    /*id：节点ID，对加载远程数据很重要。
    text：显示节点文本。
    state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。*/

    private Long id;
    private String text;
    private String state;
    private EasyUITreeResponse[] children;
    private String iconCls;
    //private String attributes;
    private Attributes attributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        //当sql映射到对象的时候，改一下数据
        if(state.equals("0")){
            this.state="open";
        }else if(state.equals("1")){
            this.state="closed";
        }else{
            this.state=state;
        }
    }

    public EasyUITreeResponse[] getChildren() {
        return children;
    }

    public void setChildren(EasyUITreeResponse[] children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
