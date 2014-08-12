package jp.gr.java_conf.ko_aoki.common.form;

import java.util.List;

/**
 * formの基本クラス.
 * @author ko-aoki
 */
public class BaseForm {
    /** メッセージリスト */
    private List<String> messages;
    /** 実行結果 */
    private String result;

    /**
     * @return the messages
     */
    public List<String> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }
}
