/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-24 下午8:51:29
 * TODO //
 */
package com.topspace.core.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topspace.core.utils.BeanUtil;


public class Message implements Serializable{


    private static final long serialVersionUID = 1L;

    private String senderId;
    private String toAddress;
    private String formUser;
    private List<String> accountIds = new ArrayList<String>();
    private Map values = new HashMap();

    public Message(String senderId) {
        this.senderId = senderId;
    }

    public Message(String senderId, String toAddress) {
        this.senderId = senderId;
        this.toAddress = toAddress;
    }

    public Message(String senderId, String toAddress, Object objectValue) {
        this.senderId = senderId;
        this.toAddress = toAddress;
        addObjectValue(objectValue);
    }

    public Message() {
    }

    public final String getSenderId() {
        return senderId;
    }

    public final void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public final Map getValue() {
        return values;
    }

    @SuppressWarnings("unchecked")
    public final void addObjectValue(Object object) {
        Map map = BeanUtil.bean2Map(object);
        values.putAll(map);
    }

    @SuppressWarnings("unchecked")
    public final void addMapValue(Map map) {
        values.putAll(map);
    }

    @SuppressWarnings("unchecked")
    public void addValue(String key, String value) {
        values.put(key, value);
    }

    public final String getToAddress() {
        return toAddress;
    }

    /**
     * 设置消息接收地址，如果是发送email，则设置email地址，如果是微信消息，则设置微信号。多个地址用逗号隔开。将不能通过配置修改消息发送形式。
     * 建议用addReceiveAccountId添加接收者，程序将会通过地址转换器AddressTransformer进行转换。
     * 
     * @param user
     */
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    /**
     * 设置接收者系统账号Id。如果不设置系统账号，可以setToAddress设置直接接收地址。 如果是设置直接地址，将不能通过配置的修改消息发送形式。
     * 
     * @param accountId
     */
    public void addReceiveAccountId(String accountId) {
        accountIds.add(accountId);
    }

    /**
     * 设置接收者系统账号Id。如果不设置系统账号，也可以setToAddress设置直接接收地址。
     * 如果是设置直接地址，将不能通过配置的修改消息发送形式。
     * 
     * @param ids
     */
    public void addReceiveAccountId(List<String> ids) {
        accountIds.addAll(ids);
    }

    /**
     * 设置接收者系统账号Id。如果不设置系统账号，也可以setToAddress设置直接接收地址。
     * 如果是设置直接地址，将不能通过配置的修改消息发送形式。
     * 
     * @param ids
     */
    public void addReceiveAccountId(String[] ids) {
        if(ids != null){
            for(String id : ids){
                accountIds.add(id);
            }
        }
    }

    public List<String> getAccountIds() {
        return accountIds;
    }

    public final String getFormUser() {
        return formUser;
    }

    public final void setFormUser(String formUser) {
        this.formUser = formUser;
    }

}


