package com.Tamazj.TamazjApp.Model;

public class Profile {

    /**
     * data : {"id":2,"name":"mahmoud zo","email":"ashq.smile@gmail.com","phone":"0595592136","gender":"male","nationality":null,"work_status":"workok","social_status":null,"educational_status":"ghj","photo":"http://salahalimohamed.website/tmajog/public/admin/img/user/11.PNG","status":"الحساب  مفعل برقم الهاتف"}
     * meta : {"message":"تمت العملية بنجاح","status":1}
     */

    private DataBean data;
    private MetaBean meta;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public static class DataBean {
        /**
         * id : 2
         * name : mahmoud zo
         * email : ashq.smile@gmail.com
         * phone : 0595592136
         * gender : male
         * nationality : null
         * work_status : workok
         * social_status : null
         * educational_status : ghj
         * photo : http://salahalimohamed.website/tmajog/public/admin/img/user/11.PNG
         * status : الحساب  مفعل برقم الهاتف
         */

        private int id;
        private String name;
        private String email;
        private String phone;
        private String gender;
        private Object nationality;
        private String work_status;
        private Object social_status;
        private String educational_status;
        private String photo;
        private String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Object getNationality() {
            return nationality;
        }

        public void setNationality(Object nationality) {
            this.nationality = nationality;
        }

        public String getWork_status() {
            return work_status;
        }

        public void setWork_status(String work_status) {
            this.work_status = work_status;
        }

        public Object getSocial_status() {
            return social_status;
        }

        public void setSocial_status(Object social_status) {
            this.social_status = social_status;
        }

        public String getEducational_status() {
            return educational_status;
        }

        public void setEducational_status(String educational_status) {
            this.educational_status = educational_status;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class MetaBean {
        /**
         * message : تمت العملية بنجاح
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
}
