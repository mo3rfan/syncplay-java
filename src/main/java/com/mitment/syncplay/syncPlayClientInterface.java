package com.mitment.syncplay;

import java.io.Serializable;
import java.util.Map;
import java.util.Stack;

/**
 * Created by irfan on 1/1/17.
 */

public interface syncPlayClientInterface {
    class userFileDetails implements Serializable {
        private String filename;
        private long duration;
        private long size;
        private String user;
        userFileDetails(long duration, long size, String filename, String userName) {
            this.duration = duration;
            this.size = size;
            this.filename = filename;
            this.user = userName;
        }
        public String getFilename() {
            return this.filename;
        }
        public long getDuration() {
            return this.duration;
        }
        public long getSize() {
            return this.size;
        }
        public String getUsername() { return this.user;}
    }
    interface playerDetails {
        long getPosition();
        Boolean isPaused();
    }
    void onConnected(String motd);
    void onError(String errMsg);
    void onUser(String username, Map<String, Boolean> event, String room);
    void onUser(String setBy, Boolean paused, double position, Boolean doSeek);
    void onUserList(Stack<userFileDetails> details);
    void onFileUpdate(userFileDetails mUserFileDetails);
    void debugMessage(String msg);
}
