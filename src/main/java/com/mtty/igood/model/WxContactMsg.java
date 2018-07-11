package com.mtty.igood.model;

/**
 * @Desp
 * @Date 2018/4/25
 * @Author mtty
 */
public class WxContactMsg {
    // 公共属性
    private String ToUserName; //小程序的原始ID
    private String FromUserName;//发送者的openid
    private Long CreateTime;//消息创建时间(整型）
    private String MsgType; // text-文本消息  image-图片消息  miniprogrampage-小程序卡片消息 event-会话事件
    private Long MsgId;//消息id，64位整型
    // 文本消息
    private String Content;//文本消息内容
    // 图片消息
    private String PicUrl;//图片链接（由系统生成）
    private String MediaId;//图片消息媒体id，可以调用获取临时素材接口拉取数据。
    // 小程序卡片消息
    private String Title;//标题
    private String AppId;//小程序appid
    private String PagePath;//小程序页面路径
    private String ThumbUrl;//封面图片的临时cdn链接
    private String ThumbMediaId;//封面图片的临时素材id
    // 会话事件
    private String Event; //事件类型，user_enter_tempsession
    private String SessionFrom;//开发者在客服会话按钮设置的session-from属性


    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getPagePath() {
        return PagePath;
    }

    public void setPagePath(String pagePath) {
        PagePath = pagePath;
    }

    public String getThumbUrl() {
        return ThumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        ThumbUrl = thumbUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getSessionFrom() {
        return SessionFrom;
    }

    public void setSessionFrom(String sessionFrom) {
        SessionFrom = sessionFrom;
    }

    @Override
    public String toString() {
        return "WxContactMsg{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", MsgId=" + MsgId +
                ", Content='" + Content + '\'' +
                ", PicUrl='" + PicUrl + '\'' +
                ", MediaId='" + MediaId + '\'' +
                ", Title='" + Title + '\'' +
                ", AppId='" + AppId + '\'' +
                ", PagePath='" + PagePath + '\'' +
                ", ThumbUrl='" + ThumbUrl + '\'' +
                ", ThumbMediaId='" + ThumbMediaId + '\'' +
                ", Event='" + Event + '\'' +
                ", SessionFrom='" + SessionFrom + '\'' +
                '}';
    }
}
