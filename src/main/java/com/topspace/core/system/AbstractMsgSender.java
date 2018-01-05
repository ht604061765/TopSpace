/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-24 下午8:50:25
 * TODO //
 */
package com.topspace.core.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


public abstract class AbstractMsgSender implements IMsgSender {
//
//
//    protected final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Resource(name = "AddressTransformer")
//    private AddressTransformer addressTrans;
//
////    protected SenderConfig getSenderConfig(String id) {
////        return MsgSenderConfigLoader.getInstance().getSenderConfg(id);
////    }
//
//    protected boolean send(Message msg) {
//        boolean success = true;
////        SenderConfig sc = getSenderConfig(msg.getSenderId());
////        // 如果没有消息发送的定义或者定义被禁用，则不发送任何消息。
////        if(sc != null && sc.isEnabled()){
////            for(SenderConfig.SenderMsgConfig smc : sc.getSenderMsgs()){
////                boolean bool = sendMsgByName(smc, msg);
////                // 返回值逻辑还有点小问题，目前处理是只要有一次不成功，就返回不成功。
////                if(!bool)
////                    success = false;
////            }
////        }
//        return success;
//    }
//
//    protected boolean sendMsgByName(SenderConfig.SenderMsgConfig smc, Message msg) {
//        boolean flag = true;
//        switch(smc.getName()){
//            case "wechat":
//                flag = sendWechatMsg(smc.getTemplate(), msg);
//                break;
//            case "shortMsg":
//                flag = sendMobileShortMsg(smc.getTemplate(), msg);
//                break;
//            case "email":
//                sendMailMsg(smc.getTemplate(), msg);
//                break;
//            case "sysMsg":
//                sendSysMsg(smc.getTemplate(), msg);
//                break;
//        }
//        return flag;
//    }
//
//    protected boolean sendWechatMsg(String templateId, Message msg) {
//        String[] users = transAddress(msg, AddressTransformer.ADDRESS_WECHAT);
//        log("微信消息", msg, users);
//        if(users == null)
//            return true;
//        boolean flag = true;
//        for(String user : users){
//            if(!StringUtil.isEmpty(user)){
//                msg.setToAddress(user);
//                String type = MessageTemplateLoader.getInstance().getTemplateType(templateId);
//                switch(type){
//                    case "text":
//                        flag = sendWechatTextMsg(templateId, msg);
//                        break;
//                    case "template":
//                        flag = sendWechatTemplateMsg(templateId, msg);
//                        break;
//                }
//            }
//        }
//        return flag;
//    }
//
//    protected boolean sendWechatTemplateMsg(String templateId, Message msg) {
//        WechatService wechatService = WechatService.getInstance();
//        msg.addValue("touser", msg.getToAddress());
//        String json = getMsgContent(templateId, msg.getValue());
//        return wechatService.sendWechatTemplateMsg(json);
//    }
//
//    protected boolean sendWechatTextMsg(String templateId, Message msg) {
//        WechatService wechatService = WechatService.getInstance();
//        msg.addValue("touser", msg.getToAddress());
//        String json = getMsgContent(templateId, msg.getValue());
//
//        return wechatService.sendWechatMsg(json);
//    }
//
//    protected void sendSysMsg(String templateId, Message msg) {
//        SysMsgSendService smsService = (SysMsgSendService) SpringBeanUtil.getBean("SysMsgSendService");
//        String[] users = transAddress(msg, AddressTransformer.ADDRESS_SYSTEM_MSG);
//        String content = getMsgContent(templateId, msg.getValue());
//        String title = getMsgTitle(templateId, msg.getValue());
//        log("系统短信", msg, users);
//        smsService.addToMsgBox(msg.getFormUser(), users, title, content);
//    }
//
//    protected void sendMailMsg(String templateId, Message msg) {
//        String content = getMsgContent(templateId, msg.getValue());
//        String title = getMsgTitle(templateId, msg.getValue());
//        String[] toUsers = transAddress(msg, AddressTransformer.ADDRESS_EMAIL);
//        log("邮件", msg, toUsers);
//        for(String toUser : toUsers){
//            if(!StringUtil.isEmpty(toUser)){
//
//                Mail mail = new Mail();
//                mail.setSubject(title);
//                mail.addToAddress(toUser);
//                mail.setContent(content);
//                String type = MessageTemplateLoader.getInstance().getTemplateType(templateId);
//                switch(type){
//                    case "text":
//                        SimpleMailSender.sendTextMail(mail);
//                        break;
//                    case "html":
//                        SimpleMailSender.sendHtmlMail(mail);
//                        break;
//                    default:
//                        SimpleMailSender.sendHtmlMail(mail);
//                }
//            }
//        }
//    }
//
//    protected boolean sendMobileShortMsg(String templateId, Message msg) {
//        String[] toUsers = transAddress(msg, AddressTransformer.ADDRESS_SHORT_MSG);
//        ISmsSender iss = (ISmsSender) SpringBeanUtil.getBean("XhMobileSmsSender");
//        String content = getMsgContent(templateId, msg.getValue());
//        log("手机短信", msg, toUsers);
//        return iss.sendSms(toUsers, content);
//    }
//
//    protected String getMsgContent(String templateId, Object value) {
//        String content = MessageTemplateLoader.getInstance().mergeContent(templateId, value);
//        return content;
//    }
//
//    protected String getMsgTitle(String templateId, Object value) {
//        String content = MessageTemplateLoader.getInstance().mergeTitle(templateId, value);
//        return content;
//    }
//
//    private String[] transAddress(Message msg, int type) {
//        if(msg.getAccountIds().isEmpty()){
//            // 如果没有设置accountId，则取直接地址，不进行转换。
//            return StringUtil.split(msg.getToAddress(), ",");
//        }else{
//            // 通过accountId获取不同消息的地址。微信号，EMail，手机号等.
//            String[] accountIds = new String[msg.getAccountIds().size()];
//            msg.getAccountIds().toArray(accountIds);
//            return addressTrans.transform(accountIds, type);
//        }
//    }
//
//    private void log(String type, Message msg, String toUsers[]) {
//        log.info("消息中心正式发送;消息类型=" + type + ";消息定义=" + msg.getSenderId() + ";接收人=" + ArrayUtil.arrayToString(toUsers) + ";发送内容="
//                + msg.getValue());
//    }

}


