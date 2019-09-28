package com.Tamazj.TamazjApp.Model;

import java.util.List;

public class Session {


    /**
     * data : [{"id":1,"time":"30","price":"50.00","created_at":"2019-09-18 19:05:17","updated_at":"2019-09-18 19:05:17","deleted_at":null},{"id":2,"time":"60","price":"100.00","created_at":"2019-09-18 19:05:28","updated_at":"2019-09-18 19:05:28","deleted_at":null}]
     * meta : {"message":"تم العرض بنجاح","status":1}
     */

    private MetaBean meta;
    private List<DataBean> data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class MetaBean {
        /**
         * message : تم العرض بنجاح
         * status : 1
         */

        private String message;
        private int status;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * time : 30
         * price : 50.00
         * created_at : 2019-09-18 19:05:17
         * updated_at : 2019-09-18 19:05:17
         * deleted_at : null
         */

        private int id;
        private String time;
        private String price;
        private String created_at;
        private String updated_at;
        private Object deleted_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }
    }
}
