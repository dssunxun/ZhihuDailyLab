package com.renova.zhihudailylab.entities;

import java.util.List;

/**
 * 当日新闻的实体类
 * Created by Renova on 2015/10/29.
 */
public class LatestNews {

    /**
     * 日期
     */
    private String date;
    /**
     * 当日新闻
     */
    private List<Storie> stories;

    /**
     * 界面顶部 ViewPager 滚动显示的显示内容（子项格式同上）
     */
    private List<TopStorie> top_stories;

    public void setDate(String date) {
        this.date = date;
    }


    public void setStories(List<Storie> stories) {
        this.stories = stories;
    }

    public void setTop_stories(List<TopStorie> top_stories) {
        this.top_stories = top_stories;
    }

    public String getDate() {
        return date;
    }

    public List<Storie> getStories() {
        return stories;
    }

    public List<TopStorie> getTop_stories() {
        return top_stories;
    }

    public static class Storie {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getImages() {
            return images;
        }

        @Override
        public String toString() {
            return "Storie{" +
                    "type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    ", images=" + images +
                    '}';
        }
    }


    public static class TopStorie{
        private Integer type;
        private Integer id;
        private String ga_prefix;
        private String title;
        private String image;

        public TopStorie(Integer type, Integer id, String ga_prefix, String title,
                         String image) {
            this.type = type;
            this.id = id;
            this.ga_prefix = ga_prefix;
            this.title = title;
            this.image = image;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @Override
        public String toString() {
            return "TopStorie{" +
                    "type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "LatestNews{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }
}
