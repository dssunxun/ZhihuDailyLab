package com.renova.zhihudailylab;

import com.squareup.okhttp.MediaType;

/**
 * Created by 孙逊 on 2015/10/29.
 * Copyright (c) Ruixing constant information technology co., LTD. Allrights reserved.
 */
public class Constants {
    public static final MediaType TEXT_MEDIA_TYPE = MediaType.parse(
            "text/plain; charset=utf-8");
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parse(
            "application/json; charset=utf-8");
    public static final MediaType IMAGE_MEDIA_TYPE = MediaType.parse("image/jpeg; charset=utf-8");
    public static final MediaType AMR_MEDIA_TYPE = MediaType.parse("audio/amr; charset=utf-8");



    public static final String LATEST_NEWS_URL="http://news-at.zhihu.com/api/4/news/latest";


}
