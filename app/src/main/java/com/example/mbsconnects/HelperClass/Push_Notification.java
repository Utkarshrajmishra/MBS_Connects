package com.example.mbsconnects.HelperClass;

public class Push_Notification {

        private NotificationData notificationData;
        private String to;


        public Push_Notification(NotificationData notificationData, String to) {
            this.notificationData = notificationData;
            this.to = to;
        }

        public NotificationData getNotificationData() {
            return notificationData;
        }

        public void setNotificationData(NotificationData notificationData) {
            this.notificationData = notificationData;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }

