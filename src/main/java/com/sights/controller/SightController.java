package com.sights.controller;

import com.sights.dto.PlaceDTO;
import com.sights.entity.Comment;
import com.sights.entity.Place;
import com.sights.entity.PlaceInformation;
import com.sights.service.AnswerService;
import com.sights.service.CommentService;
import com.sights.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class SightController {
    private final PlaceService placeService;
    private final CommentService commentService;
    private final AnswerService answerService;

    public SightController(PlaceService placeService, CommentService commentService, AnswerService answerService) {
        this.placeService = placeService;
        this.commentService = commentService;
        this.answerService = answerService;
    }
    //Получить список достопримечательностей
    @GetMapping("/all")
    public ResponseEntity<List<Place>> readAll() {
        return new ResponseEntity<>(placeService.readAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody PlaceDTO placeDTO) {
        return new ResponseEntity<>(placeService.create(placeDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Place> update(@RequestBody Place place) {
        return new ResponseEntity<>(placeService.update(place), HttpStatus.OK);
    }

    @GetMapping("/a")
    public ResponseEntity<List<Comment>> readAllComments() {
        return new ResponseEntity<>(commentService.readAll(), HttpStatus.OK);
    }
    // Получить список достопримечательностей
    // Находящихся в указанном радиусе от него (координаты пользователя передаются в запросе)
    @GetMapping("/lat={lati}lon={longi}radius={radius}")  //просто координаты и радиус
    public ResponseEntity<List<Place>> findNearPlace(@PathVariable Float lati, @PathVariable Float longi, @PathVariable Float radius) {
        return new ResponseEntity<>(answerService.findNearPlace(lati, longi, radius), HttpStatus.OK);
    }

    @GetMapping("/lat={lati}lon={longi}radius={radius}/category={category}") // и категория
    public ResponseEntity<List<Place>> categoryfindNearPlace(@PathVariable Float lati, @PathVariable Float longi,
                                                             @PathVariable Float radius, @PathVariable String category) {
        return new ResponseEntity<>(answerService.categoryFindNearPlace(lati, longi, radius, category), HttpStatus.OK);
    }

    @GetMapping("/lat={lati}lon={longi}radius={radius}/avg={avg}") // и AVG средняя оценка
    public ResponseEntity<List<Place>> avgfindNearPlace(@PathVariable Float lati, @PathVariable Float longi,
                                                             @PathVariable Float radius, @PathVariable Float avg)  {
        return new ResponseEntity<>(answerService.avgFindNearPlace(lati, longi, radius, avg), HttpStatus.OK);
    }
    @GetMapping("/lat={lati}lon={longi}radius={radius}/category={category}/avg={avg}") // Категория и AVG средняя оценка
    public ResponseEntity<List<Place>> avgAndCategoryfindNearPlace(@PathVariable Float lati, @PathVariable Float longi,
                                                        @PathVariable Float radius,@PathVariable String category, @PathVariable Float avg)  {
        return new ResponseEntity<>(answerService.avgAndCategoryFindNearPlace(lati, longi, radius, category, avg), HttpStatus.OK);
    }
    // LIMIT
    //просто координаты и радиус
    @GetMapping("/lat={lati}lon={longi}radius={radius}/lim={lim}")
    public ResponseEntity<List<Place>> findNearPlaceLim(@PathVariable Float lati, @PathVariable Float longi,
                                                        @PathVariable Float radius, @PathVariable Integer lim) {
        return new ResponseEntity<>(answerService.findNearPlaceLim(lati, longi, radius, lim), HttpStatus.OK);
    }
    @GetMapping("/lat={lati}lon={longi}radius={radius}/category={category}/lim={lim}") // и категория
    public ResponseEntity<List<Place>> categoryfindNearPlaceLim(@PathVariable Float lati, @PathVariable Float longi,
                                                             @PathVariable Float radius, @PathVariable String category,
                                                             @PathVariable Integer lim ) {
        return new ResponseEntity<>(answerService.categoryFindNearPlaceLim(lati, longi, radius, category,lim), HttpStatus.OK);
    }

    @GetMapping("/lat={lati}lon={longi}radius={radius}/avg={avg}/lim={lim}") // и AVG средняя оценка
    public ResponseEntity<List<Place>> avgfindNearPlaceLim(@PathVariable Float lati, @PathVariable Float longi,
                                                        @PathVariable Float radius, @PathVariable Float avg,
                                                        @PathVariable Integer lim)  {
        return new ResponseEntity<>(answerService.avgFindNearPlaceLim(lati, longi, radius, avg, lim), HttpStatus.OK);
    }
    @GetMapping("/lat={lati}lon={longi}radius={radius}/category={category}/avg={avg}/lim={lim}") // Категория и AVG средняя оценка
    public ResponseEntity<List<Place>> avgAndCategoryfindNearPlaceLim(@PathVariable Float lati, @PathVariable Float longi,
                                                                   @PathVariable Float radius,@PathVariable String category,
                                                                   @PathVariable Float avg, @PathVariable Integer lim)  {
        return new ResponseEntity<>(answerService.avgAndCategoryFindNearPlaceLim(lati, longi, radius, category, avg, lim), HttpStatus.OK);
    }
    //Asc Desc
    // LIMIT
    //просто координаты и радиус
    @GetMapping("/lat={lati}lon={longi}radius={radius}/lim={lim}/as")
    public ResponseEntity<List<Place>> findNearPlaceLimD(@PathVariable Float lati, @PathVariable Float longi,
                                                         @PathVariable Float radius, @PathVariable Integer lim) {
        return new ResponseEntity<>(answerService.findNearPlaceLimD(lati, longi, radius, lim), HttpStatus.OK);
    }
    @GetMapping("/lat={lati}lon={longi}radius={radius}/category={category}/lim={lim}/as={asc}") // и категория
    public ResponseEntity<List<Place>> categoryfindNearPlaceLimD(@PathVariable Float lati, @PathVariable Float longi,
                                                                @PathVariable Float radius, @PathVariable String category,
                                                                @PathVariable Integer lim,@PathVariable Boolean asc ) {
        return new ResponseEntity<>(answerService.categoryFindNearPlaceLimD(lati, longi, radius, category,lim,asc), HttpStatus.OK);
    }

    @GetMapping("/lat={lati}lon={longi}radius={radius}/avg={avg}/lim={lim}/as={asc}") // и AVG средняя оценка
    public ResponseEntity<List<Place>> avgfindNearPlaceLimD(@PathVariable Float lati, @PathVariable Float longi,
                                                           @PathVariable Float radius, @PathVariable Float avg,
                                                           @PathVariable Integer lim,@PathVariable Boolean asc)  {
        return new ResponseEntity<>(answerService.avgFindNearPlaceLimD(lati, longi, radius, avg, lim, asc), HttpStatus.OK);
    }
    @GetMapping("/lat={lati}lon={longi}radius={radius}/category={category}/avg={avg}/lim={lim}/as={asc}") // Категория и AVG средняя оценка
    public ResponseEntity<List<Place>> avgAndCategoryfindNearPlaceLimD(@PathVariable Float lati, @PathVariable Float longi,
                                                                      @PathVariable Float radius,@PathVariable String category,
                                                                      @PathVariable Float avg, @PathVariable Integer lim,
                                                                      @PathVariable Boolean asc)  {
        return new ResponseEntity<>(answerService.avgAndCategoryFindNearPlaceLimD(lati, longi, radius, category, avg, lim, asc), HttpStatus.OK);
    }
    @GetMapping("/name={name}")
    public ResponseEntity<PlaceInformation> getPlaceInfo(@PathVariable String name){
        System.out.println(name);
        String place = new String(name.getBytes(),StandardCharsets.UTF_8);
        return new ResponseEntity<>(commentService.getPlaceInformation(place),HttpStatus.OK);}
}
