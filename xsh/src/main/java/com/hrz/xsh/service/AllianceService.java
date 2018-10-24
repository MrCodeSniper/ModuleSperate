
package com.hrz.xsh.service;


import com.hrz.xsh.entity.AddressBean;
import com.hrz.xsh.entity.AllianceBanner;
import com.hrz.xsh.entity.AllianceHomeShopsEntity;
import com.hrz.xsh.entity.CityBean;
import com.hrz.xsh.entity.IndustryBean;
import com.hrz.xsh.entity.MediaEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


/**
 * ================================================
 * 展示 {@link Retrofit#create(Class)} 中需要传入的 ApiService 的使用方式
 * 存放关于用户的一些 API
 * ================================================
 */
public interface AllianceService {


    @GET("/xdz/banner/{v}/list")
    Call<AllianceBanner> getAllianceBanner(@Query("clientType") int clientType, @Query("v") String v);

    @GET("/xdz/shop/{v}/home/list/full")
//    Observable<AllianceHomeShopsEntity> getAllianceHomeShops(@Query("v") String v, @Query("page") int page, @Query("pageSize") int pageSize, @Query("industryId") Integer industryId, @Query("city") String city, @Query("isCoupon") Integer isCoupon, @Query("latitude") Double latitude, @Query("longitude") Double longitude, @Query("minDistance") Integer minDistance, @Query("maxDistance") Integer maxDistance, @Query("coordinatesType") Integer coordinatesType);
    Observable<AllianceHomeShopsEntity> getAllianceHomeShops(@QueryMap Map<String, String> options);

    @GET("/xdz/shop/city/123/cities/list")
    Call<CityBean> getAllianceOpenCities();

    @GET("/xdz/industry/{v}/list")
    Call<IndustryBean> getAllianceOpenIndustry();

    @GET("/xdz/shop/city/{v}/list")
    Call<AddressBean> getOpenCityes();

    @POST("/xdz/user/{v}/mediaRegister")
    Call<MediaEntity> getMediaEntity(@Body RequestBody body);

//    // 规则介绍
//    @GET("/hrz/api/merchant/broker/activity")
//    Observable<PersonData> getPersonIndex(@QueryMap Map<String, String> map);
//
//    // 商家二维码
//    @GET("/hrz/api/merchant/broker/qrcode")
//    Observable<WeixinSoftEntity> getCode(@QueryMap Map<String, String> map);

}
