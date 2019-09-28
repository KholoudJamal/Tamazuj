package com.Tamazj.TamazjApp.Model;

public class Profile {


    /**
     * data : {"id":13,"name":"wafaa herb","email":"wafaaherb@gmail.com","phone":"0599101010","gender":null,"nationality":"","work_status":null,"social_status":null,"educational_status":null,"photo":"http://salahalimohamed.website/tmajog/public/admin/img/setting/35163665790_d182d84f5e_k.jpg","status":"الحساب  مفعل برقم الهاتف","date_of_birth":null}
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
         * id : 13
         * name : wafaa herb
         * email : wafaaherb@gmail.com
         * phone : 0599101010
         * gender : null
         * nationality :
         * work_status : null
         * social_status : null
         * educational_status : null
         * photo : http://salahalimohamed.website/tmajog/public/admin/img/setting/35163665790_d182d84f5e_k.jpg
         * status : الحساب  مفعل برقم الهاتف
         * date_of_birth : null
         */

        private int id;
        private String name;
        private String email;
        private String phone;
        private Object gender;
        private String nationality;
        private Object work_status;
        private Object social_status;
        private Object educational_status;
        private String photo;
        private String status;
        private Object date_of_birth;

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

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public Object getWork_status() {
            return work_status;
        }

        public void setWork_status(Object work_status) {
            this.work_status = work_status;
        }

        public Object getSocial_status() {
            return social_status;
        }

        public void setSocial_status(Object social_status) {
            this.social_status = social_status;
        }

        public Object getEducational_status() {
            return educational_status;
        }

        public void setEducational_status(Object educational_status) {
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

        public Object getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(Object date_of_birth) {
            this.date_of_birth = date_of_birth;
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
