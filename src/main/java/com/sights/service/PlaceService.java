package com.sights.service;

import com.sights.dto.PlaceDTO;
import com.sights.entity.Comment;
import com.sights.entity.Place;
import com.sights.entity.PlaceInformation;
import com.sights.repository.CommentRepository;
import com.sights.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place create(PlaceDTO placeDTO) {
        Place place = new Place(placeDTO.getName(), placeDTO.getCategory(), 0, placeDTO.getGeo_latitude(), placeDTO.getGeo_longitude());
        return placeRepository.save(place);
    }

    public List<Place> readAll() {
        return placeRepository.findAll();
    }

    public Place update(Place place) {
        return placeRepository.save(place);
    }




}
