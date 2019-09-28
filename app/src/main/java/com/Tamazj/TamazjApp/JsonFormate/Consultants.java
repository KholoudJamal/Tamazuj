package com.Tamazj.TamazjApp.JsonFormate;

import java.util.List;

public class Consultants {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : test
         * email : ashq.44@gmail.com
         * phone : 2139902320
         * gender : test
         * nationality : null
         * age : null
         * date_of_birth : null
         * degree : null
         * current_job : null
         * work_status : null
         * social_status : null
         * country_of_residence : null
         * city_of_residence : null
         * educational_status : null
         * biography : null
         * means_of_communication : null
         * account_status : 1
         * photo : http://salahalimohamed.website/tmajog/public/admin/img/setting/35163665790_d182d84f5e_k.jpg
         * languages : [{"id":1,"name_ar":"انجليزي","name_en":"Einglish"},{"id":2,"name_ar":"عربي","name_en":"Arabic"}]
         * type_of_consultations : [{"id":1,"name_en":"Student","name_ar":"طالب","image":"","created_at":"2019-08-27 01:22:49","updated_at":"2019-08-27 01:22:49","deleted_at":null,"pivot":{"consultant_id":"1","category_of_consultation_id":"1"}},{"id":2,"name_en":"dd","name_ar":"يي","image":"","created_at":"2019-08-30 01:30:13","updated_at":"2019-08-30 01:30:13","deleted_at":null,"pivot":{"consultant_id":"1","category_of_consultation_id":"2"}}]
         * status : الحساب  مفعل
         */

        private int id;
        private String name;
        private String email;
        private String phone;
        private String gender;
        private Object nationality;
        private Object age;
        private Object date_of_birth;
        private Object degree;
        private Object current_job;
        private Object work_status;
        private Object social_status;
        private Object country_of_residence;
        private Object city_of_residence;
        private Object educational_status;
        private Object biography;
        private Object means_of_communication;
        private String account_status;
        private String photo;
        private String status;
        private List<LanguagesBean> languages;
        private List<TypeOfConsultationsBean> type_of_consultations;

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

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(Object date_of_birth) {
            this.date_of_birth = date_of_birth;
        }

        public Object getDegree() {
            return degree;
        }

        public void setDegree(Object degree) {
            this.degree = degree;
        }

        public Object getCurrent_job() {
            return current_job;
        }

        public void setCurrent_job(Object current_job) {
            this.current_job = current_job;
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

        public Object getCountry_of_residence() {
            return country_of_residence;
        }

        public void setCountry_of_residence(Object country_of_residence) {
            this.country_of_residence = country_of_residence;
        }

        public Object getCity_of_residence() {
            return city_of_residence;
        }

        public void setCity_of_residence(Object city_of_residence) {
            this.city_of_residence = city_of_residence;
        }

        public Object getEducational_status() {
            return educational_status;
        }

        public void setEducational_status(Object educational_status) {
            this.educational_status = educational_status;
        }

        public Object getBiography() {
            return biography;
        }

        public void setBiography(Object biography) {
            this.biography = biography;
        }

        public Object getMeans_of_communication() {
            return means_of_communication;
        }

        public void setMeans_of_communication(Object means_of_communication) {
            this.means_of_communication = means_of_communication;
        }

        public String getAccount_status() {
            return account_status;
        }

        public void setAccount_status(String account_status) {
            this.account_status = account_status;
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

        public List<LanguagesBean> getLanguages() {
            return languages;
        }

        public void setLanguages(List<LanguagesBean> languages) {
            this.languages = languages;
        }

        public List<TypeOfConsultationsBean> getType_of_consultations() {
            return type_of_consultations;
        }

        public void setType_of_consultations(List<TypeOfConsultationsBean> type_of_consultations) {
            this.type_of_consultations = type_of_consultations;
        }

        public static class LanguagesBean {
            /**
             * id : 1
             * name_ar : انجليزي
             * name_en : Einglish
             */

            private int id;
            private String name_ar;
            private String name_en;

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
        }

        public static class TypeOfConsultationsBean {
            /**
             * id : 1
             * name_en : Student
             * name_ar : طالب
             * image :
             * created_at : 2019-08-27 01:22:49
             * updated_at : 2019-08-27 01:22:49
             * deleted_at : null
             * pivot : {"consultant_id":"1","category_of_consultation_id":"1"}
             */

            private int id;
            private String name_en;
            private String name_ar;
            private String image;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private PivotBean pivot;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public String getName_ar() {
                return name_ar;
            }

            public void setName_ar(String name_ar) {
                this.name_ar = name_ar;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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

            public PivotBean getPivot() {
                return pivot;
            }

            public void setPivot(PivotBean pivot) {
                this.pivot = pivot;
            }

            public static class PivotBean {
                /**
                 * consultant_id : 1
                 * category_of_consultation_id : 1
                 */

                private String consultant_id;
                private String category_of_consultation_id;

                public String getConsultant_id() {
                    return consultant_id;
                }

                public void setConsultant_id(String consultant_id) {
                    this.consultant_id = consultant_id;
                }

                public String getCategory_of_consultation_id() {
                    return category_of_consultation_id;
                }

                public void setCategory_of_consultation_id(String category_of_consultation_id) {
                    this.category_of_consultation_id = category_of_consultation_id;
                }
            }
        }
    }
}
