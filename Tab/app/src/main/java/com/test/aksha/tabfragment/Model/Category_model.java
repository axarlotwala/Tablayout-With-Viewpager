package com.test.aksha.tabfragment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category_model {


    @Expose
    @SerializedName("category")
    public List<Category> category;
    @Expose
    @SerializedName("success")
    public int success;

    public static class Category {
        @Expose
        @SerializedName("category_name")
        public String category_name;
        @Expose
        @SerializedName("category_id")
        public String category_id;

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }
    }
}
