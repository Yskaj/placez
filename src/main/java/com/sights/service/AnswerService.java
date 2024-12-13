package com.sights.service;

import com.sights.entity.Place;
import com.sights.entity.SimpleAnswer;
import com.sights.repository.SimpleAnswerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AnswerService {
    private final SimpleAnswerRepository simpleAnswerRepository;

    public AnswerService(SimpleAnswerRepository simpleAnswerRepository) {
        this.simpleAnswerRepository = simpleAnswerRepository;
    }

    @Autowired
    private EntityManager entityManager;

    public List<Place> findNearPlace(Float lati, Float longi, Float radius) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < %s limit 10;", lati, longi, radius);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    public List<Place> findNearPlaceLim(Float lati, Float longi, Float radius, Integer lim){
        String query = String.format(
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < %s limit %s;", lati, longi, radius, lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }

    public List<Place> findNearPlaceLimD(Float lati, Float longi, Float radius, Integer lim){
        String query = String.format(
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius desc) where radius < %s limit %s;", lati, longi, radius, lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
//-------------------------------------------------------------
    public List<Place> categoryFindNearPlace(Float lati, Float longi, Float radius, String category) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < '%s' and category='%s' limit 10;", lati, longi, radius, new String(category.getBytes(), StandardCharsets.UTF_8));
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    public List<Place> categoryFindNearPlaceLim(Float lati, Float longi, Float radius, String category, Integer lim) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < '%s' and category='%s' limit '%s';", lati, longi,
                radius, new String(category.getBytes(), StandardCharsets.UTF_8),lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    public List<Place> categoryFindNearPlaceLimD(Float lati, Float longi, Float radius, String category, Integer lim, Boolean asc) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < '%s' and category='%s' limit '%s';", lati, longi,
                radius, new String(category.getBytes(), StandardCharsets.UTF_8),lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    //--------------------------------------------
    public List<Place> avgFindNearPlace(Float lati, Float longi, Float radius, Float avg) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < '%s' " +
                        "and ceil(avg_rating) = '%s'  limit 10;", lati, longi, radius, avg);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    public List<Place> avgFindNearPlaceLim(Float lati, Float longi, Float radius, Float avg, Integer lim) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < '%s' " +
                        "and ceil(avg_rating) = '%s'  limit '%s';", lati, longi, radius, avg, lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    public List<Place> avgFindNearPlaceLimD(Float lati, Float longi, Float radius, Float avg, Integer lim, Boolean asc) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) where radius < '%s' " +
                        "and ceil(avg_rating) = '%s'  limit '%s';", lati, longi, radius, avg, lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    //-----------------------------------------------------------------
    public List<Place> avgAndCategoryFindNearPlace(Float lati, Float longi, Float radius,String category, Float avg) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) " +
                        "where radius < '%s'" +
                        " and ceil(avg_rating) = %s" +
                        " and category='%s' order by avg_rating,category limit 100;", lati, longi, radius, avg ,category);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    public List<Place> avgAndCategoryFindNearPlaceLim(Float lati, Float longi, Float radius,String category, Float avg, Integer lim) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) " +
                        "where radius < '%s'" +
                        " and ceil(avg_rating) = %s" +
                        " and category='%s' order by avg_rating,category limit '%s';", lati, longi, radius, avg ,category, lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
    public List<Place> avgAndCategoryFindNearPlaceLimD(Float lati, Float longi, Float radius,String category, Float avg, Integer lim, Boolean asc) {
        String query = String.format(  //sqrt(pow(x-a)+pow(y-b)) - ближайшая точка
                "select id,name,avg_rating from(" +
                        "select *,sqrt(power((geo_latitude-%s),2)+" +
                        "power((geo_longitude - %s),2)) as radius from sights " +
                        "order by radius) " +
                        "where radius < '%s'" +
                        " and ceil(avg_rating) = %s" +
                        " and category='%s' order by avg_rating,category limit '%s';", lati, longi, radius, avg ,category, lim);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }


    public List<Place> placeInformation(String place) {
        String query = String.format(
                "select name,avg_rating,comment from sights inner join comments" +
                        " on sights.id = comments.place_id where name = %s", place);
        return entityManager.createNativeQuery(
                query, SimpleAnswer.class).getResultList();
    }
//
}
