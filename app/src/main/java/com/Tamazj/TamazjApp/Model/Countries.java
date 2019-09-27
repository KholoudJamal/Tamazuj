package com.Tamazj.TamazjApp.Model;

import java.util.List;

public class Countries {

    /**
     * data : [{"id":1,"name_ar":"بال","name_en":"pal","short_code":"p"},{"id":3,"name_ar":"اختبار","name_en":"test","short_code":"Te"}]
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
         * name_ar : بال
         * name_en : pal
         * short_code : p
         */

        private int id;
        private String name_ar;
        private String name_en;
        private String short_code;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_ar() {
            return name_ar;
        }

        public void setName_ar(String name_ar) {
            this.name_ar = name_ar;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getShort_code() {
            return short_code;
        }

        public void setShort_code(String short_code) {
            this.short_code = short_code;
        }
    }
}
